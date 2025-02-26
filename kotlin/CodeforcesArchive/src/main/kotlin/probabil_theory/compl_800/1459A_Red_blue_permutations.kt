package probabil_theory.compl_800

fun main(){
    val t = readln().toInt()
    repeat(t){
        val n = readln().toInt()
        val r = readln()
        val b = readln()
        var redFav = 0
        var blueFav = 0
        (0..<n).forEach {
            if (r[it].digitToInt() > b[it].digitToInt())
                ++redFav
            else if (r[it].digitToInt() < b[it].digitToInt())
                ++blueFav

        }
        if (redFav > blueFav)
            println("RED")
        else if (redFav < blueFav)
            println("BLUE")
        else
            println("EQUAL")
    }
}