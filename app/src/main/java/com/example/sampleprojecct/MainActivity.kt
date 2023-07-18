package com.example.sampleprojecct

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.commit
import com.example.sampleprojecct.LearningFragment.LearningFragment
import com.example.sampleprojecct.SelectionFragment.SelectionFragment
import com.google.android.material.navigation.NavigationBarView



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val learningFragment = LearningFragment()
        val selectionFragment = SelectionFragment()
        val settingFragement = SettingFragment()
        var transaction = supportFragmentManager
        transaction.commit {
            setReorderingAllowed(true)
            replace(R.id.MainFragment,selectionFragment)
        }
//        transaction.replace(R.id.MainFragment,selectionFragment)
//        transaction.commit()

        val navigationBarView =findViewById<NavigationBarView>(R.id.bottomNavigationView)

        navigationBarView.setOnItemSelectedListener{ item ->
            when(item.itemId) {
                R.id.LearningPage -> {
                    Log.i("FragmentManager","change to Main")
                    transaction.commit {
                        setReorderingAllowed(true)
                        addToBackStack(null)
                        replace(R.id.MainFragment,learningFragment)
                    }
//                    transaction.replace(R.id.MainFragment,learningFragment)
//                    transaction.commit()
                    // Respond to navigation item 1 click
                    true
                }
                R.id.HomePage -> {
                    // Respond to navigation item 2 click
                    Log.i("FragmentManager","change to selection")
                    transaction.commit {
                        setReorderingAllowed(true)
                        addToBackStack(null)
                        replace(R.id.MainFragment,selectionFragment)
                    }
//                    transaction.replace(R.id.MainFragment,selectionFragment)
//                    transaction.commit()
                    true
                }R.id.SettingPage -> {
                // Respond to navigation item 2 click
                    Log.i("FragmentManager","change to setting")
                    transaction.commit {
                        setReorderingAllowed(true)
                        addToBackStack(null)
                        replace(R.id.MainFragment,settingFragement)
                    }
//                    transaction.replace(R.id.MainFragment,settingFragement)
//                    transaction.commit()
                true
            }
                else -> {
                    Log.i("FragmentManager", "fail")
                    false
                }
            }
        }
    }

}