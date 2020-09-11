package com.project.segunfrancis.toplearner.ui.submit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project.segunfrancis.toplearner.databinding.ActivitySubmitBinding

class SubmitActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubmitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubmitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            finish()
        }
    }
}