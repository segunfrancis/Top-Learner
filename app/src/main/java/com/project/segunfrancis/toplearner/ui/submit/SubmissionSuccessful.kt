package com.project.segunfrancis.toplearner.ui.submit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.project.segunfrancis.toplearner.databinding.LayoutSubmissionSuccessfulBinding

/**
 * Created by SegunFrancis
 */

class SubmissionSuccessful : DialogFragment() {

    private lateinit var binding: LayoutSubmissionSuccessfulBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LayoutSubmissionSuccessfulBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }
}