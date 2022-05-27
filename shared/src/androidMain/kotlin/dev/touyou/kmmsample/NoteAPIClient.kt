package dev.touyou.kmmsample

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual class NoteAPIClient actual constructor() {
    actual val client: HttpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json()
        }
    }

    actual val dispatcher: CoroutineDispatcher = Dispatchers.Default
}