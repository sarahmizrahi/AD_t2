package EjemplosApuntes

import java.io.*

fun main(args: Array<String>) {

    //Lee el archivo f1.txt caracter a caracter

    val f_in = FileInputStream("f1.txt")    //Abre el archivo en modo lectura
    var c = f_in.read()     // read() lee el archivo caracter a caracter
                            //Devuelve valor numero en bytes

    while (c != -1){    //Mientras la lectura del archivo en formato byte no llegue a -1 (al final del archivo)
        println(c.toChar())     //Muestra la conversion en caracteres del archivo
        c = f_in.read()     //Lee el siguiente byte del archivo y actualiza la variable c, sin esta linea sería un bucle infinito
    }
    f_in.close()    //Cierra el flujo de entrada
}