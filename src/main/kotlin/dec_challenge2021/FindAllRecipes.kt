package dec_challenge2021

fun main() {
    val res = FindAllRecipes().findAllRecipes(
        arrayOf("burger", "bread", "sandwich"),
        listOf(
            listOf("sandwich", "meat", "bread"),
            listOf("yeast", "flour"),
            listOf("bread", "meat"),
        ),
        arrayOf("yeast", "flour", "meat")
    )

    println(res)
}

class FindAllRecipes {
    private val graph = mutableMapOf<String, List<String>>()
    private val result = mutableListOf<String>()
    private val memo = mutableMapOf<String, String>()

    fun findAllRecipes(recipes: Array<String>, ingredients: List<List<String>>, supplies: Array<String>): List<String> {
        for (supply in supplies) {
            memo[supply] = "VISITED"
        }

        for ((index, recipe) in recipes.withIndex()) {
            memo[recipe] = "NOT_VISITED"
            graph[recipe] = ingredients[index]
        }
        for (recipe in recipes) {
            topSort(recipe)
        }

        return result
    }

    private fun topSort(node: String): Boolean {
        if (!memo.containsKey(node) or (memo[node] == "VISITING")) return false
        if (memo[node] == "VISITED") return true

        memo[node] = "VISITING"
        val children = graph[node] ?: mutableListOf()
        for (child in children) {
            if (!topSort(child)) return false
        }

        memo[node] = "VISITED"
        result.add(node)
        return true
    }
}