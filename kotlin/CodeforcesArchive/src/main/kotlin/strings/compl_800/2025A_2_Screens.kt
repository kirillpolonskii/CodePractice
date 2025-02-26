package strings.compl_800

fun main(){
    val q = readln().toInt()
    repeat(q){
        val s = readln()
        val t = readln()
        var ans = 0; var maxPrefLength = 0
        while(maxPrefLength < kotlin.math.min(s.length, t.length) && s[maxPrefLength] == t[maxPrefLength]){
            ++maxPrefLength
        }
        ans = maxPrefLength +
                (if(maxPrefLength > 0) 1 else 0) +
                (s.length - maxPrefLength) + (t.length - maxPrefLength)
        println(ans)
    }
}