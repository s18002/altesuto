package com.example.altesuto

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_play.*
import java.util.*

class PlayActivity : AppCompatActivity() {
    // 問題データ    ///////////////////////////////////
    var ans =
        arrayOf("烏", "鶏", "鷲", "梟", "鷹", "鳩", "鷺", "鶴", "燕")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        /////////////////////////////////////////////
        // クイズのセット  //////////////////////////
        val list: List<*> = Arrays.asList(*ans.clone())
        Collections.shuffle(list)
        b0?.text = list[0].toString()
        b1?.text = list[1].toString()
        b2?.text = list[2].toString()
        b3?.text = list[3].toString()
        b4?.text = list[4].toString()
        b5?.text = list[5].toString()
        b6?.text = list[6].toString()
        b7?.text = list[7].toString()
        b8?.text = list[8].toString()
    }

    /////////////////////////////////////////////
    // 正解判定  ////////////////////////////////
    fun onButton(v: View) {
        // 画面切り替え準備
        val intent = Intent(this, ResultActivity::class.java)
        // 文字の取得
        val buttonText = (v as Button).text.toString()
        // 正解判定
        if (buttonText == ans[0]) {
            intent.putExtra("result", true)
        } else {
            intent.putExtra("result", false)
        }
        // 画面切り替え
        startActivity(intent)
        finish()
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