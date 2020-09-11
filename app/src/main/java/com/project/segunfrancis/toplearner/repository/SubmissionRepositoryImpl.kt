package com.project.segunfrancis.toplearner.repository

import com.project.segunfrancis.toplearner.data.remote.api.TopLearnerApi
import com.project.segunfrancis.toplearner.data.remote.repository.SubmissionRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by SegunFrancis
 */
class SubmissionRepositoryImpl(private val api: TopLearnerApi): SubmissionRepository {

    override fun submitProject(
        firstName: String,
        lastName: String,
        emailAddress: String,
        linkToProject: String,
        onSuccess: (Int) -> Unit,
        onFailure: (String) -> Unit
    ) {
        api.submitProject(firstName, lastName, emailAddress, linkToProject).enqueue(object :
            Callback<Unit?> {
            override fun onResponse(call: Call<Unit?>, response: Response<Unit?>) {
                onSuccess(response.code())
            }

            override fun onFailure(call: Call<Unit?>, t: Throwable) {
                onFailure(t.localizedMessage!!)
            }
        })
    }
}