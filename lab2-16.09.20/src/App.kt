import GraphsAlgorithms.BDS
import GraphsAlgorithms.BFS
import GraphsAlgorithms.DFS
import GraphsAlgorithms.IDDFS

fun main(args: Array<String>) {
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
    println(DFS(a, f))
    println(BFS(a, f))
    println(DFS(a, f, 2))
    println(IDDFS(a, f))
    println(BDS(a, f))
}

/*
fun main(args: Array<String>) {
    val data = File("V:/itmo/3 course/artificial intelligence systems/lab2-16.09.20/docs/graphData.txt")
        .readLines().map { it.split(" ") }.map { Triple(it[0], it[1], it[2].toInt()) }
    println("Путь: ${dfs().first} \n Длина пути = ${dfs().second}")
}*/