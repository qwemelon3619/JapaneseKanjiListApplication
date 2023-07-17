package com.example.sampleprojecct

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.sampleprojecct.LearningFragment.LearningFragment
import com.example.sampleprojecct.SelectionFragment.SelectionFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val learningFragment = LearningFragment()
        val selectionFragment = SelectionFragment()
        val settingFragement = SettingFragment()
        var transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.MainFragment,selectionFragment)
        val a =findViewById<NavigationBarView>(R.id.bottomNavigationView)

        a.setOnItemSelectedListener{ item ->
            transaction = supportFragmentManager.beginTransaction()
            when(item.itemId) {
                R.id.LearningPage -> {
                    Log.i("FragmentManager","change to Main")
                    transaction.replace(R.id.MainFragment,learningFragment)
                    transaction.commit()
                    // Respond to navigation item 1 click
                    true
                }
                R.id.HomePage -> {
                    // Respond to navigation item 2 click
                    Log.i("FragmentManager","change to selection")
                    transaction.replace(R.id.MainFragment,selectionFragment)
                    transaction.commit()
                    true
                }R.id.SettingPage -> {
                // Respond to navigation item 2 click
                    Log.i("FragmentManager","change to setting")
                    transaction.replace(R.id.MainFragment,settingFragement)
                    transaction.commit()
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