package ru.voronezhtsev.event_app.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.voronezhtsev.event_app.Storage
import ru.voronezhtsev.event_app.network.Event

fun Application.configureRouting() {

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
