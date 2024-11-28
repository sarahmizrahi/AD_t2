package EjemplosApuntes

import java.io.File

fun main() {
    val texto = "Contenido para el fichero."
    File("f3.txt").writeBytes(texto.toByteArray())
}