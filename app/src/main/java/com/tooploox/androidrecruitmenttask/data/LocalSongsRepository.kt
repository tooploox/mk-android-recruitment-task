package com.tooploox.androidrecruitmenttask.data

import com.tooploox.androidrecruitmenttask.domain.Song
import com.tooploox.androidrecruitmenttask.domain.SongsRepository

class LocalSongsRepository : SongsRepository {

    override suspend fun getSongs(term: String, limit: Int): List<Song> = listOf(
        Song(
            title = "Song 1", artist = "Artist 1"
        ),
        Song(
            title = "Song 2", artist = "Artist 2"
        ),
        Song(
            title = "Song 3", artist = "Artist 3"
        ),
    )
}