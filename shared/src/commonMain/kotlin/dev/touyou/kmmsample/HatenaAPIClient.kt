package dev.touyou.kmmsample

import io.ktor.client.*
import kotlinx.coroutines.CoroutineDispatcher

expect class HatenaAPIClient() {
    val client: HttpClient
    val dispatcher: CoroutineDispatcher
}