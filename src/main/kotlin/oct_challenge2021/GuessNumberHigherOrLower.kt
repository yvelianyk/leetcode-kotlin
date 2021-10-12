package oct_challenge2021

fun main() {
    val result = GuessNumberHigherOrLower().guessNumber(2)
    println(result)
}

class GuessNumberHigherOrLower: GuessGame() {
    override fun guessNumber(n: Int): Int {
        var left = 1
        var right = n
        while (left < right) {
            val mid = left + (right - left) / 2
            val guessed = guess(mid)
            if (guessed == 0) return mid
            when (guessed) {
                1 -> left = mid + 1
                else -> right = mid
            }
        }
        return left
    }
}

abstract class GuessGame {
    private val number = 2
    fun guess(num: Int): Int {
        return when {
            num < number -> 1
            num > number -> -1
            else -> 0
        }
    }
    abstract fun guessNumber(num: Int): Int
}