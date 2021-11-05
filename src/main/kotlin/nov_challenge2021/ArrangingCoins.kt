package nov_challenge2021

import kotlin.math.sqrt

// Could be done iterative, binary search,
// or math by Gauss sum formula and finding root of square equation
// Gauss sum formula => S = n(n+1)/2
// Hence we can solve this equation get the formula
class ArrangingCoins {
    fun arrangeCoins(n: Int): Int {
        return (sqrt(2 * n.toLong() + 0.25) - 0.5).toInt()
    }
}
