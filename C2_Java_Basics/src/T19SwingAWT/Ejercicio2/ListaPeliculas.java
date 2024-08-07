package T19SwingAWT.Ejercicio2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ListaPeliculas extends JFrame {
	private JPanel panelPrincipal;
	private JTextField campoTitulo;
	private JComboBox<String> comboBoxPeliculas;

	public ListaPeliculas() {
		configurarVentana();
		agregarComponentes();
	}

	private void configurarVentana() {
		setTitle("Lista de películas");
		setSize(470, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void agregarComponentes() {
		panelPrincipal = new JPanel();
		panelPrincipal.setLayout(null);
		setContentPane(panelPrincipal);

		JLabel etiquetaTitulo = new JLabel("Escribe el título de una película.");
		etiquetaTitulo.setBounds(20, 30, 200, 20);
		panelPrincipal.add(etiquetaTitulo);

		campoTitulo = new JTextField();
		campoTitulo.setBounds(30, 80, 150, 20);
		panelPrincipal.add(campoTitulo);

		JLabel etiquetaLista = new JLabel("Películas:");
		etiquetaLista.setBounds(300, 30, 150, 20);
		panelPrincipal.add(etiquetaLista);

		comboBoxPeliculas = new JComboBox<>();
		comboBoxPeliculas.setBounds(250, 80, 150, 20);
		panelPrincipal.add(comboBoxPeliculas);

		JButton botonAdd = new JButton("Añadir");
		botonAdd.setBounds(40, 130, 84, 20);
		botonAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				añadirPelicula();
			}
		});
		panelPrincipal.add(botonAdd);
		
		JButton botonEliminar = new JButton("Eliminar");
        botonEliminar.setBounds(150, 130, 84, 20);
        botonEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarPelicula();
            }
        });
        panelPrincipal.add(botonEliminar);
	}

	private void añadirPelicula() {
		String tituloPelicula = campoTitulo.getText(); 
	    if (!tituloPelicula.isEmpty()) { 
	        comboBoxPeliculas.addItem(tituloPelicula);
	        comboBoxPeliculas.setSelectedItem(tituloPelicula);
	        campoTitulo.setText(""); 
	    } else {
	    	JOptionPane.showMessageDialog(null, "¡Por favor, escribe el título de la pelicula que quieres añadir!", "Atención", JOptionPane.WARNING_MESSAGE);
	    }
	}

	private void eliminarPelicula() {
		int indiceSeleccionado = comboBoxPeliculas.getSelectedIndex();
	    if (indiceSeleccionado != -1) { 
	        comboBoxPeliculas.removeItemAt(indiceSeleccionado);
	    } else {
	        JOptionPane.showMessageDialog(this, "¡Por favor, selecciona la película que quieres eliminar!", "Atención", JOptionPane.WARNING_MESSAGE);
	    }
	}
}