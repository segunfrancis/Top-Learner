package com.project.segunfrancis.toplearner.ui.viewmodel

import androidx.lifecycle.*
import com.project.segunfrancis.toplearner.data.local.models.LearningLeadersLocal
import com.project.segunfrancis.toplearner.data.local.models.SkillIQLeadersLocal
import com.project.segunfrancis.toplearner.data.remote.models.LearningLeadersResponse
import com.project.segunfrancis.toplearner.data.remote.models.SkillIQLeadersResponse
import com.project.segunfrancis.toplearner.repository.TopLearnersRepositoryImpl
import com.project.segunfrancis.toplearner.util.Result
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by SegunFrancis
 */

class LearnersViewModel(private val repository: TopLearnersRepositoryImpl) : ViewModel() {
    private var _learningLeadersLocal = MutableLiveData<List<LearningLeadersLocal>>()
    val learningLeadersLocal: LiveData<List<LearningLeadersLocal>>
        get() = _learningLeadersLocal

    private var _skillIqLeadersLocal = MutableLiveData<List<SkillIQLeadersLocal>>()
    val skillIqLeadersLocal: LiveData<List<SkillIQLeadersLocal>>
        get() = _skillIqLeadersLocal

    init {
        getLearningLeadersLocal()
        getSkillIQLeadersLocal()
    }

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

    private fun getLearningLeadersLocal() {
        viewModelScope.launch {
            repository.getLearningLeadersLocal().collect {
                _learningLeadersLocal.postValue(it)
            }
        }
    }

    private fun getSkillIQLeadersLocal() {
        viewModelScope.launch {
            repository.getSkillIQLeadersLocal().collect {
                _skillIqLeadersLocal.postValue(it)
            }
        }
    }
}