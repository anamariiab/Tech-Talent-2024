package T19SwingAWT.Ejercicio3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiniEncuesta extends JFrame {
    private JPanel panelPrincipal;
    private JLabel sistemaOperativoLabel, especialidadLabel, horasLabel;
    private JRadioButton windowsRadioButton, linuxRadioButton, macRadioButton;
    private JCheckBox programacionCheckBox, disenoGraficoCheckBox, administracionCheckBox;
    private JSlider horasSlider;
    private JButton mostrarDatosButton;

    public MiniEncuesta() {
        configurarVentana();
        agregarComponentes();
    }

    private void configurarVentana() {
        setTitle("Miniencuesta");
        setSize(420, 370);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));
    }

    private void agregarComponentes() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        setContentPane(panelPrincipal);

        sistemaOperativoLabel = new JLabel("Elije un sistema operativo:");
        sistemaOperativoLabel.setBounds(20, 30, 200, 20);
        panelPrincipal.add(sistemaOperativoLabel);

        ButtonGroup grupoSistemaOperativo = new ButtonGroup();                //grupo para los botones de radio
        windowsRadioButton = new JRadioButton("Windows");
        windowsRadioButton.setBounds(30, 50, 100, 20);
        grupoSistemaOperativo.add(windowsRadioButton); 
        panelPrincipal.add(windowsRadioButton);

        linuxRadioButton = new JRadioButton("Linux");
        linuxRadioButton.setBounds(30, 70, 100, 20);
        grupoSistemaOperativo.add(linuxRadioButton); 
        panelPrincipal.add(linuxRadioButton);

        macRadioButton = new JRadioButton("Mac");
        macRadioButton.setBounds(30, 90, 100, 20);
        grupoSistemaOperativo.add(macRadioButton); 
        panelPrincipal.add(macRadioButton);

        especialidadLabel = new JLabel("Elije tu especialidad:");
        especialidadLabel.setBounds(20, 120, 200, 20);
        panelPrincipal.add(especialidadLabel);

        programacionCheckBox = new JCheckBox("Programación");
        programacionCheckBox.setBounds(30, 140, 150, 20);
        panelPrincipal.add(programacionCheckBox);

        disenoGraficoCheckBox = new JCheckBox("Diseño gráfico");
        disenoGraficoCheckBox.setBounds(30, 160, 150, 20);
        panelPrincipal.add(disenoGraficoCheckBox);

        administracionCheckBox = new JCheckBox("Administración");
        administracionCheckBox.setBounds(30, 180, 150, 20);
        panelPrincipal.add(administracionCheckBox);

        horasLabel = new JLabel("Horas dedicadas en el ordenador:");
        horasLabel.setBounds(20, 210, 200, 20);
        panelPrincipal.add(horasLabel);

        horasSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
        horasSlider.setMajorTickSpacing(1);
        horasSlider.setPaintTicks(true);
        horasSlider.setPaintLabels(true);
        horasSlider.setBounds(30, 230, 300, 40);
        panelPrincipal.add(horasSlider);

        mostrarDatosButton = new JButton("Mostrar Datos");
        mostrarDatosButton.setBounds(150, 280, 120, 30);
        panelPrincipal.add(mostrarDatosButton);

        mostrarDatosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarDatos();
            }
        });
    }

    private void mostrarDatos() {
        StringBuilder datos = new StringBuilder();
        datos.append("Sistema Operativo: ");
        if (windowsRadioButton.isSelected()) {
            datos.append("Windows");
        } else if (linuxRadioButton.isSelected()) {
            datos.append("Linux");
        } else if (macRadioButton.isSelected()) {
            datos.append("Mac");
        }
        datos.append("\nEspecialidad: ");
        if (programacionCheckBox.isSelected()) {
            datos.append("Programación ");
        }
        if (disenoGraficoCheckBox.isSelected()) {
            datos.append("Diseño gráfico ");
        }
        if (administracionCheckBox.isSelected()) {
            datos.append("Administración");
        }
        datos.append("\nHoras dedicadas en el ordenador: ").append(horasSlider.getValue());
        JOptionPane.showMessageDialog(this, datos.toString(), "Datos de la encuesta", JOptionPane.INFORMATION_MESSAGE);
    }

}
