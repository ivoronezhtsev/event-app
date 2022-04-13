package ru.voronezhtsev.event_app.plugins

import ru.voronezhtsev.event_app.Event
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import ru.voronezhtsev.event_app.Storage

fun Application.configureRouting() {

    // Starting point for a Ktor app:
    routing {
        get("/") {
            call.respondText("Events App")
        }
    }
    routing {
        post("/event") {
            val event = call.receive<Event>()
            println(event)
            Storage.insert(event)
            call.respondText("Event stored correctly", status = HttpStatusCode.Created)
        }
    }
}
