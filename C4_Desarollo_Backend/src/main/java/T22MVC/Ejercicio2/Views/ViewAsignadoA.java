package T22MVC.Ejercicio2.Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewAsignadoA extends JFrame {
    private JTable tablaAsignaciones;
    private DefaultTableModel modeloTabla;
    private JButton btnAsignar;
    private JButton btnEliminarAsignacion;

    public ViewAsignadoA() {
        configurarVentana();
        inicializarComponentes();
        agregarComponentes();
    }

    private void configurarVentana() {
        setTitle("Asignaciones");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        ImageIcon icono = new ImageIcon(getClass().getResource("/icon/asignar.png"));
        setIconImage(icono.getImage());
    }

    private void inicializarComponentes() {
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Científico");
        modeloTabla.addColumn("Proyecto");

        tablaAsignaciones = new JTable(modeloTabla);
        configurarTabla();

        btnAsignar = new JButton("Asignar científico a proyecto");
        btnEliminarAsignacion = new JButton("Eliminar asignación");
        configurarBotones();
    }

    private void configurarTabla() {
        tablaAsignaciones.setFillsViewportHeight(true);
        tablaAsignaciones.setRowHeight(25);
        tablaAsignaciones.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        tablaAsignaciones.getTableHeader().setBackground(new Color(70, 130, 180));
        tablaAsignaciones.getTableHeader().setForeground(Color.WHITE);
        tablaAsignaciones.setFont(new Font("Arial", Font.PLAIN, 14));
        tablaAsignaciones.setDefaultEditor(Object.class, null);
    }

    private void configurarBotones() {
        Font buttonFont = new Font("Arial", Font.BOLD, 14);

        btnAsignar.setBackground(new Color(34, 139, 34));
        btnAsignar.setForeground(Color.WHITE);
        btnAsignar.setFont(buttonFont);

        btnEliminarAsignacion.setBackground(new Color(220, 20, 60));
        btnEliminarAsignacion.setForeground(Color.WHITE);
        btnEliminarAsignacion.setFont(buttonFont);
    }
    
    private void agregarComponentes() {
        JScrollPane scrollPane = new JScrollPane(tablaAsignaciones);

        JPanel panelBotones = new JPanel(new GridLayout(2, 1, 0, 10));
        panelBotones.add(btnAsignar);
        panelBotones.add(btnEliminarAsignacion);

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        getContentPane().add(panelPrincipal);
    }

    public void mostrarAsignaciones(Object[][] datos) {
        modeloTabla.setDataVector(datos, new Object[]{"Científico", "Proyecto"});
    }

    public void agregarAsignacionATabla(String cientifico, String proyecto) {
        modeloTabla.addRow(new Object[]{cientifico, proyecto});
    }

    public void agregarListenerAsignar(ActionListener listener) {
        btnAsignar.addActionListener(listener);
    }

    public void agregarListenerEliminarAsignacion(ActionListener listener) {
        btnEliminarAsignacion.addActionListener(listener);
    }

    public JTable getTablaAsignaciones() {
        return tablaAsignaciones;
    }
    
    public static void main(String[] args) {

        ViewAsignadoA asignadoAView = new ViewAsignadoA();

        asignadoAView.setVisible(true);
    }
}