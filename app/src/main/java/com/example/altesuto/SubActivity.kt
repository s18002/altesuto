package com.example.altesuto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        returnButton.setOnClickListener {
            finish()
        }
       // val intent = getIntent()
       // val message = intent.extras?.getString(MainActivity.EXTRA_MESSAGE)?:""
    }
}