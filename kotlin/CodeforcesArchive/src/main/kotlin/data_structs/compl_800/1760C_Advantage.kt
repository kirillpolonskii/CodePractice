package data_structs.compl_800

fun main(){
    val t = readln().toInt()
    repeat(t){
        val n = readln().toInt()
        val origList = readln().split(" ").map { it.toLong() }
        val sortedList = origList.sorted()
        val strongest = sortedList.last()
        val secondStrongest = sortedList[sortedList.size - 2]
        val strongestInd = origList.indexOf(strongest)
        origList.forEachIndexed { ind, s ->
            if (ind != strongestInd){
                print("" + (s - strongest) + " ")
            }
            else {
                print("" + (s - secondStrongest) + " ")
            }
        }
        println()
    }
}