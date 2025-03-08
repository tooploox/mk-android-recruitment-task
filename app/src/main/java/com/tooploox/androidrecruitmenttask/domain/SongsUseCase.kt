package com.tooploox.androidrecruitmenttask.domain

import com.tooploox.androidrecruitmenttask.data.LocalSongsRepository
import com.tooploox.androidrecruitmenttask.data.NetworkSongsRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SongsUseCase {

    private val _songs: MutableStateFlow<List<Song>> = MutableStateFlow(emptyList())
    val songs: StateFlow<List<Song>> = _songs

    private val networkSongsRepository: SongsRepository = NetworkSongsRepository()
    private val localSongsRepository: SongsRepository = LocalSongsRepository()

    suspend fun getSongs(term: String, limit: Int) = coroutineScope {
        val networkSongsRequest = async {
            val result = networkSongsRepository.getSongs(term = term, limit = limit).toMutableList()
            _songs.value += result
        }

        val localSongsRequest = async {
            val result = localSongsRepository.getSongs(term = term, limit = limit)
            _songs.value += result
        }

        networkSongsRequest.await()
        localSongsRequest.await()
    }
}