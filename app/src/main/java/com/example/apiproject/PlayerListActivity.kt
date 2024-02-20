package com.example.apiproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.apiproject.databinding.ActivityPlayerListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlayerListActivity : AppCompatActivity() {
    
    companion object {
        val TAG = "PlayerListActivity"
    }

    private lateinit var binding: ActivityPlayerListBinding
    private lateinit var playerList: List<UsersLeague>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofit = RetrofitHelper.getInstance()
        val playerService = retrofit.create(PlayerService::class.java)

        val allStatsCall = playerService.getPlayersStatsAll()
        allStatsCall.enqueue(object:Callback<PlayerLeague> {
            override fun onResponse(call: Call<PlayerLeague>, response: Response<PlayerLeague>) {
                //make the default list here
                if (response.body()!=null) {
                    playerList = response.body()!!.data.users
                    playerAdapter = PlayerAdapter(playerList)
                }
            }

            override fun onFailure(call: Call<PlayerLeague>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        })







//        val playerCall = PlayerService.getPlayerStats("beasn")
//        playerCall.enqueue(object: Callback<Player> {
//            override fun onResponse(call: Call<Player>, response: Response<Player>) {
//                Log.d(TAG, "onResponse: ${response.body()}")
//            }
//
//            override fun onFailure(call: Call<Player>, t: Throwable) {
//                Log.d(TAG, "onFailure: ${t.message}")
//            }
//        })



    }

}