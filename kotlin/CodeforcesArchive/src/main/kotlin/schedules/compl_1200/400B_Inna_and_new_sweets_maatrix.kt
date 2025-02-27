package schedules.compl_1200

fun main(){
    val (n, m) = readln().split(" ").map{ it.toInt() }
    val rows = mutableListOf<String>()
    repeat(n){
        rows.add(readln())
    }
    val gnomesPositions = mutableSetOf<Int>()
    var possible = true
    for (i in 0..<n){
        if (rows[i].matches("""\**S\**G\**""".toRegex())){
            possible = false
            break
        }
        else {
            gnomesPositions.add(rows[i].indexOf('S') - rows[i].indexOf('G'))
        }
    }
    println(if (possible) gnomesPositions.size else -1)
}