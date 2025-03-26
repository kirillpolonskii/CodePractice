package geometry.compl_1000

fun main(){
    val t = readln().toInt()
    repeat(t){
        val (w, h) = readln().split(" ").map { it.toLong() }
        val dataLower = readln().split(" ").map { it.toLong() }
        val dataUpper = readln().split(" ").map { it.toLong() }
        val dataLeft = readln().split(" ").map { it.toLong() }
        val dataRight = readln().split(" ").map { it.toLong() }
        println(
            kotlin.math.max(
                kotlin.math.max(
                    (dataLower.last() - dataLower[1]) * h, (dataUpper.last() - dataUpper[1]) * h
                ),
                kotlin.math.max(
                    (dataLeft.last() - dataLeft[1]) * w, (dataRight.last() - dataRight[1]) * w
                )
            )
        )
    }
}