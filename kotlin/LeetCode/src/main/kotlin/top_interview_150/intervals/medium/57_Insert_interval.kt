package top_interview_150.intervals.medium

class Solution57 {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        var i = 0
        while (i < intervals.size && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i])
            i++
        }
        while (i < intervals.size && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = minOf(newInterval[0], intervals[i][0])
            newInterval[1] = maxOf(newInterval[1], intervals[i][1])
            i++
        }
        result.add(newInterval)
        while (i < intervals.size) {
            result.add(intervals[i])
            i++
        }
        return result.toTypedArray()
    }

    fun binSearchNewIntervPos(intervals: Array<IntArray>, newInterval: IntArray): Int{
        var l = 0
        var r = intervals.size - 1
        var pos = (l + r) / 2
        while (l < r){
            if (newInterval[0] > intervals[pos][0]){
                l = pos + 1
            }
            else if (newInterval[0] < intervals[pos][0]){
                r = pos - 1
            }
            else {
                break
            }
        }
        return pos
    }
}