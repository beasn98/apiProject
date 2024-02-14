//package com.example.apiproject
//
//import android.content.Intent
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//
//
//class PlayerAdapter(var playerList: List<Player>) :
//    RecyclerView.Adapter<PlayerAdapter.ViewHolder>() {
//
//    /**
//     * Provide a reference to the type of views that you are using
//     * (custom ViewHolder)
//     */
//    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val textViewMagnitude: TextView
//
//        init {
//            // Define click listener for the ViewHolder's View
//            textViewMagnitude = view.findViewById()
//
//        }
//
//    }
//
//    // Create new views (invoked by the layout manager)
//    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
//        // Create a new view, which defines the UI of the list item
//        val view = LayoutInflater.from(viewGroup.context)
//            .inflate(R.layout.item_player, viewGroup, false)
//
//        return ViewHolder(view)
//    }
//
//    companion object {
//        val EXTRA_EARTHQUAKE = "earthquake"
//    }
//
//    // Replace the contents of a view (invoked by the layout manager)
//    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
//
//        // Get element from your dataset at this position and replace the
//        // contents of the view with that element
//        val context = viewHolder.layout.context
//        val earthquake = playerList[position]
//
//
//        viewHolder.layout.setOnClickListener {
//            val earthquakeIntent = Intent(context, EarthquakeMapActivity::class.java)
//            earthquakeIntent.putExtra(EXTRA_EARTHQUAKE, earthquake)
//            context.startActivity(earthquakeIntent)
//        }
//
//    }
//
//    // Return the size of your dataset (invoked by the layout manager)
//    override fun getItemCount() = earthquakesList.size
//
//}