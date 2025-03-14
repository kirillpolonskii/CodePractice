package matrices.compl_1200

fun main(){
    val t = readln().toInt()
    repeat(t){
        val (n, m) = readln().split(" ").map { it.toInt() }
        val matr = mutableListOf<MutableList<Int>>()
        repeat(n){
            val row = readln().split(" ").map { it.toInt() }.toMutableList()
            matr.add(row)
        }
        val matrHasColor = IntArray(n * m)
        val matrHasColorNeighbour = IntArray(n * m)
        for (i in 0..<n){
            for (j in 0..<m){
                matrHasColor[matr[i][j] - 1] = 1
                // check the neighbours
                if (i + 1 < n && matr[i][j] == matr[i + 1][j]){
                    matrHasColorNeighbour[matr[i][j] - 1] = 1
                }
                if (j + 1 < m && matr[i][j] == matr[i][j + 1]){
                    matrHasColorNeighbour[matr[i][j] - 1] = 1
                }
            }
        }
        println(matrHasColor.sum() + matrHasColorNeighbour.sum() - 1 - matrHasColorNeighbour.max())
    }
}