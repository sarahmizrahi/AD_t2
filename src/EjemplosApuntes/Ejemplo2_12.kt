package EjemplosApuntes

import java.io.FileInputStream
import java.io.FileOutputStream

fun main(args: Array<String>) {

    //Copiar el contenido de f2.txt a f4.txt
    val f_in = FileInputStream("f2.txt")    //Abre y lee f2.txt
    val f_out = FileOutputStream("f4.txt")  //Crea y abre f4.txt

    var buffer = ByteArray(30)  //Buffer para almacenar 30 bytes
    var num = f_in.read(buffer)     //Lee f2.txt(f_in) y los lamacena en el buffer

    while (num != -1) {
        f_out.write(buffer, 0, num)     //Ecribe en f4.txt (f_out) el contenido del buffer
        num = f_in.read(buffer)  //Lee el siguiente bloque hasta que se acabe, y no sea infinito
    }
    f_in.close()
    f_out.close()
}