package org.personal.practise.leetcode.trees

import org.personal.practise.leetcode.utils.TreeNode
import java.util.LinkedList
import java.util.Queue

class MediumTree {

    // 113. Path Sum II
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        val ans: MutableList<MutableList<Int>> = ArrayList()
        val currPath: MutableList<Int> = ArrayList()
        pathSum(root, targetSum, ans, currPath)

        return ans
    }

    private fun pathSum(root: TreeNode?, targetSum: Int,
                        ans: MutableList<MutableList<Int>>, currPath: MutableList<Int>) {
        if (root == null) return

        currPath.add(root.`val`)
        if (root.left == null && root.right == null && root.`val` == targetSum) {
            ans.add(ArrayList(currPath))
        }

        pathSum(root.left, targetSum - root.`val`, ans, currPath)
        pathSum(root.right, targetSum - root.`val`, ans, currPath)
        currPath.removeLast()
    }

    // 623. Add One Row to Tree
    fun addOneRow(root: TreeNode?, `val`: Int, depth: Int): TreeNode? {
        val new = addRowIteratively(root, `val`, depth)
        return addRowRecursively(root, `val`, depth)
    }

    private fun addRowRecursively(root: TreeNode?, value: Int, depth: Int): TreeNode? {
        // Base case
        if (root == null) return TreeNode(value)
        if (depth == 1) {
            val newRoot = TreeNode(value)
            newRoot.left = root
            return newRoot
        }

        // Induction step
        if (depth == 2) {
            val tmpLeft = TreeNode(value)
            val tmpRight = TreeNode(value)
            tmpLeft.left = root.left
            tmpRight.right = root.right
            root.left = tmpLeft
            root.right = tmpRight
        }

        // Recursive step
        addRowRecursively(root.left, value, depth.minus(1))
        addRowRecursively(root.right, value, depth.minus(1))
        return root
    }

    private fun addRowIteratively(root: TreeNode?, value: Int, depth: Int): TreeNode? {
        if (root == null) return TreeNode(value)
        if (depth == 1) {
            val newRoot = TreeNode(value)
            newRoot.left = root
            return newRoot
        }

        var level = 1
        val queue: Queue<TreeNode> = LinkedList<TreeNode>()
        queue.add(root)

        while (queue.size != 0 && level < depth) {
            level++
            val size = queue.size
            for (i in 0 until size) {
                val currNode = queue.remove()
                if (level == depth) {
                    val tmpLeft = TreeNode(value)
                    val tmpRight = TreeNode(value)
                    tmpLeft.left = currNode.left
                    tmpRight.right = currNode.right
                    currNode.left = tmpLeft
                    currNode.right = tmpRight
                } else {
                    if (currNode.left != null) queue.add(currNode.left)
                    if (currNode.right != null) queue.add(currNode.right)
                }
            }
        }

        return root
    }

}
