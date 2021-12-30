package dec_challenge2021

fun main() {
    val res = SmallestIntDivisibleByK().smallestRepunitDivByK(121)
    println(res)
}

// Solved by using module addition and multiplication rules
// 1. a + b = c. (a mod k + b mod k) mod k = c mod k
// 2. a * b = c (a mod k * b mod k) mod k = c mod k
// Also:
// 111 = 11 * 10 + 1
// So, instead of keeping track of number and calculate reminder we can directly calculate reminder
// 111 mod k = (11 mod k * 10 mod k + 1)mod k
// 1111 mod k = (111 mod k + 10 mod k + 1) mod. Where 111 mod k where calculate in previous iteration
class SmallestIntDivisibleByK {
    fun smallestRepunitDivByK(k: Int): Int {
        if (k == 1) return 1
        if (k % 2 == 0 || k % 5 == 0) return -1
        var num = 1
        var count = 1
        while (num != 0) {
            num = (num * 10 % k + 1) % k
            count++
        }

        return count
    }
}