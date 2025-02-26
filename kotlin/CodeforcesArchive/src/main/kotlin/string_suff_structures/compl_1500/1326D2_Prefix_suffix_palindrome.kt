package string_suff_structures.compl_1500

fun longestPrefOrSufPalindrome(middle: String): String {
    var joinedMiddle = middle + "#" + middle.reversed()
    val prefSum = IntArray(joinedMiddle.length)
    var c = 0
    for (i in 1..<joinedMiddle.length){
        while (c != 0 && joinedMiddle[c] != joinedMiddle[i]){
            c = prefSum[c - 1]
        }
        if (joinedMiddle[c] == joinedMiddle[i]) ++c
        prefSum[i] = c
    }
    return middle.substring(0, c)
}

fun main(){
    val t = readln().toInt()
    repeat(t){
        var s = readln()
        var commonPrefSufEnd = 0
        while (commonPrefSufEnd < s.length - 1 - commonPrefSufEnd){
            if (s[commonPrefSufEnd] != s[s.length - 1 - commonPrefSufEnd])
                break
            ++commonPrefSufEnd
        }
        if (commonPrefSufEnd > 0) print(s.substring(0, commonPrefSufEnd))
        if (s.length > 2 * commonPrefSufEnd){
            var middlePart = s.substring(commonPrefSufEnd, s.length - commonPrefSufEnd)
            var a = longestPrefOrSufPalindrome(middlePart)
            var b = longestPrefOrSufPalindrome(middlePart.reversed())
            print(if (a.length > b.length) a else b)
        }
        if (commonPrefSufEnd > 0) print(s.substring(s.length - commonPrefSufEnd, s.length))
        println()
    }
}