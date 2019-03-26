package com.dncrjim.metronome

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update

@Dao
interface TempoDao {
    @Query("SELECT * from tempos")
    fun getTempos(): List<Tempos>

    @Insert(onConflict = REPLACE)
    fun insertTempo(tempos: Tempos)

    @Query("DELETE from tempos")
    fun deleteTempos()

    @Update
    fun updateTempo(tempos: Tempos);
    

    @Query("DELETE from Tempos where id = 1")
    fun deleteTempo()

    @Query("UPDATE Tempos SET tempo = :tempo, frequency = :frequency where id = :id")
    fun updateTempo(tempo: Int, frequency: Int, id : Long?)
}