package game

import kotlinx.coroutines.delay
import pathfinding.AStar
import pathfinding.Arena
import pathfinding.arenaArray

class Stage(arena: Arena) {
    private var isCheeseFound = false
    private var isMouseCaught = false
    private val stage = arena.convert(arenaArray, 12)
    private val mouseZone = stage.slice(stage.size-2 until stage.size)
    private val mid = stage.size / 2
    private val cheeseZone = stage.slice(mid-1 until mid+1)
    private val catZone = stage.slice(1 .. 2)
    private val mouseStart = arena.randomSpawn(mouseZone)
    private val catStart = arena.randomSpawn(catZone)
    private val cheese = arena.randomSpawn(cheeseZone)
    private val finder = AStar(stage)
    private val mouse = Mouse(finder, mouseStart)
    private val cat = Cat(finder, catStart)

    suspend fun startMatch(){
        println("START (${mouseStart.x}, ${mouseStart.y}) :: (${catStart.x}, ${catStart.y})")

        while (!isCheeseFound){
            val mouseStep = mouse.nextMove(cheese)
            val catStep = cat.nextMove(mouseStep)
            isCheeseFound = mouseStep == cheese
            isMouseCaught = mouseStep == catStep

            stage.forEach { line ->
                println(
                    line.joinToString(separator = " | ") {
                        if(it == cheese) "@" else if(it == mouseStep) "#" else if(it == catStep) "*" else "${it.type}"
                    }
                )
            }
            println("--------------------------------------------------")

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