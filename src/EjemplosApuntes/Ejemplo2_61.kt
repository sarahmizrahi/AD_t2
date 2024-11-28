package EjemplosApuntes

import java.io.*


fun main(args: Array<String>) {

    //Transforma el mismo fichero de una configuracion a otra, lee el byte y lo convierte en caracter
    val f_ent = InputStreamReader(FileInputStream("f5.txt"), "UTF-8")
    val f_sal = OutputStreamWriter(FileOutputStream("f5_ISO.txt"), "ISO-8859-1")

    var car = f_ent.read()
    while (car != -1){  //Mientras sigan habiendo caracteres en el fichero
        f_sal.write(car)    //Escribelos en el fichero de salida
        car = f_ent.read()  //y lee el siguiente caracter si aun no se ha acabado el fichero
    }
    f_ent.close()
    f_sal.close()
}