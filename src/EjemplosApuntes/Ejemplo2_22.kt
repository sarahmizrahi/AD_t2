package EjemplosApuntes

import java.io.CharArrayReader

fun main(args: Array<String>) {
    //CharArrayReader permite que se lean todos los caracteres bien
    val ent_1 = "Este es un byte array"
    val f_in = CharArrayReader(ent_1.toCharArray())
    var c = f_in.read()
    while (c != -1) {
        print(c.toChar())
        c = f_in.read()
    }
    f_in.close()
}