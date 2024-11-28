package EjemplosApuntes

import java.io.File
import java.io.FileReader

fun main() {
    val todo = File("f1.txt").readText()
    for (c in todo){
        println(c)
    }
}