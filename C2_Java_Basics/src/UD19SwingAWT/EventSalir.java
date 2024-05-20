package UD19SwingAWT;

import javax.swing.*;
import java.awt.event.*;

public class EventSalir extends JFrame {

	public EventSalir() {
        setTitle("Ejemplo de Menú");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Crear la barra de menú
        JMenuBar menuBar = new JMenuBar();
        
        // Crear el menú
        JMenu menu = new JMenu("Archivo");
        
        // Crear la opción de menú "Salir"
        JMenuItem salirItem = new JMenuItem("Salir");
        
        // Agregar un ActionListener al item "Salir"
        salirItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cerrar la ventana cuando se seleccione "Salir"
                dispose();
            }
        });
        
        // Agregar el item "Salir" al menú
        menu.add(salirItem);
        
        // Agregar el menú a la barra de menú
        menuBar.add(menu);
        
        // Establecer la barra de menú en la ventana
        setJMenuBar(menuBar);
    }
}