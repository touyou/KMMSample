package dev.touyou.kmmsample

import io.ktor.client.*
import io.ktor.client.engine.darwin.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.CoroutineDispatcher
import platform.darwin.dispatch_get_main_queue

actual class NoteAPIClient actual constructor() {
    actual val client: HttpClient = HttpClient(Darwin) {
        install(ContentNegotiation) {
            json()
        }
    }

    actual val dispatcher: CoroutineDispatcher = Dispatcher(dispatch_get_main_queue())
}