package zonar.snacktruck

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SnackAdapter(private val mList: List<SnacksViewModel>, private val onItemClicked: (position: Int) -> Unit) : RecyclerView.Adapter<SnackAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view, onItemClicked)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        if(itemsViewModel.isSelected()) {
            holder.imageView.setImageResource(R.drawable.ic_check_24)
        }
        else {
            holder.imageView.setImageResource(itemsViewModel.image)
        }

        // sets the text to the textview from our itemHolder class
        holder.textView.text = itemsViewModel.text

        holder.textView.setTextColor(itemsViewModel.color)
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
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
