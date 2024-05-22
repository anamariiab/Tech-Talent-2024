package T20Maven.Ejercicio3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaConEtiquetasYBotones extends JFrame {

	  private JPanel panelPrincipal;
	    private JLabel etiquetaBoton1;
	    private JLabel etiquetaBoton2;
	    private JButton boton1;
	    private JButton boton2;
	    private int contadorBoton1 = 0;
	    private int contadorBoton2 = 0;

	    public VentanaConEtiquetasYBotones() {
	        configurarVentana();
	        agregarComponentes();
	    }

	    private void configurarVentana() {
	        setTitle("Ventana con Etiquetas y Botones");
	        setSize(400, 200);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);

	        java.net.URL imgURL = VentanaConEtiquetasYBotones.class.getClassLoader().getResource("icon/Penguin2.png");
	        ImageIcon icono = new ImageIcon(imgURL);
	        setIconImage(icono.getImage());
	    }

	    private void agregarComponentes() {
	        panelPrincipal = new JPanel();
	        panelPrincipal.setLayout(new BorderLayout());
	        panelPrincipal.setBackground(new Color(255, 255, 204));

	        etiquetaBoton1 = new JLabel("<html><span style='font-family: Courier New; font-size: 16px; color: #ff0080;'>Botón 1: 0 clics</span></html>", SwingConstants.CENTER);
	        etiquetaBoton1.setHorizontalAlignment(SwingConstants.CENTER);
	        panelPrincipal.add(etiquetaBoton1, BorderLayout.NORTH);

	        etiquetaBoton2 = new JLabel("<html><span style='font-family: Courier New; font-size: 16px; color: #ff0080;'>Botón 2: 0 clics</span></html>", SwingConstants.CENTER);
	        etiquetaBoton2.setHorizontalAlignment(SwingConstants.CENTER);
	        panelPrincipal.add(etiquetaBoton2, BorderLayout.CENTER);

	        JPanel panelBotones = new JPanel(new FlowLayout());
	        panelBotones.setBackground(new Color(255, 255, 204));

	        java.net.URL imgURL1 = VentanaConEtiquetasYBotones.class.getClassLoader().getResource("icon/RabbitFace.png");
	        ImageIcon iconoFlor1 = new ImageIcon(imgURL1);
	        Image imgFlor1 = iconoFlor1.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
	        iconoFlor1 = new ImageIcon(imgFlor1);
	        boton1 = new JButton(iconoFlor1);
	        boton1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                contadorBoton1++;
	                etiquetaBoton1.setText(
	                    "<html><span style='font-family: Courier New; font-size: 16px; color: gray;'>Botón 1: " + contadorBoton1 + " clics</span></html>"
	                );
	            }
	        });
	        panelBotones.add(boton1);

	        java.net.URL imgURL2 = VentanaConEtiquetasYBotones.class.getClassLoader().getResource("icon/PigFace.png");
	        ImageIcon iconoFlor2 = new ImageIcon(imgURL2);
	        Image imgFlor2 = iconoFlor2.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
	        iconoFlor2 = new ImageIcon(imgFlor2);
	        boton2 = new JButton(iconoFlor2);
	        boton2.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                contadorBoton2++;
	                etiquetaBoton2.setText(
	                    "<html><span style='font-family: Courier New; font-size: 16px; color: gray;'>Botón 2: " + contadorBoton2 + " clics</span></html>"
	                );
	            }
	        });
	        panelBotones.add(boton2);

	        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

	        getContentPane().add(panelPrincipal);
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                new VentanaConEtiquetasYBotones().setVisible(true);
	            }
	        });
	    }
	}