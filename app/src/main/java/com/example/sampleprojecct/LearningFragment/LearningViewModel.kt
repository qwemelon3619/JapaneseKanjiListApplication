package com.example.sampleprojecct.LearningFragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.sampleprojecct.database.KanjiDatabaseDao
import com.example.sampleprojecct.database.KanjiWord
import kotlinx.coroutines.launch

class LearningViewModel(val database: KanjiDatabaseDao,
                        application: Application): AndroidViewModel(application){

    private var _wordlist = MutableLiveData<List<KanjiWord>>()
    val wordlist : LiveData<List<KanjiWord>>
        get() = _wordlist

    val wordDB = database

    private val _checked = MutableLiveData<Boolean>()
    val checked : LiveData<Boolean>
        get() = _checked

    private val _level = MutableLiveData<String>()
    val level : LiveData<String>
        get() = _level
    suspend fun getWordsFromDatabase(level: String): List<KanjiWord> {
        val word = database.findListByLevel(this.level)
        return word
    }
     fun getWordByLevel(level: String) {
         viewModelScope.launch{
             _wordlist.value = getWordsFromDatabase(level)!!
         }
     }

}