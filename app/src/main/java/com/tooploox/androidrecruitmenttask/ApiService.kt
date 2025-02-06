package com.tooploox.androidrecruitmenttask

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class ApiService {

    private val contentType = "application/json".toMediaType()
    private val client =  OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build()

    private val json = Json {
        isLenient = true
    }

    @ExperimentalSerializationApi
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://itunes.apple.com/")
        .addConverterFactory(
            json.asConverterFactory(contentType)
        )
        .client(client)
        .build()

    @OptIn(ExperimentalSerializationApi::class)
    val service: ItunesService = retrofit.create(ItunesService::class.java)
}
