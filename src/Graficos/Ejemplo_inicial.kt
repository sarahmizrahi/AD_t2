package Graficos
import javax.swing.*
import java.awt.*

    //OJO, PREGUNTAR POR LA ABUELA DE FER

//Ventana hereda de JFrame
class Ventana : JFrame() {
    //Constructor que inicializa. Construye la ventana
    init {
        val f = GUIForm()
        setContentPane(f.PanelPrincipal)
        f.button1.background= Color.RED
        f.button2.addActionListener{
            JOptionPane.showMessageDialog(null, "Hola")
        }
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        //defaultCloseOperation define que pasa cuando se cierra la ventana
        //JFrame.EXIT_ON_CLOSE, indica que el programa termina cuando se cierra la venta.
        // Importantye para que no continue ejecutandose una vez cerrada la ventana

        //Propiedades de la ventana
        setTitle("Ejemplo botones colocados directamente")      //Titulo
        setSize(400,300)    //Tamaño en pixeles, alto y ancho

        //Componentes
                //setLayout(FlowLayout()) //Coloca los componentes de izquierda a derecha juntos. cuando no caben sigue en la linea de abajo. EN LINEA
                //setLayout(GridLayout(3,2))  //Monta filas y columnas. Empieza por las filas (nºfilas, nºcolumnas)
                                                //Crea filas vacias si no se le pone botones. Tamaños iguales
                //setLayout(BorderLayout())   //5 zonas, añadir parametro para ubicarlo, EJ:add(boton1, BorderLayout.NORTH)

        //JPanel. Etiquetas
        /*setLayout(GridLayout(2,1))
        val panel1 = JPanel(FlowLayout())
        val panel2 = JPanel(GridLayout(2,2))*/


        /*val boton1 = JButton("Boton 1")
        val boton2 = JButton("Boton 2")
        val boton3 = JButton("Boton 3")
        val boton4 = JButton("Boton 4")
        val boton5 = JButton("Boton 5")
        val boton6 = JButton("Boton 6")
        val boton7 = JButton("Boton 7")*/

        /*Añade botones
        add(boton1)
        add(boton2)
        add(boton3)
        add(boton4)
        add(boton5)*/

        /*//Añade paneles
        add(panel1)
        add(panel2)
        //Añade los botones dentro del panel que queremos
        panel1.add(boton1)
        panel1.add(boton2)
        panel1.add(boton3)

        panel2.add(boton4)
        panel2.add(boton5)
        panel2.add(boton6)
        panel2.add(boton7)*/

        //JButton. Boton salir
        /*setLayout(FlowLayout())
        val boton1 = JButton("Salir")
        add(boton1)
        boton1.addActionListener {
            System.exit(0)
        }*/


    }
}

//Main
fun main(args: Array<String>) {
    EventQueue.invokeLater {    //Buena practica para asegurar que se crea y se ve la ventana
        Ventana().isVisible = true  //Crea instancia de la clase Ventana y la hace visible con true
    }
}