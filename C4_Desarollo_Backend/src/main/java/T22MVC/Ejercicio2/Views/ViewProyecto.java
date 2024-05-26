package T22MVC.Ejercicio2.Views;
import javax.swing.*;
import T22MVC.Ejercicio2.ConexionBD;
import T22MVC.Ejercicio2.Controllers.ControllerProyecto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewProyecto extends JFrame {

	private JPanel panelProyectos;
	private JLabel labelID, labelNombre, labelHoras;
	private JTextField textFieldID, textFieldNombre, textFieldHoras;
	private JButton buttonInsertar, buttonMostrar, buttonActualizar, buttonEliminar;
	private JTable tableProyectos;
	private JScrollPane scrollPaneProyectos;
	private ConexionBD conexionBD;
	private ControllerProyecto controllerProyecto;

	public ViewProyecto() {
		configurarVentana();
	//	conexionBD = new ConexionBD();
		agregarComponentes();
	}

	private void configurarVentana() {
		setTitle("Gestión de Proyectos");
		setSize(515, 230);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.LIGHT_GRAY);
	}

	private void agregarComponentes() {
		panelProyectos = new JPanel();
		panelProyectos.setLayout(null);
		getContentPane().add(panelProyectos);

		labelID = new JLabel("ID:");
		labelID.setBounds(20, 40, 80, 20);
		panelProyectos.add(labelID);

		textFieldID = new JTextField();
		textFieldID.setBounds(120, 40, 200, 20);
		panelProyectos.add(textFieldID);

		labelNombre = new JLabel("Nombre:");
		labelNombre.setBounds(20, 85, 80, 20);
		panelProyectos.add(labelNombre);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(120, 88, 200, 20);
		panelProyectos.add(textFieldNombre);

		labelHoras = new JLabel("Horas:");
		labelHoras.setBounds(20, 130, 80, 20);
		panelProyectos.add(labelHoras);

		textFieldHoras = new JTextField();
		textFieldHoras.setBounds(120, 130, 200, 20);
		panelProyectos.add(textFieldHoras);

		buttonInsertar = new JButton("Insertar");
		buttonInsertar.setBounds(380, 20, 100, 30);
		panelProyectos.add(buttonInsertar);

		buttonMostrar = new JButton("Mostrar");
		buttonMostrar.setBounds(380, 60, 100, 30);
		panelProyectos.add(buttonMostrar);

		buttonActualizar = new JButton("Actualizar");
		buttonActualizar.setBounds(380, 100, 100, 30);
		panelProyectos.add(buttonActualizar);

		buttonEliminar = new JButton("Eliminar");
		buttonEliminar.setBounds(380, 140, 100, 30);
		panelProyectos.add(buttonEliminar);
		
		buttonInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = textFieldID.getText();
                String nombre = textFieldNombre.getText();
                int horas = Integer.parseInt(textFieldHoras.getText());
                controllerProyecto.insertarProyecto(ID, nombre, horas);
            }
        });

        buttonMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	controllerProyecto.mostrarProyectos();
            }
        });

        buttonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = textFieldID.getText();
                String nombre = textFieldNombre.getText();
                int horas = Integer.parseInt(textFieldHoras.getText());
                controllerProyecto.actualizarProyecto();
            }
        });

        buttonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = textFieldID.getText();
                controllerProyecto.eliminarProyecto(ID);
            }
        });
	}
	
	   public static void main(String[] args) {
		   
	        ViewProyecto ventanaProyectos = new ViewProyecto();
	        ventanaProyectos.setVisible(true);
	    }
	}
