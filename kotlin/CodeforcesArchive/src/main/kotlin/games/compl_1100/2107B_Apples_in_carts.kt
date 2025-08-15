package games.compl_1100

fun main(){
    var T = readln().toInt()
    while (T > 0){
        val (n, k) = readln().split(" ").map {it.toLong()}
        val a = readln().split(" ").map {it.toLong()}
        var maxA = 0L
        var minA = Long.MAX_VALUE
        var applesSum = 0L
        a.forEachIndexed { index, el ->
            applesSum += el
            if (el > maxA){
                maxA = el
            }
            if (el < minA){
                minA = el
            }
        }
        val maxCount = a.count { it == maxA }
        if (maxA - minA > k){
            if (maxCount > 1){
                println("Jerry")
            }
            else {
                if (maxA - minA - 1 <= k){
                    println(if (applesSum % 2L == 1L) "Tom" else "Jerry")
                }
                else {
                    println("Jerry")
                }
            }
        }
        else {
            println(if (applesSum % 2L == 1L) "Tom" else "Jerry")
        }
        --T
    }
}