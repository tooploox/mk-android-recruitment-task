package com.tooploox.androidrecruitmenttask.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tooploox.androidrecruitmenttask.domain.Song
import com.tooploox.androidrecruitmenttask.domain.SongsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val useCase = SongsUseCase()

    val songs: StateFlow<List<Song>> = useCase.songs

    private val viewAction = MutableStateFlow<SongListViewAction?>(null)
    val viewActionFlow = viewAction.asStateFlow()

    init {
        viewModelScope.launch {
            useCase.getSongs(term = "post malone", limit = 30)
        }
    }

    fun onSongClick(song: Song) {
        viewAction.value = SongListViewAction.ShowDetails(song)
    }

    fun onViewActionHandled() {
        viewAction.value = null
    }
}
