package com.project.segunfrancis.toplearner.repository

import com.project.segunfrancis.toplearner.data.local.dao.LearnerDao
import com.project.segunfrancis.toplearner.data.local.models.LearningLeadersLocal
import com.project.segunfrancis.toplearner.data.local.models.SkillIQLeadersLocal
import com.project.segunfrancis.toplearner.data.local.repository.LocalRepository
import com.project.segunfrancis.toplearner.data.remote.api.TopLearnerApi
import com.project.segunfrancis.toplearner.data.remote.models.LearningLeadersResponse
import com.project.segunfrancis.toplearner.data.remote.models.SkillIQLeadersResponse
import com.project.segunfrancis.toplearner.data.remote.repository.RemoteRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by SegunFrancis
 */

class TopLearnersRepositoryImpl(private val dao: LearnerDao, private val api: TopLearnerApi) :
    RemoteRepository, LocalRepository {
    override fun getLearningLeadersRemote(
        onSuccess: (List<LearningLeadersResponse>?) -> Unit,
        onFailure: (String) -> Unit
    ) {
        api.getLearningLeaders().enqueue(object : Callback<List<LearningLeadersResponse>?> {
            override fun onResponse(
                call: Call<List<LearningLeadersResponse>?>,
                response: Response<List<LearningLeadersResponse>?>
            ) {
                onSuccess(response.body())
            }

            override fun onFailure(call: Call<List<LearningLeadersResponse>?>, t: Throwable) {
                onFailure(t.localizedMessage!!)
            }
        })
    }

    override fun getSkillIQLeadersRemote(
        onSuccess: (List<SkillIQLeadersResponse>?) -> Unit,
        onFailure: (String) -> Unit
    ) {
        api.getSkillIQLeaders().enqueue(object : Callback<List<SkillIQLeadersResponse>?> {
            override fun onResponse(
                call: Call<List<SkillIQLeadersResponse>?>,
                response: Response<List<SkillIQLeadersResponse>?>
            ) {
                onSuccess(response.body())
            }

            override fun onFailure(call: Call<List<SkillIQLeadersResponse>?>, t: Throwable) {
                onFailure(t.localizedMessage!!)
            }
        })
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