package com.dncrjim.metronome

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Tempo::class], version = 1)
abstract class TempoDatabase : RoomDatabase() {

    abstract fun tempoDao(): TempoDao

//    private var db: TempoDatabase? = null

//    fun getInstance(context: Context): TempoDatabase? {
//        if (db == null) {
//            synchronized(TempoDatabase::class) {
//                //Todo: Change inMemoryDatabaseBuilder() to databaseBuilder()
//                //Todo: Remove Main Thread Queries?
//                //APPDATABASE = Room.databaseBuilder(context.getApplicationContext(), TempoDatabase::class.java, "Tempo.db").allowMainThreadQueries().build()
//                db = Room.inMemoryDatabaseBuilder(context.getApplicationContext(), TempoDatabase::class.java).allowMainThreadQueries().build()
//                }
//            }
//            return db
//        }
//
//    fun destroyAppDatabase() {
//        db = null
//    }

}


//https://medium.com/mindorks/android-architecture-components-room-and-kotlin-f7b725c8d1d