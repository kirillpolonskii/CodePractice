package shortest_paths.compl_1100

fun main(){
    val t = readln().toInt()
    repeat(t){
        var (n, k, a, b) = readln().split(" ").map { it.toInt() }
        --a
        --b
        val pointsX = mutableListOf<Long>()
        val pointsY = mutableListOf<Long>()
        repeat(n){
            val (x, y) = readln().split(" ").map { it.toLong() }
            pointsX.add(x)
            pointsY.add(y)
        }
        val ans = kotlin.math.abs(pointsX[a] - pointsX[b]) + kotlin.math.abs(pointsY[a] - pointsY[b])
        var minCostAS = Long.MAX_VALUE / 2
        var minCostTB = Long.MAX_VALUE / 2
        for (i in 0..<k){
            minCostAS = kotlin.math.min(minCostAS,
                kotlin.math.abs(pointsX[a] - pointsX[i]) + kotlin.math.abs(pointsY[a] - pointsY[i]))
            minCostTB = kotlin.math.min(minCostTB,
                kotlin.math.abs(pointsX[i] - pointsX[b]) + kotlin.math.abs(pointsY[i] - pointsY[b]))
        }
        println(kotlin.math.min(ans, minCostAS + minCostTB))
    }
}