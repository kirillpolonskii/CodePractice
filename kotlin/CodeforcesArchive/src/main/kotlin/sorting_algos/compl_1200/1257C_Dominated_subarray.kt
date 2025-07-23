package sorting_algos.compl_1200

fun main(){
    val T = readln().toInt()

    repeat(T){
        val n = readln().toInt()
        val a = readln().split(" ").map{ it.toInt() - 1 }
        val numOfOccurs = IntArray(n)
        a.forEach { ++numOfOccurs[it] }
        val minLengthIntervalsL = IntArray(n) { i -> -1}
        var minLength = n + 1
        for (i in a.indices){
            if (minLengthIntervalsL[a[i]] != -1){
                minLength = kotlin.math.min(minLength, i - minLengthIntervalsL[a[i]] + 1)
            }
            minLengthIntervalsL[a[i]] = i
        }
        println(if (minLength > n) -1 else minLength)


    }
}