package T20Maven.Ejercicio5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaEventosRaton extends JFrame {

    private JTextArea areaDeTexto;

    public VentanaEventosRaton() {
        configurarVentana();
        agregarComponentes();
    }

    private void configurarVentana() {
        setTitle("Eventos Ratón");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        java.net.URL imgURL = VentanaEventosRaton.class.getClassLoader().getResource("icon/Koala.png");
        ImageIcon icono = new ImageIcon(imgURL);
        setIconImage(icono.getImage());
        
        setResizable(false);
    }

    private void agregarComponentes() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(255, 255, 204));

        JLabel etiqueta = new JLabel("EVENTOS", SwingConstants.CENTER);
        etiqueta.setFont(new Font("Courier New", Font.PLAIN, 16));
        etiqueta.setForeground(new Color(200, 100, 50));
        panel.add(etiqueta, BorderLayout.NORTH);

        areaDeTexto = new JTextArea();
        areaDeTexto.setEditable(false);
        areaDeTexto.setFont(new Font("Courier New", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(areaDeTexto);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton botonLimpiar = new JButton("Limpiar");
        botonLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                areaDeTexto.setText("");
            }
        });
        botonLimpiar.setBackground(new Color(200, 100, 50)); 
        botonLimpiar.setForeground(Color.WHITE); 
        panel.add(botonLimpiar, BorderLayout.SOUTH); 

        areaDeTexto.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                registrarEvento("Mouse clicado en la posición (" + e.getX() + ", " + e.getY() + ")");
            }

            public void mouseEntered(MouseEvent e) {
                registrarEvento("Mouse entrando en el área de texto");
            }

            public void mouseExited(MouseEvent e) {
                registrarEvento("Mouse saliendo del área de texto");
            }
        });

        getContentPane().add(panel);
    }

    private void registrarEvento(String evento) {
        areaDeTexto.append(evento + "\n");
    }
}
