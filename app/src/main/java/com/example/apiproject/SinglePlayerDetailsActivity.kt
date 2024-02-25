package com.example.apiproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apiproject.databinding.ActivitySingleplayerDetailsBinding
import com.squareup.picasso.Picasso

class SinglePlayerDetailsActivity : AppCompatActivity() {

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


        Picasso.get().load("https://tetr.io/user-content/avatars/${player?._id}.jpg").into(binding.imageViewSinglePlayerDetailsPfp)

        binding.textViewSinglePlayerDetailsUsername.text = username
    }
}