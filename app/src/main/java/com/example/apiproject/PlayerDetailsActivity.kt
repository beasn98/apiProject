package com.example.apiproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apiproject.databinding.ActivityPlayerDetailsBinding
import com.squareup.picasso.Picasso

class PlayerDetailsActivity : AppCompatActivity() {

    private lateinit var binding:ActivityPlayerDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val player = intent.getParcelableExtra<UsersLeague>(PlayerAdapter.EXTRA_PLAYER)
        val gamesPlayed = player?.league?.gamesplayed
        val gamesWon = player?.league?.gameswon
        val rating = player?.league?.rating
        val glicko = player?.league?.glicko
        val rd = player?.league?.rd
        val rank = player?.league?.rank
        val bestRank = player?.league?.bestrank
        val apm = player?.league?.apm
        val pps = player?.league?.pps
        val vs = player?.league?.vs
        val experience = player?.xp

        val winRate = (gamesWon!!.toDouble()/gamesPlayed!!) * 100

        Picasso.get().load("https://tetr.io/user-content/avatars/${player?._id}.jpg").into(binding.imageViewPlayerDetailsPfp)

        Picasso.get().load("https://tetr.io/res/league-ranks/${rank}.png").into(binding.imageViewPlayerDetailsRank)

        Picasso.get().load("https://tetr.io/res/league-ranks/${bestRank}.png").into(binding.imageViewPlayerDetailsBestRank)

        binding.textViewPlayerDetailsBestRank.text = "Best:"
        binding.textViewPlayerDetailsVs.text = "VS: " + vs.toString()
        binding.textViewPlayerDetailsApm.text = "APM: " + apm.toString()
        binding.textViewPlayerDetailsGamesPlayed.text = "Games played: " + gamesPlayed.toString()
        binding.textViewPlayerDetailsGamesWon.text = "Games won: " + gamesWon.toString()
        binding.textViewPlayerDetailsGlicko.text = "Glicko: ${String.format("%.2f", glicko)} ± ${String.format(("%.2f"), rd)}"
        binding.textViewPlayerDetailsPps.text = "PPS: " + pps.toString()
        binding.textViewPlayerDetailsRating.text = String.format("%.2f",rating) + " TR"
        binding.textViewPlayerDetailsUsername.text = intent.getStringExtra(PlayerAdapter.EXTRA_USERNAME)
        binding.textViewPlayerDetailsXp.text = "XP: " + experience?.toInt().toString()
        binding.textViewPlayerDetailsWinRate.text = "Win rate: ${String.format("%.2f",winRate)}%"
    }
}