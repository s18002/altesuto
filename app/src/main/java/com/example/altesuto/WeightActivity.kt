package com.example.altesuto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Half.toFloat
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.SeekBar
import android.widget.Spinner
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_weight.*

class WeightActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weight)

        Button.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            val weightInt = weight.text
            println(weightInt)
            intent.putExtra("data1", weightInt)
            startActivity(intent)
        }

        /*val weigthStr = 体重のテキストID.text.toString()

        println(countresult)
            intent.putExtra("test", countresult)
            startActivity(intent)

        val weigthInt = weigthStr.toInt()

        intentのweigth?.idのとこweigthIntにする
         */

        spinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {

                override
                fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val spinner = parent as? Spinner
                    val item = spinner?.selectedItem as? String
                    item?.let {
                        if (it.isNotEmpty()) weight.text = it
                    }
                }

                override
                fun onNothingSelected(parent: AdapterView<*>?) {
                }

            }

        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val heightVal = pref.getInt("HEIGHT", 160)
        weight.text = heightVal.toString()
        seekBar.progress = heightVal

        seekBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    weight.text = progress.toString()
                }

                override
                fun onStartTrackingTouch(seekBar: SeekBar?) {
                }

                override
                fun onStopTrackingTouch(seekBar: SeekBar?) {
                }
            })
    }
    override fun onPause() {
        super.onPause()
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        pref.edit {
            putInt("HEIGHT", weight.text.toString().toInt())
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean{
        when(item?.itemId) {
            R.id.input -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.time -> {
                val intent = Intent(this, SubActivity::class.java)
                startActivity(intent)
            }
            R.id.weight -> {
                val intent = Intent(this, WeightActivity::class.java)
                startActivity(intent)
            }
            R.id.game -> {
                val intent = Intent(this, PuzzlegameActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}

