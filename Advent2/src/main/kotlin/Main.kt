import java.io.File

fun advent(file: String): Int{

    var result = 0
    var temp = 1

    val dict: MutableMap<Int, MutableList<Int>> = mutableMapOf()

    File(file).forEachLine { line ->
        var (keysPart1, numbersPart) = line.split(": ").map { it.trim() }
        numbersPart = numbersPart.replace(",", "")
        numbersPart =  numbersPart.replace(";", "")
        val xx = numbersPart.split(" ").map { it.trim() }
        dict[temp] = MutableList(3) { 0 }

        for (index in 0..xx.size-1 step 2){

            var number = xx[index].toInt()
            var color =xx[index+1]


            if (color == "red") {
                dict[temp]?.set(0, Math.max(dict[temp]!!.get(0), number))
            }
            if (color == "green") {
                dict[temp]?.set(1, Math.max(dict[temp]!!.get(1), number))
            }
            if (color == "blue") {
                dict[temp]?.set(2, Math.max(dict[temp]!!.get(2), number))
            }



        }

        result += dict[temp]!!.get(0)*dict[temp]!!.get(1)*dict[temp]!!.get(2)
        /*
        var a = true
        if (dict[temp]!!.get(0) > 12) {
            a = false
        }
        if (dict[temp]!!.get(1) > 13)  a = false
        if (dict[temp]!!.get(2) > 14)  a = false
        if (a) result += temp*/


        temp++
    }




    return result

}

fun main(args: Array<String>) {
    println(advent("C:\\ZAJO\\Advent2\\src\\main\\resources\\inpudst.txt"))


}