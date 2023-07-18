package com.example.sampleprojecct.LearningFragment

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sampleprojecct.database.KanjiDatabaseDao
import com.example.sampleprojecct.database.KanjiWord
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LearningViewModel(val database: KanjiDatabaseDao,
                        application: Application): AndroidViewModel(application){

    private var wordlist : List<KanjiWord> = listOf()

    private var wordlistCalled = false

    private val wordlistOnView = MutableLiveData<List<KanjiWord>>()
    val _wordlistOnView : LiveData<List<KanjiWord>>
        get() = wordlistOnView
    private val wordlistPageNumber = MutableLiveData<Int>()
    val _wordlistPageNumber : LiveData<Int>
        get() = wordlistPageNumber

    val wordDB = database


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
    fun nextPageClicked(){
        if(wordlist.size/6 > wordlistPageNumber.value!!){
                wordlistPageNumber.value = wordlistPageNumber.value?.plus(1)
                wordlistOnView.value = setWordlistOnView()
        }

    }
    fun previousPageClicked(){
        if(wordlistPageNumber.value!! > 1) {
            wordlistPageNumber.value = wordlistPageNumber.value?.minus(1)
            wordlistOnView.value = setWordlistOnView()
        }

    }
    fun initalizeWordlist(){
        GlobalScope.launch {
            if(!wordlistCalled){
                wordlist = getWordsByLevel("소학교1학년")
                wordlistCalled = true
                wordlistPageNumber.postValue(1)
                wordlistOnView.postValue(setWordlistOnView())
            }
           else{
                wordlistOnView.postValue(setWordlistOnView())
            }

//                kanjiOnView.postValue(getWordsByLevel("소학교1학년"))
            Log.i("LearningModel", "what is Wordlistdata $wordlist" )
        }
    }

    private fun setWordlistOnView(): MutableList<KanjiWord> {
        val tempWordlistonView = mutableListOf<KanjiWord>()
        for (i in 0..5) {
            tempWordlistonView.add(
                wordlist[((wordlistPageNumber.value?.minus(1))?.times(6) ?: 0) + i]
            )
        }
        return tempWordlistonView
    }

}