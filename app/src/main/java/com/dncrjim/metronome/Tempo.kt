package com.dncrjim.metronome

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// this is the model for a tempo object

@Entity(tableName = "tempoList")

data class Tempo (
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val tempo: Int,
        val frequency: Int



//class Tempo(@ColumnInfo(name = "tempo")
//                  var tempo: Int = 0,
//                  @ColumnInfo(name = "frequency")
//                  var frequency: Int = 0
//                    ) {
//    @PrimaryKey(autoGenerate = true)
//    var id: Long? = null;

)

