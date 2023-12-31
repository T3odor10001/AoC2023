import java.io.File

fun advent(file: String): Int{
    val listOfLists: MutableList<MutableList<Char>> = mutableListOf()

    File(file).forEachLine { line ->
        val charList: MutableList<Char> = line.toList().toMutableList()

        listOfLists.add(charList)
    }

    var result = 0
    var temp = 0
    var multi = 1
    var count = false

    val directions = listOf(
        Pair(-1, -1), Pair(-1, 0), Pair(-1, 1),
        Pair(0, -1),                Pair(0, 1),
        Pair(1, -1), Pair(1, 0), Pair(1, 1)
    )



    for ((riadok, i) in listOfLists.withIndex()) {

        for ((stlpec, character) in i.reversed().withIndex()) {

            /*print(character)
            print(" ")
            print(temp)
            print(" ")
            println()*/
            if (character in '0'..'9') {
                /*println()
                print(character)
                print(" toto je cislo")
                /*print(temp)
                print(" ")*/
                println()*/


                for ((dr, dc) in directions) {
                    val newRow = riadok + dr
                    val newCol = listOfLists[0].size - 1 - stlpec + dc




                    if (newRow in 0 until listOfLists.size && newCol in 0 until listOfLists[0].size) {

                        if (listOfLists[newRow][newCol] !in '0'..'9' && listOfLists[newRow][newCol] != '.'){
                            count = true
                        }
                    }
                }



                temp += character.digitToInt() * multi
                multi *= 10


            }


            else{
                if (count){
                    result += temp
                }
                temp = 0
                multi = 1
                count = false
            }



        }
        if (count){
            result += temp
        }

        temp = 0
        multi = 1
        count = false
    }



    return result
}




fun advent2(file: String): Int{
    val listOfLists: MutableList<MutableList<Char>> = mutableListOf()

    File(file).forEachLine { line ->
        val charList: MutableList<Char> = line.toList().toMutableList()

        listOfLists.add(charList)
    }

    var result = 0
    var temp = 0
    var multi = 1
    var count = false

    val directions = listOf(
        Pair(-1, -1), Pair(-1, 0), Pair(-1, 1),
        Pair(0, -1),                Pair(0, 1),
        Pair(1, -1), Pair(1, 0), Pair(1, 1)
    )

    val dict: MutableMap<Pair<Int, Int>, MutableList<Int>> = mutableMapOf()

    var par: Pair<Int, Int> = Pair(1, 2)


    for ((riadok, i) in listOfLists.withIndex()) {

        for ((stlpec, character) in i.reversed().withIndex()) {

            if (character in '0'..'9') {



                for ((dr, dc) in directions) {
                    val newRow = riadok + dr
                    val newCol = listOfLists[0].size - 1 - stlpec + dc




                    if (newRow in 0 until listOfLists.size && newCol in 0 until listOfLists[0].size) {

                        if (listOfLists[newRow][newCol] !in '0'..'9' && listOfLists[newRow][newCol] != '.'){
                            count = true
                            par = Pair(newRow,newCol)
                        }
                    }
                }



                temp += character.digitToInt() * multi
                multi *= 10


            }


            else{
                if (count){

                    if (!dict.containsKey(par)){
                        dict[par] = mutableListOf()
                    }
                    dict[par]?.add(temp)



                }
                temp = 0
                multi = 1
                count = false

            }



        }
        if (count) {
            if (!dict.containsKey(par)) {
                dict[par] = mutableListOf()
            }
            if (temp != 0) dict[par]?.add(temp)
        }
        temp = 0
        multi = 1
        count = false

    }

    for ((key, values) in dict) {
        if (values.size == 2) {

            val multiplication = values[0] * values[1]

            result += multiplication
        }
    }

    return result
}





fun main(args: Array<String>) {
    println(advent2("C:\\ZAJO\\Advent3\\src\\main\\resources\\input.txt"))


}