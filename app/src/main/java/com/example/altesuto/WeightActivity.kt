package com.example.altesuto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
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
            intent.putExtra("data1", weight?.id)
            startActivity(intent)
        }

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
}

