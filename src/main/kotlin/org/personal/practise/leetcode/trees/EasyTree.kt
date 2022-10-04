package org.personal.practise.leetcode.trees

import org.personal.practise.leetcode.utils.TreeNode

class EasyTree {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) return false
        if (root.left == null && root.right == null) {
            return targetSum.minus(root.`val`) == 0
        }

        return hasPathSum(root.left, targetSum - root.`val`)
                || hasPathSum(root.right, targetSum - root.`val`)
    }
}