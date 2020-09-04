package com.project.segunfrancis.toplearner.ui.learningleaders

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.segunfrancis.toplearner.App
import com.project.segunfrancis.toplearner.data.local.models.LearningLeadersLocal
import com.project.segunfrancis.toplearner.databinding.FragmentLearningLeadersBinding
import com.project.segunfrancis.toplearner.ui.viewmodel.LearnersViewModel
import com.project.segunfrancis.toplearner.util.MarginItemDecoration
import com.project.segunfrancis.toplearner.util.Result
import com.project.segunfrancis.toplearner.util.displaySnackBar

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */

class LearningLeadersFragment : Fragment() {

    private lateinit var binding: FragmentLearningLeadersBinding
    private val learningLeadersAdapter = LearningLeadersRecyclerAdapter()
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
        viewModel.learningLeadersLocal.observe(viewLifecycleOwner, Observer { leaders ->
            if (leaders.isNullOrEmpty()) {
                loadRemoteData()
            } else {
                // Display cached data
                learningLeadersAdapter.setData(leaders)
                binding.learningLeadersRecyclerView.apply {
                    layoutManager = LinearLayoutManager(requireContext())
                    adapter = learningLeadersAdapter
                    addItemDecoration(MarginItemDecoration(16))
                }
            }
        })
        return binding.root
    }

    private fun loadRemoteData() {
        viewModel.learningLeadersRemote.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Result.Loading -> binding.root.displaySnackBar(result.message)
                is Result.Success -> viewModel.insertLearningLeaders(result.data.map { data ->
                    LearningLeadersLocal(
                        id = data.id,
                        name = data.name,
                        country = data.country,
                        hours = data.hours,
                        badgeUrl = data.badgeUrl
                    )
                })
                is Result.Error -> binding.root.displaySnackBar(result.error?.localizedMessage!!)
            }
        })
    }
}