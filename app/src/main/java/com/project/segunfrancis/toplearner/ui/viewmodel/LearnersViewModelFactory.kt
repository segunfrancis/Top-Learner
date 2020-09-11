package com.project.segunfrancis.toplearner.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.segunfrancis.toplearner.repository.SubmissionRepositoryImpl
import com.project.segunfrancis.toplearner.repository.TopLearnersRepositoryImpl

/**
 * Created by SegunFrancis
 */

class LearnersViewModelFactory(
    private val repositoryImpl: TopLearnersRepositoryImpl,
    private val submissionRepositoryImpl: SubmissionRepositoryImpl
) :
    ViewModelProvider.Factory {
    /**
     * Creates a new instance of the given `Class`.
     *
     * @param modelClass a `Class` whose instance is requested
     * @param <T>        The type parameter for the ViewModel.
     * @return a newly created ViewModel
    </T> */
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return with(modelClass) {
            when {
                isAssignableFrom(LearnersViewModel::class.java) ->
                    LearnersViewModel(repositoryImpl)
                isAssignableFrom(SubmissionViewModel::class.java) ->
                    SubmissionViewModel(submissionRepositoryImpl)
                else ->
                    throw IllegalArgumentException("ViewModel class (${modelClass.name}) is not mapped")
            }
        } as T
    }
}