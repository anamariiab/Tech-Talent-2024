package T22MVC.Ejercicio2.Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewProyecto extends JFrame {
    private JTable tablaProyectos;
    private DefaultTableModel modeloTabla;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnInsertar;

    public ViewProyecto() {
        configurarVentana();
        inicializarComponentes();
        agregarComponentes();
    }

    private void configurarVentana() {
        setTitle("Proyectos");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ImageIcon icono = new ImageIcon(getClass().getResource("/icon/proyecto.png"));
        setIconImage(icono.getImage());
    }
    
    private void inicializarComponentes() {
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Horas");

        tablaProyectos = new JTable(modeloTabla);
        configurarTabla();

        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnInsertar = new JButton("Insertar nuevo registro");
        configurarBotones();
    }

    private void configurarTabla() {
        tablaProyectos.setFillsViewportHeight(true);
        tablaProyectos.setRowHeight(25);
        tablaProyectos.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        tablaProyectos.getTableHeader().setBackground(new Color(70, 130, 180));
        tablaProyectos.getTableHeader().setForeground(Color.WHITE);
        tablaProyectos.setFont(new Font("Arial", Font.PLAIN, 14));
        tablaProyectos.setDefaultEditor(Object.class, null);
    }

    private void configurarBotones() {
        Font buttonFont = new Font("Arial", Font.BOLD, 14);

        btnActualizar.setBackground(new Color(70, 130, 180));
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setFont(buttonFont);
        btnActualizar.setToolTipText("Actualizar la información del proyecto seleccionado");

        btnEliminar.setBackground(new Color(220, 20, 60));
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFont(buttonFont);
        btnEliminar.setToolTipText("Eliminar el proyecto seleccionado");

        btnInsertar.setBackground(new Color(34, 139, 34));
        btnInsertar.setForeground(Color.WHITE);
        btnInsertar.setFont(buttonFont);
        btnInsertar.setToolTipText("Insertar un nuevo proyecto");
    }

    private void agregarComponentes() {
        JScrollPane scrollPane = new JScrollPane(tablaProyectos);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(2, 1, 10, 10));
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.EAST);
        panelPrincipal.add(btnInsertar, BorderLayout.SOUTH);
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        getContentPane().add(panelPrincipal);
    }

    public void mostrarProyectos(Object[][] datos) {
        modeloTabla.setDataVector(datos, new Object[]{"ID", "Nombre", "Horas"});
    }

    public void agregarProyectoATabla(String id, String nombre, int horas) {
        modeloTabla.addRow(new Object[]{id, nombre, horas});
    }

    public void agregarListenerActualizar(ActionListener listener) {
        btnActualizar.addActionListener(listener);
    }

    public void agregarListenerEliminar(ActionListener listener) {
        btnEliminar.addActionListener(listener);
    }

    public void agregarListenerInsertar(ActionListener listener) {
        btnInsertar.addActionListener(listener);
    }

    public JTable getTablaProyectos() {
        return tablaProyectos;
    }
}
