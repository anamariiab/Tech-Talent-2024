package T20Maven.Ejercicio4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaEventos extends JFrame {

    private JTextArea areaDeTexto;

    public VentanaEventos() {
        configurarVentana();
        agregarComponentes();
        eventos();
        registrarEvento("Ventana abierta");
    }

    private void configurarVentana() {
        setTitle("Eventos de Ventana");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        java.net.URL imgURL = VentanaEventos.class.getClassLoader().getResource("icon/NerdFace.png");
        ImageIcon icono = new ImageIcon(imgURL);
        setIconImage(icono.getImage());
        
        setResizable(false);
    }

    private void agregarComponentes() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(255, 255, 204));

        JLabel etiqueta = new JLabel("EVENTOS", SwingConstants.CENTER);
        etiqueta.setFont(new Font("Courier New", Font.PLAIN, 16));
        etiqueta.setForeground(new Color(0x00cfff));
        panel.add(etiqueta, BorderLayout.NORTH);

        areaDeTexto = new JTextArea();
        areaDeTexto.setEditable(false);
        areaDeTexto.setFont(new Font("Courier New", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(areaDeTexto);
        panel.add(scrollPane, BorderLayout.CENTER);

        getContentPane().add(panel);
    }

    private void eventos() {
        addWindowListener(new WindowAdapter() {
            
            public void windowIconified(WindowEvent e) {
                registrarEvento("Ventana minimizada");
            }
            public void windowDeiconified(WindowEvent e) {
                registrarEvento("Ventana restaurada");
            }

            public void windowActivated(WindowEvent e) {
                registrarEvento("Ventana activada");
            }

            public void windowDeactivated(WindowEvent e) {
                registrarEvento("Ventana desactivada");
            }
        });
    }

    private void registrarEvento(String evento) {
        areaDeTexto.append(evento + "\n");
    }

}
