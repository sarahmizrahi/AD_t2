package EjemplosApuntes

import java.io.BufferedReader
import java.io.FileOutputStream
import java.io.FileReader
import java.io.OutputStreamWriter
import java.io.PrintWriter

fun main(args: Array<String>) {

    //Mismo programa que el Ejemplo2_61
    //Pero en este se irá leyendo linea por linea

    val f_ent = BufferedReader(FileReader("f5.txt"))    //Leer el archivo linea por linea
    val f_sal = PrintWriter(OutputStreamWriter(FileOutputStream("f5_ISO.txt"), "ISO-8859-1"))
                //Crea "f5_ISO.txt" para escritura
                //FileOutputStream abre el archivo en modo escritura.
                //OutputStreamWriter especifica la codificación de caracteres ISO-8859-1
                //PrintWriter escribe líneas

    var cad = f_ent.readLine()
    while (cad != null) {
        f_sal.println(cad)
        cad = f_ent.readLine()
    }
    f_ent.close()
    f_sal.close()
}