package EjemplosApuntes

import java.io.*

fun main(args: Array<String>) {

    //Crea f5.txt y escribe el texto, sin problema con los caracteres especiales
    //Corregido. En el ejemplo esta mal.
    val texto = "Contenido para el fichero. Sin miedo a los caracteres especiales: ç, à, ú"
    val f_out = FileWriter("f5.txt", true)  //Usar true para agregar el texto, no es necesario

    for (c in texto){
        f_out.write(c.code)     //En el ejempo "c.toInt()", ya no se usa, se cambia por "c.code"
    }
    f_out.close()
}