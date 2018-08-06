package co.pinkroom.multiplatformtemplate

import co.pinkroom.multiplatformtemplate.controllers.meme
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.GsonConverter
import io.ktor.http.ContentType
import io.ktor.routing.Routing

fun Application.module() {
    install(ContentNegotiation) {
        register(ContentType.Application.Json, GsonConverter(buildGson()))
    }

    install(Routing) {
        meme()
    }
}

private fun buildGson(): Gson {
    return GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .create()
}