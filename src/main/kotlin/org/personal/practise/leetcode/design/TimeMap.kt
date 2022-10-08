package org.personal.practise.leetcode.design

import java.util.*


// 981. Time Based Key-Value Store
public class TimeMap() {

  private val map: MutableMap<String, MutableList<Pair<Int, String>>> = mutableMapOf()

  fun set(key: String, value: String, timestamp: Int) {
    val list = map.getOrDefault(key, mutableListOf())
    list.add(Pair(timestamp, value))
    map[key] = list
  }

  fun get(key: String, timestamp: Int): String {
    if (!map.containsKey(key)) {
      return ""
    }
    return binaryGet(map[key], timestamp, 0, map[key]!!.size.minus(1))
  }

  private fun binaryGet(
      list: MutableList<Pair<Int, String>>?, target: Int, start: Int, end: Int
  ): String {
    if (start > end) return ""
    val mid = start + end.minus(start).div(2)
    val midItem = list?.get(mid)

    if (target == midItem?.first) {
      return midItem.second
    } else if (target < midItem?.first!!) {
        if (mid - 1 < 0) return ""
        if (list[mid-1].first <= target) return list[mid-1].second
        return binaryGet(list, target, start, mid-1)
    } else {
        if (mid + 1 == list.size) return midItem.second
        if (list[mid+1].first == target) return list[mid+1].second
        return binaryGet(list, target, mid+1, end)
    }
  }
}