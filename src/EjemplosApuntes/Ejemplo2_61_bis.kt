package EjemplosApuntes

import java.io.*


fun main() {

    File("f5_2.txt").writeText(File("f5.txt").readText(), Charsets.ISO_8859_1)

}