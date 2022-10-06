package org.personal.practise

import org.personal.practise.leetcode.arrays.EasyArr
import org.personal.practise.leetcode.arrays.HardArr
import org.personal.practise.leetcode.arrays.MediumArr
import org.personal.practise.leetcode.dp.EasyDP
import org.personal.practise.leetcode.dp.MediumDP
import org.personal.practise.leetcode.linkedlists.EasyLL
import org.personal.practise.leetcode.strings.EasyStr
import org.personal.practise.leetcode.trees.EasyTree
import org.personal.practise.leetcode.trees.MediumTree
import org.personal.practise.leetcode.utils.ListNode
import org.personal.practise.leetcode.utils.TreeNode

class MainRunner {
    private val arraysEasy = EasyArr()
    private val arraysMedium = MediumArr()
    private val arraysHard = HardArr()
    private val stringsEasy = EasyStr()
    private val linkedListEasy = EasyLL()
    private val dpMedium = MediumDP()
    private val dpEasy = EasyDP()
    private val treeEasy = EasyTree()
    private val treeMedium = MediumTree()
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

    fun mergeTwoLinkedLists() {
        val firstfirstLL = ListNode(1)
        val firstsecondLL = ListNode(2)
        val firstthirdLL = ListNode(4)
        val secondfirstLL = ListNode(1)
        val secondsecondLL = ListNode(3)
        val secondthirdLL = ListNode(4)
        firstfirstLL.next = firstsecondLL
        firstsecondLL.next = firstthirdLL
        secondfirstLL.next = secondsecondLL
        secondsecondLL.next = secondthirdLL

        println(linkedListEasy.mergeTwoLists(firstfirstLL, secondfirstLL))
    }

    fun sumEvenAfterQueries() {
        val nums = intArrayOf(1,2,3,4)
        val queries = arrayOf(intArrayOf(1,0),intArrayOf(-3,1), intArrayOf(-4,0), intArrayOf(2,3))
        println(arraysMedium.sumEvenAfterQueries(nums, queries).joinToString(","))
    }

    fun reverseWords() {
        val words = "Let's take LeetCode contest"
//        println(stringsEasy.reverseWords(words))
        println(stringsEasy.optimisedReverseWords(words))
    }

    fun numRollsToTarget() {
        println(dpMedium.numRollsToTarget(30, 30, 500))
    }

    fun minCost() {
        val colors = "bbbaaa"
        val neededTime = intArrayOf(4,9,3,8,8,9)
        println(dpEasy.minCost(colors, neededTime))
    }

    fun hasPathSum() {
        val rootNode = TreeNode(5)
        val leftRootNode = TreeNode(4)
        val rightRootNode = TreeNode(8)
        val leftleftRootNode = TreeNode(11)
        val leftleftleftRootNode = TreeNode(7)
        val rightleftleftRootNode = TreeNode(2)
        val leftrightRootNode = TreeNode(13)
        val rightrightRootNode = TreeNode(4)
        val rightrightrightRootNode = TreeNode(4)
        rootNode.left = leftRootNode
        rootNode.right = rightRootNode
        leftRootNode.left = leftleftRootNode
        leftleftRootNode.left = leftleftleftRootNode
        leftleftRootNode.right = rightleftleftRootNode
        rightRootNode.left = leftrightRootNode
        rightRootNode.right = rightrightRootNode
        rightrightRootNode.right = rightrightrightRootNode

        println(treeEasy.hasPathSum(rootNode, 22))
    }

    fun pathSum() {
        val rootNode = TreeNode(5)
        val leftRootNode = TreeNode(4)
        val rightRootNode = TreeNode(8)
        val leftleftRootNode = TreeNode(11)
        val leftleftleftRootNode = TreeNode(7)
        val rightleftleftRootNode = TreeNode(2)
        val leftrightRootNode = TreeNode(13)
        val rightrightRootNode = TreeNode(4)
        val rightrightrightRootNode = TreeNode(4)
        rootNode.left = leftRootNode
        rootNode.right = rightRootNode
        leftRootNode.left = leftleftRootNode
        leftleftRootNode.left = leftleftleftRootNode
        leftleftRootNode.right = rightleftleftRootNode
        rightRootNode.left = leftrightRootNode
        rightRootNode.right = rightrightRootNode
        rightrightRootNode.right = rightrightrightRootNode

        println(treeMedium.pathSum(rootNode, 22).joinToString(","))
    }

    fun addRowRecursively() {
        val rootNode = TreeNode(1)
        val leftRootNode = TreeNode(2)
        val rightRootNode = TreeNode(3)
        val leftleftRootNode = TreeNode(4)
        rootNode.left = leftRootNode
        rootNode.right = rightRootNode
        leftRootNode.left = leftleftRootNode

        println(treeMedium.addOneRow(rootNode, 5, 4)?.`val`)
    }
}

fun main() {
    val runner = MainRunner()
//    runner.twoSum()
//    runner.romanToInt()
//    runner.longestCommonPrefix()
//    runner.validParentheses()
//    runner.trapRainWater()
//    runner.findDuplicateDocs()
//        runner.mergeTwoLinkedLists()
//    runner.sumEvenAfterQueries()
//    runner.reverseWords()
//    runner.numRollsToTarget()
//    runner.minCost()
//    runner.hasPathSum()
//    runner.pathSum()
    runner.addRowRecursively()
}
