package com.project.segunfrancis.toplearner.data.remote.mappers

import com.project.segunfrancis.toplearner.data.local.models.SkillIQLeadersLocal
import com.project.segunfrancis.toplearner.data.remote.models.SkillIQLeadersResponse

/**
 * Created by SegunFrancis
 */

class SkillIQLeaderRemoteToLocalMapper : Mapper<SkillIQLeadersResponse, SkillIQLeadersLocal>  {
    override fun mapToLocalLayer(data: SkillIQLeadersResponse): SkillIQLeadersLocal {
        return SkillIQLeadersLocal(
            id = data.id,
            name = data.name,
            country = data.country,
            score = data.score,
            badgeUrl = data.badgeUrl
        )
    }

    override fun mapToRemoteLayer(data: SkillIQLeadersLocal): SkillIQLeadersResponse {
        return SkillIQLeadersResponse(
            id = data.id,
            name = data.name,
            country = data.country,
            score = data.score,
            badgeUrl = data.badgeUrl
        )
    }
}