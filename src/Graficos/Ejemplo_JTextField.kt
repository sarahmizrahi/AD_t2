package Graficos

import java.awt.EventQueue
import java.awt.FlowLayout
import java.awt.GridLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.JTextField


class Ventana2 : JFrame(){
    val text1 = JTextField(15)  //El parametro indica el tamaño, es opcional
    val text2 = JTextField(15)
    val boton1 = JButton(">>")
    val salir = JButton("Salir")

    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setTitle("Ejemplo de JTextField")
        setSize(500,110)
        setLayout(GridLayout(2,1))
        val panel1 = JPanel(FlowLayout())
        val panel2 = JPanel(FlowLayout())

        add(panel1)
            panel1.add((text1))
            panel1.add((boton1))
            panel1.add((text2))
        add(panel2)
        panel2.add(salir)

        boton1.addActionListener {  //addActionListener, permite que se haga click
            text2.setText(text1.getText())}  //Se ejecuta al hacer click, hace getText obtiene el texto y setText establece el texto obtenido de text1 en text2, lo copia
        salir.addActionListener {
            System.exit(0)}
    }
}

//Main
fun main(args: Array<String>) {
    EventQueue.invokeLater {    //Buena practica para asegurar que se crea y se ve la ventana
        Ventana2().isVisible = true  //Crea instancia de la clase Ventana y la hace visible con true
    }
}