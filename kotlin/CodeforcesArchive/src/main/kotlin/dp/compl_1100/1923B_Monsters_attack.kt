package dp.compl_1100

fun main(){
    val T = readln().toInt()
    repeat(T){
        val (nLong, k) = readln().split(" ").map { it.toLong() }
        val n = nLong.toInt()
        val a = readln().split(" ").map { it.toLong() }
        val x = readln().split(" ").map { it.toInt() }
        val sumHealth = LongArray(n + 1)
        var curRemainingBullets = 0L
        var isAlive = true
        for (i in 0..<n){
            sumHealth[kotlin.math.abs(x[i])] += a[i]
        }
        for (i in 1..n){
            curRemainingBullets += k - sumHealth[i]
            isAlive = isAlive && (curRemainingBullets >= 0)
        }
        println(if (isAlive) "YES" else "NO")
    }
}