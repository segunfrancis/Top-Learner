package com.project.segunfrancis.toplearner.data.remote.repository

import com.project.segunfrancis.toplearner.data.remote.models.LearningLeadersResponse
import com.project.segunfrancis.toplearner.data.remote.models.SkillIQLeadersResponse
import com.project.segunfrancis.toplearner.util.Result
import retrofit2.Call

/**
 * Created by SegunFrancis
 */

interface RemoteRepository {

    fun getLearningLeadersRemote(
        onSuccess: (List<LearningLeadersResponse>?) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getSkillIQLeadersRemote(
        onSuccess: (List<SkillIQLeadersResponse>?) -> Unit,
        onFailure: (String) -> Unit
    )

    suspend fun submitProject(
        firstName: String,
        lastName: String,
        emailAddress: String,
        linkToProject: String
    ): Unit
}