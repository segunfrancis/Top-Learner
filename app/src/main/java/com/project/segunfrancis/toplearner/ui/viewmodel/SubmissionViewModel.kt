package com.project.segunfrancis.toplearner.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.segunfrancis.toplearner.repository.SubmissionRepositoryImpl
import com.project.segunfrancis.toplearner.util.Result

/**
 * Created by SegunFrancis
 */
class SubmissionViewModel(private val repository: SubmissionRepositoryImpl) : ViewModel() {

    private val _submissionResponse = MutableLiveData<Result<Int>>()
    val submissionResponse: LiveData<Result<Int>>
        get() = _submissionResponse

    fun submitProject(
        firstName: String,
        lastName: String,
        emailAddress: String,
        linkToProject: String
    ) {
        _submissionResponse.postValue(Result.Loading("Submitting..."))
        repository.submitProject(
            firstName,
            lastName,
            emailAddress,
            linkToProject,
            { statusCode ->
                _submissionResponse.postValue(Result.Success(statusCode))
            },
            { error ->
                _submissionResponse.postValue(Result.Error(error))
            })
    }
}