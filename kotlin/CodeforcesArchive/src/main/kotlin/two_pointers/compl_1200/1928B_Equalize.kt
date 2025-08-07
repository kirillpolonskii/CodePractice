package two_pointers.compl_1200

fun main(){
    var T = readln().toInt()
    while (T > 0){
        val n = readln().toInt()
        val a = readln().split(" ").map{ it.toLong() }.sorted().toMutableList()
        var deleted = 0
        while (deleted < a.size - 1){
            if (a[deleted] == a[deleted + 1]){
                a.removeAt(deleted)
            }
            else
                ++deleted
        }
        var r = 0
        var subArrLength = 0
        for (i in 0..<a.size){
            while (r < a.size && a[r] - a[i] < n){
                ++r
            }
            subArrLength = kotlin.math.max(subArrLength, r - i)

        }
        println(subArrLength)
        --T
    }
}