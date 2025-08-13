package math.compl_1000

fun main(){
    var T = readln().toInt()
    while (T > 0){
        val n = readln().toInt()
        var l = 1
        var r = n
        (1..n).forEach {
            if (it % 2 == 0){
                print("$l ")
                ++l
            }
            else {
                print("$r ")
                --r
            }

        }
        println()
        --T
    }
}