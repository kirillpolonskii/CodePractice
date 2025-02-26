package geometry.compl_800

fun main(){
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        var cSum = 0UL
        var dMax = 0UL
        repeat(n) {
            val (a, b) = readln().split(" ").map {it.toULong()}
            cSum += kotlin.math.min(a, b)
            if (kotlin.math.max(a, b) > dMax)
                dMax = kotlin.math.max(a, b)
        }
        println(2UL * (cSum + dMax))
    }
}