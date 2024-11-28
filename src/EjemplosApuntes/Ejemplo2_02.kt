package EjemplosApuntes

import java.io.*

fun main(args: Array<String>) {
    //Mismo que ejemplo 1 pero con byteArray
    val ent_1 = "Este es un byte array"
    val f_in = ByteArrayInputStream(ent_1.toByteArray())    //Lee y almacena los datos de ent_1, que a la vez los convierte en un array de bytes
    var c = f_in.read()     //Lee el array de bytes (f_in) caracter a caracter

    while (c != -1) {
        println(c.toChar()) //La lectura la convierte en caracteres
        c = f_in.read()
    }
    f_in.close()
}