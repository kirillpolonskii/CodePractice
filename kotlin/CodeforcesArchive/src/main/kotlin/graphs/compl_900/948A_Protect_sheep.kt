package graphs.compl_900

fun main(){
    val (r, c) = readln().split(" ").map { it.toInt() }
    val field: MutableList<MutableList<Char>> = mutableListOf()
    repeat(r){
        val row = mutableListOf<Char>()
        val strRow = readln()
        for(ch in strRow) {
            row.add(ch)
        }
        field.add(row)
    }
    var canProtectSheep = true
    for(i in 0..<r){
        for(j in 0..<c){
            if (field[i][j] == 'W'){
                if (j < c - 1 && field[i][j + 1] == '.')
                    field[i][j + 1] = 'D'
                else if (j < c - 1 && field[i][j + 1] == 'S') {
                    canProtectSheep = false
                    break
                }
                if (j > 0 && field[i][j - 1] == '.')
                    field[i][j - 1] = 'D'
                else if (j > 0 && field[i][j - 1] == 'S') {
                    canProtectSheep = false
                    break
                }
                if (i < r - 1 && field[i + 1][j] == '.')
                    field[i + 1][j] = 'D'
                else if (i < r - 1 && field[i + 1][j] == 'S') {
                    canProtectSheep = false
                    break
                }
                if (i > 0 && field[i - 1][j] == '.')
                    field[i - 1][j] = 'D'
                else if (i > 0 && field[i - 1][j] == 'S') {
                    canProtectSheep = false
                    break
                }
            }
        }
    }
    if(canProtectSheep){
        println("Yes")
        for(i in 0..<r){
            for(j in 0..<c){
                print(field[i][j])
            }
            print("\n")
        }
    } else {
        println("No")
    }

}