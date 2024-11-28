package EjemplosApuntes

import java.io.ByteArrayInputStream
import java.io.FileInputStream
import java.io.SequenceInputStream

fun main(args: Array<String>) {

    val f1 = FileInputStream("f1.txt")
    val ent_1 = "Esto es un byte array"
    val f2 = ByteArrayInputStream(ent_1.toByteArray())
    val f_in = SequenceInputStream(f1, f2) //Combina los flujos para leerlos en ese orden, para leerlos como un unico archivo

    var c = f_in.read()

    while (c != -1){
        println(c.toChar())
        c = f_in.read()
    }
    f_in.close()
}