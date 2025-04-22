package dp.compl_1200

fun main(){
    val t = readln().toInt()
    repeat(t){
        val (n, l, r) = readln().split(" ").map { it.toLong() }
        val a = readln().split(" ").map { it.toLong() }
        var curTop = 0
        var curEnd = 0
        var curSum = 0L
        var roundsAmount = 0
        while (curTop < n){
            while (curEnd < n && curSum < l){
                curSum += a[curEnd]
                ++curEnd
            }
            if (curSum in l..r){
                ++roundsAmount
                curTop = curEnd
                curSum = 0L
            }
            else {
                curSum -= a[curTop]
                ++curTop
            }
        }
        println(roundsAmount)
    }
}