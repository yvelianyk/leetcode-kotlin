package aug_challenge2023

fun main() {
    val res = IsAcronym().isAcronym(
        listOf("alice", "bob", "charlie"),
        "abb"
    )
    println(res)
}

class IsAcronym {
    fun isAcronym(words: List<String>, s: String): Boolean {
        val res: List<Char> = words.map { it.first() }
        if (res.size != s.length) return false
        for (i in res.indices) if (res[i] != s[i]) return false
        return true
    }
}