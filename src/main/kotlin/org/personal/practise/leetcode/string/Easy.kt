package org.personal.practise.leetcode.string

import java.util.*

class Easy {
    // 20. Valid Parentheses
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        for (char in s) {
            when (char) {
                ')' -> if (stack.isNotEmpty() && stack.peek() == '(') stack.pop() else return false
                '}' -> if (stack.isNotEmpty() && stack.peek() == '{') stack.pop() else return false
                ']' -> if (stack.isNotEmpty() && stack.peek() == '[') stack.pop() else return false
                else -> stack.push(char)
            }
        }

        return stack.size == 0
    }

    // Longest Common Prefix
    fun longestCommonPrefix(strs: Array<String>): String {
        strs.sort()
        var ans = strs[0]
        for (s in strs) {
            for (i in s.indices) {
                if (i < ans.length && ans[i] != s[i]) {
                    ans = ans.substring(0, i)
                    break
                }
            }
        }

        return ans
    }

    // Roman to Integer
    fun romanToInt(s: String): Int {
        val romanMap =
            mapOf<Char, Int>(
                'I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)
        var ans = 0
        var i = 0
        while (i < s.length) {
            if (romanCondition(i, s)) {
                ans = ans.plus(romanMap[s[i + 1]]!!).minus(romanMap[s[i]]!!)
                i += 2
                continue
            }
            ans = ans.plus(romanMap[s[i]]!!)
            i++
        }
        return ans
    }

    private fun romanCondition(i: Int, s: String): Boolean {
        if (i < s.length - 1) {
            return (s[i] == 'I' && (s[i + 1] == 'V' || s[i + 1] == 'X')) ||
                    (s[i] == 'X' && (s[i + 1] == 'L' || s[i + 1] == 'C')) ||
                    (s[i] == 'C' && (s[i + 1] == 'D' || s[i + 1] == 'M'))
        }

        return false
    }
}