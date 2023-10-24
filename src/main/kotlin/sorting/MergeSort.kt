package sorting

class MergeSort {

    fun sort(source: IntArray): IntArray{
        if(source.size == 1) return source
        val leftSize = source.size / 2

        val left = IntArray(size = leftSize)
        val right = IntArray(size = source.size - leftSize)
        for(i in source.indices){
            if(i < leftSize){
                left[i] = source[i]
            }else{
                right[i-leftSize] = source[i]
            }
        }

//        println("Left ${left.joinToString(", ")}")
//        println("Right ${right.joinToString(", ")}")

        return merge(
            sort(left),
            sort(right),
            source
        )
    }

    private fun merge(left: IntArray, right: IntArray, source: IntArray): IntArray{
        var i = 0
        var l = 0
        var r = 0

//        println("Before ${source.joinToString(", ")}")
        while ( i < source.size){
            val valueL = left.getOrNull(l) ?: Int.MAX_VALUE
            val valueR = right.getOrNull(r) ?: Int.MAX_VALUE
            if (valueL < valueR) {
                source[i] = valueL
                l++
            } else {
                source[i] = valueR
                r++
            }
            i++
        }
//        println("After ${source.joinToString(", ")}")
        return source
    }
}