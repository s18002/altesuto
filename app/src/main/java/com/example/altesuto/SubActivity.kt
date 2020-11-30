package com.example.altesuto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Menu
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {

    inner class MycountDownTimer(millisInFuture: Long,           // millisInFutureはタイマーの残り時間をミリ秒で指定する
                                 countDownInterval: Long) :      // countDownIntervalは後述のonTickメソッドを実行する間隔をミリ秒で指定する
        CountDownTimer(millisInFuture, countDownInterval) {
        var isRunning = true   // 本誌だとスタート、ストップを一つのボタンで行うから必要とあったからいらないかも
        override fun onTick(millisUntilFinished: Long) {     // millisUntilFinishedは残り時間をミリ秒で表した数値
            val hour = millisUntilFinished / 1000L / 3600L   // 時間を算出する記述　Lがなんなのかわからん・・・
            val minute = millisUntilFinished / 1000L % 60L   // 分
            val second = millisUntilFinished / 1000L % 60L   // 秒
            textView8.text = "%1d:%2$02d:%3$02d".format(hour, minute, second)
            // テキストに時間：分：秒と表示するための記述
            // %1は引数の１番目(hour),dは整数で表示を意味している
            // %2は引数の２番目(minute),02dは二桁の整数で表示を意味している
        }
        override fun onFinish() {               // タイマー終了時に呼び出されるメソッド　ここにタイマー終了サウンド処理とか記述する
            textView8.text = "0:00:00"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

    val sake = intent.getIntExtra("test", 0)
        textView8.setText(sake.toString())

        returnButton.setOnClickListener {
            finish()
        }

        textView8.text = "${sake}:00:00"
        val timer = MycountDownTimer(sake * 3600L * 1000L, 100)
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
