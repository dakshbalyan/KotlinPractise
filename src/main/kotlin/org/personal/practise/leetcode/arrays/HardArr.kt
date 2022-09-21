package org.personal.practise.leetcode.arrays

import java.lang.Integer.max
import kotlin.math.min

class HardArr {
    // 42. Trapping Rain Water
    /* Thought Process
1. For each block of height the max amount of water that can be stored is the min between the highest block on its
left and right
    * */
    fun bruteTrap(height: IntArray): Int {
        var waterAmt = 0
        var currHeight: Int
        var maxLeft: Int
        var maxRight: Int
        var capacity: Int
        for (i in 1 until height.size-1) {
            currHeight = height[i]
            maxLeft = findMaxHeight(height, 0, i)
            maxRight = findMaxHeight(height, i+1, height.size)
            capacity = min(maxLeft, maxRight).minus(currHeight)
            waterAmt = waterAmt.plus(max(capacity, 0))
        }

        return waterAmt
    }

//    fun optimisedTrap(height: IntArray): Int {
//        var waterAmt = 0
//        var curr: Int
//        var maxleft = IntArray(height.size)
//        var maxRight = IntArray(height.size)
//        var capacity: Int
//        for (i in 1 until height.size.minus(1)) {
//            curr = height[i]
//            maxleft = max(height[i-1], maxleft)
//            maxRight = when {
//                curr == maxRight ->
//            }
//
//        }
//    }

    private fun findMaxHeight(height: IntArray, start: Int, end: Int): Int {
        var max = 0
        for (i in start until end) {
            max = max(height[i], max)
        }

        return max
    }
}