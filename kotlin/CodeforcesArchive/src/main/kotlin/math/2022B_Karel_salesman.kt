package math

fun main(){
    val T = readln().toInt()

    repeat(T){
        val (n, x) = readln().split(" ").map{it.toLong()}
        val a = readln().split(" ").map{it.toLong()}
        val maxOfA = a.max()
        val averDistribCeiled = (a.sum() + x - 1) / x
        println(kotlin.math.max(maxOfA, averDistribCeiled))
    }
}