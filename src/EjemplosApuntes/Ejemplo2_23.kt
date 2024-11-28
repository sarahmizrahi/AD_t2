package EjemplosApuntes

import java.io.*

fun main(args: Array<String>) {

    //Muestra todos los caracteres con FileReader
    //En el ejemplo esta mal, corregido
    val f_in = FileReader("f2.txt")
    var buffer = CharArray(30)
    var n = f_in.read(buffer)

    while (n != -1) {
        for (i in 0 until n) {  //Correccion, antes in 0..n
            print(buffer[i])          //Correccion, antes (buffer[i].toChar()). toChar() no es necesario porque arriba se usa CharArray()
        }
        println("") //Imprime linea
        n = f_in.read(buffer)
    }
    f_in.close()
}