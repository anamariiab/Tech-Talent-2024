package T22MVC.Ejercicio2.Views;
import javax.swing.*;

import T22MVC.Ejercicio2.ConexionBD;
import T22MVC.Ejercicio2.Controllers.ControllerCientifico;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewCientificos extends JFrame {

    private JPanel panelCientificos;
    private JLabel labelDNI, labelNomApels;
    private JTextField textFieldDNI, textFieldNomApels;
    private JButton buttonInsertar, buttonMostrar, buttonActualizar, buttonEliminar;
 //   private ConexionBD conexionBD;
  private ControllerCientifico controllerCientificos;

    public ViewCientificos() {
        configurarVentana();
        agregarComponentes();
//    	conexionBD = new ConexionBD();
    }

    private void configurarVentana() {
        setTitle("CIENTIFICOS");
        setSize(525, 230);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        ImageIcon icono = new ImageIcon(getClass().getResource("/icon/Cientifico.png"));
        setIconImage(icono.getImage());
    }

    private void agregarComponentes() {
    	panelCientificos = new JPanel(new GridLayout(4, 1, 10, 10));
        panelCientificos.setBackground(new Color(255, 230, 179));

        labelDNI = new JLabel("DNI:");
        panelCientificos.add(labelDNI);
        
        textFieldDNI = new JTextField();
        panelCientificos.add(textFieldDNI);
        
        labelNomApels = new JLabel("NOMBRE Y APELLIDOS:");
        panelCientificos.add(labelNomApels);
        
        textFieldNomApels = new JTextField();
        panelCientificos.add(textFieldNomApels);

        buttonInsertar = new JButton("INSERTAR");
        buttonInsertar.setBackground(new Color(255, 99, 71));
        panelCientificos.add(buttonInsertar);
        
        buttonMostrar = new JButton("MOSTRAR");
        buttonMostrar.setBackground(new Color(255, 99, 71));
        panelCientificos.add(buttonMostrar);
        
        buttonActualizar = new JButton("ACTUALIZAR");
        buttonActualizar.setBackground(new Color(255, 99, 71));
        panelCientificos.add(buttonActualizar);
        
        buttonEliminar = new JButton("ELIMINAR");
        buttonEliminar.setBackground(new Color(255, 99, 71));
        panelCientificos.add(buttonEliminar);

        getContentPane().add(panelCientificos, BorderLayout.CENTER);

        buttonInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String DNI = textFieldDNI.getText();
                String nomApels = textFieldNomApels.getText();
                controllerCientificos.insertarCientifico(DNI, nomApels);
            }
        });

        buttonMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerCientificos.mostrarCientificos();
            }
        });

        buttonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String DNI = textFieldDNI.getText();
                String nomApels = textFieldNomApels.getText();
                controllerCientificos.actualizarCientifico(DNI, nomApels);
            }
        });

        buttonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String DNI = textFieldDNI.getText();
                controllerCientificos.eliminarCientifico(DNI);
            }
        });
    }
    public static void main(String[] args) {
        ViewCientificos ventanaCientificos = new ViewCientificos();
        ventanaCientificos.setVisible(true);
    }
}