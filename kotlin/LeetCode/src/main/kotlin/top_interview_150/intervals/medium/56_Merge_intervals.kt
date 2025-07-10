package top_interview_150.intervals.medium

class Solution {
    /*fun areIntervalsOverlapping(i1: IntArray, i2: IntArray){
        return i1[1] >= i2[0] || i1[]
    }*/

    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val sortedIntervals = intervals.toMutableList().sortedWith { int1, int2 ->
            int1[0] - int2[0]
        }
        val merged = mutableListOf(sortedIntervals[0])
        var curInd = 1
        while (curInd < sortedIntervals.size) {
            if (merged.last()[1] >= sortedIntervals[curInd][0]){ // can be merged
                merged.last()[0] = kotlin.math.min(merged.last()[0], sortedIntervals[curInd][0])
                merged.last()[1] = kotlin.math.max(merged.last()[1], sortedIntervals[curInd][1])
            }
            else {
                merged.add(sortedIntervals[curInd])
            }
            ++curInd
        }
        return merged.toTypedArray()
    }
}