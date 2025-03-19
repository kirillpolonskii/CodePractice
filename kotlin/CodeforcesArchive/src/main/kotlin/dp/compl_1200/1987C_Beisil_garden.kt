package dp.compl_1200

fun main(){
    val T = readln().toInt()
    repeat(T){
        val n = readln().toInt()
        val h = readln().split(" ").map { it.toLong() }
        val t = LongArray(n)
        t[n - 1] = h[n - 1]
        for (i in n-1 downTo 1){
            t[i - 1] = kotlin.math.max(h[i - 1], t[i] + 1)
        }
        println(t[0])

    }
}