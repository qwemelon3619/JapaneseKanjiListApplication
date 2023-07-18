package com.example.sampleprojecct.LearningFragment

import android.app.Application
import android.provider.Settings.Global
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.sampleprojecct.database.KanjiDatabaseDao
import com.example.sampleprojecct.database.KanjiWord
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LearningViewModel(val database: KanjiDatabaseDao,
                        application: Application): AndroidViewModel(application){

    var wordlist : List<KanjiWord> = listOf()


    private val kanjilist = MutableLiveData<List<KanjiWord>>()
    val _kanjilist : LiveData<List<KanjiWord>>
        get() = kanjilist

    val wordDB = database

    private val _checked = MutableLiveData<Boolean>()
    val checked : LiveData<Boolean>
        get() = _checked

    private val _level = MutableLiveData<String>()
    val level : LiveData<String>
        get() = _level

    private suspend fun getWordsByLevel(Level: String): List<KanjiWord> {
        val data = database.findListByLevel(Level)
        Log.i("LearningModel", "readingDB $data" )
        return data
    }
    fun getWordsFromDatabase(){
        GlobalScope.launch {
            wordlist = getWordsByLevel("소학교1학년")
            Log.i("LearningModel", "what is Wordlistdata $wordlist" )
        }
    }
    fun getWordsFromDatabase2(){
        GlobalScope.launch {
            kanjilist.postValue(getWordsByLevel("소학교1학년"))
            Log.i("LearningModel", "what is Wordlistdata $wordlist" )
        }
    }

}