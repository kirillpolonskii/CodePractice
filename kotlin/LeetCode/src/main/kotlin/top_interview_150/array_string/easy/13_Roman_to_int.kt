package top_interview_150.array_string.easy

private class Solution88 {
    fun romanToInt(s: String): Int {
        var ans = 0
        var i = 0
        while (i < s.length){
            //println(ans)
            when (s[i]){
                'M' -> {
                    ans += 1000
                    ++i
                }
                'D' -> {
                    ans += 500
                    ++i
                }
                'C' -> {
                    if (i < s.length - 1){
                        if (s[i + 1] == 'D'){
                            ans += 400
                            i += 2
                        }
                        else if (s[i + 1] == 'M'){
                            ans += 900
                            i += 2
                        }
                        else {
                            ans += 100
                            ++i
                        }
                    }
                    else {
                        ans += 100
                        ++i
                    }
                }
                'L' -> {
                    ans += 50
                    ++i
                }
                'X' -> {
                    if (i < s.length - 1){
                        if (s[i + 1] == 'L'){
                            ans += 40
                            i += 2
                        }
                        else if (s[i + 1] == 'C'){
                            ans += 90
                            i += 2
                        }
                        else {
                            ans += 10
                            ++i
                        }
                    }
                    else {
                        ans += 10
                        ++i
                    }
                }
                'V' -> {
                    ans += 5
                    ++i
                }
                'I' -> {
                    if (i < s.length - 1){
                        if (s[i + 1] == 'V'){
                            ans += 4
                            i += 2
                        }
                        else if (s[i + 1] == 'X'){
                            ans += 9
                            i += 2
                        }
                        else {
                            ans += 1
                            ++i
                        }
                    }
                    else {
                        ans += 1
                        ++i
                    }
                }
            }
        }
        return ans
    }
}

fun main(){
    println(Solution88().romanToInt("MCMXCIV"))
}