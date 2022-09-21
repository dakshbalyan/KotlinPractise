package org.personal.practise

import org.personal.practise.leetcode.arrays.EasyArr
import org.personal.practise.leetcode.arrays.HardArr
import org.personal.practise.leetcode.arrays.MediumArr
import org.personal.practise.leetcode.strings.EasyStr

class MainRunner {
    private val arraysEasy = EasyArr()
    private val arraysMedium = MediumArr()
    private val arraysHard = HardArr()
    private val stringsEasy = EasyStr()
    fun twoSum() {
        val nums = intArrayOf(3,2,4)
        val target = 6
        println(arraysEasy.twoSum(nums, target).joinToString(","))
    }

    fun romanToInt() {
        val s = "CM"
        println(stringsEasy.romanToInt(s))
    }

    fun longestCommonPrefix() {
        val strs = arrayOf("flower","flow","flight")
        println(stringsEasy.longestCommonPrefix(strs))
    }

    fun validParentheses() {
        val s = "]})))"
        println(stringsEasy.isValid(s))
    }

    fun trapRainWater() {
        val height = intArrayOf(4,2,0,3,2,5)
        println("Ans : ${arraysHard.bruteTrap(height)}")
    }

    fun findDuplicateDocs() {
        val duplicates = arrayOf("root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)")
        println(arraysMedium.findDuplicate(duplicates).joinToString(","))
    }
}

fun main() {
    val runner = MainRunner()
//    runner.twoSum()
//    runner.romanToInt()
//    runner.longestCommonPrefix()
//    runner.validParentheses()
//    runner.trapRainWater()
    runner.findDuplicateDocs()
}
