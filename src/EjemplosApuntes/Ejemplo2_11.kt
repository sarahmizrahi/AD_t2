package EjemplosApuntes

import java.io.FileOutputStream

fun main(args: Array<String>) {
    val text = "Contenido para el fichero"
    val f_out = FileOutputStream("f3.txt", true)  //Crea el archivo para su escritura de bytes, si no existe lo crea, si ya existe lo sobreescribe
                                                //true para añadir en lugar de sobreescribir, sin true, se sobreescribe
    for (c in text)     //Recorre cada caracter de text
        f_out.write(c.code)  //Y lo introduce en el archivo. toInt() convierte cada caracter a su valor numerico
                                //write() acepta enteros
    f_out.close()
}