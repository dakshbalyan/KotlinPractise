package org.personal.practise.leetcode.dp

class MediumDP {
    // 1155. Number of Dice Rolls With Target Sum
    private val mod = 1000000007;
    fun numRollsToTarget(n: Int, k: Int, target: Int): Int {
        val dp = Array(n+1) { IntArray(target+1) { -1 } }
        return calculateNumRolls(n, k, target, dp)
    }

    private fun calculateNumRolls(dice: Int, faces: Int, target: Int, dp: Array<IntArray>): Int {
        if (target < 0) return 0
        if (target == 0 && dice != 0) return 0
        if (target != 0 && dice == 0) return 0
        if (target == 0 && dice == 0) return 1
        if (dp[dice][target] != -1) return dp[dice][target]

        var count = 0
        for (i in 1..faces) {
            // TODO: ask why we need to do double mod here
            count = (count + calculateNumRolls(dice-1, faces, target - i, dp).rem(mod)).rem(mod)
        }
        dp[dice][target] = count
        return count
    }
}