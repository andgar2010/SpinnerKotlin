package com.tech_andgar.App2067710_03Spinner

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*

import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
//  private var arrayAdapter: ArrayAdapter<String>? = null

//  private var itemListWords = arrayOf(
//      "ABC",
//      "DEF",
//      "GHI",
//      "JKL",
//      "MNO"
//  )

  public override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

//  load Items Spinner
//  arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_activated_1, itemListWords)
//    spinner_words_favorites?.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_activated_1, itemListWords)

//  watch Spinner Selected
    spinner_words_favorites?.onItemSelectedListener = this
  }

  override fun onNothingSelected(p0: AdapterView<*>?) {
    Toast.makeText(this, "Nothing Select", Toast.LENGTH_LONG).show()
  }

  override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//    var itemSelected: String = p0?.getItemAtPosition(p2) as String
//    Toast.makeText(this, "$itemSelected", Toast.LENGTH_LONG).show()

    var wordSelected = p0?.getItemAtPosition(p2).toString()
    text_meaning.text = getMeaning(wordSelected)
  }

  private fun getMeaning(word: String): String? {
    return when (word) {
      getString(R.string.esternocleidomastoideo_word) -> {
        getString(R.string.esternocleidomastoideo_meaning)
      }
      getString(R.string.elucubracion_word) -> {
        getString(R.string.elucubracion_meaning)
      }
      getString(R.string.idiosincrasia_word) -> {
        getString(R.string.idiosincrasia_meaning)
      }
      else -> {
        getString(R.string.unknown_word)
      }
    }
  }

  fun goToMeaning(v: View) {
    val word = (v as Button).text
    val intent = Intent(this@MainActivity, MeaningActivity::class.java)
    intent.putExtra(MeaningActivity.KEY_WORD, word)
    startActivity(intent)
  }
}