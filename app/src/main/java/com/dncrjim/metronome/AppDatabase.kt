package com.dncrjim.metronome

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Tempos::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        private var APPDATABASE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (APPDATABASE == null) {
                synchronized(AppDatabase::class) {
                    APPDATABASE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase::class.java, "Tempos.db").allowMainThreadQueries().build()
                }
            }
            return APPDATABASE
        }
    }

    abstract fun tempoDao(): TempoDao
}