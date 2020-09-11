package com.project.segunfrancis.toplearner.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project.segunfrancis.toplearner.R
import com.project.segunfrancis.toplearner.databinding.ActivityMainBinding
import com.project.segunfrancis.toplearner.ui.submit.SubmitActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter =
            TopLearnersPagerAdapter(
                supportFragmentManager,
                resources.getString(R.string.learning_leaders_title),
                resources.getString(R.string.skill_iq_leaders_title)
            )
        binding.include.viewPager.adapter = adapter
        binding.include.tabLayout.setupWithViewPager(binding.include.viewPager)
        binding.btnSubmit.setOnClickListener {
            startActivity(Intent(this, SubmitActivity::class.java))
        }
    }
}