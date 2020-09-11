package com.project.segunfrancis.toplearner.ui.submit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.project.segunfrancis.toplearner.App
import com.project.segunfrancis.toplearner.databinding.ActivitySubmitBinding
import com.project.segunfrancis.toplearner.ui.viewmodel.SubmissionViewModel
import com.project.segunfrancis.toplearner.util.displaySnackBar

class SubmitActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubmitBinding
    private lateinit var viewModel: SubmissionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubmitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, App.viewModelFactory)[SubmissionViewModel::class.java]

        binding.backButton.setOnClickListener {
            finish()
        }

        binding.submitButton.setOnClickListener {
            if (fieldsAreValid()) {
                binding.root.displaySnackBar("All Fields are valid")
            }
        }
    }

    private fun fieldsAreValid(): Boolean {
        val fields =
            listOf(binding.firstNameEt, binding.lastNameEt, binding.emailEt, binding.projectLinkEt)
        for (view in fields) {
            if (view.text.isNullOrEmpty()) {
                view.error = "Field should not be empty"
                return false
            }
        }
        return true
    }
}