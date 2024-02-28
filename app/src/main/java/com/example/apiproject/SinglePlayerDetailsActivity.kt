package com.example.apiproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apiproject.databinding.ActivitySingleplayerDetailsBinding
import com.squareup.picasso.Picasso

class SinglePlayerDetailsActivity : AppCompatActivity() {
    companion object {
        val EXTRA_PLAYER = "player"
    }

    private lateinit var binding : ActivitySingleplayerDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingleplayerDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Hey Sam G, can you do this stuff?
        // Please design the activity_singleplayer_details.xml file.
        // Also, please set all the stuff that would go on the design below
        val player = intent.getParcelableExtra<Player>(PlayerListActivity.EXTRA_PLAYER)?.data?.user
        val username = player?.username
        val rating = player?.league?.rating




        Picasso.get().load("https://tetr.io/user-content/avatars/${player?._id}.jpg").into(binding.imageViewSinglePlayerDetailsPfp)

        Picasso.get().load("https://tetr.io/res/league-ranks/${player?.league?.rank}.png").into(binding.imageViewPlayerDetailsRank)
        Picasso.get().load("https://tetr.io/res/league-ranks/${player?.league?.bestrank}.png").into(binding.imageViewPlayerDetailsBestRank)
        Picasso.get().load("https://tetr.io/res/flags/${player?.country}.png").into(binding.imageViewSinglePlayerStatsDetailsCountry)

        binding.textViewSinglePlayerDetailsUsername.text = username
        binding.buttonSinglePlayerDetailsTakeToStats.text = "Tetra League Stats"

        binding.textViewSinglePlayerDetailsBest.text = "Best: "

        binding.textViewSinglePlayerDetailsXp.text = "XP: ${player?.xp}"

        binding.textViewSinglePlayerDetailsRating.text = "$rating TR"

        binding.buttonSinglePlayerDetailsTakeToStats.setOnClickListener {
            val dataIntent = Intent(this, SinglePlayerStatsDetails::class.java)
            dataIntent.putExtra(EXTRA_PLAYER, player)
            this.startActivity(dataIntent)
        }
    }
}