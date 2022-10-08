package org.personal.practise.leetcode.design

import java.util.*

// 981. Time Based Key-Value Store
class OptTimeMap() {

    /** Initialize your data structure here. */
    private val map: MutableMap<String, TreeMap<Int, String>> = mutableMapOf()
    // log(n)
    fun set(key: String, value: String, timestamp: Int) {
        val sortedMap = map[key] ?: TreeMap()
        sortedMap[timestamp] = value
        map[key] = sortedMap
    }

    // log(n)
    fun get(key: String, timestamp: Int): String {
        return map[key]?.floorEntry(timestamp)?.value ?: ""
    }
}