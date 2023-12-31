import java.io.File

fun removeMultipleSpaces(input: String): String {
    return input.replace(Regex("\\s+"), " ")
}

fun advent(file: String): Int {

    val dict: MutableMap<Int, Int> = mutableMapOf()
    var result = 0
    var temp = 0
    File(file).forEachLine { line ->
        val (keysPart1, numbersPart) = line.split("|").map { it.trim() }
        val (nothing, keysPart) = keysPart1.split(":").map { it.trim() }

        val keys = removeMultipleSpaces(keysPart).split(" ").map { it.toInt() }


        val numbers = removeMultipleSpaces(numbersPart).split(" ").map { it.toInt() }

        for (number in numbers){
            if (number in keys){
                temp++
            }


        }
        if (temp > 0) {
            result += (Math.pow((2).toDouble(), (temp-1).toDouble())).toInt()
        }

        temp = 0
    }

    return result

}

fun advent2(file: String): Int {

    val dict: MutableMap<Int, Int> = mutableMapOf()
    var result = 0
    var temp = 0
    var ticket = 1
    val lines = File(file).readLines()
    val numberOfLines = lines.size

    for (q in 1..numberOfLines) dict[q] = 1


    File(file).forEachLine { line ->
        val (keysPart1, numbersPart) = line.split("|").map { it.trim() }
        val (nothing, keysPart) = keysPart1.split(":").map { it.trim() }

        val keys = removeMultipleSpaces(keysPart).split(" ").map { it.toInt() }


        val numbers = removeMultipleSpaces(numbersPart).split(" ").map { it.toInt() }

        for (number in numbers){
            if (number in keys){
                temp++
            }


        }
        if (temp > 0) {




            var x = dict[ticket]!!





            for (i in 1..temp){
                if (ticket + i <= numberOfLines) dict[ticket+i] = dict[ticket+i]!! + x


            }


        }

        temp = 0
        ticket++

    }



    for (a in 1..ticket-1){
        if (a in dict) result = result + dict[a]!!
        else result += 1


    }

    return result

}



fun main(args: Array<String>) {
    println(advent2("C:\\ZAJO\\Advent4\\src\\main\\resources\\input.txt"))

}