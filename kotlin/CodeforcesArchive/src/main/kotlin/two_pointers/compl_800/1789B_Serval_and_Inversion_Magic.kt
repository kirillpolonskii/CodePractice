package two_pointers.compl_800

fun main(){
    val t = readln().toInt()
    repeat(t){
        val n = readln().toInt()
        val s = readln()
        var metIllegal = false
        var metLegAftIlleg = false
        var canInverse = true
        for (i in 0..<n/2){
            if (s[i] != s[n - 1 - i]){
                metIllegal = true
                if (metLegAftIlleg){
                    canInverse = false
                    break
                }
            }
            else {
                if (metIllegal){
                    metLegAftIlleg = true
                }
            }
        }
        println(if (canInverse) "Yes" else "No")
    }
}