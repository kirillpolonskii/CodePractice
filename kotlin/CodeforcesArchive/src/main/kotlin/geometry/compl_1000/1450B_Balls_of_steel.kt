package geometry.compl_1000

fun List<Pair<Int, Int>>.mDist(i: Int, j: Int): Int {
    return kotlin.math.abs(this[i].first - this[j].first) +
            kotlin.math.abs(this[i].second - this[j].second)
}

fun main(){
    val t = readln().toInt()
    repeat(t){
        val (n, k) = readln().split(" ").map { it.toInt() }
        val distances = mutableListOf<MutableList<Int>>()
        (0..<n).forEach { innerInd ->
            distances.add(mutableListOf())
            (0..<n).forEach { _ ->
                distances[innerInd].add(0)
            }
        }
        val coords = mutableListOf<Pair<Int, Int>>()
        (0..<n).forEach { _ ->
            val (x, y) = readln().split(" ").map { it.toInt() }
            coords.add(Pair(x, y))
        }
        (0..<n).forEach { i ->
            distances.add(mutableListOf())
            (0..<n).forEach { j ->
                distances[i][j] = coords.mDist(i, j)
            }
        }
        var answer = -1
        var pointsInProximityAmount = 0
        (0..<n).forEach { i ->
            pointsInProximityAmount = 0
            (0..<n).forEach { j ->
                if (distances[i][j] <= k){
                    ++pointsInProximityAmount
                }
            }
            if (pointsInProximityAmount == n){
                answer = 1
                return@forEach
            }
        }
        println(answer)
    }
}