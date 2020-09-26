import java.util.*


/**
 * Содержит методы для поиска пути в графе.
 * @author Кульбако Артемий.
 */
object GraphsAlgorithms {

    /**
     * Алгоритм поиск в глубину на графах с ограничением глубины [limit] (DFS и DLS).
     * @return путь от [start] до [finish] и его длину.
     * @link https://ru.haru-atari.com/blog/17-algorithms-on-graphs-deep-first-search-dfs-dls-iddfs
     * @link https://stackoverflow.com/questions/12864004/tracing-and-returning-a-path-in-depth-first-search
     */
    fun DFS(start: Vertex, finish: Vertex, limit: Int = Int.MAX_VALUE): Pair<List<Vertex>, Int> {
        val path = Stack<Vertex>()
        //необходимо использовать вложенную функцию, чтобы создать замыкания для переменной path
        fun innerDFS(current: Vertex, limit: Int, visited: Set<Vertex> = setOf()): Boolean =
            when {
                current == finish -> true
                limit == 0 -> false
                else -> {
                    current.getNeighbors().filter { it !in visited }.forEach {
                        if (innerDFS(it, limit - 1, visited + current)) {
                            path.push(it)
                            return true
                        } }
                    false
                }
            }
        innerDFS(start, limit)
        path.push(start) //добавляем в начало пути вершину, из которой начали поиск
        return path.reversed() to path.size - 1 //вычитаем из длины пути вершину, из которой начали поиск
    }

    /**
     * Алгоритм поиска в ширину на графах.
     * @return путь от [start] до [finish] и его длину.
     * @link https://www.fandroid.info/8-5-osnovy-kotlin-grafy/4/
     * @link https://brestprog.by/topics/bfs/
     */
    fun BFS(start: Vertex, finish: Vertex): Pair<List<Vertex>, Int> {
        val queue = Stack<Vertex>().apply { this.push(start) }
        val parents = mutableMapOf<Vertex, Vertex?>(start to null) //ключ - вершина, значение - родитель
        val visited = mutableSetOf(start)
        while (queue.isNotEmpty()) {
            val next = queue.pop()
            if (next == finish) {
                var last = finish
                val path = mutableListOf(last)
                while (parents[last] != null) {
                    last = parents[last]!!
                    path.add(last)
                }
                return path.reversed() to path.size - 1
            }
            next.getNeighbors().filter { it !in visited }.forEach {
                queue.add(it)
                parents[it] = next
            } }
        return listOf(start) to 0
    }

    /**
     * Алгоритм поиск с итеративным углублением. Использует в своей реализации [DFS].
     * @return путь от [start] до [finish] и его длину.
     */
    fun IDDFS(start: Vertex, finish: Vertex): Pair<List<Vertex>, Int> =
        generateSequence(1) { it + 1 }.map { DFS(start, finish, it) }.find { it.first.size > 1 }?: listOf(start) to 0

    /**
     * Алгоритм двунаправленного поиск в графе.
     * @return путь от [start] до [finish] и его длину.
     * @link https://www.geeksforgeeks.org/bidirectional-search/
     */
    fun BDS(start: Vertex, finish: Vertex): Pair<List<Vertex>, Int> {
        val sData = Triple(
            mutableListOf(start),                               //очередь
            mutableSetOf(start),                                //посещённые вершины
            mutableMapOf<Vertex, Vertex?>(start to null)        //родители
        )
        val fData = Triple(
            mutableListOf(finish),
            mutableSetOf(finish),
            mutableMapOf<Vertex, Vertex?>(finish to null)
        )
        fun innerBFS(vertexData: Triple<MutableList<Vertex>, MutableSet<Vertex>, MutableMap<Vertex, Vertex?>>) {
            val current = vertexData.first.first()
            vertexData.first.removeAt(0)
            current.getNeighbors().filter { it !in vertexData.second }.forEach {
                vertexData.third[it] = current
                vertexData.second.add(it)
                vertexData.first.add(it)
            }
        }
        while (sData.first.isNotEmpty() && fData.first.isNotEmpty()) {
            innerBFS(sData)
            innerBFS(fData)
            val intersectVertices = sData.second intersect fData.second
            if (intersectVertices.isNotEmpty()) {
                val path = mutableListOf<Vertex>()
                var intersect: Vertex? = intersectVertices.first()
                while (intersect != start) {
                    val parent = sData.third[intersect] ?: break
                    path.add(parent)
                    intersect = parent
                }
                path.reverse()
                intersect = intersectVertices.first()
                while (intersect != finish) {
                    val parent = sData.third[intersect]?: break
                    path.add(parent)
                    intersect = parent
                }
                return path to path.size - 1
            }
        }
        return listOf(start) to 0
    }
}