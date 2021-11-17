package wk267

// [84,49,5,24,70,77,87,8]
// 3
fun main() {
    val tickets = intArrayOf(84, 49, 5, 24, 70, 77, 87, 8)
    val result = Problem1().timeRequiredToBuy(tickets, 3)
    println()
}

class Problem1 {
    fun timeRequiredToBuy(tickets: IntArray?, k: Int): Int {
        var total = 0
        while (tickets!![k] != 0) {
            for (index in tickets.indices) {
                if (tickets[index] != 0) {
                    total += 1
                    tickets[index] = tickets[index] - 1
                    if (index == k && tickets[index] == 0) return total
                }
            }
        }

        return total
    }
}
