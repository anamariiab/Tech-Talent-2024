package T22MVC.Ejercicio1.Views;
import T22MVC.Ejercicio1.Models.ModelVideos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewVideos extends JFrame {

	private JTable tablaVideos;
	private DefaultTableModel modeloTabla;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnInsertar;

	public ViewVideos() {
		configurarVentana();
		inicializarComponentes();
		agregarComponentes();
	}

	private void configurarVentana() {
		setTitle("Videos");
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		ImageIcon icono = new ImageIcon(getClass().getResource("/icon/videocassette.png"));
		setIconImage(icono.getImage());
	}

	private void inicializarComponentes() {
		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("ID");
		modeloTabla.addColumn("Título");
		modeloTabla.addColumn("Director");
		modeloTabla.addColumn("ID Cliente");

		tablaVideos = new JTable(modeloTabla);
		configurarTabla();

		btnActualizar = new JButton("Actualizar");
		btnEliminar = new JButton("Eliminar");
		btnInsertar = new JButton("Insertar nuevo video");
		configurarBotones();
	}

	private void configurarTabla() {
		tablaVideos.setFillsViewportHeight(true);
		tablaVideos.setRowHeight(25);
		tablaVideos.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		tablaVideos.getTableHeader().setBackground(new Color(70, 130, 180));
		tablaVideos.getTableHeader().setForeground(Color.WHITE);
		tablaVideos.setFont(new Font("Arial", Font.PLAIN, 14));
		tablaVideos.setDefaultEditor(Object.class, null);
	}

	private void configurarBotones() {
		Font buttonFont = new Font("Arial", Font.BOLD, 14);

		btnActualizar.setBackground(new Color(70, 130, 180));
		btnActualizar.setForeground(Color.WHITE);
		btnActualizar.setFont(buttonFont);
		btnActualizar.setToolTipText("Actualizar la información del video seleccionado");

		btnEliminar.setBackground(new Color(220, 20, 60));
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(buttonFont);
		btnEliminar.setToolTipText("Eliminar el video seleccionado");

		btnInsertar.setBackground(new Color(34, 139, 34));
		btnInsertar.setForeground(Color.WHITE);
		btnInsertar.setFont(buttonFont);
		btnInsertar.setToolTipText("Insertar un nuevo video");
	}

	private void agregarComponentes() {
		JScrollPane scrollPane = new JScrollPane(tablaVideos);

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

	public void mostrarVideos(List<ModelVideos> videos) {
		modeloTabla.setRowCount(0); // Limpiar la tabla antes de llenarla de nuevo

		for (ModelVideos video : videos) {
			Object[] fila = { video.getId(), video.getTitle(), video.getDirector(), video.getCli_id() };
			modeloTabla.addRow(fila);
		}
	}

	public void actualizarListaVideos(List<ModelVideos> videos) {
		mostrarVideos(videos);
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

	public JTable getTablaVideos() {
		return tablaVideos;
	}
}