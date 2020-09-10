package com.project.segunfrancis.toplearner.ui.viewmodel

import androidx.lifecycle.*
import com.project.segunfrancis.toplearner.data.local.models.LearningLeadersLocal
import com.project.segunfrancis.toplearner.data.local.models.SkillIQLeadersLocal
import com.project.segunfrancis.toplearner.data.remote.mappers.mapLearningLeadersResponseToLocal
import com.project.segunfrancis.toplearner.data.remote.mappers.mapSkillIQLeadersResponseToLocal
import com.project.segunfrancis.toplearner.repository.TopLearnersRepositoryImpl
import com.project.segunfrancis.toplearner.util.Result
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by SegunFrancis
 */

class LearnersViewModel(private val repository: TopLearnersRepositoryImpl) : ViewModel() {
    private var _learningLeadersLocal = MutableLiveData<Result<List<LearningLeadersLocal>>>()
    val learningLeadersLocal: LiveData<Result<List<LearningLeadersLocal>>>
        get() = _learningLeadersLocal

    private var _skillIqLeadersLocal = MutableLiveData<Result<List<SkillIQLeadersLocal>>>()
    val skillIqLeadersLocal: LiveData<Result<List<SkillIQLeadersLocal>>>
        get() = _skillIqLeadersLocal

    fun learningLeadersRemote() {
        _learningLeadersLocal.postValue(Result.Loading("Loading..."))
        repository.getLearningLeadersRemote(
            { list ->
                insertLearningLeaders(list!!.map {
                    mapLearningLeadersResponseToLocal(it)
                })
                getLearningLeadersLocal()
            }, { localizedMessage ->
                _learningLeadersLocal.postValue(Result.Error(localizedMessage))
            })
    }

    fun skillIQLeadersRemote() {
        _skillIqLeadersLocal.postValue(Result.Loading("Loading..."))
        repository.getSkillIQLeadersRemote({ list ->
            insertSkillIqLeaders(list!!.map {
                mapSkillIQLeadersResponseToLocal(it)
            })
            getSkillIQLeadersLocal()
        }, { localizedMessage ->
            _skillIqLeadersLocal.postValue(Result.Error(localizedMessage))
        })
    }

    private fun insertLearningLeaders(leaders: List<LearningLeadersLocal>) {
        viewModelScope.launch {
            repository.insertLearningLeaders(leaders)
        }
    }

    private fun insertSkillIqLeaders(leaders: List<SkillIQLeadersLocal>) {
        viewModelScope.launch {
            repository.insertSkillIQLeaders(leaders)
        }
    }

    private fun getLearningLeadersLocal() {
        viewModelScope.launch {
            repository.getLearningLeadersLocal().collect {
                _learningLeadersLocal.postValue(Result.Success(it))
            }
        }
    }

    private fun getSkillIQLeadersLocal() {
        viewModelScope.launch {
            repository.getSkillIQLeadersLocal().collect {
                _skillIqLeadersLocal.postValue(Result.Success(it))
            }
        }
    }
}