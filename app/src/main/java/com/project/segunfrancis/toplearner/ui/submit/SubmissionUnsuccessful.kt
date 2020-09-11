package com.project.segunfrancis.toplearner.ui.submit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.project.segunfrancis.toplearner.databinding.LayoutSubmissionUnsuccessfulBinding

/**
 * Created by SegunFrancis
 */

class SubmissionUnsuccessful : DialogFragment() {

    private lateinit var binding: LayoutSubmissionUnsuccessfulBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LayoutSubmissionUnsuccessfulBinding.inflate(layoutInflater)
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