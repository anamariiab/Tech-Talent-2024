package T22MVC.Ejercicio1.Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Date;

public class ViewVideos extends JFrame {
	private JTable tablaVideos;
	private DefaultTableModel modeloTabla;

	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnInsertar;
	public ViewVideos() {
		setTitle("Videos");
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		ImageIcon icono = new ImageIcon(getClass().getResource("/icon/videocassette.png")); 
	    setIconImage(icono.getImage());

		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("ID");
		modeloTabla.addColumn("Título");
		modeloTabla.addColumn("Director");
		modeloTabla.addColumn("ID Cliente");

		tablaVideos = new JTable(modeloTabla);
		tablaVideos.setFillsViewportHeight(true);
		tablaVideos.setRowHeight(25);
		tablaVideos.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		tablaVideos.getTableHeader().setBackground(new Color(70, 130, 180));
		tablaVideos.getTableHeader().setForeground(Color.WHITE);
		tablaVideos.setFont(new Font("Arial", Font.PLAIN, 14));

		JScrollPane scrollPane = new JScrollPane(tablaVideos);
		tablaVideos.setDefaultEditor(Object.class, null);

		btnActualizar = new JButton("Actualizar");
		btnEliminar = new JButton("Eliminar");
		btnInsertar = new JButton("Insertar un nuevo registro");

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

		btnActualizar.setToolTipText("Actualizar la información del video seleccionado");
		btnEliminar.setToolTipText("Eliminar el video seleccionado");
		btnInsertar.setToolTipText("Insertar un nuevo video");

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

	public void mostrarVideos(Object[][] datos) {
		modeloTabla.setDataVector(datos, new Object[] { "ID", "Título", "Director", "ID Cliente" });
	}

	public void agregarVideoATabla(int id, String title, String director, int clientId) {
		modeloTabla.addRow(new Object[] { id, title, director, clientId });
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
