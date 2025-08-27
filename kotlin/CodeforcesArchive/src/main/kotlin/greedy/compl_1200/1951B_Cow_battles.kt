package greedy.compl_1200


fun main(){
    val T = readln().toInt()
    repeat(T){
        val (n, K) = readln().split(" ").map { it.toInt() }
        val a = readln().split(" ").map { it.toLong() }.toMutableList()
        val k = K - 1
        var firstStrongerThanK = 0
        while (firstStrongerThanK < a.size){
            if (a[k] >= a[firstStrongerThanK]) ++firstStrongerThanK
            else break
        }
        if (firstStrongerThanK == a.size) println(a.size - 1)
        else {
            if (k < firstStrongerThanK) println(firstStrongerThanK - 1)
            else {
                a[k] = a[firstStrongerThanK].also { a[firstStrongerThanK] = a[k] }
                var winsAfterSwap = if (firstStrongerThanK == 0) 0 else 1
                while (winsAfterSwap + (if (firstStrongerThanK == 0) 1 else 0) + firstStrongerThanK < a.size){
                    if (a[firstStrongerThanK + winsAfterSwap + (if (firstStrongerThanK == 0) 1 else 0)] < a[firstStrongerThanK]){
                        ++winsAfterSwap
                    }
                    else {
                        break
                    }
                }
                println(kotlin.math.max(firstStrongerThanK - 1, winsAfterSwap))
            }
        }
    }
}