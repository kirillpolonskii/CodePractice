package dp.compl_900

fun checkExistence(digitOnCheckAmount: Int, lesserAmount: Int, biggerAmount: Int): Int {
    //val difference = biggerAmount - lesserAmount
    var newLesserAmount = 1
    var newBiggerAmount = biggerAmount - (lesserAmount - 1)
    if ((newLesserAmount + newBiggerAmount) % 2 == 0 &&
        (newLesserAmount + newBiggerAmount) / 2 - 1 <= digitOnCheckAmount + (biggerAmount - (lesserAmount - 1))){
        return 1
    }
    else {
        return 0
    }
}

fun main(){
    val t = readln().toInt()
    repeat(t){
        val (startAmount1, startAmount2, startAmount3) = readln().split(" ").map { it.toInt() }
        println("" +
                checkExistence(startAmount1, kotlin.math.min(startAmount2, startAmount3), kotlin.math.max(startAmount2, startAmount3))
                + " " +
                checkExistence(startAmount2, kotlin.math.min(startAmount1, startAmount3), kotlin.math.max(startAmount1, startAmount3))
                + " " +
                checkExistence(startAmount3, kotlin.math.min(startAmount2, startAmount1), kotlin.math.max(startAmount2, startAmount1))
        )
    }
}