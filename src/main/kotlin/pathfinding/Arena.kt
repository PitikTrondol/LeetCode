package pathfinding

import kotlin.math.abs
import kotlin.math.sqrt

val arenaArray = intArrayOf(
    3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
    3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 3,
    3, 0, 3, 0, 3, 3, 3, 3, 3, 3, 0, 3, 3, 3, 0, 3, 3, 0, 3, 0, 3,
    3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 3,
    3, 0, 3, 0, 3, 3, 3, 3, 3, 3, 0, 3, 3, 3, 3, 3, 3, 0, 3, 0, 3,
    3, 3, 3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 3, 0, 3,
    3, 0, 3, 0, 3, 0, 3, 3, 3, 3, 0, 3, 3, 3, 3, 0, 3, 0, 3, 0, 3,
    3, 0, 3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 3,
    3, 0, 3, 0, 3, 0, 3, 0, 0, 3, 3, 3, 0, 0, 3, 0, 3, 3, 3, 0, 3,
    3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 0, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3,
    3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 3,
    3, 3, 3, 0, 0, 0, 3, 0, 3, 0, 0, 0, 3, 0, 3, 0, 0, 0, 3, 3, 3,
    3, 0, 0, 0, 3, 0, 3, 0, 0, 3, 3, 3, 0, 0, 3, 0, 3, 0, 3, 0, 3,
    3, 0, 3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 3, 0, 3,
    3, 0, 3, 3, 3, 0, 3, 3, 3, 3, 0, 3, 3, 3, 3, 0, 3, 3, 3, 0, 3,
    3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 3, 0, 3,
    3, 0, 3, 0, 3, 3, 3, 3, 3, 3, 0, 3, 3, 3, 3, 3, 3, 0, 3, 0, 3,
    3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 3,
    3, 0, 3, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 3, 3, 3, 0, 3, 0, 3,
    3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 3,
    3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
)

class Arena {

    fun convert(arenaArray: IntArray, width: Int): List<List<Node>> {
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

                tmp.add(node)
            }
            map2D.add(tmp)
        }

        return map2D
    }

    fun randomSpawn(spawnZone: List<Node>): Node {
        val candidate = mutableListOf<Node>()
        for (node in spawnZone) {
            if (node.type != 0) continue
            candidate.add(node)
        }
        return candidate.apply { shuffle(); shuffle() }[0]
    }
}

fun Node?.orEmpty(): Node = this ?: Node(0, 0, 0)
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
        return "$type (${x}, $y)"
    }
}