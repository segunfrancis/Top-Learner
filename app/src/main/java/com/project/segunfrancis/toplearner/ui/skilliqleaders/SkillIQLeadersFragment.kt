package com.project.segunfrancis.toplearner.ui.skilliqleaders

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.segunfrancis.toplearner.App
import com.project.segunfrancis.toplearner.data.local.models.SkillIQLeadersLocal
import com.project.segunfrancis.toplearner.databinding.FragmentSkillIqLeadersBinding
import com.project.segunfrancis.toplearner.ui.viewmodel.LearnersViewModel
import com.project.segunfrancis.toplearner.util.MarginItemDecoration
import com.project.segunfrancis.toplearner.util.Result
import com.project.segunfrancis.toplearner.util.displaySnackBar

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
        viewModel.skillIqLeadersLocal.observe(viewLifecycleOwner, Observer { leaders ->
            if (leaders.isNullOrEmpty()) {
                loadRemoteData()
            } else {
                // Display cached data
                skillLeadersAdapter.setData(leaders)
                binding.skillIqLeadersRecyclerView.apply {
                    layoutManager = LinearLayoutManager(requireContext())
                    adapter = skillLeadersAdapter
                    addItemDecoration(MarginItemDecoration(16))
                }
            }
        })
        return binding.root
    }

    private fun loadRemoteData() {
        viewModel.skillIQLeadersRemote.observe(viewLifecycleOwner, Observer { result ->
            when(result) {
                is Result.Loading -> binding.root.displaySnackBar(result.message)
                is Result.Success -> viewModel.insertSkillIqLeaders(result.data.map { data ->
                    SkillIQLeadersLocal(
                        id = data.id,
                        name = data.name,
                        country = data.country,
                        score = data.score,
                        badgeUrl = data.badgeUrl
                    )
                })
                is Result.Error -> binding.root.displaySnackBar(result.error?.localizedMessage.toString())
            }
        })
    }
}