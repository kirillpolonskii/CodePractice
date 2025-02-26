package data_structs.compl_800

fun main(){
    val t = readln().toInt()
    repeat(t){
        val n = readln().toInt()
        val fullList = readln().split(" ").map { it.toLong() }
        var tower1 = fullList[0]
        val remainList = fullList.subList(1, fullList.size).toMutableList()
        remainList.sort()
        for (tower in remainList){
            if (tower > tower1){
                tower1 += kotlin.math.ceil((tower - tower1) / 2.0).toLong()
            }
        }
        println(tower1)
    }
}