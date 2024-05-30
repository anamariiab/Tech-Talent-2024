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
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("ID");
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Apellido");
		modeloTabla.addColumn("Dirección");
		modeloTabla.addColumn("DNI");
		modeloTabla.addColumn("Fecha");

		tablaClientes = new JTable(modeloTabla);
		JScrollPane scrollPane = new JScrollPane(tablaClientes);

		btnActualizar = new JButton("Actualizar");
		btnEliminar = new JButton("Eliminar");
		btnInsertar = new JButton("Insertar Nuevo");

		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new FlowLayout());
		panelBotones.add(btnActualizar);
		panelBotones.add(btnEliminar);

		// Agregar tabla y panel de botones al frame
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		getContentPane().add(panelBotones, BorderLayout.EAST);
		getContentPane().add(btnInsertar, BorderLayout.SOUTH);
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