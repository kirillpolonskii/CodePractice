package hashes.compl_1200

fun main(){
    var T = readln().toInt()
    while(T > 0){
        val n = readln().toInt()
        val s = readln()
        var deduct = 0
        for (i in 0..s.length-3){
            if (s[i] == s[i + 2]){
                ++deduct
            }
        }
        println(n - 1 - deduct)
        --T
    }
}