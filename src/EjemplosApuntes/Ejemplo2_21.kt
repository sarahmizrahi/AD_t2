package EjemplosApuntes

import java.io.FileReader

fun main(args: Array<String>) {

    //FileReader permite que se lean todos los caracteres, pero no me sale así
    val f_in = FileReader("f1.txt")
    var c = f_in.read()

    while (c != -1){
        println(c.toChar())
        c = f_in.read()
    }
    f_in.close()
}