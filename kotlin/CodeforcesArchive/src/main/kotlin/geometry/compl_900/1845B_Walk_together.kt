package geometry.compl_900

fun manhDist(xA: Long, yA: Long, xB: Long, yB: Long): Long{
    return kotlin.math.abs(xA - xB) + kotlin.math.abs(yA - yB)
}

fun main(){
    val t = readln().toInt()
    repeat(t){
        val (xA, yA) = readln().split(" ").map { it.toLong() }
        val (xB, yB) = readln().split(" ").map { it.toLong() }
        val (xC, yC) = readln().split(" ").map { it.toLong() }
        println((manhDist(xA, yA, xB, yB) + manhDist(xA, yA, xC, yC) - manhDist(xB, yB, xC, yC)) / 2 + 1)
    }
}