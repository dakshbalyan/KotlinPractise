package org.personal.practise.leetcode.design

import java.util.TreeMap
import kotlin.math.max

// 732. My Calendar III
/*
* https://www.hackerearth.com/practice/math/geometry/line-sweep-technique/tutorial/
* https://leetcode.com/problems/my-calendar-iii/discuss/2670758/LeetCode-The-Hard-Way-Explained-Line-By-Line
*
* */
class MyCalendarThree() {
    private val lines: TreeMap<Int, Int> = TreeMap()
    fun book(start: Int, end: Int): Int {
        var cnt = 0
        var max = 0
        lines[start] = lines.getOrDefault(start, 0).plus(1)
        lines[end] = lines.getOrDefault(end, 0).minus(1)

        lines.forEach { line ->
            cnt += line.value
            max = max(max, cnt)
        }

        return max
    }

}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * var obj = MyCalendarThree()
 * var param_1 = obj.book(start,end)
 */