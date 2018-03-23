package traveljournal.io.traveljournal.src.adapter
import android.app.Activity
import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import traveljournal.io.traveljournal.R
import traveljournal.io.traveljournal.ViewJournalEntryDetailActivity

class JournalViewAdapter(private val activity : Activity): RecyclerView.Adapter<JournalViewAdapter.ViewHolder>() {

    //TODO refactor this to be held in model object: JournalEntry
    private val titles = arrayOf("My awesome day at the beach", "Discovered this amazing building!", "Coconut huts are cool")

    private val details = arrayOf(getDummyDesc(), getDummyDesc(), getDummyDesc())

    private val images = intArrayOf(R.drawable.hol1, R.drawable.hol2, R.drawable.hol3)

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView = itemView.findViewById(R.id.journal_entry_photo)
        var itemTitle: TextView = itemView.findViewById(R.id.journal_entry_title)
        var itemDetail: TextView = itemView.findViewById(R.id.journal_entry_description)
        var itemCard: CardView = itemView.findViewById(R.id.trips_cv)

    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.fragment_journal_item_cardview, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text = details[i]
        viewHolder.itemImage.setImageResource(images[i])
        viewHolder.itemCard.setOnClickListener {
            val intent = Intent(this.activity, ViewJournalEntryDetailActivity::class.java).apply {
                putExtra("123", "Clicked item : " + titles[i])
            }

            activity.startActivity(intent)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = titles.size

    fun getDummyDesc() : String {
        return "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam bibendum justo tincidunt est mattis porttitor. Mauris pharetra justo vitae quam tristique, sit amet imperdiet mauris aliquet. Nam consectetur leo maximus sem pretium, sit amet dictum dolor maximus. Mauris pulvinar sed diam eu sodales. Nam a iaculis leo. Sed consequat convallis est, sed gravida elit bibendum eu. Ut quis molestie tortor. Praesent maximus hendrerit eros luctus pellentesque. Phasellus quis porta leo.\n" +
                "\n" +
                "Praesent diam enim, tincidunt sed urna quis, maximus consequat nulla. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque ante enim, vulputate luctus elit id, consequat rutrum sapien. Nulla pulvinar nulla lectus, vel semper nunc tristique sed. Fusce ultricies enim lacus, ut varius est consectetur sed. Sed at condimentum lectus. In vulputate, orci sed molestie pretium, eros risus ornare velit, vitae vestibulum odio massa vulputate mauris. In tempus, arcu eu consequat tempor, libero ante semper justo, et lacinia dolor justo ac augue. Nulla scelerisque congue nulla, vitae scelerisque velit. Suspendisse sit amet leo non lectus faucibus posuere."
    }
}
