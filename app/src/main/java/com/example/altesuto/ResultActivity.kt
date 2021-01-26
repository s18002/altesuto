package com.example.altesuto

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*


class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // 結果を取得    /////////////////////
        val intent = intent
        val result = intent.getBooleanExtra("result", false)

        // 結果に合わせて表示切り替え ////////
        if (!result) ivResult.setImageResource(R.drawable.result_b2)
        // import android.R;があるとRがローカルではなくandroidを指定するためdrawbleから参照できなくなる
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