package ternary_search.compl_1100

fun main(){
    val t = readln().toInt()
    repeat(t){
        val (n, d) = readln().split(" ").map { it.toLong() }
        var x = 0
        var possible = false
        while (x <= kotlin.math.sqrt(d.toFloat())){
            if (x + ((d + x) / (x + 1)) <= n){
                possible = true
                break
            }
            ++x
        }
        println(if (possible) "YES" else "NO")
    }
}