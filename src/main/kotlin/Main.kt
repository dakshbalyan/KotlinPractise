import java.util.Collections
import java.util.Comparator

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
  val tmp = IntArray(m)
  for (i in tmp.indices) {
    tmp[i] = nums1[i]
  }

  var i = 0
  var j = 0
  var k = 0
  while (i < m && j < n) {
    if (tmp[i] <= nums2[j]) {
      nums1[k++] = tmp[i++]
    } else {
      nums1[k++] = nums2[j++]
    }
  }

    if (i < m) {
        while (i < m) {
            nums1[k++] = tmp[i++]
        }
    }

    if (j < n) {
        while (j < n) {
            nums1[k++] = nums2[j++]
        }
    }
}

fun minSetSize(arr: IntArray): Int {
    val freq:HashMap<Int, Int> = HashMap<Int, Int>()
    for (num in arr) {
        freq[num] = freq.getOrDefault(num,0) + 1
    }

    val values = freq.values.sorted().reversed()
    var sum = 0
    var cnt = 0
    val thresh = arr.size/2
    for (value in values) {
        sum += value
        if (sum >= thresh)
            return ++cnt
        cnt++
    }
    return cnt
}

fun main() {}
