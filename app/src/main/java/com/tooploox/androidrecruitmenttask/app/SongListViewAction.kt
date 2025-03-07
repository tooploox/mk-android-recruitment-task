package com.tooploox.androidrecruitmenttask.app

import com.tooploox.androidrecruitmenttask.domain.Song

sealed interface SongListViewAction {

    data class ShowDetails(val song: Song) : SongListViewAction
}