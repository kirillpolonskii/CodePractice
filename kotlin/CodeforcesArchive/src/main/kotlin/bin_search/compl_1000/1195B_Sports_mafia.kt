package bin_search.compl_1000

fun main(){
    val (n, k) = readln().split(" ").map {it.toLong()}
    println(n - 1 - ((-5 + kotlin.math.sqrt(25.0 - 16 + 8 * k + 8 * n)) / 2).toInt())
}