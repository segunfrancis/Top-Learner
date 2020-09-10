package com.project.segunfrancis.toplearner.data.remote.api

import com.project.segunfrancis.toplearner.data.remote.models.LearningLeadersResponse
import com.project.segunfrancis.toplearner.data.remote.models.SkillIQLeadersResponse
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by SegunFrancis
 */

interface TopLearnerApi {
    @GET("api/hours")
    fun getLearningLeaders(): Call<List<LearningLeadersResponse>>

    @GET("api/skilliq")
    fun getSkillIQLeaders(): Call<List<SkillIQLeadersResponse>>

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    suspend fun submitProject(
        @Field("entry.1877115667") firstName: String,
        @Field("entry.2006916086") lastName: String,
        @Field("entry.1824927963") emailAddress: String,
        @Field("entry.284483984") linkToProject: String
    ): Unit
}