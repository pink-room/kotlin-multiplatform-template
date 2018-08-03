package co.pinkroom.multiplatformtemplate

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import co.pinkroom.multiplatformtemplate.data.repository.MemeRepository
import co.pinkroom.multiplatformtemplate.domain.GetMemes
import co.pinkroom.multiplatformtemplate.presentation.memes.MemesContract
import co.pinkroom.multiplatformtemplate.presentation.memes.MemesPresenter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_memes.*

class MemesActivity : AppCompatActivity(), MemesContract.View {

  private val presenter = MemesPresenter(GetMemes(MemeRepository()))

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_memes)
    nextView.setOnClickListener { presenter.onNextClicked() }
    presenter.start(this)
  }

  override fun showMemeImage(url: String) {
    Glide.with(this).load(url).into(memeView)
  }

  override fun showMemeTitle(title: String) {
    titleView.text = title
  }
}
