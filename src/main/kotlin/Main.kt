import kotlin.random.Random

fun main(args: Array<String>) {

//    println("Pascal's Triangle")
//    PascalTriangle(rowIndex = 15).proof()
//    println("------------------------")

//    println("Two Sum")
//    val size = 10000000
//    val bottom = (0 - size)
//    val array = IntArray(size){
//        Random.nextInt(bottom, size)
//    }
//    val target = Random.nextInt(bottom, 0)
//    TwoSum(nums = array, target = target).proof()
//    println("------------------------")

//    println("Add Two Number")
//    AddTwoNumber(
//        list1 = createLinkedList(size = 10, default = 9),
//        list2 = createLinkedList(size = 9, default = 9)
//    ).proof()
//    println("------------------------\n")

    val test = List(15){
        Char(32+Random.nextInt(0,128-32))
    }.joinToString("")
    println("Longest Substring $test")
//    println("Result 1 : ${LongestSubstring("abcabcbb").lengthOfLongestSubstring()}")
//    println("Result 2 : ${LongestSubstring("bbbbb").lengthOfLongestSubstring()}")
//    println("Result 3 : ${LongestSubstring("pwwkew").lengthOfLongestSubstring()}")
//    println("Result 4 : ${LongestSubstring(test).lengthOfLongestSubstring()}")
    println("Result 3 : ${LongestSubstring("advcwaertdf").lengthOfLongestSubstring()}")
}

fun createLinkedList(size: Int = 1, default: Int? = null): ListNode{
    val value = default ?: Random.nextInt(0, 9)
    if(size == 1) return ListNode(value)
    return ListNode(`val` = value,).apply {
        next = createLinkedList(size = size-1, default = value)
    }
}
