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
 *
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
        // Generate list, display

        // getting the recyclerview by its id
        val recyclerview = view.findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(view.context)

        //mSnacks.generate()

        // This will pass the ArrayList to our Adapter
        val adapter = SnackAdapter(mSnacks.getData()) { position -> onListItemClick(position) }

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

        val sendOrder = view.findViewById<Button>(R.id.floatingActionButton)

        sendOrder.setOnClickListener {
            // Init Dialog Builder
            val builder: AlertDialog.Builder? = activity?.let {
                AlertDialog.Builder(it)
            }
            // Build List of Items
            var textOut = ""
            for (i in 0 until mSnacks.getData().size){
                if (mSnacks.getData()[i].isSelected()) textOut += "1x ${mSnacks.getData()[i].text}\n"
            }
            textOut += "TOTAL: \$X.XX"
            // Build and show a dialog box with the list of orders TODO show list, clear
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

    private fun reset() {
        for (i in 0 until mSnacks.getData().size) {
            if (mSnacks.getData()[i].isSelected()) mSnacks.getData()[i].select()
        }
        // getting the recyclerview by its id
        val recyclerview = view?.findViewById<RecyclerView>(R.id.recyclerview)

        // This will pass the ArrayList to our Adapter
        val adapter = SnackAdapter(mSnacks.getData()) { position -> onListItemClick(position) }

        // Setting the Adapter with the recyclerview
        if (recyclerview != null) {
            recyclerview.adapter = adapter
        }
    }
}