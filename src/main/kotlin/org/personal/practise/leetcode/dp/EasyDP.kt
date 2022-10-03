package org.personal.practise.leetcode.dp

class EasyDP {
    // 1578. Minimum Time to Make Rope Colorful
    fun minCost(colors: String, neededTime: IntArray): Int {
        var cost = 0
        var maxTime = 0
        for (i in 1 until colors.length) {
            if (colors[i] == colors[i-1]) {
                maxTime = neededTime[i - 1].coerceAtLeast(maxTime)
                cost += neededTime[i].coerceAtMost(maxTime)
            } else {
                maxTime = 0
            }
        }

        return cost
    }
}