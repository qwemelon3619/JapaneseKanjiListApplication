package com.example.sampleprojecct.database
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface KanjiDatabaseDao {

    @Query("SELECT * from `KanjiList.db` WHERE Level=:key")
    fun findListByLevel(key: String) : List<KanjiWord>
    @Query("SELECT * from `KanjiList.db` WHERE Level=:key")
    fun findListByLevelLivedata(key: String) : LiveData<List<KanjiWord>>
    @Insert
    fun insert(instance: KanjiWord)
}