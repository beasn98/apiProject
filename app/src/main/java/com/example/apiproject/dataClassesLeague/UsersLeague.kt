package com.example.apiproject.dataClassesLeague

import android.os.Parcelable
import com.example.apiproject.LeagueStats
import kotlinx.parcelize.Parcelize

@Parcelize
data class UsersLeague(
    val _id: String,
    val username: String,
    val xp: Double,
    val country: String?,
    val league: LeagueStats
) : Parcelable
