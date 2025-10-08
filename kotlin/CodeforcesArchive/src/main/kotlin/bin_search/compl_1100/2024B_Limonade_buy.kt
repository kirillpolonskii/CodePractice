package bin_search.compl_1100

fun main(){
    val T = readln().toInt()
    val fib = listOf(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89)
    repeat(T){
        val (n, k) = readln().split(" ").map { it.toInt() }
        val a = readln().split(" ").map { it.toLong() }.toMutableList()
        val fullCircles = kotlin.math.ceil(k.toDouble() / n).toInt()
        a.sort()
        var additionalTaps = 0
        a.forEach { el ->
            if (el < fullCircles) ++additionalTaps
        }
        println(k + additionalTaps)
    }
}