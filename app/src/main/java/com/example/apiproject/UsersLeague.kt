package com.example.apiproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UsersLeague(
    val _id: String,
    val username: String,
    val xp: Double,
    val country: String?,
    val league: LeagueStats
) : Parcelable
