package EjemplosApuntes

import java.io.File

fun main() {

    val f = File("f1.txt")  //Guarda en f el archivo
    val todo = f.readBytes()    //f1 se trata como una secuencia de bytes.
                                // readBytes() lee el archivo como un array

    for (c in todo){    //Recorre los bytes leidos
        println(c.toChar()) //y los imprime conviertidos en caracteres
    }
}