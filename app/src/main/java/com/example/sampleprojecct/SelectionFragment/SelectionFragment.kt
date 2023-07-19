package com.example.sampleprojecct.SelectionFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.children
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResult
import com.example.sampleprojecct.PartSelectionFragment.PartSelectionFragment
import com.example.sampleprojecct.R
import com.example.sampleprojecct.databinding.FragmentSelectionBinding


// TODO: Rename parameter arguments, choose names that match

class SelectionFragment : Fragment() {
    lateinit var binding : FragmentSelectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_selection,container,false)
        buttonOnClickListener()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun buttonOnClickListener() {
        val btnSequence = binding.SelectGrid.children
        val transaction = activity?.supportFragmentManager
        val partSelectionFragment = PartSelectionFragment()
        btnSequence.forEach { btn->
            btn.setOnClickListener{v->
                when(v.id){
                    R.id.Select_level_1->{
                        Log.i("SelectionView","btn 1 clicked")
                        onclickFunction(1,partSelectionFragment,transaction)
                    }
                    R.id.Select_level_2->{
                        Log.i("SelectionView","btn 2 clicked")
                        onclickFunction(2, partSelectionFragment, transaction)
                    }
                    R.id.Select_level_3->{
                        Log.i("SelectionView","btn 3 clicked")
                        onclickFunction(3, partSelectionFragment, transaction)
                    }
                    R.id.Select_level_4->{
                        Log.i("SelectionView","btn 4 clicked")
                        onclickFunction(4, partSelectionFragment, transaction)
                    }
                    R.id.Select_level_5->{
                        Log.i("SelectionView","btn 5 clicked")
                        onclickFunction(5, partSelectionFragment, transaction)
                    }
                    R.id.Select_level_6->{
                        Log.i("SelectionView","btn 6 clicked")
                        onclickFunction(6, partSelectionFragment, transaction)
                    }
                }
            }
        }
    }
    private fun onclickFunction(
        level: Int,
        partSelectionFragment: PartSelectionFragment,
        transaction: FragmentManager?
    ){
        setFragmentResult("SelectPart", bundleOf("level" to level))
        transaction?.commit{
            setReorderingAllowed(true)
            addToBackStack(null)
            replace(R.id.MainFragment,partSelectionFragment)
        }
    }

}
