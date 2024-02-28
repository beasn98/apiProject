package com.example.apiproject

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PlayerAdapter(var playerList: List<UsersLeague>) :
    RecyclerView.Adapter<PlayerAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewName: TextView
        val layout : ConstraintLayout
        val profilePicture : ImageView
        val textViewStanding : TextView
        val imageViewRank: ImageView
        val imageViewCountry: ImageView
        init {
            // Define click listener for the ViewHolder's View
            textViewName = view.findViewById(R.id.textView_playerItem_username)
            layout = view.findViewById(R.id.layout_item_player)
            profilePicture = view.findViewById(R.id.imageView_playerItem_pfp)
            textViewStanding = view.findViewById(R.id.textView_playerItem_standing)
            imageViewRank = view.findViewById(R.id.imageView_playerItem_rank)
            imageViewCountry = view.findViewById(R.id.imageView_playerItem_country)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_player, viewGroup, false)

        return ViewHolder(view)
    }
    companion object {
        val TAG = "playerAdapter"
        val EXTRA_PLAYER = "player"
        val EXTRA_USERNAME = "username"
        val EXTRA_STANDING = "standing"
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val context = viewHolder.layout.context
        val player = playerList[position]
        viewHolder.textViewName.text = player.username
        viewHolder.textViewStanding.text = "#${position+1}"

        Picasso.get().load("https://tetr.io/res/league-ranks/${player.league.rank}.png").into(viewHolder.imageViewRank)

        Picasso.get().load("https://tetr.io/user-content/avatars/${player._id}.jpg").into(viewHolder.profilePicture)

        Picasso.get().load("https://tetr.io/res/flags/${player.country?.lowercase()}.png").into(viewHolder.imageViewCountry)

        viewHolder.layout.setOnClickListener {
            val playerIntent = Intent(context, PlayerDetailsActivity::class.java)
            playerIntent.putExtra(EXTRA_PLAYER, player)
            playerIntent.putExtra(EXTRA_USERNAME, player.username)
            playerIntent.putExtra(EXTRA_STANDING, position+1)
            context.startActivity(playerIntent)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = playerList.size

}