package oct_challenge2021

class RandomizedSet {
    private val map = hashMapOf<Int, Int>()
    private val list = mutableListOf<Int>()

    fun insert(`val`: Int): Boolean {
        if (map.contains(`val`)) return false
        map[`val`] = list.size
        list.add(`val`)
        return true
    }

    fun remove(`val`: Int): Boolean {
        if (!map.contains(`val`)) return false
        val currentIndex = map[`val`]
        val last = list.last()
        list[currentIndex!!] = last
        map[last] = currentIndex
        list.removeAt(list.size - 1)
        map.remove(`val`)
        return true
    }

    fun getRandom(): Int {
        return list.random()
    }
}
