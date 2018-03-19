package traveljournal.io.traveljournal.src.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import traveljournal.io.traveljournal.R

class TripsViewAdapter : RecyclerView.Adapter<TripsViewAdapter.ViewHolder>() {

    private val titles = arrayOf("My awesome day at the beach ", "Trip 2", "Trip 3");

    private val details = arrayOf("Item one details", "Item two details",
            "Item three details")

    private val images = intArrayOf(R.drawable.hol1, R.drawable.hol2, R.drawable.hol3)

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.trip_photo)
            itemTitle = itemView.findViewById(R.id.trip_title)
            itemDetail = itemView.findViewById(R.id.trip_description)
            itemView.setOnClickListener{view : View ->  }
        }
    }


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.fragment_trips_item_cardview, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text = details[i]
        viewHolder.itemImage.setImageResource(images[i])
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = titles.size


}
