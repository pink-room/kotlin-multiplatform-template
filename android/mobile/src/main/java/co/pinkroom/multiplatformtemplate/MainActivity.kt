package co.pinkroom.multiplatformtemplate

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import co.pinkroom.multiplatformtemplate.domain.GetRecipe

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val titleView = findViewById<TextView>(R.id.title)
        titleView.text = GetRecipe().run().title
    }
}
