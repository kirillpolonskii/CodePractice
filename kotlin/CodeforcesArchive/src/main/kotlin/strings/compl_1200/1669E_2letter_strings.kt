package strings.compl_1200

fun main(){
    val T = readln().toInt()
    repeat(T){
        val n = readln().toInt()
        val allStringsAmount = mutableListOf<IntArray>()
        repeat(12){
            allStringsAmount.add(IntArray(12))
        }
        var ans = 0L
        for (i in 0..<n){
            val curS = readln()
            for (j in 0..1){
                for (ch in 'a'..'k'){
                    if (curS[j] == ch){
                        continue
                    }

                    val differStrBuilder = StringBuilder(curS)
                    differStrBuilder[j] = ch
                    val differStr = differStrBuilder.toString()
                    //println(differStr)
                    ans += allStringsAmount[differStr[0].code - 'a'.code][differStr[1].code - 'a'.code]
                }
            }
            ++allStringsAmount[curS[0] - 'a'][curS[1] - 'a']
        }
        println(ans)
    }
}