package bk69

// ["dd","aa","bb","dd","aa","dd","bb","dd","aa","cc","bb","cc","dd","cc"]
fun main() {
    val res = Problem3().longestPalindrome(
        arrayOf(
            "xx", "zz"
        )
    )
    println(res)
}

class Problem3 {
    fun longestPalindrome(words: Array<String>): Int {
        val countMap = words.toList().groupingBy { it }.eachCount() as MutableMap<String, Int>
        var sameMax = 0
        var res = 0
        for (entry in countMap) {
            val str = entry.key
            val reversed = str.reversed()
            val num = entry.value
            val reversedCount = countMap.getOrDefault(str.reversed(), 0)
            if (str == reversed && num == 1) sameMax = 1
            if (num >= 1 && reversedCount >= 1) {
                var minNum = minOf(num, reversedCount)
                if (minNum > 1 && minNum % 2 == 1) minNum--
                res += minNum * if (str == reversed) 2 else 4
                countMap[str] = num - minNum
                if (countMap.containsKey(reversed)) {
                    countMap[reversed] = reversedCount - minNum
                }
            }
        }
        for (entry in countMap) {
            if (entry.key == entry.key.reversed()) sameMax = maxOf(entry.value, sameMax)
        }

        return res + sameMax * 2
    }
}
