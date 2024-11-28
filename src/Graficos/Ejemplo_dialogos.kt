package Graficos

import java.awt.*
import javax.swing.*


//Se crean 2 clases, una por ventana.
//Cuando se abre la ventana secundaria, hasta que no se ciarra no se puede volver a la principal

class Ventana6 : JFrame(){
    val boton1 = JButton("Boton 1")

    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setTitle("Ejemplo de JDialog")
        setSize(400, 300)
        setLocationRelativeTo(null)
        setLayout(GridLayout(2, 1))
        val panell1 = JPanel(FlowLayout())
        val panell2 = JPanel(FlowLayout())
        add(panell1)
        add(panell2)

        panell1.add(JLabel("Programa principal. Para volver al dialogo clica el boton"))
        panell2.add(boton1)

        boton1.addActionListener {
            println("Abriendo dialogo")
            Ventana_dialogo(this)   //Hace referencia a la ventana actual
        }

    }
}



class Ventana_dialogo(f: Ventana6) : JDialog(f,"Dialogo",true) {
    init {
        setSize(200, 100)
        setLocationRelativeTo(null)
        val panell = JPanel()
        panell.add(JLabel("Hola, que tal?"))
        add(panell)
        setVisible(true)
    }
}


//Main
fun main(args: Array<String>) {
    EventQueue.invokeLater {    //Buena practica para asegurar que se crea y se ve la ventana
        Ventana6().isVisible = true  //Crea instancia de la clase Ventana y la hace visible con true
    }
}