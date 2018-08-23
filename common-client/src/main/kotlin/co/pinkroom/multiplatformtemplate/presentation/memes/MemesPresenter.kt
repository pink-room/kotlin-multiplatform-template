package co.pinkroom.multiplatformtemplate.presentation.memes

import co.pinkroom.multiplatformtemplate.UIDispatcher
import co.pinkroom.multiplatformtemplate.data.model.Meme
import co.pinkroom.multiplatformtemplate.domain.GetMemes
import kotlinx.coroutines.experimental.launch

class MemesPresenter(private val getMemes: GetMemes) : MemesContract.Presenter {

    private lateinit var view: MemesContract.View
    private val memes: MutableList<Meme> = mutableListOf()
    private var currentMeme: Int = 0

    override fun start(view: MemesContract.View) {
        this.view = view
        initView()
    }

    override fun onNextClicked() {
        showNextMemeIfExists()
    }

    private fun initView() {
        getNewMemes()
        currentMeme = 0
        showNextMemeIfExists()
    }

    private fun getNewMemes() {
        getMemes.run { newMemes ->
            memes.clear()
            memes.addAll(newMemes)
            launch(UIDispatcher) { showCurrentMemeIfExists() }
        }
    }

    private fun showCurrentMemeIfExists() {
        if (memes.size <= 0) return
        view.showMemeImage(memes[currentMeme].url)
        view.showMemeTitle(memes[currentMeme].title)
    }

    private fun showNextMemeIfExists() {
        if (memes.size <= 0) return
        currentMeme = (currentMeme + 1) % memes.size
        showCurrentMemeIfExists()
    }
}