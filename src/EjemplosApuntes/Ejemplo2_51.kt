package EjemplosApuntes

import java.io.*


fun main(args: Array<String>) {

    //Copiar el contenido de f7.txt y modificarlo, linea por linea
    val f_ent = BufferedReader(FileReader("f7_ent.txt"))    //Para leer linea por linea
    val f_sal = PrintWriter(FileWriter("f7_sal.txt"))   //Para escribir linea por linea
    var cad = f_ent.readLine(); //Lee la primera linea y lo almacena en cad. Se crea "cad" porque representa cada linea
    var i = 0       //contador para numerar las lineas

    while (cad != null) {   //Mientras cad (linea) sea nulo(mientras sigan habiendo lineas)
        i++     //Incrementa el contador para saber por que linea va
        f_sal.println("" + i + ".- " + cad)     //Al archivo de salida escribele la linea cad. i será el numero de veces/lineas que se ejecuta el bucle
        cad = f_ent.readLine()      //Lee la siguiente linea
    }
    f_ent.close()
    f_sal.close()
}