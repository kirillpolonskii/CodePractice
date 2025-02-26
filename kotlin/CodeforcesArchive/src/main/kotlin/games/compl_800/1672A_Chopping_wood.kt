package games.compl_800

fun List<Int>.countEvenOdd(): Pair<Int, Int>{
    var evenAmount = 0
    var oddAmount = 0
    this.forEach{
        if (it % 2 == 0){
            ++evenAmount
        }
        else {
            ++oddAmount
        }
    }
    return Pair(evenAmount, oddAmount)
}

fun main(){
    val t = readln().toInt()
    repeat(t){
        val n = readln().toInt()
        val a = readln().split(" ").map { it.toInt() }
        val (evenAmount, oddAmount) = a.countEvenOdd()
        if (evenAmount % 2 == 0){
            println("maomao90")
        }
        else {
            println("errorgorn")
        }
    }
}