package dec_challenge2021

class MinCostToMoveChips {
    // 1,2,3        3,2
    // 2,2,2,3,3 => 2,3
    //
    // 1,2,3,4
    //
    // 2,3,2,3
    // 0,0,4,6 => 4
    //
    // 1,2,3,4,5
    //
    // 2,3,2,3,2
    // 6,6
    // Group by even and odd and find min
    fun minCostToMoveChips(position: IntArray): Int {
        var oddNum = 0
        var evenNum = 0
        for (i in position) {
            if (i % 2 == 0) evenNum++ else oddNum++
        }
        return minOf(evenNum, oddNum)
    }
}