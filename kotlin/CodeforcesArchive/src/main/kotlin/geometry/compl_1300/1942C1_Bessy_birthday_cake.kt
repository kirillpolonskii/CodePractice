package geometry.compl_1300

fun main(){
    val T = readln().toInt()

    repeat(T){
        var (n, x, y) = readln().split(" ").map{ it.toLong() }
        var initY = y
        val chosenVerts = readln().split(" ").map{ it.toLong() }.sorted()
        var maxTriangles = x - 2
        var trianglesFromEvenGood = 0
        val oddGood = mutableListOf<Int>()
        val processGap: (Int) -> Unit = { g: Int ->
            if (g <= 1){
                maxTriangles += g
            }
            else if (g % 2 == 1) {
                oddGood.add(g / 2)
            }
            else {
                trianglesFromEvenGood += g / 2
            }
        }
        for (i in 0..x-2){
            processGap((chosenVerts[(i + 1).toInt()] - chosenVerts[i.toInt()] - 1).toInt())
        }
        processGap(((chosenVerts[0] + n) - chosenVerts[(x - 1).toInt()] - 1).toInt())
        oddGood.sort()
        oddGood.forEach {
            if (y >= it){
                maxTriangles += it + 1
                y -= it
            }
            else {
                maxTriangles += y
                y = 0
            }
        }
        var evenTriangles = kotlin.math.min(trianglesFromEvenGood, y.toInt())
        y -= evenTriangles
        maxTriangles += evenTriangles
        var usedVerts = initY - y
        maxTriangles += usedVerts
        println(maxTriangles)

    }
}