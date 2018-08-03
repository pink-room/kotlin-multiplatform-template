package co.pinkroom.multiplatformtemplate.presentation.memes

import co.pinkroom.multiplatformtemplate.data.Meme
import co.pinkroom.multiplatformtemplate.domain.GetMemes

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
        val newMemes = getMemes.run()
        memes.clear()
        memes.addAll(newMemes)
    }

    private fun showNextMemeIfExists() {
        if (memes.size <= 0) return
        currentMeme = (currentMeme + 1) % memes.size
        view.showMemeImage(memes[currentMeme].url)
        view.showMemeTitle(memes[currentMeme].title)
    }
}