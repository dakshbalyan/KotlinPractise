package org.personal.practise.leetcode.linkedlists

import org.personal.practise.leetcode.utils.ListNode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class EasyLL {
    // 21. Merge Two Sorted Lists
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var smaller = if(list1!!.`val` <= list2!!.`val`) list1 else list2
        var larger = if(list1.`val` > list2.`val`) list1 else list2

        var prev = smaller
        while (smaller.next != null && larger.next != null) {
            while (smaller.`val` <= larger.`val`) {
                prev = smaller
                smaller = smaller.next!!
            }
            prev.next = larger
            prev = smaller
            smaller = larger
            larger = prev

        }

        return null
    }
}
