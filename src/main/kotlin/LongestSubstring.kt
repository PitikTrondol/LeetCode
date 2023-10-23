class LongestSubstring(private val s: String) {

    fun lengthOfLongestSubstring(): Int{

        val memoize = mutableMapOf<String, Int>()
        var substring = ""
        var result = substring
        for(char in s) {

//            val stored = memoize[substring]
//            println("Substring [$substring] :: char [$char] :: size [$stored]")
            if(substring.contains(char)) {
                substring = substring.substringAfter(char)+char
                continue
            }

            substring += char
//            println("Bottom $substring")

            if(substring.length > result.length) result = substring
            memoize[result] = result.length
        }
//        println("${log(memoize.keys.joinToString(", "))} :: ${log(result)}")

        return memoize[result] ?: 0
    }

    private fun log(string: String): String{
        return "${Char(182)}- $string -${Char(182)}"
    }
}