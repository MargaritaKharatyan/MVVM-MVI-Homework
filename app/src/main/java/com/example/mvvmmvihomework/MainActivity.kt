package com.example.mvvmmvihomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmmvihomework.databinding.ActivityMainBinding
import com.example.mvvmmvihomework.spacexschedules.presentation.screens.ScheduleFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.add(R.id.frame, ScheduleFragment())
        transaction.commit()
    }

}