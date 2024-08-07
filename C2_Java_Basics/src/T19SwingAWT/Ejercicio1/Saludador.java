package T19SwingAWT.Ejercicio1;

import java.awt.event.*;
import javax.swing.*;

public class Saludador extends JFrame {

	private JPanel panelPrincipal;

	public Saludador() {
		configurarVentana();
		agregarComponentes();
	}

	private void configurarVentana() {
		setTitle("EL SALUDADOR");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void agregarComponentes() {
		panelPrincipal = new JPanel();
		panelPrincipal.setLayout(null);
		setContentPane(panelPrincipal);

		JLabel etiquetaMensaje = new JLabel("¡Bienvenido/a! ¿Cómo te llamas?");
		etiquetaMensaje.setBounds(30, 50, 250, 20);
		panelPrincipal.add(etiquetaMensaje);

		JTextField campoNombre = new JTextField();
		campoNombre.setBounds(30, 100, 230, 20);
		panelPrincipal.add(campoNombre);

		JButton botonSaludar = new JButton("¡Saludar!");
		botonSaludar.setBounds(100, 150, 100, 20);
		botonSaludar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String nombre = campoNombre.getText();
				if (nombre.isEmpty()) {
					JOptionPane.showMessageDialog(null, "¡Por favor, introduce tu nombre!", "Atención", JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "¡Hola " + nombre + "!");
				}
			}
		});
		panelPrincipal.add(botonSaludar);
	}
}
	
