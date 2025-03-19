package geometry.compl_1200

fun main(){
    val T = readln().toInt()
    repeat(T){
        val n = readln().toInt()
        val points = mutableListOf<Pair<ULong, ULong>>()
        repeat(n){
            val (curX, curY) = readln().split(" ").map { it.toULong() }
            points.add(curX to curY)
        }
        val (xStart, yStart, xFin, yFin) = readln().split(" ").map { it.toULong() }
        val startFinDist2 = (xStart - xFin) * (xStart - xFin) + (yStart - yFin) * (yStart - yFin)
        val minDist = points
            .map { (it.first - xFin) * (it.first - xFin) + (it.second - yFin) * (it.second - yFin) }
            .min()
        println(if (startFinDist2 >= minDist) "NO" else "YES")
    }
}