package org.personal.practise.leetcode.strings

class MediumStr {

    // 1328. Break a Palindrome
    fun breakPalindrome(palindrome: String): String {
        val len = palindrome.length
        if (len == 1) return ""
        val chars = palindrome.toCharArray()
        for (i in 0 until len/2) {
            if (chars[i] != 'a') {
                chars[i] = 'a'
                return String(chars)
            }
        }

        chars[len - 1] = 'b'
        return String(chars)
    }

    fun withoutArrBreakPalindrome(palindrome: String): String {
        val len = palindrome.length
        if (len == 1) return ""
        var i = 0

        while (i < len/2) {
            if (palindrome[i] != 'a') {
                return palindrome.substring(0,i).plus('a').plus(palindrome.substring(i+1))
            }
            i++
        }

        return palindrome.substring(0,len-1).plus('b')
    }
}