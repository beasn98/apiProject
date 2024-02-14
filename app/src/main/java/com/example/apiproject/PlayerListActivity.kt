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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofit = RetrofitHelper.getInstance()
        val PlayerService = retrofit.create(PlayerService::class.java)

//        val allStatsCall = PlayerService.getPlayersStatsAll()
//        allStatsCall.enqueue(object:Callback<PlayerLeague> {
//            override fun onResponse(call: Call<PlayerLeague>, response: Response<PlayerLeague>) {
//                Log.d(TAG, "onResponse: ${response.body()}")
//            }
//
//            override fun onFailure(call: Call<PlayerLeague>, t: Throwable) {
//                Log.d(TAG, "onFailure: ${t.message}")
//            }
//        })

        binding.searchViewPlayerSearchbar.setOnSearchClickListener()


        val playerCall = PlayerService.getPlayerStats("beasn")
        playerCall.enqueue(object: Callback<Player> {
            override fun onResponse(call: Call<Player>, response: Response<Player>) {
                Log.d(TAG, "onResponse: ${response.body()}")
            }

            override fun onFailure(call: Call<Player>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        })



    }

}