package com.example.sampleprojecct.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [KanjiWord::class], version = 1)
abstract class KanjiDatabase : RoomDatabase() {
    abstract fun kanjiDatabaseDao() : KanjiDatabaseDao

    companion object{


        private var INSTANCE: KanjiDatabase? = null
        fun getWord(context:Context): KanjiDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(context.applicationContext
                    ,KanjiDatabase::class.java,"sample.db")
                        .createFromAsset("database/data.db")
                        .build()
                    INSTANCE = instance
                }
                return instance
            }

        }
    }

}