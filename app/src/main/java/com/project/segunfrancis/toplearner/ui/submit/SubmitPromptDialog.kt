package com.project.segunfrancis.toplearner.ui.submit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.project.segunfrancis.toplearner.databinding.LayoutSubmitPromptBinding

/**
 * Created by SegunFrancis
 */

class SubmitPromptDialog(private val clickListener: SubmitButtonClickListener) : DialogFragment() {

    private lateinit var binding: LayoutSubmitPromptBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LayoutSubmitPromptBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cancelButton.setOnClickListener {
            dismiss()
        }
        binding.confirmSubmitButton.setOnClickListener {
            clickListener.onButtonClick()
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    interface SubmitButtonClickListener {
        fun onButtonClick()
    }
}