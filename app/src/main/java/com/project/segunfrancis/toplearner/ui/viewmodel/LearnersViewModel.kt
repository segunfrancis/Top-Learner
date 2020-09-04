package com.project.segunfrancis.toplearner.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.project.segunfrancis.toplearner.data.local.models.LearningLeadersLocal
import com.project.segunfrancis.toplearner.data.local.models.SkillIQLeadersLocal
import com.project.segunfrancis.toplearner.data.remote.models.LearningLeadersResponse
import com.project.segunfrancis.toplearner.data.remote.models.SkillIQLeadersResponse
import com.project.segunfrancis.toplearner.repository.TopLearnersRepositoryImpl
import com.project.segunfrancis.toplearner.util.Result
import kotlinx.coroutines.launch

/**
 * Created by SegunFrancis
 */

class LearnersViewModel(private val repository: TopLearnersRepositoryImpl) : ViewModel() {

    val learningLeadersRemote: LiveData<Result<List<LearningLeadersResponse>>> = liveData {
        emit(Result.Loading("Loading"))
        emit(repository.getLearningLeadersRemote())
    }

    val skillIQLeadersRemote: LiveData<Result<List<SkillIQLeadersResponse>>> = liveData {
        emit(Result.Loading("Loading"))
        emit(repository.getSkillIQLeadersRemote())
    }

    fun insertLearningLeaders(leaders: List<LearningLeadersLocal>) {
        viewModelScope.launch {
            repository.insertLearningLeaders(leaders)
        }
    }

    fun insertSkillIqLeaders(leaders: List<SkillIQLeadersLocal>) {
        viewModelScope.launch {
            repository.insertSkillIQLeaders(leaders)
        }
    }

    val learningLeadersLocal: LiveData<List<LearningLeadersLocal>> = liveData {
        emit(repository.getLearningLeadersLocal())
    }

    val skillIqLeadersLocal: LiveData<List<SkillIQLeadersLocal>> = liveData {
        emit(repository.getSkillIQLeadersLocal())
    }
}