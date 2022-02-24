package zonar.snacktruck

/**
 * Snacks View Model object. Data object that represents a single snack item.
 */
data class SnacksViewModel(val text: String, val color: Int) {
    /**
     * Private variable representing if the object is selected. Used to determine it's place in
     * the checkout screen.
     * NOTES
     * In a situation where multiples of the same item can be ordered, this would be a counter
     * and the select function would instead be a pair of functions, increment and decrement.
     */
    private var selected = false

    /**
     * returns boolean value of selection status.
     */
    fun isSelected(): Boolean {
        return selected
    }

    /**
     * Flips the setting to/from selected and unselected.
     */
    fun select() {
        selected = !selected
    }
}
