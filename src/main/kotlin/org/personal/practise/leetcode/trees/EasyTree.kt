package org.personal.practise.leetcode.trees

import org.personal.practise.leetcode.utils.TreeNode
import java.util.LinkedList
import java.util.Queue

class EasyTree {

    // 112. Path Sum
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) return false
        if (root.left == null && root.right == null) {
            return targetSum.minus(root.`val`) == 0
        }

        return hasPathSum(root.left, targetSum - root.`val`)
                || hasPathSum(root.right, targetSum - root.`val`)
    }

    // 653. Two Sum IV - Input is a BST
    fun findTarget(root: TreeNode?, k: Int): Boolean {
        val values = mutableListOf<Int>()
        fillValues(values, root)

        var start = 0
        var end = values.size - 1
        var sum = 0

        while (start < end) {
            sum = values[start].plus(values[end])
            if (sum == k) {
                return true
            } else if (sum > k) {
                end--
            } else {
                start++
            }
        }

        return false
    }

    private fun fillValues(values: MutableList<Int>, root: TreeNode?) {
        if (root == null) return

        fillValues(values, root.left)
        values.add(root.`val`)
        fillValues(values, root.right)
    }

    fun findTargetBFS(root: TreeNode?, k: Int): Boolean {
        val queue: Queue<TreeNode> = LinkedList()
        val set = mutableSetOf<Int>()
        queue.add(root)

        while (queue.size != 0) {
            val currNode = queue.remove()
            if (set.contains(k.minus(currNode.`val`))) return true
            set.add(currNode.`val`)

            if (currNode.left != null) queue.add(currNode.left)
            if (currNode.right != null) queue.add(currNode.right)
        }

        return false
    }
}