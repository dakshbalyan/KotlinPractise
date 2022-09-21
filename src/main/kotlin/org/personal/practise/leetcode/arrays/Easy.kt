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
}