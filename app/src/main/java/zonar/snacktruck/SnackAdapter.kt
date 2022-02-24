package zonar.snacktruck

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Adapter for the Recycler View to hold a list of snacks.
 * NOTES
 * Much of this is boilerplate adapter code and is generated comments. Most of the modifications
 * were in allowing a function to be passed in for the click listener.
 */
class SnackAdapter(private val mList: List<SnacksViewModel>, private val onItemClicked: (position: Int) -> Unit) : RecyclerView.Adapter<SnackAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view, onItemClicked)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        // Temp object
        val itemsViewModel = mList[position]

        // sets the image based on selection status of object; check if selected, cross if not.
        if(itemsViewModel.isSelected()) {
            holder.imageView.setImageResource(R.drawable.ic_check_24)
        }
        else {
            holder.imageView.setImageResource(R.drawable.ic_cross_24)
        }

        // Assign text and color based on input.
        holder.textView.text = itemsViewModel.text
        holder.textView.setTextColor(itemsViewModel.color)
    }

    /**
     * Getter function for list size. Override because container is handled differently than
     * parent.
     */
    override fun getItemCount(): Int {
        return mList.size
    }

    /**
     * Holds a view and assigns it's text, image, and click listener.
     */
    class ViewHolder(view: View, private val onItemClicked: (position: Int) -> Unit) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)
        private var selected: Boolean = false
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            onItemClicked(absoluteAdapterPosition)
            selected = !selected
            if (selected) {
                imageView.setImageResource(R.drawable.ic_check_24)
            } else {
                imageView.setImageResource(R.drawable.ic_cross_24)
            }
        }
    }
}
