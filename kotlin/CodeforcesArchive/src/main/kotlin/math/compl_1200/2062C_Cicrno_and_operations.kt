package math.compl_1200

fun main(){
    val T = readln().toInt()

    repeat(T){
        val n = readln().toInt()
        val a = readln().split(" ").map { it.toLong() }.toMutableList()
        a.add(0, 0)
        var maxSum = Long.MIN_VALUE
        var curSize = n
        for (i in 1..n){
            //println("a=${a.joinToString()}")
            var curSum = 0L
            (1..curSize).forEach { curSum += a[it] }
            //println("curSum=$curSum")
            if (i == 1)
                maxSum = kotlin.math.max(maxSum, curSum)
            else
                maxSum = kotlin.math.max(maxSum, kotlin.math.max(curSum, -curSum))
            //println("maxSum=$maxSum")
            (1..<curSize).forEach { a[it] = a[it + 1] - a[it] }
            --curSize
        }
        println(maxSum)
    }
}