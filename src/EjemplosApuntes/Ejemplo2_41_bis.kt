package EjemplosApuntes


import java.io.*

fun main() {

    val f_out = File("f6.txt").printWriter()

    val a = 5.25.toFloat()
    val b = "Hola."
    f_out.print(b)
    f_out.println("Que tal?")
    f_out.println(a+3)
    f_out.printf("El numero %d en hexadecimal es %x", 27, 27)

    f_out.println()
}