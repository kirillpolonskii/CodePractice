package top_interview_150.math.medium

class Solution172 {
    // Подсмотрел решение
    fun trailingZeroes(n: Int): Int {
            var count = 0
            var divisor = 5
            while (n / divisor > 0) {
                count += n / divisor
                divisor *= 5
            }
            return count
    }
}