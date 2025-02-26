package dp.compl_800

fun readIntList(delim: String) = readln().split(delim).map{it.toInt()}

fun main(){
    val t = readln().toInt()
    repeat(t){
        val n = readln().toInt()
        val p = readIntList(" ")
        /*p.forEach{print(" " + it)}
        println()*/
        if (n < 2){
            println(0)
        }
        else {
            val dp = mutableListOf<Int>()
            dp.add(0)
            dp.add(if (p[0] > p[1]) 1 else 0)
            for (i in 2..<n){
                dp.add(kotlin.math.max(dp[i - 1], dp[i - 2] + if (p[i - 1] > p[i]) 1 else 0))
            }
            /*dp.forEach{print(" " + it)}
            println()*/
            println(dp[n - 1])
        }

    }
}