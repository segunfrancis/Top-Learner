package com.project.segunfrancis.toplearner.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
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
abstract class TopLearnerDatabase() : RoomDatabase() {
    abstract fun learnerDao(): LearnerDao

    companion object {
        @Volatile
        private var INSTANCE: TopLearnerDatabase? = null

        fun getInstance(context: Context): TopLearnerDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TopLearnerDatabase::class.java,
                        "status_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}