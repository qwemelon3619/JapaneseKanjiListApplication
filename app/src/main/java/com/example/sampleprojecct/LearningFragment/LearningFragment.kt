package com.example.sampleprojecct.LearningFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.sampleprojecct.R
import com.example.sampleprojecct.database.KanjiDatabase
import com.example.sampleprojecct.databinding.FragmentLearningBinding

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
        LearningViewModel.initalizeWordlist()

        LearningViewModel._wordlistOnView.observe(viewLifecycleOwner){
            it?.let{
                val adapter = LearningAdapter(it)
                binding.kanjiCardGrid.adapter = adapter
            }
        }
        binding.KanjiNext.setOnClickListener {
            LearningViewModel.nextPageClicked()
        }
        binding.KanjiPrevious.setOnClickListener {
            LearningViewModel.previousPageClicked()
        }
//        return inflater.inflate(R.layout.fragment_learning, container, false)
        return binding.root

    }



}