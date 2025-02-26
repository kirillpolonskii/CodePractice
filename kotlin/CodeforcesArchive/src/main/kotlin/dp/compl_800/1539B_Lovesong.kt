package dp.compl_800
import java.util.Scanner

fun main() {
    val input = Scanner(System.`in`)
    val (n, q) = readln().split(" ").map{it.toInt()}
    val prefSum = mutableListOf<Int>()
    prefSum.add(0)
    val charSeq = readln()
    for (i in 1..n) {
        // val char = System.`in`.read()
        // val char = input.next().single().code

        //val chOrderNum = char - 96
        prefSum.add(prefSum[i - 1] + charSeq[i - 1].code - 96)
    }
    //prefSum.forEach{print(" " + it)}
    repeat(q){
        val (l, r) = readln().split(" ").map{it.toInt()}
        println(prefSum[r] - prefSum[l - 1])
    }
}