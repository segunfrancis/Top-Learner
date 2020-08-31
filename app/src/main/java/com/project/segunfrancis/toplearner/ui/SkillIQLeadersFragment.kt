package com.project.segunfrancis.toplearner.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.segunfrancis.toplearner.databinding.FragmentSkillIqLeadersBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SkillIQLeadersFragment : Fragment() {

    private lateinit var binding: FragmentSkillIqLeadersBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSkillIqLeadersBinding.inflate(layoutInflater)
        return binding.root
    }
}