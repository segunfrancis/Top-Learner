package com.project.segunfrancis.toplearner.data.remote.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.project.segunfrancis.toplearner.BuildConfig
import com.project.segunfrancis.toplearner.util.AppConstants.BASE_URL
import com.project.segunfrancis.toplearner.util.AppConstants.CALL_TIMEOUT
import com.project.segunfrancis.toplearner.util.AppConstants.WRITE_TIMEOUT
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by SegunFrancis
 */

fun gson(): Gson {
    return GsonBuilder().setLenient().serializeNulls().create()
}

fun okHttpClient(): OkHttpClient {
    val clientBuilder = OkHttpClient.Builder().apply {
        callTimeout(CALL_TIMEOUT, TimeUnit.SECONDS)
        writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) {
            val httpLoggingInterceptor =
                HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            addInterceptor(httpLoggingInterceptor)
        }
    }
    return clientBuilder.build()
}

fun buildRetrofit(): Retrofit {
    return Retrofit.Builder()
        .client(okHttpClient())
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson()))
        .build()
}

fun buildAPIService(): TopLearnerApi = buildRetrofit().create(TopLearnerApi::class.java)