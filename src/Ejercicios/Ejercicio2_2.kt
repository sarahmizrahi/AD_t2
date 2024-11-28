package Ejercicios

import javax.swing.*
import java.awt.*
import java.io.*


/*En el JTextField de dalt posarem el nom (i ruta) del fitxer.

Quan apretem al botó Obrir ha de bolcar el contingut del fitxer al JTextArea(controlant prèviament que existeix el fitxer).
Quan apretem a Guardar , ha de bolcar el contingut delJTextArea en el fitxer (el nom del qual tenim en el JTextField).*/



class Pantalla : JFrame() {
    val et_f = JLabel("Fichero:")
    val fichero = JTextField(25)
    val abrir = JButton("Abrir")
    val guardar = JButton("Guardar")
    val et_a = JLabel("Contenido:")
    val areaTexto = JTextArea(10, 50)
    val scrollPane = JScrollPane(areaTexto)

    // en iniciar posem un contenidor per als elements anteriors
    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE

        setLayout(GridLayout(2, 1))
        setTitle("Editor de texto")

        val panel1 = JPanel(GridLayout(0, 1))
        val panel1_1 = JPanel(FlowLayout())
        panel1.add(panel1_1)
        panel1_1.add(et_f)
        panel1_1.add(fichero)

        val panel1_2 = JPanel(FlowLayout())
        panel1.add(panel1_2)
        panel1_2.add(abrir)
        panel1_2.add(guardar)
        val panel2 = JPanel(GridLayout(0, 1))
        panel2.add(scrollPane)
        areaTexto.setEditable(true)

        add(panel1)
        add(panel2)
        pack()

        //Abrir y volcar contenido
       // Quan apretem al botó Obrir ha de bolcar el contingut del fitxer al JTextArea(controlant prèviament que existeix el fitxer).
        abrir.addActionListener {
            val rutaArchivo = fichero.text  //Obtiene ruta del archivo. fichero es la variable de arriba JTextField
            val archivo = File(rutaArchivo) //Crear un obj File con la ruta obtenida
            if (archivo.exists() && archivo.isFile){    //Si el archivo existe y es un archivo
                areaTexto.text = archivo.readText() //Lee el contenido del archivo y muestralo en areaTexto
            } else JOptionPane.showMessageDialog(this, "El archivo no existe.") //Sino, error
        }

        //Guardar
       // Quan apretem a Guardar , ha de bolcar el contingut delJTextArea en el fitxer (el nom del qual tenim en el JTextField)
        guardar.addActionListener {
            val rutaAchivo = fichero.text   //Obtiene la ruta del archivo del campo de texto
            val archivo = File(rutaAchivo)  //Crea obj File con la ruta obtenida
            archivo.writeText(areaTexto.text)   //Escribe el contenido de areaTexto en el archivo para guardarlo
        }
    }
}
    private fun crearMostrarVentana() {
        val frame = Pantalla()
        frame.isVisible = true
    }

    //Main
    fun main(args: Array<String>) {
        EventQueue.invokeLater { crearMostrarVentana() }
    }
