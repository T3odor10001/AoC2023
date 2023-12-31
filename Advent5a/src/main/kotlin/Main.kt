import java.io.File

fun advent(file: String): Long{


    var temp = 0
    var seeds = listOf<Long>()
    var index = 0

    val dict: MutableMap<Int, MutableList<List<Long>>> = mutableMapOf()
    dict[1] = mutableListOf()
    dict[2] = mutableListOf()
    dict[3] = mutableListOf()
    dict[4] = mutableListOf()
    dict[5] = mutableListOf()
    dict[6] = mutableListOf()
    dict[7] = mutableListOf()

    File(file).forEachLine { line ->
        if (line.contains("seeds", ignoreCase = true)){
            val (keysPart1, numbersPart) = line.split(": ").map { it.trim() }
            seeds = numbersPart.split(" ").map { it.toLong() }
        }
        else if (line.contains("-", ignoreCase = true)){
            index++
        }
        else if (line != ""){
            dict[index]?.add(line.split(" ").map { it.toLong() })
        }

    }
    var result = Long.MAX_VALUE
    for (seed in seeds){
        var actual_seed = seed

        for (i in 1..7){

            for (value in dict[i]!!){
                if (actual_seed in value[1]..(value[1]+value[2]-1)){
                    actual_seed = value[0] + (actual_seed - value[1])
                    break
                }

            }

        }


        result = Math.min(actual_seed, result)

    }


    return result

}

fun advent2(file: String): Long{


    var temp = 0
    var seeds = listOf<Long>()
    var index = 0

    val dict: MutableMap<Int, MutableList<List<Long>>> = mutableMapOf()
    dict[1] = mutableListOf()
    dict[2] = mutableListOf()
    dict[3] = mutableListOf()
    dict[4] = mutableListOf()
    dict[5] = mutableListOf()
    dict[6] = mutableListOf()
    dict[7] = mutableListOf()

    File(file).forEachLine { line ->
        if (line.contains("seeds", ignoreCase = true)){
            val (keysPart1, numbersPart) = line.split(": ").map { it.trim() }
            seeds = numbersPart.split(" ").map { it.toLong() }
        }
        else if (line.contains("-", ignoreCase = true)){
            index++
        }
        else if (line != ""){
            dict[index]?.add(line.split(" ").map { it.toLong() })
        }

    }
    var result = Long.MAX_VALUE
    var first_stage = mutableListOf<Long>()
    first_stage = seeds.toMutableList()
    var second_stage = mutableListOf<Long>()


    for (x in 1..7) {


        while (first_stage.size != 0){
            var actual_seed = first_stage[0]

            var actual_range = first_stage[1]
            first_stage.removeAt(0)
            first_stage.removeAt(0)


            var sides = mutableListOf<Long>()
            var checker = true

            for (value in dict[x]!!) {


                if (actual_seed in value[1]..(value[1]+value[2]-1)){
                    var how_many_numbers = value[2] - (actual_seed -value[1])

                    if (how_many_numbers >= actual_range){

                        second_stage.add(value[0] + (actual_seed - value[1]))
                        second_stage.add(actual_range)
                        checker = false
                        break
                    }
                    else{
                        second_stage.add(value[0] + (actual_seed - value[1]))
                        second_stage.add(how_many_numbers)

                        //dsdsd
                        first_stage.add(actual_seed+how_many_numbers)
                        first_stage.add(actual_range-how_many_numbers)
                        checker = false
                        break
                    }

                }

                else if ((actual_seed + actual_range -1) in value[1]..(value[1]+value[2]-1)){
                    var how_many = ((actual_seed + actual_range -1) - value[1]) +1
                    //sasas
                    first_stage.add(actual_seed)
                    first_stage.add(actual_range-how_many)

                    second_stage.add(value[0] + ((actual_seed + actual_range - how_many) - value[1]))
                    second_stage.add(how_many)
                    checker = false
                    break

                }






            }
            if (checker){
                second_stage.add(actual_seed)
                second_stage.add(actual_range)
            }




        }

        //println(second_stage)
        first_stage = second_stage
        second_stage = mutableListOf()

    }





    var result_list = mutableListOf<Long>()
    for (indexing in 0..first_stage.size - 1 step 2) {
        var actual_seed = first_stage[indexing]

        var actual_range = first_stage[indexing + 1]

        result_list.add(actual_seed)

    }

    return result_list.min()

}




fun main(args: Array<String>) {
    println(advent2("C:\\ZAJO\\Advent5a\\src\\main\\resources\\inputzz.txt"))


}