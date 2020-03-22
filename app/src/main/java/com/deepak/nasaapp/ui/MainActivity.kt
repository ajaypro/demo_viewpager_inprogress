package com.deepak.nasaapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.deepak.nasaapp.R
import com.deepak.nasaapp.ui.overview.SpaceFragment

class MainActivity : AppCompatActivity() {

    private val spaceFragment = SpaceFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, spaceFragment)
        fragmentTransaction.commit()
    }
}
