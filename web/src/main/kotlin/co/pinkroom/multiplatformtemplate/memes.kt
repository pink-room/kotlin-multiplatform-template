package co.pinkroom.multiplatformtemplate

import co.pinkroom.multiplatformtemplate.data.repository.MemeRepository
import co.pinkroom.multiplatformtemplate.domain.GetMemes
import co.pinkroom.multiplatformtemplate.presentation.memes.MemesContract
import co.pinkroom.multiplatformtemplate.presentation.memes.MemesPresenter
import org.w3c.dom.events.EventListener
import kotlin.browser.document

class Memes : MemesContract.View {

    private val presenter = MemesPresenter(GetMemes(MemeRepository()))

    init {
        document.getElementById("button_next")?.addEventListener("click", EventListener { presenter.onNextClicked() })
        presenter.start(this)
    }

    override fun showMemeImage(url: String) {
        document.getElementById("image")?.setAttribute("src", url)
    }

    override fun showMemeTitle(title: String) {
        document.getElementById("title")?.innerHTML = title
    }
}