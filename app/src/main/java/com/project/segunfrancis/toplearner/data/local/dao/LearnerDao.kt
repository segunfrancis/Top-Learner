package com.project.segunfrancis.toplearner.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.project.segunfrancis.toplearner.data.local.models.LearningLeadersLocal
import com.project.segunfrancis.toplearner.data.local.models.SkillIQLeadersLocal
import kotlinx.coroutines.flow.Flow

/**
 * Created by SegunFrancis
 */

@Dao
interface LearnerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLearningLeaders(leaders: List<LearningLeadersLocal>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSkillIQLeaders(leaders: List<SkillIQLeadersLocal>)

    @Query("SELECT * FROM learning_leaders")
    fun getLearningLeaders(): Flow<List<LearningLeadersLocal>>

    @Query("SELECT * FROM skill_iq_leaders")
    fun getSkillIQLeaders(): Flow<List<SkillIQLeadersLocal>>
}