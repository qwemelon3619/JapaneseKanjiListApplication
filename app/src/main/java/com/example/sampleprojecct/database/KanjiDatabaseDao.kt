package com.example.sampleprojecct.database
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface KanjiDatabaseDao {

    @Query("SELECT * from Kanji_word_table Where level=:key")
    fun findListByLevel(key: LiveData<String>) : List<KanjiWord>

}