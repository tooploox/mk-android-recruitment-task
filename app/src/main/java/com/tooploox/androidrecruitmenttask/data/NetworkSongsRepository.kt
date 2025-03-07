package com.tooploox.androidrecruitmenttask.data

import com.tooploox.androidrecruitmenttask.domain.Song
import com.tooploox.androidrecruitmenttask.domain.SongsRepository
import kotlinx.coroutines.delay

class NetworkSongsRepository : SongsRepository {

    private val apiService = ApiService()

    override suspend fun getSongs(term: String, limit: Int): List<Song> {
        delay(timeMillis = 3_000)
        return apiService.service.getSongs(
            term = term,
            limit = limit
        ).songs.map { it.toDomainModel() }
    }
}