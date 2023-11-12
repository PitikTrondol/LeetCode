import game.Stage
import kotlinx.coroutines.runBlocking
import pathfinding.AStar
import pathfinding.Arena
import pathfinding.Node
import pathfinding.arenaArray
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {

//    println("Pascal's Triangle")
//    solution.PascalTriangle(rowIndex = 15).proof()
//    println("------------------------")

//    println("Two Sum")
//    val size = 10000000
//    val bottom = (0 - size)
//    val array = IntArray(size){
//        Random.nextInt(bottom, size)
//    }
//    val target = Random.nextInt(bottom, 0)
//    solution.TwoSum(nums = array, target = target).proof()
//    println("------------------------")

//    println("Add Two Number")
//    solution.AddTwoNumber(
//        list1 = createLinkedList(size = 10, default = 9),
//        list2 = createLinkedList(size = 9, default = 9)
//    ).proof()
//    println("------------------------\n")

//    val test = List(15){ Char(32+Random.nextInt(0,128-32)) }.joinToString("")
//    println("Longest Substring $test")
//    println("Result : ${solution.LongestSubstring("advcwaertdf").lengthOfLongestSubstring()}")
//    println("------------------------\n")

//    println("Merge Sort")
//    val source = IntArray(9009000){ it }.apply { shuffle() }
//    val source2 = IntArray(9009000){ it }.apply { shuffle() }
//    var time = measureTimeMillis { MergeSort().test.invoke(source) }
//    println("Deep Recursive $time")
//    time = measureTimeMillis { MergeSort().sort(result) }
//    println("Normal $time")
//    var result = IntArray(20){ it }.apply { shuffle() }
//    println("RESULT ${result.joinToString(", ")}")
//    MergeSort().sort(result)
//    println("RESULT ${result.joinToString(", ")}")
//    println("------------------------\n")

//    println("--------------------------------------")
//    val arena = Arena()
//    val map = arena.convert(arenaArray, 12)
//    val start = arena.randomSpawn(map.slice(map.size-2 until map.size))
//    val target = arena.randomSpawn(map.slice(1 .. 2))
//    println("${start.x}, ${start.y} | ${target.x}, ${target.y}")
//
//    map.forEach { line ->
//        println(line.joinToString(separator = " | ") { "${it.type}" })
//    }
//
//    var path : List<Node>
//    val time = measureTimeMillis { path = AStar(map).findPath(start, target) }
//    println("======")
//    println("RESULT ${path.joinToString(separator = " | ") { "(${it.x}, ${it.y})" }} :: $time")
//    println("======")
//
//    map.forEach { line ->
//        println(line.joinToString(separator = " | "){
//            if(path.contains(it)) "*" else "${it.type}"}
//        )
//    }

    runBlocking {
        val stage = Stage(Arena())
        stage.startMatch()
    }
}
