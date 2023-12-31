import java.io.File

fun advent(file: String): Int{

    var result = 0
    var temp = 0



    File(file).forEachLine { line ->
        val charList: MutableList<Char> = line.toList().toMutableList()


        for (character in charList.reversed()){

            if (character in '0'..'9'){
                temp += character.digitToInt()
                break
            }

        }
        for (character in charList){

            if (character in '0'..'9'){
                temp += character.digitToInt()*10
                break
            }

        }
        result += temp
        temp = 0

    }
    return result

}

fun advent2(file: String): Int{

    var result = 0
    var temp = 0
    File(file).forEachLine { line ->
        val xx: MutableList<String> = mutableListOf()


        for (i in 0..line.length){
            for (j in i..line.length){
                xx.add(line.substring(i,j))


            }


        }



        for (character in xx.reversed()){



            if (character == "one" || character == "1")
            {
                temp += 1
                break
            }
            else if (character == "two"|| character == "2")
            {
                temp += 2
                break
            }
            else if (character == "three"|| character == "3")
            {
                temp += 3
                break
            }
            else if (character == "four"|| character == "4")
            {
                temp += 4
                break
            }
            else if (character == "five"|| character == "5")
            {
                temp += 5
                break
            }
            else if (character == "six"|| character == "6")
            {
                temp += 6
                break
            }
            else if (character == "seven"|| character == "7")
            {
                temp += 7
                break
            }
            else if (character == "eight"|| character == "8")
            {
                temp += 8
                break
            }
            else if (character == "nine"|| character == "9")
            {
                temp += 9
                break
            }





        }
        for (character in xx){



            if (character == "one"|| character == "1")
            {
                temp += 10
                break
            }
            else if (character == "two"|| character == "2")
            {
                temp += 20
                break
            }
            else if (character == "three"|| character == "3")
            {
                temp += 30
                break
            }
            else if (character == "four"|| character == "4")
            {
                temp += 40
                break
            }
            else if (character == "five"|| character == "5")
            {
                temp += 50
                break
            }
            else if (character == "six"|| character == "6")
            {
                temp += 60
                break
            }
            else if (character == "seven"|| character == "7")
            {
                temp += 70
                break
            }
            else if (character == "eight"|| character == "8")
            {
                temp += 80
                break
            }
            else if (character == "nine"|| character == "9")
            {
                temp += 90
                break
            }

        }
        result += temp
        temp = 0

    }
    return result

}


fun main(args: Array<String>) {
    println(advent2("C:\\ZAJO\\Advent5\\src\\main\\resources\\inputzx.txt"))


}