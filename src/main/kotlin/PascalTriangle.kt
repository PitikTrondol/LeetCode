import kotlin.math.min

class PascalTriangle(private val rowIndex: Int) : Solution{
    override fun proof() {
        println("Index $rowIndex")
        println("Result ${getRow(rowIndex).joinToString(", ")}")
    }

    private fun getRow(row: Int): List<Long>{
        if(row < 0 ) return emptyList()

        val result = mutableListOf<Long>()
        (0 until row + 1).forEach {k->
            var value: Long = 1
            val mid = min(k, row-k)
            (0 until mid).forEach {i->
                value = value * (row-i)/(i+1)
            }

            result.add(value)
        }

        return result
    }
}