package com.example.sampleprojecct.LearningFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleprojecct.R
import com.example.sampleprojecct.databinding.FragmentLearningBinding
import org.w3c.dom.Text

/**
 * A simple [Fragment] subclass.
 * Use the [learningFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LearningFragment : Fragment() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<LearningViewData>
    lateinit var kanji: Array<String>
    lateinit var kanjiKorean: Array<String>
    private lateinit var binding: FragmentLearningBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLearningBinding.inflate(inflater,container,false);
        newRecyclerView = binding.kanjiCardGrid
        val manager= GridLayoutManager(activity,2)
        newRecyclerView.layoutManager = manager
        newArrayList = arrayListOf()
        // Inflate the layout for this fragment
        kanji = arrayOf(
            "一","二","三","士","五"
        )
        kanjiKorean = arrayOf(
            "한 일","두 이","석 삼","선비 사","다섯 오"
        )
        getUserdata()
        return binding.root
//        return inflater.inflate(R.layout.fragment_learning, container, false)
//        return binding.root

    }

    private fun getUserdata() {
        for(i in kanji.indices){
            val word = LearningViewData(kanji[i],kanjiKorean[i])
            newArrayList.add(word)
        }
        newRecyclerView.adapter= LearningAdapter(newArrayList)
    }


}