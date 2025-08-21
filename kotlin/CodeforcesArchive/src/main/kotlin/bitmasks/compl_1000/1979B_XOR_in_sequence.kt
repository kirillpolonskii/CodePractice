package bitmasks.compl_1000

fun main(){
    var T = readln().toInt()
    while (T > 0){
        val (x, y) = readln().split(" ").map{ it.toLong() }
        for (i in 0..29){
            if (x and (1L shl i) != y and (1L shl i)){
                println(1L shl i)
                break
            }
        }

        --T
    }
}