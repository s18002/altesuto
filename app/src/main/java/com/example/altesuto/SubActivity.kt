package com.example.altesuto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val sake = intent.getIntExtra("test", 0)
        textView8.setText(sake.toString())

        returnButton.setOnClickListener {
            finish()
        }
        // val intent = getIntent()
        // val message = intent.extras?.getString(MainActivity.EXTRA_MESSAGE)?:""
    }
}