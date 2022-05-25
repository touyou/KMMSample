package dev.touyou.kmmsample

import io.ktor.client.*
import io.ktor.client.engine.darwin.*
import io.ktor.client.plugins.contentnegotiation.*
import kotlinx.coroutines.CoroutineDispatcher
import platform.darwin.dispatch_get_main_queue
import io.ktor.serialization.kotlinx.xml.*

actual class HatenaAPIClient actual constructor() {
    actual val client: HttpClient = HttpClient(Darwin) {
        install(ContentNegotiation) {
            xml()
        }
    }

    actual val dispatcher: CoroutineDispatcher = Dispatcher(dispatch_get_main_queue())
}