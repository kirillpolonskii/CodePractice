package greedy.compl_1000

fun main(){
    val t = readln().toInt()
    repeat(t){
        val s = readln()
        var found = false
        for (i in 0..<s.length-1){
            if (s[i] == s[i + 1]){
                print(s[i])
                print(s[i + 1])
                found = true
                break
            }
        }
        if (!found){
            for (i in 0..<s.length-2){
                if (s[i] != s[i + 1] && s[i + 1] != s[i + 2] && s[i] != s[i + 2]){
                    print(s[i])
                    print(s[i + 1])
                    print(s[i + 2])
                    found = true
                    break
                }
            }
        }
        if(!found)
            print(-1)
        println()
    }
}