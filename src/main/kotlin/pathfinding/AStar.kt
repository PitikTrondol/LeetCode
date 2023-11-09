package pathfinding

class AStar(private val arena: List<List<Node>>) {
    fun findPath(start: Node, target: Node): List<Node> {
        val toSearch = mutableListOf<Node>().apply { add(start) }
        val processed = mutableListOf<Node>()
        val path = mutableListOf<Node>()
        while (toSearch.isNotEmpty()) {
            var current = toSearch.first()

            for (t in toSearch) {
                if (t.f < current.f || t.f == current.f && t.h < current.h) {
                    current = t
                }
            }

            processed.add(current)
            toSearch.remove(current)

            if(current == target){
                var currentPath: Node? = target
                while (currentPath != null){
                    path.add(currentPath)
                    currentPath = currentPath.next
                }

                return path
            }

            val neighbors = searchNeighbors(current)
            for (neighbor in neighbors) {
                if (neighbor.type == 3 || processed.contains(neighbor)) continue

                val isInSearch = toSearch.contains(neighbor)
                val cost = current.g + current.distance(neighbor)

                if (!isInSearch || cost < neighbor.g) {
                    neighbor.setG(cost)
                    neighbor.setNext(current)

                    if (!isInSearch) {
                        neighbor.setH(neighbor.distance(target))
                        toSearch.add(neighbor)
                    }
                }
            }
        }

        return path
    }

    private fun searchNeighbors(current: Node): List<Node> {
        val neighbors = mutableListOf<Node>()
        (current.x - 1..current.x + 1).forEach { x ->
            (current.y - 1..current.y + 1).forEach { y ->
                if (x >= 0 && y >= 0 && x < arena.size && y < arena[0].size) {
                    val candidate = arena[x][y]
                    if (current != candidate) {
                        neighbors.add(candidate)
                    }
                }
            }
        }

        return neighbors
    }
}