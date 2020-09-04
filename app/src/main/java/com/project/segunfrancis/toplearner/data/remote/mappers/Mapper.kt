package com.project.segunfrancis.toplearner.data.remote.mappers

/**
 * Created by SegunFrancis
 */

interface Mapper<I, O> {
    fun mapToLocalLayer(data: I): O
    fun mapToRemoteLayer(data: O): I
}