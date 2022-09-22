package org.personal.practise.leetcode.arrays

class MediumArr {
    fun findDuplicate(paths: Array<String>): List<List<String>> {
        val contentMap = HashMap<String, MutableList<String>>()
        var files: List<String>
        var rootPath: String
        var fileName: String
        var content: String
        paths.forEach { path ->
            files = path.split(" ")
            rootPath = files[0]
            for ( i in 1 until files.size) {
                val file = files[i].split("(")
                fileName = file[0]
                content = file[1]

                if (!contentMap.containsKey(content))
                    contentMap[content] = arrayListOf()
                contentMap[content]!!.add("$rootPath/$fileName")
            }
        }
        val duplicates = mutableListOf<List<String>>()
        contentMap.forEach { (_, value) ->
            if (value.size > 1) {
                duplicates.add(value)
            }
        }

        return duplicates
    }

    // 985. Sum of Even Numbers After Queries
    fun sumEvenAfterQueries(nums: IntArray, queries: Array<IntArray>): IntArray {
        var evenSum = 0
        val evenSumArr = IntArray(nums.size)
        nums.forEach { num ->
            if (num.rem(2) == 0)
                evenSum = evenSum.plus(num)
        }
        var i = 0
        queries.forEach { query ->
            require(i < evenSumArr.size)
            evenSumArr[i] = processQuery(nums, query[1], query[0], evenSum)
            evenSum = evenSumArr[i++]
        }

        return evenSumArr
    }

    private fun processQuery(nums: IntArray, idx: Int, value: Int, initialSum: Int): Int {
        val prevVal = nums[idx]
        nums[idx] = nums[idx].plus(value)

        return if (prevVal.rem(2) == 0 && nums[idx].rem(2) == 0) {
            initialSum.minus(prevVal).plus(nums[idx])
        } else if (prevVal.rem(2) != 0 && nums[idx].rem(2) == 0) {
            initialSum.plus(nums[idx])
        } else if (prevVal.rem(2) == 0 && nums[idx].rem(2) != 0) {
            initialSum.minus(prevVal)
        } else {
            initialSum
        }
    }
}