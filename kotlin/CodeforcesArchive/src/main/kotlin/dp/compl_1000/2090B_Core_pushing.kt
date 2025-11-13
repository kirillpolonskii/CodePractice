package dp.compl_1000

fun main(){
    val t = readln().toInt()
    repeat(t){
        val (n, m) = readln().split(" ").map { it.toInt() }
        val rows = mutableListOf<String>()
        val columns = Array<StringBuilder>(m) { i -> StringBuilder() }
        repeat(n){
            rows.add(readln())
            rows.last().forEachIndexed { index, ch ->
                columns[index].append(ch)
            }
        }
        var isValid = true
        var curI = n - 1
        var curJ = m - 1
        while (curI >= 0){
            while (curJ >= 0){
                if (rows[curI][curJ] == '1'){
                    if (rows[curI].substring(0..<curJ).contains('0') &&
                        columns[curJ].substring(0..<curI).contains('0')){
                        isValid = false
                    }
                }
                --curJ
                if (!isValid) break
            }
            if (!isValid) break
            curJ = m - 1
            --curI
        }

        println(if (isValid) "YES" else "NO")
    }
}