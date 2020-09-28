import GraphsAlgorithms.bestFirstSearch
import GraphsAlgorithms.breadthFirstSearch
import GraphsAlgorithms.depthFirstSearch
import java.io.File

fun main(args: Array<String>) {
    val root = "V:/itmo/3 course/artificial intelligence systems/lab2-16.09.20/docs/"
    val roads = File("${root}graphData.txt").readLines().map { it.split(" ") }
    val vertices = roads.asSequence().flatten().filter { it.toIntOrNull() == null }.map { Vertex(it) }.toSet()
    roads.forEach { r ->
        val (a, b) = vertices.filter { it.name == r[0] || it.name == r[1] }
        a.link(b, r[2].toInt())
    }
    File("${root}heuristics.txt").readLines().map { it.split(" ") }.forEach { l ->
        vertices.find { it.name == l[0] }!!.heuristicMark = l[1].toInt()
    }
    val nodeA = vertices.find { it.name == "Рига" }!!
    val nodeB = vertices.find { it.name == "Уфа" }!!
    println(bestFirstSearch(nodeA, nodeB))

    val a = Vertex("A")
    val b = Vertex("B")
    val c = Vertex("C")
    val d = Vertex("D")
    val e = Vertex("E")
    val f = Vertex("F")
    a.link(b)
    a.link(c)
    b.link(d)
    b.link(e)
    c.link(f)
    e.link(f)
}