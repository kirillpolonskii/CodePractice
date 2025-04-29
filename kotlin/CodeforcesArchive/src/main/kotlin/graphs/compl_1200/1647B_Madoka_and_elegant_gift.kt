package graphs.compl_1200

fun main(){
    val T = readln().toInt()
    repeat(T){
        val (n, m) = readln().split(" ").map { it.toInt() }
        val matr = mutableListOf<String>()
        (1..n).forEach {
            matr.add(readln())
        }
        var isElegant = true
        if (n != 1 && m != 1) {
            for (i in 0..<n - 1){
                for (j in 0..<m - 1){
                    if ((matr[i][j] == '1' && matr[i][j+1] == '0' && matr[i+1][j] == '1' && matr[i+1][j+1] == '1') ||
                        (matr[i][j] == '1' && matr[i][j+1] == '1' && matr[i+1][j] == '1' && matr[i+1][j+1] == '0') ||
                        (matr[i][j] == '1' && matr[i][j+1] == '1' && matr[i+1][j] == '0' && matr[i+1][j+1] == '1') ||
                        (matr[i][j] == '0' && matr[i][j+1] == '1' && matr[i+1][j] == '1' && matr[i+1][j+1] == '1')){
                        isElegant = false
                        break
                    }
                }
                if (!isElegant) break
            }
        }
        println(if (isElegant) "YES" else "NO")
    }
}