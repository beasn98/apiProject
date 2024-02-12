package com.example.apiproject

data class User(
    val username: String,
    val badges: List<Badge>,
    val xp: Double,
    val gamesplayed: Int,
    val gameswon: Int,
    val gametime: Double,
    val country: String,
    val supporter_tier: Int,
    val verified: Boolean,
    val league: LeagueStats
)
