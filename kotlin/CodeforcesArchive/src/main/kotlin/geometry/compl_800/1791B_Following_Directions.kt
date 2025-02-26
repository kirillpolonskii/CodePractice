package geometry.compl_800

import readInt

fun main(){
    repeat(readInt()){
        val n = readInt()
        val s = readln()
        var vecX = 0
        var vecY = 0
        var isCandyReachable = false
        for (com in s) {
            when (com){
                'U' -> vecY += 1
                'D' -> vecY -= 1
                'L' -> vecX -= 1
                'R' -> vecX += 1
            }
            if (vecX == 1 && vecY == 1) {
                isCandyReachable = true
                break
            }
        }
        println(if (isCandyReachable) "YES" else "NO")
    }
}