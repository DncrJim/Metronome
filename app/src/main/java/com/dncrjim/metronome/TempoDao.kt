package com.dncrjim.metronome

import androidx.room.*

@Dao
interface TempoDao {
    @Query("SELECT * from tempoList")
    fun getAllTempos(): List<Tempo>

    @Query("DELETE FROM tempoList")
    fun deleteAllTempos()


    @Query("select * from tempoList where id = :id")
    fun getTempoById(id: Int): Tempo

    @Query("DELETE from tempoList where id = :id")
    fun deleteTempoById(id: Int): Tempo

    // this has an issue if a tempo from the middle is deleted
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTempo(tempo: Tempo)




//    @Query("DELETE from tempoList")
//    fun deleteTempos()
//
//    @Update
//    fun updateTempo(tempoList: Tempo)
//
//
//    @Query("UPDATE Tempo SET tempo = :tempo, frequency = :frequency where id = :id")
//    fun updateTempo(tempo: Int, frequency: Int, id : Long?)


}