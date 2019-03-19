package com.dncrjim.metronome

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TempoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tempo)


        val button = findViewById<Button>(R.id.returnButton)
        button.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))

        }
    }

}