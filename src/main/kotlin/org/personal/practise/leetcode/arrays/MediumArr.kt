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
}