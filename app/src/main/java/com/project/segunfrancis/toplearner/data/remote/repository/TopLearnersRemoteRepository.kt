package com.project.segunfrancis.toplearner.data.remote.repository

import com.project.segunfrancis.toplearner.data.remote.models.LearningLeadersResponse
import com.project.segunfrancis.toplearner.data.remote.models.SkillIQLeadersResponse

/**
 * Created by SegunFrancis
 */

interface TopLearnersRemoteRepository {

    fun getLearningLeadersRemote(
        onSuccess: (List<LearningLeadersResponse>?) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getSkillIQLeadersRemote(
        onSuccess: (List<SkillIQLeadersResponse>?) -> Unit,
        onFailure: (String) -> Unit
    )
}