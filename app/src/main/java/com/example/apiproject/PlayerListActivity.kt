package com.example.apiproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apiproject.databinding.ActivityPlayerListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlayerListActivity : AppCompatActivity() {
    
    companion object {
        val TAG = "PlayerListActivity"
        val EXTRA_PLAYER = "player"
    }

    private lateinit var binding: ActivityPlayerListBinding
    private lateinit var playerList: List<UsersLeague>
    private lateinit var playerAdapter: PlayerAdapter

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
                    //playerAdapter.notifyDataSetChanged()
                    binding.recyclerViewPlayerList.adapter = playerAdapter
                    binding.recyclerViewPlayerList.layoutManager = LinearLayoutManager(this@PlayerListActivity)
                }
            }

            override fun onFailure(call: Call<PlayerLeague>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        })


        binding.searchViewPlayerSearchbar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                val playerCall = playerService.getPlayerStats(query ?: "")
                playerCall.enqueue(object: Callback<Player> {
                    override fun onResponse(call: Call<Player>, response: Response<Player>) {
                        val playerIntent = Intent(this@PlayerListActivity, SinglePlayerDetailsActivity::class.java)
                        playerIntent.putExtra(EXTRA_PLAYER, response.body())
                        this@PlayerListActivity.startActivity(playerIntent)
                    }

                    override fun onFailure(call: Call<Player>, t: Throwable) {
                        Log.d(TAG, "onFailure: ${t.message}")
                    }
                })
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })





    }

}