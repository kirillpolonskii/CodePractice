package data_structs.compl_1000

fun main(){
    val t = readln().toInt()
    repeat(t){
        var s = readln()
        s = s.reversed()
        val resultingStr = StringBuilder("")
        var curAmountb = 0
        var curAmountB = 0
        s.forEachIndexed { ind, ch ->
            if (ch == 'b'){
                ++curAmountb
            }
            else if (ch == 'B'){
                ++curAmountB
            }
            else if (ch.isLowerCase()){
                if (curAmountb > 0){
                    --curAmountb
                }
                else {
                    resultingStr.append(ch)
                }
            }
            else {
                if (curAmountB > 0){
                    --curAmountB
                }
                else {
                    resultingStr.append(ch)
                }
            }
        }

        println(resultingStr.reversed().toString())
    }
}