import java.io.File

fun removeMultipleSpaces(input: String): String {
    return input.replace(Regex("\\s+"), " ")
}

fun advent(file: String): Long {

    val dict: MutableList<List<Long>> = mutableListOf()
    var result = 1L
    var temp = 0
    File(file).forEachLine { line ->


        var (keysPart1, numbersPart) = line.split(":").map { it.trim() }
        numbersPart = numbersPart.replace(" ", "")

        val keys = removeMultipleSpaces(numbersPart).split(" ").map { it.toLong() }
        dict.add(keys)
    }


    for (index in 0..dict[0].size-1){


        var temp = 0
        for (i in 0..dict[0][index]){

            var x = dict[0][index] - i
            var speed = i

            var traveled = x * speed

            if (dict[1][index] < traveled) temp++

        }


        result *= temp

    }


    println(dict)
    return result
}


fun main(args: Array<String>) {
    println(advent("C:\\ZAJO\\Advent6\\src\\main\\resources\\qweinput.txt"))

}