package com.example.altesuto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.E

class MainActivity : AppCompatActivity() {

    private var count: Int = 0
    private var count2: Int = 0
    private var count3: Int = 0
    private var count4: Int = 0
    private var count5: Int = 0
    private var count6: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendButton.setOnClickListener {
            val intent = Intent(applicationContext, SubActivity::class.java)
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
        val button5 = findViewById<Button>(R.id.count_button3)//　button5を使用
        val textView3 = findViewById<TextView>(R.id.count_text3)
        button5.setOnClickListener {
            count3 += 1
            textView3.text = count3.toString()
        }
        val button6 = findViewById<Button>(R.id.count_down3)//  button6を使用
        button6.setOnClickListener{
            count3 -= 1
            textView3.text = count3.toString()
        }

        //ハイボールのカウント動作
        val button7 = findViewById<Button>(R.id.count_button4)//　button5を使用
        val textView4 = findViewById<TextView>(R.id.count_text4)
        button7.setOnClickListener {
            count4 += 1
            textView4.text = count4.toString()
        }
        val button8 = findViewById<Button>(R.id.count_down4)//  button6を使用
        button8.setOnClickListener{
            count4 -= 1
            textView4.text = count4.toString()
        }

        //ワインのカウント動作
        val button9 = findViewById<Button>(R.id.count_button5)//　button5を使用
        val textView5 = findViewById<TextView>(R.id.count_text5)
        button9.setOnClickListener {
            count5 += 1
            textView5.text = count5.toString()
        }
        val button10 = findViewById<Button>(R.id.count_down5)//  button6を使用
        button10.setOnClickListener{
            count5 -= 1
            textView5.text = count5.toString()
        }

        //日本酒のカウント動作
        val button11 = findViewById<Button>(R.id.count_button6)//　button5を使用
        val textView6 = findViewById<TextView>(R.id.count_text6)
        button11.setOnClickListener {
            count6 += 1
            textView6.text = count6.toString()
        }
        val button12 = findViewById<Button>(R.id.count_down6)//  button6を使用
        button12.setOnClickListener{
            count6 -= 1
            textView6.text = count6.toString()
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