package oct_challenge2021

fun main() {
    val board = arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'C', 'S'),
        charArrayOf('A', 'D', 'E', 'E'),
    )
    val res = WordSearch().exist(board, "ABCCED")
    println(res)
}

class WordSearch {
    private lateinit var board: Array<CharArray>
    private lateinit var word: String

    fun exist(board: Array<CharArray>, word: String): Boolean {
        this.board = board
        this.word = word
        for (i in board.indices) {
            for (j in board[i].indices) {
                if (traverse(i, j, 0)) return true
            }
        }
        return false
    }

    fun traverse(i: Int, j: Int, currentIndex: Int): Boolean {
        if (board[i][j] != word[currentIndex]) return false
        if (currentIndex == word.length - 1) return board[i][j] == word[currentIndex]
        val dirs = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
        val temp = board[i][j]
        board[i][j] = '#'
        var result = false
        for (dir in dirs) {
            val newI = i + dir[0]
            val newJ = j + dir[1]
            if (
                newI >= 0 &&
                newI < board.size &&
                newJ >= 0 &&
                newJ < board[0].size &&
                board[newI][newJ] != '#'
            ) {
                result = result || traverse(newI, newJ, currentIndex + 1)
            }
        }
        board[i][j] = temp
        return result
    }
}