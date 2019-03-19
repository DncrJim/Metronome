package com.dncrjim.metronome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var tempoList = mutableListOf<Int>(80, 100, 120, 140)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Todo: Insert data to make project only in Portrait (PizzaKeeper)


        //onclick for last tempo and new tempo

        lastTempoButton.setOnClickListener {
            startActivity(Intent(applicationContext, TempoActivity::class.java))
        }

        newTempoButton.setOnClickListener {
            inputNewTempo()
        }


        //Todo: Recycler View for recently used tempos
    }

    fun inputNewTempo() {
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.custom_dialog, null)
        dialogBuilder.setView(dialogView)

        val editText = dialogView.findViewById<View>(R.id.`editTempoText`) as EditText

        dialogBuilder.setTitle("Add New Tempo")
        dialogBuilder.setPositiveButton("OK") {dialog, whichButton ->

            var tempoAsInt = editText.text.toString().toInt()
            when (tempoAsInt) {
                !in 36..300 -> Toast . makeText (this, "Error: Tempo must be between 36 and 300", Toast.LENGTH_LONG).show()
                in tempoList -> {
                    val intent = Intent(this, TempoActivity::class.java)
                    startActivity(intent)
                }
                else -> {
                    tempoList.add(tempoAsInt)
                    val intent = Intent(this, TempoActivity::class.java)
                    startActivity(intent)
                }
                //also close dialog box?
            }
        }
        dialogBuilder.setNegativeButton("Cancel") {dialog, whichButton -> }

        val b = dialogBuilder.create()
        b.show()
        }

    }

