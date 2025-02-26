package bin_search.compl_800

import kotlin.math.min

fun main(){
    val t = readln().toInt()
    repeat(t){
        val inputList = readln().split(" ").map { it.toLong() }
        val n: Long = inputList[0]; val a: Long = inputList[1]; val b: Long = inputList[2]
        val maxProfit: Long = if (b < a) {
            n * a
        }
        else {
            val k = min(b - a + 1, n)
            (b - k + 1) * n + k * (k - 1) / 2
        }
        println(maxProfit)
    }
}