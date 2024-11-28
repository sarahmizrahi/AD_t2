package EjemplosApuntes


import java.io.*

fun main(args: Array<String>) {

    val f_out = PrintStream("f6.txt") //Crea f6.txt y con PrintStream permite que se imprima mezclando tipos de datos

    val a = 5.25.toFloat()
    val b = "Hola."

    f_out.print(b)  //escribe en el fichero "Hola."
    f_out.println("Que tal?")
    f_out.println(a+3)
    f_out.printf("El numero %d en hexadecimal es %x", 27, 27)   //los argumentos 27, 27 dan valor a %d y %x/printf da formato

    f_out.close()
}