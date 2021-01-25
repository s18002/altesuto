package com.example.altesuto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {
    inner class MycountDownTimer(millisInFuture: Long,           // millisInFutureはタイマーの残り時間をミリ秒で指定する
                                 countDownInterval: Long) :      // countDownIntervalは後述のonTickメソッドを実行する間隔をミリ秒で指定する
        CountDownTimer(millisInFuture, countDownInterval) {
        var isRunning = true   // 本誌だとスタート、ストップを一つのボタンで行うから必要とあったからいらないかも
        override fun onTick(millisUntilFinished: Long) {     // millisUntilFinishedは残り時間をミリ秒で表した数値
            val hour = (millisUntilFinished / (1000 * 60 * 60))   // 時間を算出する記述
            val minute = (millisUntilFinished / (1000 * 60))  % 60   // 分
            val second = (millisUntilFinished / 1000) % 60   // 秒
            textView8.text = "%1d:%2$02d:%3$02d".format(hour, minute, second)
            // テキストに時間：分：秒と表示するための記述
            // %1は引数の１番目(hour),dは整数で表示を意味している
            // %2は引数の２番目(minute),02dは二桁の整数で表示を意味している
        }
        override fun onFinish() {               // タイマー終了時に呼び出されるメソッド　ここにタイマー終了サウンド処理とか記述する
            textView8.text = "0:00:00"
        }
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        val sake = intent.getFloatExtra("test", 0f)
        textView8.setText(sake.toString())
        returnButton.setOnClickListener {
            finish()
        }
        textView8.text = "${sake}:00:00"
        val timer = MycountDownTimer((sake * 3600 * 1000).toLong(), 100)
        // タイマーの継続時間としてn時間、onTickが呼ばれる間隔として0.1秒(100て書いてるやつ)
        // ちなみにn分だとn * 60 * 1000となる
        // ここよくわからんかった　記述するのはtimer.isRunning()の方かも
        timer.isRunning
        timer.start()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
}
