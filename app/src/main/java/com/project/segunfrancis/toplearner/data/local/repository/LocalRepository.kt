package com.project.segunfrancis.toplearner.data.local.repository

import com.project.segunfrancis.toplearner.data.local.models.LearningLeadersLocal
import com.project.segunfrancis.toplearner.data.local.models.SkillIQLeadersLocal
import kotlinx.coroutines.flow.Flow

/**
 * Created by SegunFrancis
 */

interface LocalRepository {
    suspend fun insertLearningLeaders(leaders: List<LearningLeadersLocal>)

    suspend fun insertSkillIQLeaders(leaders: List<SkillIQLeadersLocal>)

    suspend fun getLearningLeadersLocal(): Flow<List<LearningLeadersLocal>>

    suspend fun getSkillIQLeadersLocal(): Flow<List<SkillIQLeadersLocal>>
}