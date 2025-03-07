package com.tooploox.androidrecruitmenttask.data

import com.tooploox.androidrecruitmenttask.domain.Song
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SongsResponse(
    @SerialName("results") val songs: List<SongResponse>
)

@Serializable
data class SongResponse(
    @SerialName("trackName") val trackName: String,
    @SerialName("artistName") val artist: String
)

fun SongResponse.toDomainModel() = Song(title = trackName, artist = artist)
