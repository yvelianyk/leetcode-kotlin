package oct_challenge2022

import java.util.*

class Solution {

    fun intToRoman(num: Int): String {
        val map = TreeMap<Int, String>()
        var resNum = num
        map[1] = "I"
        map[5] = "V"
        map[10] = "X"
        map[50] = "L"
        map[100] = "C"
        map[500] = "D"
        map[1000] = "M"
        map[4] = "IV"
        map[9] = "IX"
        map[40] = "XL"
        map[90] = "XC"
        map[400] = "CD"
        map[900] = "CM"
        val result = StringBuilder()
        while (resNum != 0) {
            val (key, value) = map.floorEntry(resNum)
            result.append(value)
            resNum -= key
        }
        return result.toString()
    }

}