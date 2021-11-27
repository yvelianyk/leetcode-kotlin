package bk66

class Problem1 {
    fun countWords(words1: Array<String>, words2: Array<String>): Int {
        val map1 = words1.toList().groupingBy { it }.eachCount()
        val map2 = words2.toList().groupingBy { it }.eachCount()
        var result = 0
        for (entry: Map.Entry<String, Int> in map1) {
            val word = entry.key
            val count1 = entry.value
            val count2 = map2.getOrDefault(word, 0)
            if (count1 == count2 && count1 == 1) {
                result++
            }
        }
        return result
    }
}
