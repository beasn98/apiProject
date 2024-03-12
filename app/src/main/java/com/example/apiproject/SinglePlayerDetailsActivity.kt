package com.example.apiproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.apiproject.dataClassesUser.Player
import com.example.apiproject.databinding.ActivitySingleplayerDetailsBinding
import com.squareup.picasso.Picasso
import java.math.BigDecimal

class SinglePlayerDetailsActivity : AppCompatActivity() {

    companion object {
        val TAG = "SinglePlayerDetailsActivity"
    }

    private lateinit var binding: ActivitySingleplayerDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingleplayerDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val player = intent.getParcelableExtra<Player>(PlayerListActivity.EXTRA_PLAYER)?.data?.user
        val username = player?.username
        val rating = if (player?.league?.rating!! > -1) String.format(
            "%.2f",
            player.league.rating
        ) + " TR" else "Never played Tetra League"
        val rd = player.league.rd
        val glicko = player.league.glicko
        val exp = player.xp
        val gamesPlayed = player.league.gamesplayed
        val gamesWon = player.league.gameswon
        val apm = player.league.apm
        val pps = player.league.pps
        val vs = player.league.vs

        val bestRank = player.league.bestrank ?: "z"

        Picasso.get().load("https://tetr.io/user-content/avatars/${player._id}.jpg")
            .placeholder(R.drawable.cat).into(binding.imageViewSinglePlayerDetailsPfp)

        Picasso.get().load("https://tetr.io/res/league-ranks/${player.league.rank}.png")
            .into(binding.imageViewSinglePlayerDetailsRank)
        Picasso.get().load("https://tetr.io/res/league-ranks/${bestRank}.png")
            .into(binding.imageViewSinglePlayerDetailsBestRank)
        Picasso.get().load("https://tetr.io/res/flags/${player.country?.lowercase()}.png")
            .into(binding.imageViewSinglePlayerStatsDetailsCountry)

        binding.textViewSinglePlayerDetailsUsername.text = username
        binding.buttonSinglePlayerDetailsTakeToStats.text = "Tetra League Stats"

        binding.textViewSinglePlayerDetailsBest.text = "Best: "

        binding.textViewSinglePlayerDetailsXp.text =
            "XP: ${BigDecimal.valueOf(exp!!).toPlainString()}"

        binding.textViewSinglePlayerDetailsRating.text = rating

        if (rating == "Never played Tetra League") {
            binding.buttonSinglePlayerDetailsTakeToStats.isEnabled = false
        }
        else {
            binding.buttonSinglePlayerDetailsTakeToStats.setOnClickListener {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Tetra League stats:")
                builder.setMessage(
                    "Glicko: ${String.format("%.2f", glicko)} ± ${String.format(("%.2f"), rd)} \n" +
                            "\n" +
                            "Games played: $gamesPlayed \n" +
                            "Games won: $gamesWon \n" +
                            "Win rate: ${
                                String.format(
                                    "%.2f",
                                    (gamesWon.toDouble() / gamesPlayed) * 100
                                )
                            }% \n" +
                            "\n" +
                            "APM: $apm \n" +
                            "PPS: $pps \n" +
                            "VS: $vs"
                )

                builder.setPositiveButton("That's wild", null)
                builder.show()
            }
        }

        if (player.badges.isEmpty()) {
            binding.buttonSinglePlayerDetailsBadges.isEnabled = false
            binding.buttonSinglePlayerDetailsBadges.text = "No badges"
        }
        else {
            binding.buttonSinglePlayerDetailsBadges.text = "Badges"
            binding.buttonSinglePlayerDetailsBadges.setOnClickListener {
                var message = ""
                for (i in 0..<player.badges.size) {
                    message += "${i + 1}) ${player.badges[i].label}"
                    message += "\n"
                }
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Badges:")
                builder.setMessage(message)
                builder.setPositiveButton("Woah!", null)
                builder.show()
            }
        }
    }
}