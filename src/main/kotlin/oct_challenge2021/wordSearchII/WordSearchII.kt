package oct_challenge2021.wordSearchII

fun main() {
    val matrix = arrayOf(
        charArrayOf('o', 'a', 'a', 'n'),
        charArrayOf('e', 't', 'a', 'e'),
        charArrayOf('i', 'h', 'k', 'r'),
        charArrayOf('i', 'f', 'l', 'v'),
    )
    val words = arrayOf("oath", "pea", "eat", "rain")
    val result = WordSearchII().findWords(matrix, words)
    println(result) // expected "oath", "eat"
}

class WordSearchII {
    private val hashResult = hashSetOf<String>()
    private lateinit var board: Array<CharArray>
    private val trie = Trie()
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        this.board = board
        for (word in words) trie.insert(word)
        for (i in board.indices) {
            for (j in board[0].indices) {
                traverse(i, j, "")
            }
        }
        return hashResult.toList()
    }

    private fun traverse(i: Int, j: Int, prev: String) {
        if (i < 0 || i >= board.size || j < 0 || j >= board[0].size || board[i][j] == '#') return
        val current = prev + board[i][j]
        if (!trie.startsWith(current)) return
        if (trie.search(current)) hashResult.add(current)
        val temp = board[i][j]
        board[i][j] = '#'
        traverse(i + 1, j, current)
        traverse(i, j + 1, current)
        traverse(i - 1, j, current)
        traverse(i, j - 1, current)
        board[i][j] = temp
    }
}

private class Trie {
    private val root: TrieNode? = TrieNode()

    fun insert(word: String) {
        var node = root
        for (currChar in word) {
            if (!node!!.containsKey(currChar)) {
                node.put(currChar, TrieNode())
            }
            node = node.get(currChar)
        }
        node!!.isEnd = true
    }

    fun search(word: String): Boolean {
        val node = searchPrefix(word)
        return node != null && node.isEnd
    }

    fun startsWith(prefix: String): Boolean {
        val node = searchPrefix(prefix)
        return node != null
    }

    private fun searchPrefix(word: String): TrieNode? {
        var node = root
        for (currChar in word) {
            if (node!!.containsKey(currChar)) {
                node = node.get(currChar)
            } else {
                return null
            }
        }

        return node
    }

}

private class TrieNode {
    private val numberOfAlphabet = 26
    private var links: Array<TrieNode?> = arrayOfNulls(numberOfAlphabet)
    var isEnd = false

    fun containsKey(char: Char): Boolean {
        return links[char - 'a'] != null
    }

    fun get(char: Char): TrieNode? {
        return links[char - 'a']
    }

    fun put(char: Char, node: TrieNode) {
        links[char - 'a'] = node
    }

}