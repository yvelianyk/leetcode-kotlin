package nov_challenge2021

fun main() {
    val result = AccountsMerge().accountsMerge(
        mutableListOf(
            mutableListOf("David", "Avid0@m.co", "David0@m.co", "David1@m.co"),
            mutableListOf("David", "Gvid3@m.co", "David3@m.co", "David4@m.co"),
            mutableListOf("David", "David4@m.co", "David5@m.co"),
            mutableListOf("David", "David2@m.co", "David3@m.co"),
            mutableListOf("David", "David1@m.co", "David2@m.co"),
        )
    )
    println(result)
}

class AccountsMerge {
    private var result: MutableList<MutableList<String>> = mutableListOf()
    private val emailsAdjList = mutableMapOf<String, MutableSet<String>>()
    private val visited = mutableSetOf<String>()

    fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
        val emailNameMap = mutableMapOf<String, String>()
        for (account in accounts) {
            val emails = account.subList(1, account.size)
            for (email in emails) {
                emailNameMap[email] = account[0]
                val adjEmails = emailsAdjList.getOrDefault(email, emails.toMutableSet())
                adjEmails.addAll(emails)
                emailsAdjList[email] = adjEmails
            }
        }

        for (entry in emailNameMap) {
            val list = mutableListOf<String>()
            traverse(entry.key, list)
            if (list.size > 0) {
                list.sort()
                list.add(0, emailNameMap[entry.key]!!)
                result.add(list)
            }
        }

        return result
    }

    private fun traverse(email: String, list: MutableList<String>) {
        if (visited.contains(email)) return
        visited.add(email)
        list.add(email)
        val children: MutableSet<String> = emailsAdjList.getOrDefault(email, mutableSetOf())
        for (child in children) {
            traverse(child, list)
        }
    }
}
