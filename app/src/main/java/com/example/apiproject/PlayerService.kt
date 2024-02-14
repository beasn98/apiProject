package com.example.apiproject

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Path

interface PlayerService {
    @GET("users/{user}")
    fun getPlayerStats(@Path("user") user: String): Call<Player>

    @GET("users/lists/league")
    fun getPlayersStatsAll(): Call<PlayerLeague>
}