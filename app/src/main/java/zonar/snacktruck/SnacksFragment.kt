package zonar.snacktruck

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Fragment Class for ordering on the snack truck. Displays a list of options generated by the
 * ViewModel and allows selection of any number of them before submitting an order.
 * NOTES
 * the mock up seems to imply that each item can only be ordered once at a time, which while I
 * would personally implement a design that allows multiple copies of the same item, I decided
 * to stick to the given design specifications.
 * @author Marc Perez
 */
class SnacksFragment : Fragment() {
    private val mSnacks: SnacksListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_snacks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Generate recyclerView from Snacks list data
        recycler()

        // Assign order Button On Click Listener
        view.findViewById<Button>(R.id.floatingActionButton).setOnClickListener {
            // Init Dialog Builder
            val builder: AlertDialog.Builder? = activity?.let {
                AlertDialog.Builder(it)
            }
            // Build List of Items in String
            var textOut = ""
            for (i in 0 until mSnacks.getData().size){
                if (mSnacks.getData()[i].isSelected()) textOut += "1x ${mSnacks.getData()[i].text}\n"
            }
            textOut += "TOTAL: \$X.XX"
            // Build and show a dialog box with the list of orders
            builder?.setMessage(textOut)
                ?.setTitle(getString(R.string.text_dialog_title))
                ?.setPositiveButton("Submit"
                ) { _, _ ->
                    Toast.makeText(context, "Success!", Toast.LENGTH_LONG).show()
                    reset()
                }
                ?.setNegativeButton("Cancel"
                ) { _, _ ->
                    Toast.makeText(context, "Failure!", Toast.LENGTH_LONG).show()
                }
                ?.create()?.show()
        }
    }

    private fun onListItemClick(position: Int) {
        mSnacks.select(position)
    }

    /**
     * Resets status of selected items in the snack list and resets the recycler view.
     */
    private fun reset() {
        for (i in 0 until mSnacks.getData().size) {
            if (mSnacks.getData()[i].isSelected()) mSnacks.select(i)
        }
        recycler()
    }

    /**
     * Creates a recyclerview and displays it based on data retrieved by ModelView.
     */
    private fun recycler() {
        val recyclerview = view?.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview?.layoutManager = LinearLayoutManager(view?.context)
        val adapter = SnackAdapter(mSnacks.getData()) { position -> onListItemClick(position) }
        recyclerview?.adapter = adapter
    }
}