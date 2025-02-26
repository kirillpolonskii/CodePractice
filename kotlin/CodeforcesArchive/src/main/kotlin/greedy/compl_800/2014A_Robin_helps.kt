package greedy.compl_800

fun main(){
    val t = readln().toInt()
    repeat(t){
        val (n, k) = readln().split(" ").map{it.toInt()}
        val people = readln().split(" ").map{it.toInt()}
        var curBalance = 0
        var helpedPeople = 0
        for (a in people){
            if (a >= k){
                curBalance += a
            }
            else if (a == 0 && curBalance > 0){
                ++helpedPeople
                --curBalance
            }
        }
        println(helpedPeople)
    }
}