package com.project.segunfrancis.toplearner.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.segunfrancis.toplearner.databinding.FragmentLearningLeadersBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */

class LearningLeadersFragment : Fragment() {

    private lateinit var binding: FragmentLearningLeadersBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLearningLeadersBinding.inflate(layoutInflater)
        return binding.root
    }
}