package com.project.segunfrancis.toplearner.util

/**
 * Created by SegunFrancis
 */

sealed class Result<out T: Any> {
    data class Loading(val message: String): Result<Nothing>()
    data class Success<T: Any>(val data: T): Result<T>()
    data class Error(val error: String?): Result<Nothing>()
}