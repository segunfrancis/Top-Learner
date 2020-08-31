package com.project.segunfrancis.toplearner.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.project.segunfrancis.toplearner.data.local.dao.LearnerDao
import com.project.segunfrancis.toplearner.data.local.models.LearningLeadersLocal
import com.project.segunfrancis.toplearner.data.local.models.SkillIQLeadersLocal

/**
 * Created by SegunFrancis
 */

@Database(
    entities = [LearningLeadersLocal::class, SkillIQLeadersLocal::class],
    version = 1,
    exportSchema = false
)
abstract class TopLearnerDatabase : RoomDatabase() {
    abstract fun learnerDao(): LearnerDao
}