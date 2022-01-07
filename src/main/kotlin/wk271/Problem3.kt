package wk271

fun main() {
//    val res = Problem3().minimumRefill(intArrayOf(2,2,3,3), 5 ,5)
//    val res = Problem3().minimumRefill(intArrayOf(2,2,3,3), 3 ,4)
    val res = Problem3().minimumRefill(intArrayOf(2, 2, 5, 2, 2), 5, 5)
    println(res)
}

class Problem3 {
    fun minimumRefill(plants: IntArray, capacityA: Int, capacityB: Int): Int {
        var aliceCur = 0
        var bobCur = plants.size - 1
        var aliceCurCapacity = capacityA
        var bobCurCapacity = capacityB
        var result = 0
        while (aliceCur <= bobCur) {
            if (aliceCur == bobCur) {
                if (bobCurCapacity > aliceCurCapacity) {
                    if (plants[bobCur] <= bobCurCapacity) {
                        bobCurCapacity -= plants[bobCur]
                    } else {
                        result++
                    }
                } else {
                    if (plants[aliceCur] <= aliceCurCapacity) {
                        aliceCurCapacity -= plants[aliceCur]
                    } else {
                        result++
                    }
                }
                return result
            }
            if (plants[aliceCur] <= aliceCurCapacity) {
                aliceCurCapacity -= plants[aliceCur]
            } else {
                result++
                aliceCurCapacity = capacityA
                aliceCurCapacity -= plants[aliceCur]
            }

            if (plants[bobCur] <= bobCurCapacity) {
                bobCurCapacity -= plants[bobCur]
            } else {
                result++
                bobCurCapacity = capacityB
                bobCurCapacity -= plants[bobCur]
            }

            aliceCur++
            bobCur--
        }
        return result
    }
}
