package geometry.compl_1100


fun main(){
    var T = readln().toInt()
    while (T > 0){
        val (n, C) = readln().split(" ").map {it.toLong()}
        val s = readln().split(" ").map {it.toLong()}
        val a = java.math.BigInteger.valueOf(4L * n)
        val b = java.math.BigInteger.valueOf(4L * s.sum())
        var sumOfSqr = 0L
        s.forEach { sumOfSqr += it * it }
        val c = java.math.BigInteger.valueOf(sumOfSqr - C)
        val discr = b * b - java.math.BigInteger.valueOf(4) * a * c
        if (discr == java.math.BigInteger.valueOf(0)){
            println(-b / (java.math.BigInteger.valueOf(2) * a))

        }
        else {
            val w1 = (-b - discr.sqrt()) / (java.math.BigInteger.valueOf(2) * a)
            val w2 = (-b + discr.sqrt()) / (java.math.BigInteger.valueOf(2) * a)
            println(kotlin.math.max(w1.toLong(), w2.toLong()))
        }

        --T
    }
}