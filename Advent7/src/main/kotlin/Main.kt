import java.io.File

fun advent(file: String): Int {

    val main: MutableMap<Int, MutableList<MutableList<String>>> = mutableMapOf()
    main[7] = mutableListOf()
    main[6] = mutableListOf()
    main[5] = mutableListOf()
    main[4] = mutableListOf()
    main[3] = mutableListOf()
    main[2] = mutableListOf()
    main[1] = mutableListOf()

    var temp = 0
    File(file).forEachLine { line ->
        temp++
        val (keysPart1, numbersPart) = line.split(" ").map { it.trim() }
        val dict: MutableMap<Char, Int> = mutableMapOf()

        var zolik = 0
        for (char in keysPart1){
            if (char == 'J') zolik++
            else {
                if (char !in dict) dict[char] = 0
                dict[char] = dict[char]!! + 1
            }
        }
        var x: MutableList<Int> = mutableListOf()
        for (key in dict.keys) dict[key]?.let { x.add(it) }
        x.sortDescending()

        if (x.size == 0) main[7]?.add(mutableListOf(keysPart1, numbersPart))
        else {
            x[0] += zolik

            if (x.size == 1) main[7]?.add(mutableListOf(keysPart1, numbersPart))
            if (x.size == 2) {
                if (x[0] == 4 && x[1] == 1) main[6]?.add(mutableListOf(keysPart1, numbersPart))
                else main[5]?.add(mutableListOf(keysPart1, numbersPart))
            }
            if (x.size == 3) {
                if (x[0] == 3 && x[1] == 1 && x[2] == 1) main[4]?.add(mutableListOf(keysPart1, numbersPart))
                else main[3]?.add(mutableListOf(keysPart1, numbersPart))
            }
            if (x.size == 4) main[2]?.add(mutableListOf(keysPart1, numbersPart))
            if (x.size == 5) main[1]?.add(mutableListOf(keysPart1, numbersPart))
        }



    }

    var index = 1
    var result = 0
    //vyhra
    for (key in main.keys.sorted()){
        //dd = [[T55J5, 684], [QQQJA, 483]]
        var dd = main[key]
        var qw: MutableList<MutableList<Int>> = mutableListOf()
        if (dd != null) {
            // klas = [QQQJA, 483]
            for (klas in dd){
                var temporary: MutableList<Int> = mutableListOf()
                for (character in klas[0]){

                    when (character){
                        'A' -> temporary.add(13)
                        'K' -> temporary.add(12)
                        'Q' -> temporary.add(11)
                        'J' -> temporary.add(1)
                        'T' -> temporary.add(10)
                        else -> temporary.add(character.digitToInt())
                    }
                }

                temporary.add(klas[1].toInt())
                qw.add(temporary)
            }


        }
        println(qw)
        qw.sortWith { a, b ->
            var i = 0
            while (i < a.size && i < b.size) {
                if (a[i] != b[i]) {
                    return@sortWith a[i] - b[i]
                }
                i++
            }
            a.size - b.size
        }
        println(qw)

        qw.forEach {
            result += it[5] * index
            index++
        }

    }




    return result

}


fun main(args: Array<String>) {
    println(advent("C:\\ZAJO\\Advent7\\src\\main\\resources\\dsinput.txt"))
}