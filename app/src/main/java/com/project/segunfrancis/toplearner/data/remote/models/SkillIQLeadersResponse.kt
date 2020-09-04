package com.project.segunfrancis.toplearner.data.remote.models

/**
 * Created by SegunFrancis
 */

data class SkillIQLeadersResponse(
    val id: Long,
    val name: String,
    val score: Int,
    val country: String,
    val badgeUrl: String
)