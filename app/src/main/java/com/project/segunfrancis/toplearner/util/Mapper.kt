package com.project.segunfrancis.toplearner.util

import com.project.segunfrancis.toplearner.data.local.models.LearningLeadersLocal
import com.project.segunfrancis.toplearner.data.local.models.SkillIQLeadersLocal
import com.project.segunfrancis.toplearner.data.remote.models.LearningLeadersResponse
import com.project.segunfrancis.toplearner.data.remote.models.SkillIQLeadersResponse

/**
 * Created by SegunFrancis
 */

fun mapLearningLeadersResponseToLocal(response: LearningLeadersResponse): LearningLeadersLocal {
    return LearningLeadersLocal(
        id = response.id,
        name = response.name,
        country = response.country,
        hours = response.hours,
        badgeUrl = response.badgeUrl
    )
}

fun mapSkillIQLeadersResponseToLocal(response: SkillIQLeadersResponse): SkillIQLeadersLocal {
    return SkillIQLeadersLocal(
        id = response.id,
        name = response.name,
        country = response.country,
        score = response.score,
        badgeUrl = response.badgeUrl
    )
}