package co.pinkroom.multiplatformtemplate.data.repository

import co.pinkroom.multiplatformtemplate.ApplicationDispatcher
import co.pinkroom.multiplatformtemplate.data.model.Meme
import kotlinx.coroutines.experimental.launch

class MemeRepository {

    fun getMemes(): List<Meme> {

        launch(ApplicationDispatcher) {
            println("Coroutines test!")
        }

        return listOf(
                Meme("Chocolate!!!!", "https://i.imgflip.com/2f49xl.jpg"),
                Meme("Third World Problems.", "https://i.imgflip.com/2f37f4.jpg"),
                Meme("Cookies...", "https://i.imgflip.com/2f6n2b.jpg"),
                Meme("Can't get fired :D", "https://i.kym-cdn.com/photos/images/facebook/001/217/729/f9a.jpg")
        )
    }
}