package com.project.segunfrancis.toplearner.ui.submit

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.project.segunfrancis.toplearner.App
import com.project.segunfrancis.toplearner.databinding.ActivitySubmitBinding
import com.project.segunfrancis.toplearner.ui.viewmodel.SubmissionViewModel
import com.project.segunfrancis.toplearner.util.Result.Loading
import com.project.segunfrancis.toplearner.util.Result.Error
import com.project.segunfrancis.toplearner.util.Result.Success

class SubmitActivity : AppCompatActivity(), SubmitPromptDialog.SubmitButtonClickListener {

    private lateinit var binding: ActivitySubmitBinding
    private lateinit var viewModel: SubmissionViewModel
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubmitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, App.viewModelFactory)[SubmissionViewModel::class.java]

        binding.backButton.setOnClickListener {
            finish()
        }
        progressDialog = ProgressDialog(this)
        progressDialog.setCancelable(false)
        binding.submitButton.setOnClickListener {
            if (fieldsAreValid()) {
                showDialog()
            }
        }
        observeResponse()
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

    private fun observeResponse() {
        viewModel.submissionResponse.observe(this, Observer { result ->
            when (result) {
                is Loading -> {
                    progressDialog.setTitle("Please wait")
                    progressDialog.setMessage(result.message)
                    progressDialog.show()
                }
                is Success -> {
                    SubmissionSuccessful().show(supportFragmentManager, "SubmissionSuccessful")
                    progressDialog.hide()
                }
                is Error -> {
                    SubmissionUnsuccessful().show(supportFragmentManager, "SubmissionUnsuccessful")
                    progressDialog.hide()
                }
            }
        })
    }

    private fun showDialog() {
        SubmitPromptDialog(this@SubmitActivity).show(supportFragmentManager, "SubmitPromptDialog")
    }

    override fun onButtonClick() {
        viewModel.submitProject(
            binding.firstNameEt.text.toString().trim(),
            binding.lastNameEt.text.toString().trim(),
            binding.emailEt.text.toString().trim(),
            binding.projectLinkEt.text.toString().trim()
        )
    }
}