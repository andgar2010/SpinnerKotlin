package com.tech_andgar.App2067710_03Spinner

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_meaning.*

class MeaningActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_meaning)

    val word = intent.getStringExtra(KEY_WORD)
    title = word

    meaning.text = when(word) {
      getString(R.string.esternocleidomastoideo_word) ->
        getString(R.string.esternocleidomastoideo_meaning)
      getString(R.string.elucubracion_word) ->
        getString(R.string.elucubracion_meaning)
      getString(R.string.idiosincrasia_word) ->
        getString(R.string.idiosincrasia_meaning)
      else -> getString(R.string.unknown_word)
    }
  }

  companion object {
    const val KEY_WORD = "word"
  }
}