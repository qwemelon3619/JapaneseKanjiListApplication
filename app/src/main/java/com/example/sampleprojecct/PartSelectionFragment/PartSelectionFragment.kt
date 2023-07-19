package com.example.sampleprojecct.PartSelectionFragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.GridLayoutManager
import com.example.sampleprojecct.LearningFragment.LearningFragment
import com.example.sampleprojecct.MainActivity
import com.example.sampleprojecct.R
import com.example.sampleprojecct.databinding.FragmentPartSelectionBinding

//import com.example.sampleprojecct.databinding.
/**
 * A simple [Fragment] subclass.
 * Use the [PartSelectionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class PartSelectionFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var binding : FragmentPartSelectionBinding
    private val wordcout  = listOf<Int>(0,81, 161, 201, 203, 194, 192)
    lateinit var mainActivity : MainActivity
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_part_selection,container,false)
        setFragmentResultListener("SelectPart") { key, bundle ->
            // We use a String here, but any type that can be put in a B`undle is supported
            val level :Int = bundle.getInt("level")
            // Do something with the result...
            val adapter = PartSelectionAdapter(makeDataList(level))

            adapter.setItemClickListener(object : PartSelectionAdapter.OnItemClickListener {
                override fun onClick(v: View, position: Int) {
                    val learningFragment = LearningFragment()
                    val transaction = activity?.supportFragmentManager

                    onclickFunction(level,position,learningFragment,transaction)

                }
            })
            binding.partSelectionGrid.isNestedScrollingEnabled
            binding.partSelectionGrid.adapter = adapter
            var manager = GridLayoutManager(activity,2)
            binding.partSelectionGrid.layoutManager = manager


        }



        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_part_selection, container, false)
        return binding.root
    }
    private fun makeDataList(level: Int): List<PartSelectionData>{
        val dataList : MutableList<PartSelectionData> = mutableListOf<PartSelectionData>()
        val pagerNumber = wordcout[level]/30
        for(i in 0..pagerNumber){
            if(i == pagerNumber){
                dataList.add(PartSelectionData(level,i*30+1,i*30+1+(wordcout[level]%30)))
            }
            else{
                dataList.add(PartSelectionData(level,i*30+1,(i+1)*30))
            }
        }
        return dataList
    }
    private fun onclickFunction(
        level: Int,
        position: Int,
        partSelectionFragment: LearningFragment,
        transaction: FragmentManager?
    ){
        setFragmentResult("PartSelection", bundleOf("level" to level, "page" to position))
        mainActivity.setIteminMenu()
        transaction?.commit{
            replace(R.id.MainFragment,partSelectionFragment)
        }
    }
}