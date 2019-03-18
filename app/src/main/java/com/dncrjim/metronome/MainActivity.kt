package com.dncrjim.metronome

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    var tempoList = mutableListOf<Int>(80, 100, 120, 140)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Todo: Insert data to make project only in Portrait (PizzaKeeper)



        //Todo: New Tempo Popup

            inputNewTempo()



        //Todo: Recycler View for recently used tempos
    }

    fun inputNewTempo() {
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.custom_dialog, null)
        dialogBuilder.setView(dialogView)

        val editText = dialogView.findViewById<View>(R.id.editTextName) as EditText

        dialogBuilder.setTitle("Add New Tempo")
        //insert textbox with string here as setMessage()?
        dialogBuilder.setPositiveButton("OK") { dialog, whichButton ->
            //do something with edt.getText().toString();

            var tempoAsInt = editText.text.toString().toInt()
            if (tempoAsInt != null) {


                //also close dialog box?
                Toast.makeText(this, "Not a Valid Number", Toast.LENGTH_LONG).show()

            } else if (tempoAsInt > 300, tempoAsInt < 36) {


            } else {
                // Add Name in list    ---   change to Int?
                tempoList.add(tempoAsInt)
                // Handler code here.
                val intent = Intent(this, NewTempoActivity::class.java)
                startActivity(intent)
            }

        }
        dialogBuilder.setNegativeButton("Cancel") { dialog, whichButton -> }

        val b = dialogBuilder.create()
        b.show()

    }
}
