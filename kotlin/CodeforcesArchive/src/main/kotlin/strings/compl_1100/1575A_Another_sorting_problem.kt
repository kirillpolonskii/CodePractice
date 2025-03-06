package strings.compl_1100

fun main(){
    val (n, m) = readln().split(" ").map { it.toInt() }
    val shelf = mutableListOf<Pair<String, Int>>()
    for (t in 1..n) {
        val s = StringBuilder(readln())
        for (i in 0..<m){
            if (i % 2 == 1){
                //println("" + 'Z'.code + " " + s[i].code)
                s[i] = ('A'.code + 'Z'.code - s[i].code).toChar()
            }
        }
        //println(s)
        shelf.add(s.toString() to t)
    }
    shelf.sortWith {pair1, pair2 ->
        if (pair1.first > pair2.first) 1
        else if (pair1.first < pair2.first) -1
        else 0
    }
    shelf.forEach { print("" + it.second + " ") }
}