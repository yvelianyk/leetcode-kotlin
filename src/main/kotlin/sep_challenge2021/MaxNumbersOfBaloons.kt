package sep_challenge2021

fun main() {
    val result = maxNumberOfBalloons("loonbalxballpoon")
    println("result: $result")
}

fun maxNumberOfBalloons(text: String): Int {
    val map = text.toCharArray().filter {
        "balon".contains(it)
    }.groupingBy { it }.eachCount()

    return arrayOf(
        map.getOrDefault('b', 0),
        map.getOrDefault('a', 0),
        map.getOrDefault('l', 0) / 2,
        map.getOrDefault('o', 0) / 2,
        map.getOrDefault('n', 0)
    ).minOrNull()!!
}