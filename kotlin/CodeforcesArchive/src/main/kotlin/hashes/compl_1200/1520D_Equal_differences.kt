package hashes.compl_1200

fun main(){
    val t = readln().toInt()
    repeat(t){
        val n = readln().toInt()
        val curEqualPairsCount = mutableMapOf<Int, Int>()
        var answer = 0L
        val a = readln().split(" ").map { it.toInt() }
        a.forEachIndexed { index, el ->
            val curB = el - index
            answer += curEqualPairsCount[curB] ?: 0
            if (curEqualPairsCount[curB] != null)
                curEqualPairsCount[curB] = curEqualPairsCount.getOrDefault(curB, 0) + 1
            else
                curEqualPairsCount[curB] = 1
        }
        println(answer)
    }
}