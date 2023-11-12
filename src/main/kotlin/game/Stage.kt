package game

import kotlinx.coroutines.delay
import pathfinding.AStar
import pathfinding.Arena
import pathfinding.Node
import pathfinding.arenaArray

class Stage(arena: Arena) {
    private var isCheeseFound = false
    private var isMouseCaught = false
    private val stage = arena.convert(arenaArray, 21)
    private val mouseStart = arena.randomSpawn(stage[1])
    private val catStart = arena.randomSpawn(stage[19])
    private val cheese = stage[10][10]
    private val finder = AStar(stage)
    private val mouse = Mouse(finder, mouseStart)
    private val cat = Cat(finder, catStart)

    private fun drawStage(stage: List<List<Node>>, cat: Node, mouse: Node, cheese: Node){
        var separator = 0
        stage.forEach { line ->
            println(
                line.joinToString(separator = " | ") {
                    when (it) {
                        cheese -> {
                            "*"
                        }
                        cat -> {
                            "W"
                        }
                        mouse -> {
                            "K"
                        }
                        else -> {
                            "${it.type}"
                        }
                    }
                }.also { separator = it.length }
            )
        }
        (0 until separator).forEach {
            print("-")
        }
        println()
    }

    private suspend fun startCountDown(){
        delay(3000)
        var count = 3
        while (count > 0){
            print("$count  ")
            count-=1
            delay(1000)
        }
        println("START")
    }

    suspend fun startMatch(){

        println("MOUSE (${mouseStart.x}, ${mouseStart.y}) :: CAT (${catStart.x}, ${catStart.y}) :: CHEESE (${cheese.x}, ${cheese.y})")
        drawStage(stage = stage, cat = catStart, mouse = mouseStart, cheese = cheese)

        startCountDown()

        while (!isCheeseFound){
            val mouseStep = mouse.nextMove(cheese)
            val catStep = cat.nextMove(mouseStep)
            isCheeseFound = mouseStep == cheese
            isMouseCaught = mouseStep == catStep

            drawStage(stage = stage, cat = catStep, mouse = mouseStep, cheese = cheese)

            if(isMouseCaught) {
                println("MOUSE GOT CAUGHT!")
                break
            }

            delay(1000)
        }
        if(isCheeseFound && !isMouseCaught) {
            println("CHEESE FOUND, MOUSE WIN!")
        }
    }

}