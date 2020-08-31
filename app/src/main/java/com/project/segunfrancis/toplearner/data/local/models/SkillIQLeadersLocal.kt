package com.project.segunfrancis.toplearner.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by SegunFrancis
 */

@Entity(tableName = "skill_iq_leaders")
data class SkillIQLeadersLocal(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    var name: String,
    var score: Int,
    var country: String,
    var badgeUrl: String
)