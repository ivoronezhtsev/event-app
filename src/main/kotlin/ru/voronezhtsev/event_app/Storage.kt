package ru.voronezhtsev.event_app

import org.ktorm.database.Database
import org.ktorm.dsl.insert
import org.ktorm.schema.Table
import org.ktorm.schema.long
import org.ktorm.schema.text
import org.ktorm.schema.timestamp
import java.time.Instant.now

object Storage {
    private val database = Database.connect(
        "jdbc:postgresql://localhost:5433/postgres",
        user = "postgres", password = "cee\'d831mc"
    )

    fun insert(event: Event) {
        database.insert(Events) {
            set(it.title, event.title)
            set(it.desc, event.desc)
            set(it.userId, event.userId)
            set(it.cityId, event.cityId)
            set(it.date, now())
        }
    }
}

object Events : Table<Nothing>("events") {
    val title = text("title")
    val desc = text("description")
    val userId = long("user_id")
    val cityId = long("city_id")
    val date = timestamp("date")
}