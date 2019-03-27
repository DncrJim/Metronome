package com.dncrjim.metronome

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Tempos::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun tempoDao(): TempoDao

    companion object {
        private var APPDATABASE: AppDatabase? = null

        //Todo: Build APPDATABASE for testing here?

        fun getInstance(context: Context): AppDatabase? {
            if (APPDATABASE == null) {
                synchronized(AppDatabase::class) {
                    //Todo: Change inMemoryDatabaseBuilder() to databaseBuilder()
                    //Todo: Remove Main Thread Queries?
                    //APPDATABASE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase::class.java, "Tempos.db").allowMainThreadQueries().build()
                    APPDATABASE = Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase::class.java).allowMainThreadQueries().build()
                }
            }
            return APPDATABASE
        }

        fun destroyAppDatabase() {
            APPDATABASE = null
        }
    }
}


//https://medium.com/mindorks/android-architecture-components-room-and-kotlin-f7b725c8d1d