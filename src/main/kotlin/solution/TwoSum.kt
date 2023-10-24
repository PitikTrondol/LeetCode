package solution

class TwoSum(private val nums: IntArray, private val target: Int) : Solution {
    override fun proof() {
        val array = nums.takeIf { it.size <= 50 }
        println("List ${array?.joinToString(", ") ?: "Too Long"} :: Target $target")
        println("Result [${getIndices().joinToString(", ")}]")
    }

    private fun getIndices(): IntArray {
        val result = IntArray(2){ -1 }
        if (nums.size < 2) return result
        val memoize = mutableMapOf<Int, Int>()

        for (i in nums.indices) {
            val pair = memoize[target - nums[i]]
            if (pair != null && i != pair) {
                return result.apply {
                    this[0] = i
                    this[1] = pair
                }
            }

            memoize[nums[i]] = i
        }
        return result
    }
}