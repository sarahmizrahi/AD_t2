package EjemplosApuntes

import java.io.*

fun main(args: Array<String>) {

    //Leer datos del archivo f2.txt en bloques de hasta 30 bytes a la vez. Buffer-> matriz de bytes
    val f_in = FileInputStream("f2.txt")    //Se abre el archivo para la lectura
    var buffer = ByteArray(30)  //Crea un array de bytes (buffer) de 30 bytes
                                    //Se almacenan en un buffer los datos leidos antes de procesarlos
    var c = f_in.read(buffer)       //Lee los bytes del buffer y los almacena en c
    while (c != -1){
        for (i in 0..c - 1)     //Recorre el buffer y lo convierte en caracteres
            print(buffer[i].toChar())
        println("")     //Añade linea
        c = f_in.read(buffer)
    }
    f_in.close()
}