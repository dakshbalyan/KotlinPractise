package org.personal.practise

import org.personal.practise.leetcode.arrays.Easy

class MainRunner {
    private val arraysEasy = Easy()
    fun twoSum() {
        val nums = intArrayOf(3,2,4)
        val target = 6
        println(arraysEasy.twoSum(nums, target).joinToString(","))
    }

    fun romanToInt() {
        val s = "CM"
        println(arraysEasy.romanToInt(s))
    }

    fun longestCommonPrefix() {
        val strs = arrayOf("flower","flow","flight")
        println(arraysEasy.longestCommonPrefix(strs))
    }
}

fun main() {
    val runner = MainRunner()
//    runner.twoSum()
//    runner.romanToInt()
    runner.longestCommonPrefix()
}
