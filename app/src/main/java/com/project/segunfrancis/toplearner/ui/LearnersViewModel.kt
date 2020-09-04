package com.project.segunfrancis.toplearner.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.project.segunfrancis.toplearner.data.remote.models.LearningLeadersResponse
import com.project.segunfrancis.toplearner.data.remote.models.SkillIQLeadersResponse
import com.project.segunfrancis.toplearner.repository.TopLearnersRepositoryImpl
import com.project.segunfrancis.toplearner.util.Result

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
}