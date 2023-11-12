package game

import pathfinding.AStar
import pathfinding.Node

class Cat(
    private val finder: AStar,
    override val startPosition: Node,
): Actor {
    private var currentPos = startPosition
    override fun nextMove(target: Node): Node{
        if(currentPos == target) return  target

        val path = finder.findPath(currentPos, target)
        currentPos = path.last()
        return currentPos
    }
}