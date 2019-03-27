package com.dncrjim.metronome

import androidx.room.*

@Dao
interface TempoDao {
    @Query("SELECT * from tempos")
    fun getAllTempos(): List<Tempos>

    @Query("DELETE FROM tempos")
    fun deleteAllTempos()


    @Query("select * from tempos where id = :id")
    fun getTempoById(id: Int): Tempos

    @Query("DELETE from tempos where id = :id")
    fun deleteTempoById(id: Int): Tempos





    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTempo(tempos: Tempos)

//    @Query("DELETE from tempos")
//    fun deleteTempos()
//
//    @Update
//    fun updateTempo(tempos: Tempos)
//
//
//    @Query("UPDATE Tempos SET tempo = :tempo, frequency = :frequency where id = :id")
//    fun updateTempo(tempo: Int, frequency: Int, id : Long?)


}