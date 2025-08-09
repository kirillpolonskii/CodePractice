package greedy.compl_1100

fun main(){
    var T = readln().toInt()
    while (T > 0){
        val n = readln().toInt()
        val a = readln().split(" ").map{ it.toInt() }.toMutableList()
        var isBeautiful = false
        var isSortedAsc = true
        var isSortedDesc = true
        for (i in 0..a.size - 2){
            if (kotlin.math.abs(a[i] - a[i + 1]) <= 1){
                isBeautiful = true
                break
            }
            if (a[i] < a[i + 1]){
                isSortedDesc = false
            }
            if (a[i] > a[i + 1]){
                isSortedAsc = false
            }
        }
        if (isBeautiful){
            println(0)
        }
        else if (isSortedAsc || isSortedDesc){
            println(-1)
        }
        else {
            println(1)
        }

        --T
    }
}