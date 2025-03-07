package com.tooploox.androidrecruitmenttask.data

import retrofit2.http.GET
import retrofit2.http.Query

interface ItunesService {

    @GET("/search?entity=song&media=music")
    suspend fun getSongs(
        @Query("term") term: String,
        @Query("limit") limit: Int
    ): SongsResponse
}
