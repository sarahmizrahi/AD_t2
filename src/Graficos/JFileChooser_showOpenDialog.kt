package Graficos

import java.awt.*
import javax.swing.*

class Ventana7 : JFrame() {

    //showOpenDialog(). Permite navegar y seleccionar carpetas/ficheros para abrirlos

    val boto1 = JButton("Botó 1")
    val fc = JFileChooser()

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

        panell1.add(JLabel("Programa principal. Per anar al diàleg apreta el botó"))
        panell2.add(boto1)

        boto1.addActionListener {
            val r = fc.showOpenDialog(this)
            if (r == JFileChooser.APPROVE_OPTION) {
                println("Fitxer seleccionat: " + fc.getSelectedFile().getName());
            } else
                println("No s'ha seleccionat res");
        }
    }
}


//Main
fun main(args: Array<String>) {
    EventQueue.invokeLater {    //Buena practica para asegurar que se crea y se ve la ventana
        Ventana7().isVisible = true  //Crea instancia de la clase Ventana y la hace visible con true
    }
}