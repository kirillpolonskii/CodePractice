package strings.compl_900

fun main(){
    val t = readln().toInt()
    repeat(t){
        val (n, k) = readln().split(" ").map { it.toInt() }
        val s = readln()
        val freqs = mutableListOf<Int>()
        for (i in 0..<26) freqs.add(0)
        for (letter in s){
            ++freqs[letter.code - 97]
        }
        var resultS = ""
        for (i in 0..<kotlin.math.min(25, n / k)){
            while(freqs[i] < k - resultS.length){
                resultS += (i + 97).toChar()
                println(resultS)
            }

        }
        val c = (97 + kotlin.math.min(25, n / k)).toChar()
        while (k > resultS.length){
            resultS += c
            println(resultS)
        }
        println(resultS.reversed())
    }
}