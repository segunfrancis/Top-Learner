package com.project.segunfrancis.toplearner.data.remote.repository

import com.project.segunfrancis.toplearner.data.remote.models.LearningLeadersResponse
import com.project.segunfrancis.toplearner.data.remote.models.SkillIQLeadersResponse
import com.project.segunfrancis.toplearner.util.Result

/**
 * Created by SegunFrancis
 */

interface RemoteRepository {

    suspend fun getLearningLeadersRemote(): Result<List<LearningLeadersResponse>>

    suspend fun getSkillIQLeadersRemote(): Result<List<SkillIQLeadersResponse>>

    suspend fun submitProject(
        firstName: String,
        lastName: String,
        emailAddress: String,
        linkToProject: String
    ): Unit
}