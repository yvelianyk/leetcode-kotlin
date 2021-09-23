package sep_challenge2021

fun main() {
    val arr = intArrayOf(100)
    val res = maxTurbulenceSize(arr)
    println(res)
}

fun maxTurbulenceSize(arr: IntArray): Int {
    var result = 1
    var currComparison = 0
    var maxLength = 1
    for (i in 0 until arr.size - 1) {
        if (arr[i] < arr[i + 1]) {
            if (currComparison >= 0) maxLength++ else maxLength = 2
            currComparison = -1
        } else if (arr[i] > arr[i + 1]) {
            if (currComparison <= 0) maxLength++ else maxLength = 2
            currComparison = 1
        } else {
            currComparison = 0
            maxLength = 1
        }
    }
    return result
}