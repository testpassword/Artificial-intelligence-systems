import GraphsAlgorithms.A_StarSearch
import GraphsAlgorithms.bestFirstSearch
import GraphsAlgorithms.bidirectionalSearch
import GraphsAlgorithms.breadthFirstSearch
import GraphsAlgorithms.depthFirstSearch
import GraphsAlgorithms.depthLimitSearch
import GraphsAlgorithms.iterativeDeepeningDepthFirstSearch
import java.io.File

fun main(args: Array<String>) {
    val root = "V:/itmo/3 course/artificial intelligence systems/lab2-16.09.20/docs/"
    val vertices = File("${root}heuristics.txt").readLines().map { it.split(" ") }
        .map { Vertex(it[0]).apply { this.h = it[1].toInt() } }.toSet()
    File("${root}graphData.txt").readLines().map { it.split(" ") }.forEach { r ->
        val (a, b) = vertices.filter { it.name == r[0] || it.name == r[1] }
        a.link(b, r[2].toInt())
    }
    val (a, b) = vertices.filter { it.name == "Рига" || it.name == "Уфа" }
    println("""
        DFS ${depthFirstSearch(a, b)}
        BFS ${breadthFirstSearch(a, b)}
        DLS ${depthLimitSearch(a, b, 5)}
        IDDFS ${iterativeDeepeningDepthFirstSearch(a, b)}
        BDS ${bidirectionalSearch(a, b)}
        BFS ${bestFirstSearch(a, b)}
        A* ${A_StarSearch(a, b)}
    """.trimIndent()
    )
}