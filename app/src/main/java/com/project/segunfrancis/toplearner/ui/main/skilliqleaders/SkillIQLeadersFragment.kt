package com.project.segunfrancis.toplearner.ui.main.skilliqleaders

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
import com.project.segunfrancis.toplearner.databinding.FragmentSkillIqLeadersBinding
import com.project.segunfrancis.toplearner.ui.viewmodel.LearnersViewModel
import com.project.segunfrancis.toplearner.util.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */

class SkillIQLeadersFragment : Fragment() {

    private lateinit var binding: FragmentSkillIqLeadersBinding
    private val skillLeadersAdapter = SkillIQLeadersRecyclerAdapter()
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
        binding = FragmentSkillIqLeadersBinding.inflate(layoutInflater)
        binding.noNetworkButton.setOnClickListener {
            loadRemoteData()
        }
        binding.skillIqLeadersRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(MarginItemDecoration(16))
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loadRemoteData()
        viewModel.skillIqLeaders.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Success -> {
                    skillLeadersAdapter.setData(result.data)
                    binding.skillIqLeadersRecyclerView.adapter = skillLeadersAdapter
                    binding.loadingAnimation.hide()
                    binding.noNetworkAnimation.hide()
                    binding.noNetworkButton.hide()
                }
                is Error -> {
                    binding.root.displaySnackBar(result.error)
                    binding.noNetworkAnimation.show()
                    binding.noNetworkButton.show()
                    binding.loadingAnimation.hide()
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
        viewModel.skillIQLeadersRemote()
    }
}