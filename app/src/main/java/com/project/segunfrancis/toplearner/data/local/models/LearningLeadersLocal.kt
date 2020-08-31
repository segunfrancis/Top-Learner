package com.project.segunfrancis.toplearner.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by SegunFrancis
 */

@Entity(tableName = "learning_leaders")
data class LearningLeadersLocal(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val hours: Int,
    val country: String,
    val badgeUrl: String
)