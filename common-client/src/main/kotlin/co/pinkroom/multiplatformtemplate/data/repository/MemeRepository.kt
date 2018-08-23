package co.pinkroom.multiplatformtemplate.data.repository

import co.pinkroom.multiplatformtemplate.ApplicationDispatcher
import co.pinkroom.multiplatformtemplate.data.api.ApiUtils
import co.pinkroom.multiplatformtemplate.data.model.Meme
import io.ktor.client.HttpClient
import io.ktor.client.request.*
import io.ktor.http.URLProtocol
import kotlinx.coroutines.experimental.launch
import kotlinx.serialization.json.JsonTreeParser

class MemeRepository {

    private val client = HttpClient()

    fun getMemes(callback: (List<Meme>) -> Unit) {
        launch(ApplicationDispatcher) {
            val result = getMemesFromServer()
            callback(parseResultToMemes(result))
        }
    }

    private suspend fun getMemesFromServer(): String {
        return client.get {
            url {
                protocol = URLProtocol.HTTPS
                host = ApiUtils.host
                port = URLProtocol.HTTPS.defaultPort
                encodedPath = "memes"
            }
        }
    }

    // TODO: This should be refactored as soon as kotlinx serialization is available for Kotlin Native
    private fun parseResultToMemes(result: String): List<Meme> {
        val elem = JsonTreeParser(result).read()
        return elem.jsonArray.map {
            Meme(it.jsonObject["title"].primitive.content, it.jsonObject["url"].primitive.content)
        }
    }
}