package T22MVC.Ejercicio2.Views;

import T22MVC.Ejercicio2.Models.ModelCientificos;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewCientificos extends JFrame {
	private JTable tablaCientificos;
	private DefaultTableModel modeloTabla;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnInsertar;

	public ViewCientificos() {
		configurarVentana();
		inicializarComponentes();
		agregarComponentes();
	}

	private void configurarVentana() {
		setTitle("Científicos");
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	//	ImageIcon icono = new ImageIcon(getClass().getResource("/icon/green_book.png"));
		//setIconImage(icono.getImage());
	}

	private void inicializarComponentes() {
		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("DNI");
		modeloTabla.addColumn("Nombre y Apellidos");

		tablaCientificos = new JTable(modeloTabla);
		configurarTabla();

		btnActualizar = new JButton("Actualizar");
		btnEliminar = new JButton("Eliminar");
		btnInsertar = new JButton("Insertar nuevo registro");
		configurarBotones();
	}

	private void configurarTabla() {
		tablaCientificos.setFillsViewportHeight(true);
		tablaCientificos.setRowHeight(25);
		tablaCientificos.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		tablaCientificos.getTableHeader().setBackground(new Color(70, 130, 180));
		tablaCientificos.getTableHeader().setForeground(Color.WHITE);
		tablaCientificos.setFont(new Font("Arial", Font.PLAIN, 14));
		tablaCientificos.setDefaultEditor(Object.class, null);
	}

	private void configurarBotones() {
		Font buttonFont = new Font("Arial", Font.BOLD, 14);

		btnActualizar.setBackground(new Color(70, 130, 180));
		btnActualizar.setForeground(Color.WHITE);
		btnActualizar.setFont(buttonFont);
		btnActualizar.setToolTipText("Actualizar la información del científico seleccionado");

		btnEliminar.setBackground(new Color(220, 20, 60));
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(buttonFont);
		btnEliminar.setToolTipText("Eliminar el científico seleccionado");

		btnInsertar.setBackground(new Color(34, 139, 34));
		btnInsertar.setForeground(Color.WHITE);
		btnInsertar.setFont(buttonFont);
		btnInsertar.setToolTipText("Insertar un nuevo científico");
	}

	private void agregarComponentes() {
		JScrollPane scrollPane = new JScrollPane(tablaCientificos);

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

	public void mostrarCientificos(List<ModelCientificos> cientificos) {
		modeloTabla.setRowCount(0);  // limpiar la tabla antes de llenarla de nuevo

		for (ModelCientificos cientifico : cientificos) {
			Object[] fila = {
				cientifico.getDni(),
				cientifico.getNomApels()
			};
			modeloTabla.addRow(fila);
		}
	}

	public void actualizarListaCientificos(List<ModelCientificos> cientificos) {
		mostrarCientificos(cientificos);
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

	public JTable getTablaCientificos() {
		return tablaCientificos;
	}
}