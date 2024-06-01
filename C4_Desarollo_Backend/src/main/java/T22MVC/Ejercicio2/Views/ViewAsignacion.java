package T22MVC.Ejercicio2.Views;

import T22MVC.Ejercicio2.Models.ModelAsignacion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewAsignacion extends JFrame {
    private JTable tablaAsignaciones;
    private DefaultTableModel modeloTabla;
    private JButton btnInsertar;
    private JButton btnEliminar;

    public ViewAsignacion() {
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

        btnInsertar = new JButton("Insertar");
        btnEliminar = new JButton("Eliminar");
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

        btnInsertar.setBackground(new Color(70, 130, 180));
        btnInsertar.setForeground(Color.WHITE);
        btnInsertar.setFont(buttonFont);
        btnInsertar.setToolTipText("Asignar");

        btnEliminar.setBackground(new Color(220, 20, 60));
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFont(buttonFont);
        btnEliminar.setToolTipText("Eliminar asignación");
    }

    private void agregarComponentes() {
        JScrollPane scrollPane = new JScrollPane(tablaAsignaciones);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(2, 1, 10, 10));
        panelBotones.add(btnInsertar);
        panelBotones.add(btnEliminar);

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.EAST);
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        getContentPane().add(panelPrincipal);
    }

    public void mostrarAsignaciones(List<ModelAsignacion> asignaciones) {
        modeloTabla.setRowCount(0); // limpiar la tabla antes de llenarla de nuevo

        for (ModelAsignacion asignacion : asignaciones) {
            Object[] fila = {
                    asignacion.getCientifico(),
                    asignacion.getProyecto()
            };
            modeloTabla.addRow(fila);
        }
    }
    
    public void actualizarListaAsignaciones(List<ModelAsignacion> asignaciones) {
        mostrarAsignaciones(asignaciones);
    }

    public void agregarListenerInsertar(ActionListener listener) {
        btnInsertar.addActionListener(listener);
    }

    public void agregarListenerEliminar(ActionListener listener) {
        btnEliminar.addActionListener(listener);
    }

    public JTable getTablaAsignaciones() {
        return tablaAsignaciones;
    }
}