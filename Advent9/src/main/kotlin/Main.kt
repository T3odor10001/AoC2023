import java.io.File

fun removeMultipleSpaces(input: String): String {
    return input.replace(Regex("\\s+"), " ")
}

fun advent(file: String): Long {

    val dict: MutableMap<Int, Int> = mutableMapOf()
    var result = 0L
    var temp = 0

    File(file).forEachLine { line ->
        var keys = line.split(" ").map { it.toLong() }.toMutableList()

        var second: MutableList<Long> = mutableListOf()

        var last: MutableList<Long> = mutableListOf()


        while (!keys.all { it == 0L }){
            last.add(keys[0])
            for (index in 0..keys.size-2){
                var number1 = keys[index]
                var number2 = keys[index+1]
                second.add(number2 - number1)


            }





            keys = second
            second = mutableListOf()


        }
        var xx = 0L


        for (prvok in last.reversed()){
            xx = prvok - xx

        }

        result += xx


    }

    return result

}


fun main(args: Array<String>) {
    println(advent("C:\\ZAJO\\Advent9\\src\\main\\resources\\sdssss.txt"))

}