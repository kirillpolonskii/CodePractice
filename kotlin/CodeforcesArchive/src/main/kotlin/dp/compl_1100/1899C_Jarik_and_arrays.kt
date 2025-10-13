package dp.compl_1100

fun main(){
    val T = readln().toInt()
    repeat(T){
        val n = readln().toInt()
        val a = readln().split(" ").map { it.toInt() }
        var maxSum = a[0]
        var curMinPrefSum = kotlin.math.min(0, a[0])
        var curSum = maxSum
        for (i in 1..<n){
            if (kotlin.math.abs(a[i] % 2) == kotlin.math.abs(a[i - 1] % 2)){
                curSum = 0
                curMinPrefSum = 0
            }
            curSum += a[i]
            maxSum = kotlin.math.max(maxSum, curSum - curMinPrefSum)
            curMinPrefSum = kotlin.math.min(curMinPrefSum, curSum)
        }
        println(maxSum)
    }
}