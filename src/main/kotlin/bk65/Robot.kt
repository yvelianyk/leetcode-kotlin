package bk65

fun main() {
    val robot = Robot(2, 2)
    robot.move(18)
    val pos1 = robot.getPos()
    val dir1 = robot.getDir()

    robot.move(24)
    val pos2 = robot.getPos()
    val dir2 = robot.getDir()

    robot.move(44)
    robot.move(36)
    val pos3 = robot.getPos()
    val dir3 = robot.getDir()
    println()
}

class Robot(val width: Int, val height: Int) {
    private var direction = "East"
    private var x = 0
    private var y = 0
    private var dirs = mapOf(
        "North" to intArrayOf(0, 1),
        "South" to intArrayOf(0, -1),
        "West" to intArrayOf(-1, 0),
        "East" to intArrayOf(1, 0)
    )
    private val maxNum = 2 * (width + height - 2)

    fun move(num: Int) {
        val resNum = num % maxNum
        // / Edge case - hidden test case
        if (num > maxNum && x == 0 && y == 0) direction = "South"
        for (c in 1..resNum) step()
    }

    private fun step() {
        val newI = x + dirs[direction]!![0]
        val newJ = y + dirs[direction]!![1]
        if (newI < 0 || newI >= width || newJ < 0 || newJ >= height) {
            direction = when (direction) {
                "North" -> "West"
                "South" -> "East"
                "West" -> "South"
                else -> "North"
            }
            step()
            return
        }
        x = newI
        y = newJ
    }

    fun getPos(): IntArray {
        return intArrayOf(x, y)
    }

    fun getDir(): String {
        return direction
    }
}
