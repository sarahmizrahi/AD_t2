package Graficos

import java.awt.*
import javax.swing.*

class Ventana4 : JFrame() {

    //Lista desplegable

    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setTitle("Ejemplo de JComboBox")
        setSize(400, 300)
        setLayout(FlowLayout()) //Organiza los componentes de forma horizontal

        //Componentes
        add(JLabel("Elige un color"))   //Añade etiqueta
        val lista = arrayOf("Rojo", "Azul", "Verde", "Amarillo")    //Array de lo colores guardados en la variable lista
        val combo = JComboBox(lista)    //Crea la lista y la guarda en combo
        add(combo)  //Añade la lista
        val boton1 = JButton("Color")   //Crea boton
        add(boton1) //Añade el boton

        //Evento
        combo.addActionListener {   //Evento. Se ejecuta al seleccionar un elemento de la lista(del combo box)
            when (combo.getSelectedIndex()) {       //Cuando el indice se haya seleccionado, haz lo siguiente
                0->boton1.setBackground(Color.red)
                1->boton1.setBackground(Color.blue)
                2->boton1.setBackground(Color.green)
                3->boton1.setBackground(Color.yellow)
            }
        }
    }
}

//Main
fun main(args: Array<String>) {
    EventQueue.invokeLater {    //Buena practica para asegurar que se crea y se ve la ventana
        Ventana4().isVisible = true  //Crea instancia de la clase Ventana y la hace visible con true
    }
}