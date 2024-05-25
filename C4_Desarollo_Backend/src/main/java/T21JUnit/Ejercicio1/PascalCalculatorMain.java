package T21JUnit.Ejercicio1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PascalCalculatorMain extends JFrame implements ActionListener {
	
    private JTextField campoTexto1, campoTexto2, campoResultado;
    private JButton sumaBoton, restaBoton, multBoton, divBoton, resetBoton, porcentajeBoton;
    private JLabel etiqueta1, etiqueta2, etiquetaResultado;
    private PascalCalculator calculator;

    public PascalCalculatorMain() {
        setTitle("Pascal's_Calculator.exe");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));
        setResizable(false);
        
        JMenuBar barraMenu = new JMenuBar();
        JMenu menuOpciones = new JMenu("Opciones");

        JMenuItem itemHistorial = new JMenuItem("Historial");
        itemHistorial.addActionListener(this);
        menuOpciones.add(itemHistorial);

        JMenuItem itemAcercaDe = new JMenuItem("Acerca de");
        itemAcercaDe.addActionListener(this);
        menuOpciones.add(itemAcercaDe);

        JMenuItem itemSalir = new JMenuItem("Salir");
        itemSalir.addActionListener(this);
        menuOpciones.add(itemSalir);

        barraMenu.add(menuOpciones);
        setJMenuBar(barraMenu);

        setVisible(true);

        calculator = new PascalCalculator();

        // etiquetas
        etiqueta1 = new JLabel("Operando 1:");
        add(etiqueta1);
        campoTexto1 = new JTextField();
        customizarCampoTexto(campoTexto1);
        add(campoTexto1);

        etiqueta2 = new JLabel("Operando 2:");
        add(etiqueta2);
        campoTexto2 = new JTextField();
        customizarCampoTexto(campoTexto2);
        add(campoTexto2);

        etiquetaResultado = new JLabel("Resultado:");
        add(etiquetaResultado);
        campoResultado = new JTextField();
        campoResultado.setEditable(false);
        customizarCampoTexto(campoResultado);
        add(campoResultado);

        // botones
        sumaBoton = new JButton("+");
        sumaBoton.addActionListener(this);
        customizarBoton(sumaBoton, Color.GREEN.darker());
        add(sumaBoton);

        restaBoton = new JButton("-");
        restaBoton.addActionListener(this);
        customizarBoton(restaBoton, Color.RED.darker());
        add(restaBoton);

        multBoton = new JButton("x");
        multBoton.addActionListener(this);
        customizarBoton(multBoton, Color.BLUE.darker());
        add(multBoton);

        divBoton = new JButton("/");
        divBoton.addActionListener(this);
        customizarBoton(divBoton, Color.ORANGE.darker());
        add(divBoton);

        resetBoton = new JButton("c");
        resetBoton.addActionListener(this);
        customizarBoton(resetBoton, Color.GRAY);
        add(resetBoton);

        porcentajeBoton = new JButton("%");
        porcentajeBoton.addActionListener(this);
        customizarBoton(porcentajeBoton, Color.YELLOW.darker());
        add(porcentajeBoton);

        setVisible(true);
    }

    private void customizarBoton(JButton boton, Color color) {
        boton.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        boton.setFocusPainted(false);
        boton.setBackground(color);
        boton.setForeground(Color.WHITE);

        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton.setBackground(boton.getBackground().darker());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton.setBackground(boton.getBackground().brighter());
            }
        });
    }

    private void customizarCampoTexto(JTextField campoTexto) {
        campoTexto.setBackground(Color.LIGHT_GRAY);
        campoTexto.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        campoTexto.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Acerca de")) {
            String mensajeAcercaDe = "Pascal's_Calculator\nVersión 1.0\n\nDesarrollado por:\n" + "LAJ TechTigresas";
            JOptionPane.showMessageDialog(this, mensajeAcercaDe, "Acerca de", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getActionCommand().equals("Salir")) {
            System.exit(0);
        } else if (e.getActionCommand().equals("Historial")) {
        	ArrayList<String> historial = calculator.getHistorialCalculos();
            mostrarHistorial(historial);
        } else if (e.getSource() == resetBoton) {
            campoTexto1.setText("");
            campoTexto2.setText("");
            campoResultado.setText("");
        } else {
            double num1, num2;
            try {
                num1 = Double.parseDouble(campoTexto1.getText());
                num2 = Double.parseDouble(campoTexto2.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "¡Por favor, introduce caracteres válidos!", "Atención", JOptionPane.WARNING_MESSAGE);
                return;
            }

            double resultado = 0.0;

            try {
                if (e.getActionCommand().equals("+")) {
                    resultado = calculator.sumar(num1, num2);
                } else if (e.getActionCommand().equals("-")) {
                    resultado = calculator.restar(num1, num2);
                } else if (e.getActionCommand().equals("x")) {
                    resultado = calculator.multiplicar(num1, num2);
                } else if (e.getActionCommand().equals("/")) {
                    resultado = calculator.dividir(num1, num2);
                } else if (e.getActionCommand().equals("%")) {
                    resultado = calculator.calcularPorcentaje(num1, num2);
                }
                campoResultado.setText(String.valueOf(resultado));

            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(this, "¡Ups! " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            calculator.agregarAlHistorial(num1, e.getActionCommand(), num2, resultado);
        }
    }
    
    private void mostrarHistorial(ArrayList<String> historial) {
        JTextArea areaHistorial = new JTextArea();
        areaHistorial.setEditable(false);
        areaHistorial.setRows(10);
        areaHistorial.setColumns(30);

        StringBuilder textoHistorial = new StringBuilder();
        for (String calculo : historial) {
            textoHistorial.append(calculo).append("\n");
        }
        areaHistorial.setText(textoHistorial.toString());

        JScrollPane scrollPane = new JScrollPane(areaHistorial);
        JOptionPane.showMessageDialog(this, scrollPane, "Historial de cálculos", JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String[] args) {
        new PascalCalculatorMain();
    }
}