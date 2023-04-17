package apr_challenge2023

class KidsWithCandies {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        val max = candies.maxOrNull()
        return candies.toList().map { i -> (i + extraCandies) >= max!! }
    }
}