package sep_challenge2021

fun main() {
    val matrix = arrayOf(intArrayOf(1,2,3), intArrayOf(4,5,6), intArrayOf(7,8,9))
    val res = spiralOrder(matrix)
    println(res)
}

fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    var bottom = matrix.size - 1
    var right = matrix[0].size - 1
    var top = 0
    var left = 0
    var dir = "R"
    var rowIndex = 0
    var colIndex = 0
    val result = ArrayList<Int>()
    while (left <= right && top <= bottom) {
        when (dir) {
            "R" -> {
                while (colIndex < right) {
                   result.add(matrix[rowIndex][colIndex++])
                }
                dir = "D"
                top++
            }
            "D" -> {
                while (rowIndex < bottom) {
                    result.add(matrix[rowIndex++][colIndex])
                }
                dir = "L"
                right--
            }
            "L" -> {
                while (colIndex > left) {
                    result.add(matrix[rowIndex][colIndex--])
                }
                dir = "U"
                bottom--
            }
            "U" -> {
                while (rowIndex > top) {
                    result.add(matrix[rowIndex--][colIndex])
                }
                dir = "R"
                left++
            }
        }
    }

    result.add(matrix[rowIndex][colIndex])
    return result
}

