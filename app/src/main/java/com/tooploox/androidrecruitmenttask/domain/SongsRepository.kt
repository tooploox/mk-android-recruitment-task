package com.tooploox.androidrecruitmenttask.domain

interface SongsRepository {

    suspend fun getSongs(term: String, limit: Int): List<Song>
}