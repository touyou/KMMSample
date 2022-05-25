package dev.touyou.kmmsample

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.xml.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual class HatenaAPIClient actual constructor() {
    actual val client: HttpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            xml()
        }
    }

    actual val dispatcher: CoroutineDispatcher = Dispatchers.Default
}