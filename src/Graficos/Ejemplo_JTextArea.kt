package Graficos

import java.awt.*

import javax.swing.*


class Ventana3 : JFrame() {

    //Textos mas grandes

    val t1 = JTextArea(10,35)    //tamañao de filas y columnas
    val salir = JButton("Salir")

    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setTitle("Ejemplo de JTextArea")
        setLayout(BorderLayout(2,1))
        val panel1 = JPanel(FlowLayout())
        val panel2 = JPanel(FlowLayout())

        add(panel1,BorderLayout.CENTER)
        val scroll = JScrollPane(t1)    //IMPORTANTE EL SCROLL, sino habra texto que se quedará oculto
        panel1.add(scroll)      //Añadir el scroll al panel

        add(panel2,BorderLayout.SOUTH)
        panel2.add(salir)

        pack()  //Ajusta el tamaño de la ventana

        salir.addActionListener { System.exit(0) }
    }
}

//Main
fun main(args: Array<String>) {
    EventQueue.invokeLater {    //Buena practica para asegurar que se crea y se ve la ventana
        Ventana3().isVisible = true  //Crea instancia de la clase Ventana y la hace visible con true
    }
}