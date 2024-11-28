package Ejercicios

import java.io.*


/*Este primer ejercicio es para el tratamiento de bytes, ya que se tratará de modificar una imagen.
Para poder probarlo, puedes utilizar la imagen Penyagolosa.bmp que se te proporciona en el aula virtual
y debes copiarla en el directorio raíz del proyecto Tema2 para un funcionamiento más cómodo.

No se pretende construir un editor de imágenes. Solo pretendemos tomar la información del archivo byte a byte,
realizar alguna transformación en los bytes y guardarla en otro archivo.

El formato de un archivo bmp, aproximadamente, es el siguiente:

En los primeros 54 bytes se guarda información diversa, como el tamaño de la imagen, la paleta de colores, etc.
A partir de ahí se guarda cada punto de la imagen como 3 bytes, uno para el rojo (R), uno para el verde (G)
 y uno para el azul (B), yendo de izquierda a derecha y de arriba a abajo.

Copia y modifica la clase FitxerImatge en el paquete exercicis, creando los métodos oportunos siguiendo estas pautas:
El constructor FitxerImatge(File fEnt) debe inicializar la propiedad f (File) si y solo si existe el archivo y la
extensión del archivo es .bmp (lo controlaremos simplemente porque el nombre del archivo termina así).
En caso contrario, mostrar los mensajes de error oportunos por la salida estándar.

Los métodos de transformación (transformaNegatiu, transformaObscur y el voluntario transformaBlancNegre)
 deben crear un nuevo archivo que contendrá la imagen transformada como veremos más adelante.
 El nombre del nuevo archivo se debe formar a partir del nombre del archivo de entrada, el que hemos guardado en el constructor.
 Será siempre poniendo antes del .bmp un guión bajo y un identificativo de la transformación realizada:
  _n para el negativo, _o para el oscuro y _bn para el blanco y negro (parte voluntaria).
  Es decir, si el archivo de entrada fuera imatge1.bmp, el de salida deberá ser:

imatge1_n.bmp para el método transformaNegatiu
imatge1_o.bmp para el método transformaObscur
imatge1_bn.bmp para el método voluntario transformaBlancNegre
En cada transformación, los primeros 54 bytes se deben copiar sin modificar: se deben escribir en el archivo de destino tal y como se han leído del archivo de entrada.

A partir del byte 54, cada vez que se lea un byte, se deberá transformar antes de escribirlo en el destino. La transformación es de la siguiente manera:

Para el negativo (transformaNegatiu), cada byte de color (RGB) de cada punto, se debe transformar en el complementario. Como estamos hablando de bytes pero que al leerlos los guardamos en enteros, simplemente será calcular 255 - b (si b es el byte leído).
Para el oscuro (transformaObscur), cada byte de color (RGB) de cada punto, se debe bajar de intensidad a la mitad. Simplemente será calcular b / 2 (si b es el byte leído).
Para el blanco y negro (transformaBlancNegre), que es el voluntario, debemos dar el mismo valor para el rojo, el azul y el verde (RGB) de cada punto, y así conseguiremos un gris de intensidad adecuada. Una buena manera será leer los tres bytes de cada punto (no se aconseja utilizar una lectura con un array de 3 posiciones; mejor hacer tres lecturas guardadas en tres variables diferentes), calcular la media de estos 3 valores, y escribir el resultado 3 veces en el archivo de destino.
En ninguno de los casos anteriores se recomienda la lectura de los bytes en un ByteArray, porque puedes tener resultados imprevisibles debido a la interpretación numérica (y por tanto con signo, cosa que en este caso no tiene sentido, ya que son números del 0 al 255). Se recomienda vivamente leer byte a byte.*/


class FitxerImatge(fEnt: File) {
    var f: File = File("")   //No modifiques esta línea. Su valor se debe modificar en el constructor

    //Constructor
    init {
        //Comprobar que existe y que acabe en .bmp
        if (fEnt.exists() && fEnt.name.endsWith(".bmp")) {
            f = fEnt
        } else {
            println("Error: El archivo no existe.")
        }
    }

    //Metodo para transformar la imagen a negativo
    fun transformaNegatiu() {
        val of = File(f.absolutePath.replace(".bmp", "_n.bmp"))
        transformarImagen(of) { b -> 255 - b }
    }

    //Metodo para transformar la imagen a oscuro
    fun transformaObscur() {
        val of = File(f.absolutePath.replace(".bmp", "_o.bmp"))
        transformarImagen(of) { b -> b / 2 }
    }

    //Metodo para transformar la imagen a blanco y negro (escala de grises)
    fun transformaBlancNegre() {
        val of = File(f.absolutePath.replace(".bmp", "_bn.bmp"))
        transformarImagen(of) { r, g, b ->
            val gris = (r + g + b) / 3
            Triple(gris, gris, gris)
        }
    }

    private fun transformarImagen(outputFile: File, transformacion: (Int) -> Int) {
        FileInputStream(f).use { input ->
            FileOutputStream(outputFile).use { output ->
                //Copiar los primeros 54 bytes sin modificar
                val bytes = ByteArray(54)
                input.read(bytes)
                output.write(bytes)

                //Transformar los bytes restantes
                var byte = input.read()
                while (byte != -1) {
                    val transformedByte = transformacion(byte)
                    output.write(transformedByte)
                    byte = input.read()
                }
            }
        }
    }

    private fun transformarImagen(outputFile: File, transformacion: (Int, Int, Int) -> Triple<Int, Int, Int>) {
        FileInputStream(f).use { input ->
            FileOutputStream(outputFile).use { output ->
                //Copiar los primeros 54 bytes sin modificar
                val ba = ByteArray(54)
                input.read(ba)
                output.write(ba)

                //Transformar los bytes restantes
                var r = input.read()
                var g = input.read()
                var b = input.read()
                while (r != -1 && g != -1 && b != -1) {
                    val (nuevoR, nuevoG, nuevoB) = transformacion(r, g, b)
                    output.write(nuevoR)
                    output.write(nuevoG)
                    output.write(nuevoB)
                    r = input.read()
                    g = input.read()
                    b = input.read()
                }
            }
        }
    }
}


//MAIN
fun main(args: Array<String>) {

    val f = File("Penyagolosa.bmp")

    val fi = FitxerImatge(f)
    fi.transformaNegatiu()
    fi.transformaObscur()
    fi.transformaBlancNegre()
}