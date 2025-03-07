package com.tooploox.androidrecruitmenttask.domain

import kotlinx.serialization.Serializable

@Serializable
data class Song(
    val title: String,
    val artist: String
)
