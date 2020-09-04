package com.project.segunfrancis.toplearner.data.remote.models

/**
 * Created by SegunFrancis
 */

data class LearningLeadersResponse(
    val id: Long,
    val name: String,
    val hours: Int,
    val country: String,
    val badgeUrl: String
)