package com.example.apiproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.apiproject.databinding.ActivityPlayerDetailsBinding
import com.squareup.picasso.Picasso
import java.math.BigDecimal

class PlayerDetailsActivity : AppCompatActivity() {

    private lateinit var binding:ActivityPlayerDetailsBinding

    companion object {
        val TAG = "playerDetailsActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val player = intent.getParcelableExtra<UsersLeague>(PlayerAdapter.EXTRA_PLAYER)
        val gamesPlayed = player?.league?.gamesplayed ?:0
        val gamesWon = player?.league?.gameswon ?:0
        val rating = player?.league?.rating ?:0
        val glicko = player?.league?.glicko ?:0
        val rd = player?.league?.rd ?:0
        val rank = player?.league?.rank ?: "z"
        val bestRank = player?.league?.bestrank
        val apm = player?.league?.apm ?:0
        val pps = player?.league?.pps ?:0
        val vs = player?.league?.vs ?:0
        val experience = player?.xp
        val country = player?.country ?:""

        val winRate = (gamesWon!!.toDouble()/gamesPlayed!!) * 100

        Picasso.get().load("https://tetr.io/user-content/avatars/${player?._id}.jpg").placeholder(R.drawable.cat).into(binding.imageViewPlayerDetailsPfp)

        Picasso.get().load("https://tetr.io/res/league-ranks/${rank}.png").into(binding.imageViewPlayerDetailsRank)

        Picasso.get().load("https://tetr.io/res/league-ranks/${bestRank}.png").into(binding.imageViewPlayerDetailsBestRank)

        Picasso.get().load("https://tetr.io/res/flags/${country.lowercase()}.png").into(binding.imageViewPlayerDetailsCountry)

        binding.textViewPlayerDetailsBestRank.text = "Best:"
        binding.textViewPlayerDetailsStanding.text = "#" + intent.getIntExtra(PlayerAdapter.EXTRA_STANDING, -1)
        binding.textViewPlayerDetailsVs.text = "VS: " + vs.toString()
        binding.textViewPlayerDetailsApm.text = "APM: " + apm.toString()
        binding.textViewPlayerDetailsGamesPlayed.text = "Games played: " + gamesPlayed.toString()
        binding.textViewPlayerDetailsGamesWon.text = "Games won: " + gamesWon.toString()
        binding.textViewPlayerDetailsGlicko.text = "Glicko: ${String.format("%.2f", glicko)} ± ${String.format(("%.2f"), rd)}"
        binding.textViewPlayerDetailsPps.text = "PPS: " + pps.toString()
        binding.textViewPlayerDetailsRating.text = String.format("%.2f",rating) + " TR"
        binding.textViewPlayerDetailsUsername.text = intent.getStringExtra(PlayerAdapter.EXTRA_USERNAME)
        binding.textViewPlayerDetailsXp.text = "XP: ${BigDecimal.valueOf(experience!!).toPlainString()}"
        binding.textViewPlayerDetailsWinRate.text = "Win rate: ${String.format("%.2f",winRate)}%"
    }
}