package dev.touyou.kmmsample

import kotlinx.serialization.Serializable

@Serializable
data class NoteSummary(
    val name: String,
    val eyecatch: String,
    val body: String,
)

@Serializable
data class NoteSummaries(
    val contents: List<NoteSummary>,
    val totalCount: Int,
)

@Serializable
data class NoteData(
    val data: NoteSummaries
)