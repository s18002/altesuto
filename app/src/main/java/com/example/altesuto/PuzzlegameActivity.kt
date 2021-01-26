package com.example.altesuto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.view.View


class PuzzlegameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_puzzlegame)
    }

    //////////////////////////////////////////////
    // プレイ画面表示
    fun onStart(@Suppress("UNUSED_PARAMETER")view: View?) {
        val intent = Intent(this, PlayActivity::class.java)
        startActivity(intent)
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