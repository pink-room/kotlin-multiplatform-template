package co.pinkroom.multiplatformtemplate.presentation.memes

class MemesContract {
    interface View {
        fun showMemeImage(url: String)

        fun showMemeTitle(title: String)
    }

    interface Presenter {
        fun start(view: View)

        fun onNextClicked()
    }
}