package com.project.segunfrancis.toplearner.ui.viewmodel

import androidx.lifecycle.*
import com.project.segunfrancis.toplearner.data.remote.models.LearningLeadersResponse
import com.project.segunfrancis.toplearner.data.remote.models.SkillIQLeadersResponse
import com.project.segunfrancis.toplearner.repository.TopLearnersRepositoryImpl
import com.project.segunfrancis.toplearner.util.Result

/**
 * Created by SegunFrancis
 */

class LearnersViewModel(private val repository: TopLearnersRepositoryImpl) : ViewModel() {
    private var _learningLeadersLocal = MutableLiveData<Result<List<LearningLeadersResponse>>>()
    val learningLeaders: LiveData<Result<List<LearningLeadersResponse>>>
        get() = _learningLeadersLocal

    private var _skillIqLeadersLocal = MutableLiveData<Result<List<SkillIQLeadersResponse>>>()
    val skillIqLeaders: LiveData<Result<List<SkillIQLeadersResponse>>>
        get() = _skillIqLeadersLocal

    fun learningLeadersRemote() {
        _learningLeadersLocal.postValue(Result.Loading("Loading..."))
        repository.getLearningLeadersRemote(
            { list ->
                _learningLeadersLocal.postValue(Result.Success(list!!))
            }, { localizedMessage ->
                _learningLeadersLocal.postValue(Result.Error(localizedMessage))
            })
    }

    fun skillIQLeadersRemote() {
        _skillIqLeadersLocal.postValue(Result.Loading("Loading..."))
        repository.getSkillIQLeadersRemote({ list ->
            _skillIqLeadersLocal.postValue(Result.Success(list!!))
        }, { localizedMessage ->
            _skillIqLeadersLocal.postValue(Result.Error(localizedMessage))
        })
    }
}