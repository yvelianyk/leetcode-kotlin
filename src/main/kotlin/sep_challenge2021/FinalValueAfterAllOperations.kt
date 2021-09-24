package sep_challenge2021

fun finalValueAfterOperations(operations: Array<String>): Int {
    var res = 0
    for (operation in operations) {
        when {
            operation.contains("++") -> res++
            operation.contains("--") -> res--
        }
    }
    return res
}