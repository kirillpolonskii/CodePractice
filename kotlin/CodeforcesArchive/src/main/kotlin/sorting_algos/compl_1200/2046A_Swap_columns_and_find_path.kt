package sorting_algos.compl_1200

fun main(){
    val T = readln().toInt()
    repeat(T){
        val n = readln().toInt()
        val a = ArrayList<List<Int>>(2)
        a.add(readln().split(" ").map { it.toInt() })
        a.add(readln().split(" ").map { it.toInt() })
        val bestCells = LongArray(n) { kotlin.math.max(a[0][it], a[1][it]).toLong() }
        val fullSumCells = LongArray(n) { (a[0][it] + a[1][it]).toLong() }
        val bestSum: Long = bestCells.sum()
        var ans: Long = Long.MIN_VALUE
        (0..<n).forEach {
            ans = kotlin.math.max(ans, bestSum - bestCells[it] + fullSumCells[it])
        }
        println(ans)
    }
}