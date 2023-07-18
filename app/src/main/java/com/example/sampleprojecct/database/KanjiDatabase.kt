package com.example.sampleprojecct.database

import android.content.Context
import android.util.Log
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [KanjiWord::class],
        version = 1)
abstract class KanjiDatabase : RoomDatabase() {
    abstract fun kanjiDatabaseDao() : KanjiDatabaseDao

    companion object{


        private var INSTANCE: KanjiDatabase? = null
        fun getWord(context:Context): KanjiDatabase{
            context.getDatabasePath("data.db").delete()
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(context.applicationContext
                    ,KanjiDatabase::class.java,"data.db")
                        .createFromAsset("database/data.db")
                        .build()
                    INSTANCE = instance
                    Log.i("Database", "Check Database" )
                }

                return instance
            }

        }
    }

}