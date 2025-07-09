package top_interview_150.two_pointers.medium

class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var ind1 = 0
        var ind2 = 1
        for (i in 0..<numbers.size-1){
            val indOfAux = numbers.binarySearch(target - numbers[i], i + 1)
            if (indOfAux <= 0) continue
            else {
                ind1 = i
                ind2 = indOfAux
                break
            }
        }
        return intArrayOf(ind1 + 1, ind2 + 1)
    }
}
/*
* Правильное решение:
* fun twoSum(numbers: IntArray, target: Int): IntArray {
        var l = 0
        var r = numbers.size - 1

        while (l < r) {
            when {
                numbers[l] + numbers[r] == target -> return intArrayOf(l+1, r+1)
                numbers[l] + numbers[r] > target -> r--
                else -> l++
            }
        }

        return intArrayOf()
    }
* */
fun main (){
    println(Solution().twoSum(intArrayOf(-1,0), -1).joinToString())
}