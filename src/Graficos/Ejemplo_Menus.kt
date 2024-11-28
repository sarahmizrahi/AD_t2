package Graficos

import java.awt.EventQueue
import javax.swing.*

class Ventana5 : JFrame(){

    //

    val menu_principal = JMenuBar()     //Principal, barra de menu

    val menu_1 = JMenu("Menu 1")    //JMenu son elementos del principal, los que se despliegan
    val menu_2 = JMenu("Menu 2")
    val menu_3 = JMenu("Menu 3")
    val menu_11 = JMenuItem("Menu 11")  //JMenuItem realizan acciones
    val menu_12 = JMenu("Menu 12")
    val menu_13 = JMenuItem("Menu 13")
    val menu_21 = JMenuItem("Menu 21")
    val menu_22 = JMenuItem("Menu 22")
    val menu_salir = JMenuItem("Salir")
    val menu_121 = JMenuItem("Menu 121")
    val menu_122 = JMenuItem("Menu 122 (salir)")

    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setTitle("Ejemplo de Menús")
        setSize(400, 300)
        setJMenuBar(menu_principal)     //setJMenuBar permite que se incluyan elementos dentro de otros

        //Componentes
        //Al menu principal añade el 1, 2 y 3
        menu_principal.add(menu_1)
        menu_principal.add(menu_2)
        menu_principal.add(menu_3)
        //Al menu1 añade los siguientes
        menu_1.add(menu_11)
        menu_1.add(menu_12)
        menu_1.add(JSeparator())    //Barras separadoras, una linea que separa el menu12 del 13
        menu_1.add(menu_13)

        //Al menu12 que esta dentro de menu1, añade el 121 y 122
            menu_12.add(menu_121)
            menu_12.add(menu_122)
        //Al menu2 añade los siguientes
        menu_2.add(menu_21)
        menu_2.add(menu_22)
        //Al menu3 añade salir
        menu_3.add(menu_salir)

        //Eventos
        menu_122.addActionListener { salir() }
        menu_salir.addActionListener { salir() }

    }

    fun salir(){
        System.exit(0)
    }
}

//Main
fun main(args: Array<String>) {
    EventQueue.invokeLater {    //Buena practica para asegurar que se crea y se ve la ventana
        Ventana5().isVisible = true  //Crea instancia de la clase Ventana y la hace visible con true
    }
}