package zonar.snacktruck

data class SnacksViewModel(val image: Int, val text: String, val color: Int, var selected: Boolean) {
    fun isSelected(): Boolean {
        return selected
    }

    fun select() {
        selected = !selected
    }
}
