package game

import pathfinding.Node

interface Actor {
    val startPosition: Node
    fun nextMove(target: Node): Node
}