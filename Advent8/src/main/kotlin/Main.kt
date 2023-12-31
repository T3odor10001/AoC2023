import java.io.File
import kotlin.math.abs



fun advent(file: String): Long {

    val dict: MutableMap<String, List<String>> = mutableMapOf()

    var temp = 0
    var charList: MutableList<Char> = mutableListOf()
    File(file).forEachLine { line ->
        if (line != "") {
            if (temp == 0) {

                charList = line.toList().toMutableList()

                temp++
            } else {
                var liner = line
                liner = liner.replace("(", "")
                liner = liner.replace(",", "")
                liner = liner.replace(")", "")



                val (keysPart1, numbersPart) = liner.split(" = ").map { it.trim() }
                val xx = numbersPart.split(" ")
                dict[keysPart1] = xx

            }
        }

    }

    var result = 0L

    var kluce: MutableList<String> = mutableListOf()
    for (k in dict.keys){

        if (k[2] == 'A') kluce.add(k)

    }

    var resultx: MutableList<Long> = mutableListOf()
    for (kluc in kluce) {
        resultx.add(find_first(charList, kluc, dict))
    }


    println(resultx)

    return lcmOfList(resultx)

}

fun find_first(charList: MutableList<Char>, start: String, dict: MutableMap<String, List<String>>): Long{


    var kluc = start
    var result = 0L
    while (true){
        for (char in charList){


        if (char == 'L') {
            kluc = dict[kluc]?.get(0).toString()

        } else {
            kluc = dict[kluc]?.get(1).toString()

        }
        result++
        if (kluc[2] == 'Z') return result




        }
    }



    return result



}


fun gcd(a: Long, b: Long): Long {
    return if (b == 0L) a else gcd(b, a % b)
}

fun lcm(a: Long, b: Long): Long {
    return kotlin.math.abs(a * b) / gcd(a, b)
}

fun lcmOfList(numbers: MutableList<Long>): Long {
    return numbers.reduce { acc, num -> lcm(acc, num.toLong()) }
}


fun main(args: Array<String>) {
    println(advent("C:\\ZAJO\\Advent8\\src\\main\\resources\\dsinpudst.txt"))
}