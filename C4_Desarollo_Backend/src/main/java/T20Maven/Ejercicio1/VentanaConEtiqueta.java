package T20Maven.Ejercicio1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaConEtiqueta extends JFrame {

	private JPanel panelPrincipal;
	private JLabel etiquetaMensaje;
	private String mensaje = "¡Hola, Mundo!";
	private int indice = 0;

	public VentanaConEtiqueta() {
		configurarVentana();
		agregarComponentes();
	}

	private void configurarVentana() {
		setTitle("Ventanita con etiqueta");
		setSize(400, 300); // Ajustar el tamaño
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);

		ImageIcon icono = new ImageIcon(Ejercicio1.class.getClassLoader().getResource("img/CherryBlossom.png"));
		setIconImage(icono.getImage());
	}

	private void agregarComponentes() {
		panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout());
		panelPrincipal.setBackground(Color.lightGray); 

		etiquetaMensaje = new JLabel("", SwingConstants.CENTER);
		etiquetaMensaje.setFont(new Font("Arial", Font.BOLD, 24));
		etiquetaMensaje.setForeground(Color.white);
		panelPrincipal.add(etiquetaMensaje, BorderLayout.CENTER);

		getContentPane().add(panelPrincipal);

		Timer timer = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (indice < mensaje.length()) {
					etiquetaMensaje.setText(etiquetaMensaje.getText() + mensaje.charAt(indice));
					indice++;
				} else {
					((Timer) e.getSource()).stop(); 
				}
			}
		});
		timer.start(); 
	}
}