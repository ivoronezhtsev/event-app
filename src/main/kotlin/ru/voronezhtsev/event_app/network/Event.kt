package ru.voronezhtsev.event_app.network

import kotlinx.serialization.Serializable

@Serializable
data class Event(
    val title: String,
    val desc: String,
    val userId: Long,
    val addressId: Long,
    val date: String
)