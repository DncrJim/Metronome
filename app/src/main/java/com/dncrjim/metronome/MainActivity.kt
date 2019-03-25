package com.dncrjim.metronome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModelProviders
import com.dncrjim.metronome.AddOrEditActivity
import kotlinx.android.synthetic.main.activity_main.*
import com.dncrjim.metronome.DatabaseHandler

class MainActivity : AppCompatActivity() {

    //Todo: if tempoList null create default list of tempos?

    var listTempos: List<Tempos> = ArrayList<Tempos>()


        //Todo: make tempoList persistent across app and saves.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //onclick for last tempo and new tempo

        lastTempoButton.setOnClickListener {
            startActivity(Intent(applicationContext, TempoActivity::class.java))
        }

        newTempoButton.setOnClickListener {
            inputNewTempo()
        }
        //Todo: Recycler View for recently used tempos
        //Todo: Add Readme


    }

    fun initDB() {
        dbHandler = DatabaseHandler(this)
        listTempos = (dbHandler as DatabaseHandler).tempo()
        tempoRecyclerAdapter = TempoRecyclerAdapter(tempoList = listTempos, context = applicationContext)
        (recyclerView as RecyclerView).adapter = taskRecyclerAdapter
    }



    private fun inputNewTempo() {
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.new_tempo_dialog, null)
        dialogBuilder.setView(dialogView)

        val editText = dialogView.findViewById<View>(R.id.editTempoText) as EditText

        dialogBuilder.setTitle("Add New Tempo")
        dialogBuilder.setPositiveButton("OK") {dialog, whichButton ->

            val tempoAsInt = editText.text.toString().toInt()
            when (tempoAsInt) {
                !in 36..300 -> Toast . makeText (this, "Error: Tempo must be between 36 and 300", Toast.LENGTH_LONG).show()
                in tempoList -> {
                    val intent = Intent(this, TempoActivity::class.java)
                    intent.putExtra("SEND_TEMPO",tempoAsInt)
                    startActivity(intent)
                }
                else -> {
                    tempoList.add(tempoAsInt)
                    val intent = Intent(this, TempoActivity::class.java)
                    intent.putExtra("SEND_TEMPO",tempoAsInt)
                    startActivity(intent)
                }
                //also close dialog box?
            }
        }
        dialogBuilder.setNegativeButton("Cancel") {dialog, whichButton -> }

        val b = dialogBuilder.create()
        b.show()
        }

    override fun onResume() {
        super.onResume()
        initDB()
    }
}



