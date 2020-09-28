/**
 * Вершина графа. [name] - название вершины.
 * @author Кульбако Артемий
 */
data class Vertex(val name: String): Comparable<Vertex> {

    private val neighbors = mutableMapOf<Vertex, Int>()
    var heuristicMark: Int = 0

    /**
     * Соединить вершину с вершиной [v]. [length] - вес ребра.
     */
    fun link(v: Vertex, length: Int) {
        this.neighbors[v] = length
        v.neighbors[this] = length
    }

    /**
     * Соединить вершину с вершиной [v].
     */
    //В предыдущей реализации параметр по умолчанию не использовался, чтобы сохранить инфиксную форму.
    infix fun link(v: Vertex) = link(v, 1)

    /**
     * Разорвать связь с вершиной [v].
     */
    infix fun unlink(v: Vertex) {
        this.neighbors.remove(v)
        v.neighbors.remove(this)
    }

    /**
     * @return прямых соседей вершины, без возможности редактировать их, во избежание нарушения целостности графа.
     */
    fun getNeighbors() = this.neighbors.toMap()

    override fun compareTo(other: Vertex) = this.heuristicMark - other.heuristicMark
}