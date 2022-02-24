@file:Suppress("UNCHECKED_CAST")

package zonar.snacktruck

import android.graphics.Color
import androidx.lifecycle.ViewModel

class SnacksListViewModel: ViewModel() {
    private val mData = ArrayList<SnacksViewModel>()
    init {
        generate()
    }

    fun getData(): ArrayList<SnacksViewModel> {
        return mData.clone() as ArrayList<SnacksViewModel>
    }

    fun generate() {
        val img = R.drawable.ic_cross_24
        val meatColor = Color.parseColor("#FF0000")
        val vegColor = Color.parseColor("#00FF00")

        // TODO retrieve data from backend instead of hardcode
        mData.add(SnacksViewModel(img, "French Fries", vegColor, false))
        mData.add(SnacksViewModel(img, "Veggieburger", vegColor, false))
        mData.add(SnacksViewModel(img, "Carrots", vegColor, false))
        mData.add(SnacksViewModel(img, "Apples", vegColor, false))
        mData.add(SnacksViewModel(img, "Banana", vegColor, false))
        mData.add(SnacksViewModel(img, "Milkshake", vegColor, false))
        mData.add(SnacksViewModel(img, "Cheeseburger", meatColor, false))
        mData.add(SnacksViewModel(img, "Hamburger", meatColor, false))
        mData.add(SnacksViewModel(img, "Hot Dog", meatColor, false))
    }

    fun select(position: Int) {
        mData[position].select()
    }
}