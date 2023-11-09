import pathfinding.AStar
import pathfinding.Arena
import pathfinding.arenaArray
import solution.ListNode
import sorting.MergeSort
import kotlin.random.Random
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
//    val source = IntArray(20){ it }.apply { shuffle() }
//    println("Before ${source.joinToString(", ")}")
//    val time = measureTimeMillis { MergeSort().sort(source) }
//    println("After ${source.joinToString(", ")}")
//    println("Time $time")
//    println("------------------------\n")

//    println(arenaArray.joinToString(", "))
//    println("--------------------------------------")
    val (arena, start, target) = Arena().convert(arenaArray, 12)
    println("${start.x}, ${start.y} | ${target.x}, ${target.y}")
    arena.forEach { line ->
        println(line.joinToString(separator = " | ") { "${it.type}" })
    }

    val path = AStar(arena).findPath(start, target)
    println("\n======")
    println("RESULT ${path.joinToString(separator = " | ") { "${it.type} (${it.x}, ${it.y})" }}")
    println("======")

    arena.forEach { line ->
        println(line.joinToString(separator = " | "){
            if(path.contains(it)) "*" else "${it.type}"}
        )
    }
}
