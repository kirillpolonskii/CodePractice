package graphs.compl_1300

import kotlin.math.min

fun main(){
    val T = readln().toInt()

    repeat(T){
        val (n, m) = readln().split(" ").map{it.toInt()}
        val a = readln().split(" ").map{it.toInt()}.toMutableList()
        val vertDegree = IntArray(n)
        val friendVerts = mutableListOf<Pair<Int, Int>>()
        repeat(m){
            val (a, b) = readln().split(" ").map{it.toInt()}
            ++vertDegree[a - 1]
            ++vertDegree[b - 1]
            friendVerts.add(a to b)
        }
        var minGloom = Int.MAX_VALUE
        if (m % 2 == 0) minGloom = 0
        vertDegree.forEachIndexed { index, deg ->
            if (deg % 2 == 1) minGloom = min(minGloom, a[index])
        }
        friendVerts.forEachIndexed { index, edge ->
            if (vertDegree[edge.first - 1] % 2 == 0 && vertDegree[edge.second - 1] % 2 == 0)
                minGloom = min(minGloom, a[edge.first - 1] + a[edge.second - 1])
        }
        println(minGloom)
    }
}