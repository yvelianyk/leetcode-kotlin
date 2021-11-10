package bk48

// ["AuthenticationManager","renew","countUnexpiredTokens","countUnexpiredTokens","generate","generate","renew","generate","generate",
// "countUnexpiredTokens","countUnexpiredTokens","countUnexpiredTokens","renew","countUnexpiredTokens","countUnexpiredTokens","countUnexpiredTokens","generate","countUnexpiredTokens","renew"]
// [[13],["ajvy",1],[3],[4],["fuzxq",5],["izmry",7],["puv",12],["ybiqb",13],["gm",14],[15],[18],[19],
// ["ybiqb",21],[23],[25],[26],["aqdm",28],[29],["puv",30]]
fun main() {
    val manager = AuthenticationManager(13)
    manager.renew("ajvy", 1)
    val res1 = manager.countUnexpiredTokens(3)
    val res2 = manager.countUnexpiredTokens(4)
    manager.generate("fuzxq", 5)
    manager.generate("izmry", 7)
    manager.renew("puv", 12)
    manager.generate("ybiqb", 13)
    manager.generate("gm", 14)
    val res3 = manager.countUnexpiredTokens(15)
    val res4 = manager.countUnexpiredTokens(18)
    val res5 = manager.countUnexpiredTokens(19)
    manager.renew("ybiqb", 21)
    val res33 = manager.countUnexpiredTokens(23)
    val res44 = manager.countUnexpiredTokens(25)
    val res55 = manager.countUnexpiredTokens(26)
    println()
}

class AuthenticationManager(timeToLive: Int) {
    private var timeToLive: Int

    init {
        this.timeToLive = timeToLive
    }

    private val map = mutableMapOf<String, Int>()

    fun generate(tokenId: String, currentTime: Int) {
        map[tokenId] = currentTime + timeToLive
    }

    fun renew(tokenId: String, currentTime: Int) {
        if (map.containsKey(tokenId) && map[tokenId]!! > currentTime) {
            generate(tokenId, currentTime)
        }
    }

    fun countUnexpiredTokens(currentTime: Int): Int {
        map.entries.removeIf {
            it.value <= currentTime
        }
        return map.size
    }
}
