package bk48

fun main() {
    val result = MaxNumberOfConsecutiveOnes().getMaximumConsecutive(intArrayOf(1, 3))
    println(result)
}

// 1,1,1,4
// 0 - [0,1]
// sum = 1 coin = 1

// 1 - [0,1]
// 1 - [1,2]
// [0,2]. sum = 2, coin = 1

// 1 - [0,2]
// 1 - [1,3]
// [0,3]. sum = 3 coin = 1

// 4 - [0,3]
// 4 - [4,7]
// sum = 4. coin = 4

// 1,3
// 0 - [0,1]
// 1 - [0,1]
// sum = 1, coin 1

// 3 - [0,1]
// 3 - [3,4] = difference bigger than 1 - skip
// sum = 2 coin = 3
class MaxNumberOfConsecutiveOnes {
    fun getMaximumConsecutive(coins: IntArray): Int {
        coins.sort()
        var sum = 1
        for (coin in coins) {
            if (coin <= sum) {
                sum += coin
            } else return sum
        }
        return sum
    }
}
