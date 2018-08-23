package co.pinkroom.multiplatformtemplate.domain

import co.pinkroom.multiplatformtemplate.data.model.Meme
import co.pinkroom.multiplatformtemplate.data.repository.MemeRepository

class GetMemes(private val memeRepository: MemeRepository) {

    fun run(callback: (List<Meme>) -> Unit) = memeRepository.getMemes(callback)
}
