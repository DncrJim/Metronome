package com.dncrjim.metronome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var handler: Handler

    // put
    //var tempoList = mutableListOf<Int>(80, 100, 120, 140)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //onclick for last tempo and new tempo
        lastTempoButton.setOnClickListener {
            startActivity(Intent(applicationContext, TempoActivity::class.java))
        }

        newTempoButton.setOnClickListener {
            inputNewTempo()
        }

        //Todo: Recycler View for recently used tempoList
    }

    //popup to add new tempo
    fun inputNewTempo() {
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.custom_dialog, null)
        dialogBuilder.setView(dialogView)


        val editText = dialogView.findViewById<View>(R.id.editTempoText) as EditText
        dialogBuilder.setTitle("Add New Tempo")
        dialogBuilder.setPositiveButton("OK") {dialog, whichButton ->

            var tempoAsInt = editText.text.toString().toInt()
            when (tempoAsInt) {
                //reject tempoList outside of acceptable range
                !in 36..300 -> Toast . makeText (this, "Error: Tempo must be between 36 and 300", Toast.LENGTH_LONG).show()
                else -> {

                    //add new tempo to tempoList. can't generate own ID yet
                    tempoList.add(Tempo(nextId(), tempoAsInt, 0))

                    //move to other activity and send new tempo
                    val intent = Intent(this, TempoActivity::class.java)
                    intent.putExtra("currentTempo", tempoAsInt)
                    startActivity(intent)
                }
                //Todo: also close dialog box?
            }
        }
        dialogBuilder.setNegativeButton("Cancel") {dialog, whichButton -> }

        val b = dialogBuilder.create()
        b.show()
        }

    //get next ID number from tempoList...
    private fun nextId(): Int {
        if (tempoList.size == null) {
            return 1
        } else {
            return tempoList.size + 1
        }
    }

}

