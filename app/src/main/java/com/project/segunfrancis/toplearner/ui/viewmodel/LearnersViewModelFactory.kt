package com.project.segunfrancis.toplearner.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.segunfrancis.toplearner.repository.TopLearnersRepositoryImpl

/**
 * Created by SegunFrancis
 */

class LearnersViewModelFactory(private val repositoryImpl: TopLearnersRepositoryImpl) :
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
        if (modelClass.isAssignableFrom(LearnersViewModel::class.java)) {
            return LearnersViewModel(
                repositoryImpl
            ) as T
        } else {
            throw IllegalArgumentException("ViewModel class (${modelClass.name}) is not mapped")
        }
    }
}