package oct_challenge2021

fun main() {
    val trie = Trie()
    trie.insert("apple")
    val res1 = trie.search("apple")
    assert(res1)
    val res2 = trie.search("app")
    assert(!res2)
    val res3 = trie.startsWith("app")
    assert(res3)
    trie.insert("app")
    val res4 = trie.search("app")
    assert(res4)
}

class Trie {
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