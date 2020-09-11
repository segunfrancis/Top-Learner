package com.project.segunfrancis.toplearner

import android.app.Application
import com.project.segunfrancis.toplearner.data.local.dao.LearnerDao
import com.project.segunfrancis.toplearner.data.local.db.TopLearnerDatabase
import com.project.segunfrancis.toplearner.data.remote.api.TopLearnerApi
import com.project.segunfrancis.toplearner.data.remote.api.buildAPIService
import com.project.segunfrancis.toplearner.repository.TopLearnersRepositoryImpl
import com.project.segunfrancis.toplearner.ui.viewmodel.LearnersViewModelFactory

/**
 * Created by SegunFrancis
 *
 * Manual dependency injection
 */

class App : Application() {

    companion object {
        private lateinit var context: App
        private val dao: LearnerDao by lazy {
            TopLearnerDatabase.getInstance(context.applicationContext).learnerDao()
        }
        private val service: TopLearnerApi
            get() = buildAPIService()

        private val repositoryImpl: TopLearnersRepositoryImpl
            get() = TopLearnersRepositoryImpl(dao, service)

        val viewModelFactory: LearnersViewModelFactory
            get() = LearnersViewModelFactory(
                repositoryImpl
            )
    }

    override fun onCreate() {
        context = this
        super.onCreate()
    }
}