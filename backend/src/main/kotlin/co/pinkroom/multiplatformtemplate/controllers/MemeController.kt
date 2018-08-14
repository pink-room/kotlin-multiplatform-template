package co.pinkroom.multiplatformtemplate.controllers

import co.pinkroom.multiplatformtemplate.data.model.Meme
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.route

fun Routing.meme() {

    route("memes") {
        get { call.respond(generateMemes()) }
    }
}

private fun generateMemes(): List<Meme> {
    return listOf(
            Meme("Chocolate!!!!", "https://i.imgflip.com/2f49xl.jpg"),
            Meme("Third World Problems.", "https://i.imgflip.com/2f37f4.jpg"),
            Meme("Cookies...", "https://i.imgflip.com/2f6n2b.jpg"),
            Meme("Can't get fired :D", "https://i.kym-cdn.com/photos/images/facebook/001/217/729/f9a.jpg")
    )
}