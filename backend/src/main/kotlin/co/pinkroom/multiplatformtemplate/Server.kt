package co.pinkroom.multiplatformtemplate

import co.pinkroom.multiplatformtemplate.controllers.meme
import co.pinkroom.multiplatformtemplate.controllers.recipe
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.GsonConverter
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.routing

fun Application.module() {
    install(ContentNegotiation) {
        register(ContentType.Application.Json, GsonConverter(buildGson()))

    }

    install(Routing) {
        routing {
            get("/") {
                call.respondText("Hello World!", ContentType.Text.Plain)
            }
        }
        recipe()
        meme()
    }
}

private fun buildGson(): Gson {
    return GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .create()
}