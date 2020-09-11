package com.project.segunfrancis.toplearner.ui.main.learningleaders

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.segunfrancis.toplearner.App
import com.project.segunfrancis.toplearner.util.Result.Success
import com.project.segunfrancis.toplearner.util.Result.Error
import com.project.segunfrancis.toplearner.util.Result.Loading
import com.project.segunfrancis.toplearner.databinding.FragmentLearningLeadersBinding
import com.project.segunfrancis.toplearner.ui.viewmodel.LearnersViewModel
import com.project.segunfrancis.toplearner.util.*

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
        binding.noNetworkButton.setOnClickListener {
            loadRemoteData()
        }
        binding.learningLeadersRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(MarginItemDecoration(16))
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loadRemoteData()
        viewModel.getLearningLeadersLocal()
        viewModel.learningLeadersLocal.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Success -> {
                    learningLeadersAdapter.setData(result.data)
                    binding.learningLeadersRecyclerView.adapter = learningLeadersAdapter
                    binding.loadingAnimation.hide()
                    binding.noNetworkAnimation.hide()
                    binding.noNetworkButton.hide()
                }
                is Error -> {
                    binding.root.displaySnackBar(result.error)
                    binding.noNetworkAnimation.show()
                    binding.loadingAnimation.hide()
                    binding.noNetworkButton.show()
                }
                is Loading -> {
                    binding.loadingAnimation.show()
                    binding.noNetworkAnimation.hide()
                    binding.noNetworkButton.hide()
                }
            }
        })
    }

    private fun loadRemoteData() {
        viewModel.learningLeadersRemote()
    }
}