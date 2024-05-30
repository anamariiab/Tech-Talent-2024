package T22MVC.Ejercicio1.Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Date;

public class ViewCliente extends JFrame {
	private JTable tablaClientes;
	private DefaultTableModel modeloTabla;

	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnInsertar;

	public ViewCliente() {
		setTitle("Lista de Clientes");
		setSize(800, 500);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null); 

		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("ID");
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Apellido");
		modeloTabla.addColumn("Dirección");
		modeloTabla.addColumn("DNI");
		modeloTabla.addColumn("Fecha");

		tablaClientes = new JTable(modeloTabla);
        tablaClientes.setFillsViewportHeight(true);
        tablaClientes.setRowHeight(25);
        tablaClientes.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        tablaClientes.getTableHeader().setBackground(new Color(70, 130, 180));
        tablaClientes.getTableHeader().setForeground(Color.WHITE);
        tablaClientes.setFont(new Font("Arial", Font.PLAIN, 14));
        
        JScrollPane scrollPane = new JScrollPane(tablaClientes);

		btnActualizar = new JButton("Actualizar");
		btnEliminar = new JButton("Eliminar");
		btnInsertar = new JButton("Insertar nuevo registro");

		btnActualizar.setBackground(new Color(70, 130, 180));
        btnActualizar.setForeground(Color.WHITE);
        btnEliminar.setBackground(new Color(220, 20, 60));
        btnEliminar.setForeground(Color.WHITE);
        btnInsertar.setBackground(new Color(34, 139, 34));
        btnInsertar.setForeground(Color.WHITE);

        Font buttonFont = new Font("Arial", Font.BOLD, 14);
        btnActualizar.setFont(buttonFont);
        btnEliminar.setFont(buttonFont);
        btnInsertar.setFont(buttonFont);

        btnActualizar.setToolTipText("Actualizar la información del cliente seleccionado");               
        btnEliminar.setToolTipText("Eliminar el cliente seleccionado");
        btnInsertar.setToolTipText("Insertar un nuevo cliente");

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
        
        /* 
        JMenuBar menuBar = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem menuItemSalir = new JMenuItem("Salir");
        menuItemSalir.addActionListener(e -> System.exit(0));
        menuArchivo.add(menuItemSalir);
        menuBar.add(menuArchivo);
        
        JMenu menuAyuda = new JMenu("Ayuda");
        JMenuItem menuItemAcercaDe = new JMenuItem("Acerca de");
        menuItemAcercaDe.addActionListener(e -> JOptionPane.showMessageDialog(this, "Aplicación gestión de clientes v1.0"));
        menuAyuda.add(menuItemAcercaDe);
        menuBar.add(menuAyuda);

        setJMenuBar(menuBar);*/     
        
    }

	public void mostrarClientes(Object[][] datos) {
		modeloTabla.setDataVector(datos, new Object[] { "ID", "Nombre", "Apellido", "Dirección", "DNI", "Fecha" }); // cargar
																													// los
																													// datos
																													// en
																													// la
																													// tabla
	}

	public void agregarClienteATabla(int id, String nombre, String apellido, String direccion, int dni, Date fecha) { // add
																														// nuevo
																														// cliente
		modeloTabla.addRow(new Object[] { id, nombre, apellido, direccion, dni, fecha });
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

	public JTable getTablaClientes() {
		return tablaClientes;
	}
}