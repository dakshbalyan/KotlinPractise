package org.personal.practise

import org.personal.practise.leetcode.arrays.Easy

class MainRunner {
    private val arraysEasy = Easy()
    fun twoSum() {
        val nums = intArrayOf(3,2,4)
        val target = 6
        println(arraysEasy.twoSum(nums, target).joinToString(","))
    }
}

fun main() {
    val runner = MainRunner()
    runner.twoSum()
}
