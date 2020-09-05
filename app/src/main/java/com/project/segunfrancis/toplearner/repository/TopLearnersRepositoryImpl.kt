package com.project.segunfrancis.toplearner.repository

import com.project.segunfrancis.toplearner.data.local.dao.LearnerDao
import com.project.segunfrancis.toplearner.data.local.models.LearningLeadersLocal
import com.project.segunfrancis.toplearner.data.local.models.SkillIQLeadersLocal
import com.project.segunfrancis.toplearner.data.local.repository.LocalRepository
import com.project.segunfrancis.toplearner.data.remote.api.TopLearnerApi
import com.project.segunfrancis.toplearner.data.remote.models.LearningLeadersResponse
import com.project.segunfrancis.toplearner.data.remote.models.SkillIQLeadersResponse
import com.project.segunfrancis.toplearner.data.remote.repository.RemoteRepository
import com.project.segunfrancis.toplearner.util.Result
import com.project.segunfrancis.toplearner.util.Result.Error
import com.project.segunfrancis.toplearner.util.Result.Success
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

/**
 * Created by SegunFrancis
 */

class TopLearnersRepositoryImpl(private val dao: LearnerDao, private val api: TopLearnerApi) :
    RemoteRepository, LocalRepository {
    override suspend fun getLearningLeadersRemote(): Result<List<LearningLeadersResponse>> {
        return try {
            Success(api.getLearningLeaders())
        } catch (t: Throwable) {
            return Error(t)
        }
    }

    override suspend fun getSkillIQLeadersRemote(): Result<List<SkillIQLeadersResponse>> {
        return try {
            Success(api.getSkillIQLeaders())
        } catch (t: Throwable) {
            return Error(t)
        }
    }

    override suspend fun submitProject(
        firstName: String,
        lastName: String,
        emailAddress: String,
        linkToProject: String
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            api.submitProject(firstName, lastName, emailAddress, linkToProject)
        }
    }

    override suspend fun insertLearningLeaders(leaders: List<LearningLeadersLocal>) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insertLearningLeaders(leaders)
        }
    }

    override suspend fun insertSkillIQLeaders(leaders: List<SkillIQLeadersLocal>) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insertSkillIQLeaders(leaders)
        }
    }

    override suspend fun getLearningLeadersLocal(): Flow<List<LearningLeadersLocal>> {
        return dao.getLearningLeaders()
    }

    override suspend fun getSkillIQLeadersLocal(): Flow<List<SkillIQLeadersLocal>> {
        return dao.getSkillIQLeaders()
    }
}