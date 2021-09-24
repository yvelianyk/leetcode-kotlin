package sep_challenge2021

fun main() {
    val result = tribonacci(25)
    println(result)
}

// 0, 1, 1,
// 3 = 0 + 1 + 1 = 2
// 4 = 1 + 1 + 2
// From 3-th next is the sum of prev 3 th
fun tribonacci(n: Int): Int {
    val arr = mutableListOf<Int>(0,1,1)
    if (n < 3) return arr[n]
    for (i in 3..n) {
        arr.add(arr.takeLast(3).sum())
        if (i == n) return arr[i]
    }
    return arr.last()
}