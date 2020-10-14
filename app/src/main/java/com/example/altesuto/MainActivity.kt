package com.example.altesuto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var count: Int = 0
    private var count2: Int = 0
    private var count3: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendButton.setOnClickListener {
            val intent = Intent(application, SubActivity::class.java)
            startActivity(intent)
        }
        //泡盛のカウント動作
        val button = findViewById<Button>(R.id.count_button)
        val textView = findViewById<TextView>(R.id.count_text)
        button.setOnClickListener {
            count += 1
            textView.text = count.toString()
        }
        val button3 = findViewById<Button>(R.id.count_down)//  button3を使用
        button3.setOnClickListener {
            count -= 1
            textView.text = count.toString()
        }

        //ビールのカウント動作
        val button2 = findViewById<Button>(R.id.count_button2)//　button2を使用
        val textView2 = findViewById<TextView>(R.id.count_text2)
        button2.setOnClickListener {
            count2 += 1
            textView2.text = count2.toString()
        }
        val button4 = findViewById<Button>(R.id.count_down2)//  button4を使用
        button4.setOnClickListener{
            count2 -= 1
            textView2.text = count2.toString()
        }

        //チューハイのカウント動作
        val button5 = findViewById<Button>(R.id.count_button3)//　button2を使用
        val textView3 = findViewById<TextView>(R.id.count_text3)
        button5.setOnClickListener {
            count3 += 1
            textView3.text = count3.toString()
        }
        val button6 = findViewById<Button>(R.id.count_down3)//  button4を使用
        button6.setOnClickListener{
            count3 -= 1
            textView3.text = count3.toString()
        }
    }
}
/*
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
 */