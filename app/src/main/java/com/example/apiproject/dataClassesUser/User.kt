package com.example.apiproject.dataClassesUser

import android.os.Parcelable
import com.example.apiproject.LeagueStats
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val _id: String,
    val username: String,
    val badges: List<Badge>,
    val xp: Double,
    val gamesplayed: Int,
    val gameswon: Int,
    val gametime: Double,
    val country: String?,
    val verified: Boolean,
    val league: LeagueStats
) : Parcelable
