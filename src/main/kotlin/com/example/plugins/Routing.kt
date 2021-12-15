package com.example.plugins

import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import java.io.File

fun Application.configureRouting() {

    // Starting point for a Ktor app:
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/download_app") {
            val apk = File("./src/main/resources/files/app_library.apk")
            if(apk.exists()) {
                call.respondFile(apk)
                call.response.header("Content-Disposition", "attachment; filename=\"${apk.name}\"")
            }
            else call.respond(HttpStatusCode.NotFound)
        }
    }
}
