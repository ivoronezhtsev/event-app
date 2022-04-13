package ru.voronezhtsev.event_app

import kotlinx.serialization.Serializable

@Serializable
data class Event(
    val title: String,
    val desc: String,
    val userId: Long,
    val cityId: Long
    //todo Дата?
)