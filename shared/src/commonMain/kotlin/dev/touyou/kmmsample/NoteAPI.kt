package dev.touyou.kmmsample

import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NoteAPI {
    val apiClient: NoteAPIClient = NoteAPIClient()
    companion object {
        val BASEURL = "https://note.com/api/v2/creators/naofumit/contents?kind=note&page=1"
    }

    fun fetchNotes(callback: (List<NoteSummary>) -> Unit) {
        GlobalScope.apply {
            launch(apiClient.dispatcher) {
                val result = apiClient.client.get(BASEURL).body<NoteData>()
                callback(result.data.contents)
            }
        }
    }
}