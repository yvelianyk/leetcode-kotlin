package sep_challenge2021

fun main() {
    var arr = listOf<String>("cha","r","act","ers")
    val res = maxLength(arr)
    println(res)
}

var max = 0

fun maxLength(arr: List<String>): Int {
    backtrack(arr, 0, "");
    return max;
}

private fun backtrack(arr: List<String>, index: Int, currString: String) {
    if (index == arr.size) max = maxOf(max, currString.length)

    for (currIndex in index until arr.size) {
        val areAllCharsUnique = arr[currIndex].toCharArray().toSet().size == arr[currIndex].length
        if (areAllCharsUnique && !isDuplicates(currString, arr[currIndex])) {
            max = maxOf(max, arr[currIndex].length + currString.length)
            backtrack(arr, currIndex + 1, currString + arr[currIndex])
        }
    }
}

private fun isDuplicates(
    currString: String,
    str: String,
): Boolean {
    val set = currString.toCharArray().toSet()
    for (c in str) if (set.contains(c)) return true
    return false
}
