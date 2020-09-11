package com.project.segunfrancis.toplearner.repository

import com.project.segunfrancis.toplearner.data.remote.api.TopLearnerApi
import com.project.segunfrancis.toplearner.data.remote.models.LearningLeadersResponse
import com.project.segunfrancis.toplearner.data.remote.models.SkillIQLeadersResponse
import com.project.segunfrancis.toplearner.data.remote.repository.TopLearnersRemoteRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by SegunFrancis
 */

class TopLearnersRepositoryImpl(private val api: TopLearnerApi) :
    TopLearnersRemoteRepository {
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
}