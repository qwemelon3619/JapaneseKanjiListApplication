package com.example.sampleprojecct.LearningFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleprojecct.R
import com.example.sampleprojecct.database.KanjiDatabase
import com.example.sampleprojecct.database.KanjiWord
import com.example.sampleprojecct.databinding.FragmentLearningBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.w3c.dom.Text

/**
 * A simple [Fragment] subclass.
 * Use the [learningFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LearningFragment : Fragment() {
    private lateinit var newArrayList: ArrayList<LearningViewData>

    lateinit var binding: FragmentLearningBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_learning,container,false)
        val application = requireNotNull(this.activity).application
        val dataSource = KanjiDatabase.getWord(application).kanjiDatabaseDao()
        val viewModelFactory = LearningViewFactory(dataSource,application)
        val LearningViewModel = ViewModelProvider(this,viewModelFactory).get(LearningViewModel::class.java)

        val manager= GridLayoutManager(activity,2)


        // Inflate the layout for this fragment
        binding.kanjiCardGrid.layoutManager = manager
//        newArrayList = arrayListOf()
//        val kanji : Array<String> = arrayOf("a","b","c","d","e")
//        val mean : Array<String> = arrayOf("123","123","123","123","123")
//        for(i in kanji.indices){
//            newArrayList.add(LearningViewData(kanji[i],mean[i])
//        }
        val data = LearningViewModel.getWordByLevel("소학교2학년")
        val adapter = LearningAdapter()
        binding.kanjiCardGrid.adapter = adapter

//        return inflater.inflate(R.layout.fragment_learning, container, false)
        return binding.root

    }



}