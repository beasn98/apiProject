package com.example.apiproject

data class LeagueStats(val gamesplayed:Int,
    val gameswon: Int,
    val rating: Double,
    val glicko: Double,
    val rd: Double,
    val rank: String,
    val bestrank: String,
    val apm: Double,
    val pps: Double,
    val vs: Double,
    val standing: Int,
    )
