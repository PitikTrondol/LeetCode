package pathfinding

import java.lang.Integer.max
import kotlin.math.abs
import kotlin.math.sqrt

val arenaArray = intArrayOf(
    0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0,
    0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0,
    0, 3, 3, 3, 3, 3, 0, 3, 3, 0, 0, 0,
    0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0,
    3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0,
    0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0,
    0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0,
    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
    0, 0, 0, 3, 3, 3, 0, 0, 0, 0, 0, 0,
    0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0,
    0, 0, 0, 0, 0, 3, 0, 3, 0, 0, 0, 0,
    0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0,
    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
    0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0,
)

class Arena {

    private var start = Node(0, 0, 0)
    private var target = Node(0, 0, 0)
    fun convert(arenaArray: IntArray, width: Int): Triple<List<List<Node>>, Node, Node> {
        val map2D = mutableListOf<List<Node>>()
        val height = arenaArray.size / width

        for (w in (0 until height)) {
            val tmp = mutableListOf<Node>()
            for (h in (0 until width)) {
                val node = Node(
                    type = arenaArray[w * width + h],
                    x = w,
                    y = h
                )

                if (node.type == 1) start = node
                if (node.type == 2) target = node
                tmp.add(node)
            }
            map2D.add(tmp)
        }

        return Triple(map2D, start, target)
    }
}

class Node(val type: Int, val x: Int, val y: Int) {

    private var _g = 0
    val g: Int get() = _g

    private var _h = 0
    val h: Int get() = _h

    val f: Int get() = _g + _h

    private var _next: Node? = null
    val next: Node? get() = _next

    fun setG(newG: Int) {
        _g = newG
    }

    fun setH(newH: Int) {
        _h = newH
    }

    fun setNext(newNode: Node) {
        _next = newNode
    }

    fun distance(other: Node): Int {
        val distX = abs(x - other.x)
        val distY = abs(y - other.y)
        val sideA = distX * distX * 1.0
        val sideB = distY * distY * 1.0

        return (sqrt(sideA + sideB) * 100).toInt()
    }

    override fun toString(): String {
        return "$type"
    }
}