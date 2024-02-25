package com.example.apiproject

import android.content.Intent
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

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewName: TextView
        val layout : ConstraintLayout
        val profilePicture : ImageView
        val textViewStanding : TextView
        val textViewRanking : TextView
        init {
            // Define click listener for the ViewHolder's View
            textViewName = view.findViewById(R.id.textView_playerItem_username)
            layout = view.findViewById(R.id.layout_item_player)
            profilePicture = view.findViewById(R.id.imageView_playerItem_pfp)
            textViewStanding = view.findViewById(R.id.textView_playerItem_standing)
            textViewRanking = view.findViewById(R.id.textView_playerItem_rank)
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
        val EXTRA_PLAYER = "player"
        val EXTRA_USERNAME = "username"
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val context = viewHolder.layout.context
        val player = playerList[position]
        viewHolder.textViewName.text = player.username
        viewHolder.textViewStanding.text = player.league.standing.toString()
        viewHolder.textViewRanking.text = player.league.rank
        Picasso.get().load("https://tetr.io/user-content/avatars/${player._id}.jpg").into(viewHolder.profilePicture)

        viewHolder.layout.setOnClickListener {
            val playerIntent = Intent(context, SinglePlayerDetailsActivity::class.java)
            playerIntent.putExtra(EXTRA_PLAYER, player)
            playerIntent.putExtra(EXTRA_USERNAME, player.username)
            context.startActivity(playerIntent)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = playerList.size

}