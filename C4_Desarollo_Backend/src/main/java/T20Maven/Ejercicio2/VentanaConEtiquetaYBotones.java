package T20Maven.Ejercicio2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import T20Maven.Ejercicio1.VentanaConEtiqueta;

public class VentanaConEtiquetaYBotones extends JFrame {

	private JPanel panelPrincipal;
	private JLabel etiqueta;
	private JButton boton1;
	private JButton boton2;

	public VentanaConEtiquetaYBotones() {
		configurarVentana();
		agregarComponentes();
	}

	private void configurarVentana() {
		setTitle("Ventana con Etiqueta y Botones");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		java.net.URL imgURL = VentanaConEtiqueta.class.getClassLoader().getResource("icon/Tulip.png");
		ImageIcon icono = new ImageIcon(imgURL);
		setIconImage(icono.getImage());
	}


	private void agregarComponentes() {
	    panelPrincipal = new JPanel();
	    panelPrincipal.setLayout(new BorderLayout());
	    panelPrincipal.setBackground(new Color(204, 255, 204));

	    etiqueta = new JLabel("<html><span style='font-family: Courier New; font-size: 14px; color: green;'>Último botón presionado:</span> <span style='font-family: Courier New; font-size: 16px; color: white;'>Ninguno</span></html>", SwingConstants.CENTER);
	    etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
	    panelPrincipal.add(etiqueta, BorderLayout.CENTER);

	    JPanel panelBotones = new JPanel(new FlowLayout()); 
	    panelBotones.setBackground(new Color(204, 255, 204));

	    java.net.URL imgURL1 = VentanaConEtiquetaYBotones.class.getClassLoader().getResource("icon/Hibiscus.png");
	    ImageIcon iconoFlor1 = new ImageIcon(imgURL1);
	    Image imgFlor1 = iconoFlor1.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    iconoFlor1 = new ImageIcon(imgFlor1);
	    boton1 = new JButton(iconoFlor1);
	    boton1.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            etiqueta.setText(
	                    "<html><span style='font-family: Courier New; font-size: 14px; color: green;'>Último botón presionado:</span> <span style='font-family: Courier New; font-size: 16px; color: #e40078;'>Botón 1</span></html>");
	        }
	    });
	    panelBotones.add(boton1);

	    java.net.URL imgURL2 = VentanaConEtiquetaYBotones.class.getClassLoader().getResource("icon/Blossom.png");
	    ImageIcon iconoFlor2 = new ImageIcon(imgURL2);
	    Image imgFlor2 = iconoFlor2.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    iconoFlor2 = new ImageIcon(imgFlor2);
	    boton2 = new JButton(iconoFlor2);
	    boton2.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            etiqueta.setText(
	                    "<html><span style='font-family: Courier New; font-size: 14px; color: green;'>Último botón presionado:</span> <span style='font-family: Courier New; font-size: 16px; color: #e40078;'>Botón 2</span></html>");
	        }
	    });
	    panelBotones.add(boton2);

	    panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

	    getContentPane().add(panelPrincipal);
	}
}