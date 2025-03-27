package dp.compl_1000

fun main(){
    val t = readln().toInt()
    repeat(t){
        val n = readln().toInt()
        val a = readln().split(" ").map { it.toLong() }.toMutableList()
        var minPosElInd = a.indexOfFirst { it > 0 }
        while (minPosElInd < n - 2 && minPosElInd >= 0){
            a[minPosElInd + 1] -= 2 * a[minPosElInd]
            a[minPosElInd + 2] -= a[minPosElInd]
            a[minPosElInd] = 0
            while (minPosElInd < n - 1 && a[minPosElInd] <= 0L){
                ++minPosElInd
            }
        }
        println(if (a.count { it == 0L } == n) "YES" else "NO")
    }
}