package org.personal.practise.leetcode.arrays

import java.util.*

class Easy {
  fun findOriginalArray(changed: IntArray): IntArray {
    val len = changed.size.div(2)
    val defaultAns: IntArray = intArrayOf(0)

    if (changed.size.rem(2) != 0) return defaultAns
    Arrays.sort(changed)
    val freqMap = hashMapOf<Int, Int>()
    changed.forEach { elem -> freqMap[elem] = freqMap.getOrDefault(elem, 0) + 1 }
    val res: IntArray = IntArray(len) { 0 }
    var itr: Int = 0
    var doubled: Int
    for (elem in changed) {
      doubled = elem * 2
      if (checkPairForElemExists(elem, doubled, freqMap)) {
        res[itr++] = elem
        freqMap[elem] = freqMap[elem]!!.minus(1)
        freqMap[doubled] = freqMap[doubled]!!.minus(1)
      }
    }

    if (itr < len) return defaultAns
    return res
  }

  private fun checkPairForElemExists(num: Int, pair: Int, map: HashMap<Int, Int>): Boolean {
    if (num == 0) {
      return map[num]!! > 1
    }

    return map[num]!! > 0 && map.containsKey(pair) && map[pair]!! > 0
  }

  // Another question
  fun palindromePairs(words: Array<String>): List<List<Int>> {
    var curr: String
    val ans: MutableList<List<Int>> = mutableListOf()
    val visited = IntArray(words.size) { 0 }
    for (i in 0..words.size.minus(1)) {
      if (visited[i] == 1) continue

      curr = words[i]
      for (j in 0..words.size.minus(1)) {
        if (i != j && visited[j] == 0 && checkPalindrome(curr.plus(words[j]))) {
          if (curr.length == words[j].length) {
            ans.add(listOf(i, j))
            ans.add(listOf(j, i))
            visited[i] = 1
            visited[j] = 1
          } else {
              ans.add(listOf(i,j))
          }
        }
      }
    }

    return ans
  }

  private fun checkPalindrome(str: String): Boolean {
    var start = 0
    var end = str.length - 1
    while (start < end) {
      if (str[start] != str[end]) {
        return false
      }
      start++
      end--
    }
    return true
  }

  // Two Sum
  fun twoSum(nums: IntArray, target: Int): IntArray {
    val indexMap = hashMapOf<Int, Int>()

    nums.forEachIndexed{ index, num ->
      indexMap[num] = index
    }
    println(indexMap)
    var find: Int
    nums.forEachIndexed { index, num ->
      find = target.minus(num)
      if (indexMap.containsKey(find) && indexMap[find]!! != index) {
        return intArrayOf(indexMap[find]!!, index)
      }
    }

    return intArrayOf()
  }

  // Roman to Integer
  fun romanToInt(s: String): Int {
    val romanMap = mapOf<Char, Int>(
      'I' to 1, 'V' to 5, 'X' to 10, 'L' to 50,
      'C' to 100, 'D' to 500, 'M' to 1000)
    var ans = 0
    var i = 0
    while (i < s.length) {
      if (romanCondition(i, s)) {
        ans = ans.plus(romanMap[s[i+1]]!!).minus(romanMap[s[i]]!!)
        i+=2
        continue
      }
      ans = ans.plus(romanMap[s[i]]!!)
      i++
    }
    return ans
  }

  private fun romanCondition(i: Int, s: String): Boolean {
    if (i < s.length - 1) {
      return (s[i] == 'I' && (s[i+1] == 'V' || s[i+1] == 'X'))
              || (s[i] == 'X' && (s[i+1] == 'L' || s[i+1] == 'C'))
              || (s[i] == 'C' && (s[i+1] == 'D' || s[i+1] == 'M'))
    }

    return false
  }

  // Longest Common Prefix
  fun longestCommonPrefix(strs: Array<String>): String {
    strs.sort()
    var ans = strs[0]
    for (s in strs) {
      for (i in s.indices) {
        if (i < ans.length && ans[i] != s[i]) {
          ans = ans.substring(0,i)
        }
      }
    }

    return ans
  }
}