package strings.compl_1100

fun main(){
    var T = readln().toInt()
    while (T > 0){
        val p = readln()
        val s = readln()
        if (p[0] != s[0]){
            println("NO")
            --T
            continue
        }
        var pSoundStart = 0
        var pSoundEnd = 0
        var sSoundStart = 0
        var sSoundEnd = 0
        var isSoundsValid = true
        while (pSoundStart < p.length && sSoundStart < s.length){
            while(pSoundEnd < p.length && p[pSoundEnd] == p[pSoundStart]) ++pSoundEnd
            while(sSoundEnd < s.length && s[sSoundEnd] == s[sSoundStart]) ++sSoundEnd
            if ((pSoundEnd - pSoundStart) * 2 < sSoundEnd - sSoundStart ||
                pSoundEnd - pSoundStart > sSoundEnd - sSoundStart){
                isSoundsValid = false
                break
            }
            pSoundStart = pSoundEnd
            sSoundStart = sSoundEnd
            if (pSoundStart >= p.length && sSoundStart < s.length){
                isSoundsValid = false
                break
            }
            if (sSoundStart >= s.length && pSoundStart < p.length){
                isSoundsValid = false
                break
            }
        }
        println(if (isSoundsValid) "YES" else "NO")
        --T
    }
}