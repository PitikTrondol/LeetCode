package game

import kotlinx.coroutines.delay
import pathfinding.AStar
import pathfinding.Node
import kotlin.math.max

class Mouse(
    private val finder: AStar,
    override val startPosition: Node
): Actor {

    private var currentPos = startPosition
    override fun nextMove(target: Node): Node{
        val path = finder.findPath(currentPos, target)
        currentPos = path.last()
        return currentPos
    }
}