package co.pinkroom.multiplatformtemplate.controllers

import co.pinkroom.multiplatformtemplate.data.Recipe
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.route

fun Routing.recipe() {

    route("recipes") {
        get {
            val recipes = listOf(Recipe("Bacalhau com natas!"), Recipe("Sarrabulho!!!"))
            call.respond(recipes)
        }
    }
}