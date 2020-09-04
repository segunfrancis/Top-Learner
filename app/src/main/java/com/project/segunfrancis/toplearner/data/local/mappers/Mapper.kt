package com.project.segunfrancis.toplearner.data.local.mappers

/**
 * Created by SegunFrancis
 */
interface Mapper<I, O> {
    fun mapToRemoteLayer(leader: I): O
    fun mapToLocalLayer(leader: O): I
}