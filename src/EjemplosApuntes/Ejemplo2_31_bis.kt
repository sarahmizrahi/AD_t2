package EjemplosApuntes

import java.io.*

fun main() {
    val texto ="Contenido para el fichero. Sin miedo a los caracteres especiales: ç, à, ú"
    File("f5.txt").writeText(texto)
}