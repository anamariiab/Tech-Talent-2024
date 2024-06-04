package T22MVC.Ejercicio2.Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ViewSeleccionTabla2 extends JFrame {

    private JButton btnCientificos;
    private JButton btnAsignaciones;
    private JButton btnProyecto;

    public ViewSeleccionTabla2() {
        configurarVentana();
        inicializarComponentes();
        agregarComponentes();
    }

    private void configurarVentana() {
        setTitle("Selecciona una tabla");
        setSize(440, 140);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        ImageIcon icono = new ImageIcon(getClass().getResource("/icon/dedo.png"));
        setIconImage(icono.getImage()); 
    }

    private void inicializarComponentes() {
    	btnCientificos = new JButton("Científicos");
        btnAsignaciones = new JButton("Asignaciones");
        btnProyecto = new JButton("Proyectos");
        configurarBotones();
    }

    private void configurarBotones() {
        Font buttonFont = new Font("Arial", Font.BOLD, 14);

        btnCientificos.setBackground(new Color(70, 130, 180));
        btnCientificos.setForeground(Color.WHITE);
        btnCientificos.setFont(buttonFont);

        btnAsignaciones.setBackground(new Color(34, 139, 34));
        btnAsignaciones.setForeground(Color.WHITE);
        btnAsignaciones.setFont(buttonFont);
        
        btnProyecto.setBackground(new Color(70, 130, 180));
        btnProyecto.setForeground(Color.WHITE);
        btnProyecto.setFont(buttonFont);
    }

    private void agregarComponentes() {
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 2, 10, 10));
        panelBotones.add(btnCientificos);
        panelBotones.add(btnAsignaciones);
        panelBotones.add(btnProyecto);
        
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        getContentPane().add(panelBotones, BorderLayout.CENTER);
    }

    public void agregarListenerCientificos(ActionListener listener) {
    	btnCientificos.addActionListener(listener);
    }

    public void agregarListenerAsignaciones(ActionListener listener) {
        btnAsignaciones.addActionListener(listener);
    }
    
    public void agregarListenerProyecto(ActionListener listener) {
    	btnProyecto.addActionListener(listener);
    }
}