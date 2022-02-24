@file:Suppress("UNCHECKED_CAST")

package zonar.snacktruck

import android.graphics.Color
import android.util.Log
import androidx.lifecycle.ViewModel

/**
 * ViewModel class for storing and populating the list of snack items.
 * NOTES
 * A note has been left where the expected API integration would be placed.
 * Usage of a MutableLiveData would be preferable for a more scalable system but in the interest
 * of time and lack of necessity here I have opted for a simple arraylist.
 */
class SnacksListViewModel: ViewModel() {
    /**
     *  Container for all data objects representing possible snacks.
     */
    private val mData = ArrayList<SnacksViewModel>()
    init {
        generate()  // Generates a list on creation.
    }

    /**
     * Retrieves a copy of the data array.
     */
    fun getData(): ArrayList<SnacksViewModel> {
        return mData.clone() as ArrayList<SnacksViewModel>
    }
    /**
     * helper function for the constructor. Generates a list of snack objects for display.
     */
    private fun generate() {
        val meatColor = Color.parseColor("#FF0000")
        val vegColor = Color.parseColor("#00FF00")

        // TODO retrieve data from backend instead of hardcode
        mData.add(SnacksViewModel("French Fries", vegColor))
        mData.add(SnacksViewModel("Veggieburger", vegColor))
        mData.add(SnacksViewModel("Carrots", vegColor))
        mData.add(SnacksViewModel("Apples", vegColor))
        mData.add(SnacksViewModel("Banana", vegColor))
        mData.add(SnacksViewModel("Milkshake", vegColor))
        mData.add(SnacksViewModel("Cheeseburger", meatColor))
        mData.add(SnacksViewModel("Hamburger", meatColor))
        mData.add(SnacksViewModel("Hot Dog", meatColor))
    }

    /**
     * Selection function. Designates an object at the given index position to switch it's selected
     * status.
     */
    fun select(position: Int) {
        try{
            mData[position].select()
        } catch (e: ArrayIndexOutOfBoundsException) {
            Log.e("SnacksListViewModel", e.message.toString())
        }
    }
}