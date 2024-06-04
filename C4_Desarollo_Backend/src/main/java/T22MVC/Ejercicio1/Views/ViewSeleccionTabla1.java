package T22MVC.Ejercicio1.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewSeleccionTabla1 extends JFrame {

    private JButton btnClientes;
    private JButton btnVideos;

    public ViewSeleccionTabla1() {
        configurarVentana();
        inicializarComponentes();
        agregarComponentes();
    }

    private void configurarVentana() {
        setTitle("Selecciona una tabla");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        ImageIcon icono = new ImageIcon(getClass().getResource("/icon/dedo.png"));
        setIconImage(icono.getImage()); 
    }

    private void inicializarComponentes() {
        btnClientes = new JButton("Clientes");
        btnVideos = new JButton("Videos");
        configurarBotones();
    }

    private void configurarBotones() {
        Font buttonFont = new Font("Arial", Font.BOLD, 14);

        btnClientes.setBackground(new Color(34, 139, 34));
        btnClientes.setForeground(Color.WHITE);
        btnClientes.setFont(buttonFont);

        btnVideos.setBackground(new Color(70, 130, 180));
        btnVideos.setForeground(Color.WHITE);
        btnVideos.setFont(buttonFont);
    }

    private void agregarComponentes() {
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 2, 10, 10));
        panelBotones.add(btnClientes);
        panelBotones.add(btnVideos);

        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        getContentPane().add(panelBotones, BorderLayout.CENTER);
    }

    public void agregarListenerClientes(ActionListener listener) {
        btnClientes.addActionListener(listener);
    }

    public void agregarListenerVideos(ActionListener listener) {
        btnVideos.addActionListener(listener);
    }
}