package chinese_remainder_th.compl_800

fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
}

fun lcm(a: Int, b: Int): Int {
    return (a * b) / gcd(a, b)
}

fun main(){
    val t = readln().toInt()
    repeat(t){
        val (a, b) = readln().split(" ").map { it.toInt() }
        var m = lcm(a, b)
        for (i in kotlin.math.min(a, b)..m){
            if (i % a == i % b){
                m = i
                break
            }
        }
        println(m)
    }
}