package org.personal.practise.leetcode.trees

import org.personal.practise.leetcode.utils.TreeNode

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

}
