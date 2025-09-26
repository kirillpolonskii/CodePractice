package dp.compl_1100

fun main(){
    val T = readln().toInt()
    val fib = listOf(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89)
    repeat(T){
        val (n, m) = readln().split(" ").map { it.toInt() }
        val ans = IntArray(m)
        for(i in 0..<m){
            val dimensionsDesc = readln().split(" ").map { it.toInt() }.sortedDescending()
            if (fib[n] + fib[n - 1] <= dimensionsDesc[0]
                && fib[n] <= dimensionsDesc[1] && fib[n] <= dimensionsDesc[2])
                ans[i] = 1
        }
        println(ans.joinToString(""))
    }
}