package com.tooploox.androidrecruitmenttask.domain

import com.tooploox.androidrecruitmenttask.data.LocalSongsRepository
import com.tooploox.androidrecruitmenttask.data.NetworkSongsRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SongsUseCase {

    private val _songs: MutableStateFlow<MutableList<Song>> = MutableStateFlow(mutableListOf())
    val songs: StateFlow<List<Song>> = _songs

    private val networkSongsRepository: SongsRepository = NetworkSongsRepository()
    private val localSongsRepository: SongsRepository = LocalSongsRepository()

    suspend fun getSongs(term: String, limit: Int) = coroutineScope {
        val networkSongsRequest = async {
            _songs.value += networkSongsRepository.getSongs(term = term, limit = limit).toMutableList()
        }

        val localSongsRequest = async {
            _songs.value += localSongsRepository.getSongs(term = term, limit = limit)
        }

        networkSongsRequest.await()
        localSongsRequest.await()
    }
}