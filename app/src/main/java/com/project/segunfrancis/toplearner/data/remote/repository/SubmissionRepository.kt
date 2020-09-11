package com.project.segunfrancis.toplearner.data.remote.repository

/**
 * Created by SegunFrancis
 */
interface SubmissionRepository {
    fun submitProject(
        firstName: String,
        lastName: String,
        emailAddress: String,
        linkToProject: String,
        onSuccess: (Int) -> Unit,
        onFailure: (String) -> Unit
    )
}