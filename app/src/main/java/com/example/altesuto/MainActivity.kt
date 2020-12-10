package com.example.altesuto

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var count: Int = 0
    private var count2: Int = 0
    private var count3: Int = 0
    private var count4: Int = 0
    private var count5: Int = 0
    private var count6: Int = 0

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId) {
            R.id.input -> {(
                    "file:app/src/main/java/com/example/altesuto/MainActivity.kt"
                    )
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //純アルコール量（ｇ）÷（体重×0.1）＝アルコール処理に要する時間

        sendButton.setOnClickListener {
            val intent = Intent(applicationContext, SubActivity::class.java)

            val countresult =((18*count)/*泡盛 */ + (16*count2)/*ビール*/ + (22*count3)/*チューハイ*/ +
                    (22*count4)/*ハイボール*/ + (11*count5)/*ワイン*/ + (21*count6)/*日本酒*/) / 7 /*体重(70kg*0.1)*/
            intent.putExtra("test", countresult)
            startActivity(intent)
        }

        rstbutton.setOnClickListener {
            count = 0
            count_text.text = count.toString()
            count2 = 0
            count_text2.text = count2.toString()
            count3 = 0
            count_text3.text = count3.toString()
            count4 = 0
            count_text4.text = count4.toString()
            count5 = 0
            count_text5.text = count5.toString()
            count6 = 0
            count_text6.text = count6.toString()
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