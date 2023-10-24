package solution

import kotlin.random.Random

class AddTwoNumber(private val list1: ListNode?, private val list2: ListNode?) : Solution {
    override fun proof() {
        println("Proof ${printNode(addTwoNumbers())}")
    }

    private fun addTwoNumbers(): ListNode? {

        var node1: ListNode? = list1
        var node2: ListNode? = list2
        var remainder = 0
        val starter = ListNode(-1)
        var pointer: ListNode? = starter
        while (node1 != null || node2 != null || remainder == 1) {

            val one = node1?.`val` ?: 0
            val two = node2?.`val` ?: 0
            val sum = (one + two + remainder).run {

                if (this >= 10) {
                    remainder = 1
                    this - 10
                } else {
                    remainder = 0
                    this
                }
            }

            println("$one + $two = $sum")
            val newNode = ListNode(sum)
            if (starter.next == null) {
                starter.next = newNode
                pointer = starter.next
            } else {
                pointer?.next = newNode
                pointer = pointer?.next
            }

            node1 = node1?.next
            node2 = node2?.next
        }

        return starter.next
    }

    private fun printNode(start: ListNode?, base: String = ""): String {
        if (start == null) return base
        val newBase = if (base.isBlank()) {
            base + start.`val`
        } else {
            base + ", " + start.`val`
        }

        return printNode(start.next, newBase)
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun createLinkedList(size: Int = 1, default: Int? = null): ListNode {
    val value = default ?: Random.nextInt(0, 9)
    if(size == 1) return ListNode(value)
    return ListNode(`val` = value,).apply {
        next = createLinkedList(size = size-1, default = value)
    }
}