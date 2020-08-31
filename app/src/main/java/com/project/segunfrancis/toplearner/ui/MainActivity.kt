package com.project.segunfrancis.toplearner.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.project.segunfrancis.toplearner.R
import com.project.segunfrancis.toplearner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        val adapter = TopLearnersPagerAdapter(
            supportFragmentManager,
            resources.getString(R.string.learning_leaders_title),
            resources.getString(R.string.skill_iq_leaders_title)
        )
        binding.include.viewPager.adapter = adapter
        binding.include.tabLayout.setupWithViewPager(binding.include.viewPager)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_submit -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}