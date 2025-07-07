package geometry.compl_1300

fun euclidDist2(x1: Long, y1: Long, x2: Long, y2: Long) = (x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2)

fun main(){
    val T = readln().toInt()

    repeat(T){
        val (n, x) = readln().split(" ").map { it.toLong() }
        var curX = 0L
        var curY = 0L
        val finX = x
        val finY = 0L
        val a = readln().split(" ").map { it.toLong() }
        val maxA = a.max()
        var jumps = 0L
        var foundLastPoint = false
        while (!foundLastPoint){
            if (a.contains(
                    kotlin.math.sqrt(euclidDist2(curX, curY, finX, finY).toDouble()).toLong()
            )) {
                //println("into 1st")
                ++jumps
                foundLastPoint = true
            }
            else if (euclidDist2(curX, curY, finX, finY) <= 4 * maxA * maxA){
                //println("into 2nd")
                jumps += 2
                foundLastPoint = true

            }
            else {
                //println("into 3d")
                jumps += (x / maxA - 1)
                curX += maxA * (x / maxA - 1)
            }

        }
        println(jumps)
    }
}