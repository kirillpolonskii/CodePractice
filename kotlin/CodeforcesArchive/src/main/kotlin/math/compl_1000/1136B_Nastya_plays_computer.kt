package math.compl_1000

fun main(){
    val (n, k) = readln().split(" ").map { it.toInt() }
    print(
        kotlin.math.min(n - k, k - 1)
        + 6
        + (n - 2) * 3
    )

}