package co.pinkroom.multiplatformtemplate.domain

import co.pinkroom.multiplatformtemplate.data.repository.MemeRepository

class GetMemes(private val memeRepository: MemeRepository) {

    fun run() = memeRepository.getMemes()
}
