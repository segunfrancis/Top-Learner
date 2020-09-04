package com.project.segunfrancis.toplearner.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.project.segunfrancis.toplearner.App
import com.project.segunfrancis.toplearner.databinding.FragmentLearningLeadersBinding
import com.project.segunfrancis.toplearner.util.Result
import com.project.segunfrancis.toplearner.util.displaySnackBar

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */

class LearningLeadersFragment : Fragment() {

    private lateinit var binding: FragmentLearningLeadersBinding
    private val viewModel: LearnersViewModel by lazy {
        ViewModelProvider(
            requireActivity(),
            App.viewModelFactory
        )[LearnersViewModel::class.java]
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLearningLeadersBinding.inflate(layoutInflater)
        viewModel.learningLeadersRemote.observe(viewLifecycleOwner, Observer { result ->
            when(result) {
                is Result.Loading -> binding.root.displaySnackBar(result.message)
                is Result.Success -> binding.root.displaySnackBar(result.data[1].name)
                is Result.Error -> binding.root.displaySnackBar(result.error?.localizedMessage!!)
            }
        })
        return binding.root
    }
}