package T22MVC.Ejercicio2.Views;
import T22MVC.Ejercicio2.Controllers.ControllerAsignacion;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class ViewAsignacion extends JFrame {

    private JTable tabla;
    private JButton buttonAgregar, buttonEliminar;
    private DefaultTableModel modeloTabla;
//    private DatabaseManager dbManager;
    private ControllerAsignacion controllerAsignacion;
    
    public ViewAsignacion() {
        configurarVentana();
        agregarComponentes();
//        dbManager = new DatabaseManager(); 
     //   controllerAsignacion = new ControllerAsignacion();
     //   controllerAsignacion.cargarDatos(modeloTabla);
  
    }

    private void configurarVentana() {
        setTitle("ASIGNACIONES");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setVisible(true);
        
    }
    
    private void agregarComponentes() {
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("DNI Científico");
        modeloTabla.addColumn("ID Proyecto");
        tabla = new JTable(modeloTabla);
        tabla.setFont(new Font("Arial", Font.PLAIN, 14));
        tabla.setRowHeight(30);
        tabla.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
       
        buttonAgregar = new JButton("Agregar");
        buttonEliminar = new JButton("Eliminar");
        
        buttonAgregar.setBackground(new Color(34, 139, 34));
        buttonAgregar.setForeground(Color.WHITE);
        buttonAgregar.setFont(new Font("Arial", Font.BOLD, 14));
        buttonEliminar.setBackground(new Color(178, 34, 34));
        buttonEliminar.setForeground(Color.WHITE);
        buttonEliminar.setFont(new Font("Arial", Font.BOLD, 14));


        Container contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        contenedor.add(new JScrollPane(tabla), BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        panelBotones.add(buttonAgregar);
        panelBotones.add(buttonEliminar);
        contenedor.add(panelBotones, BorderLayout.SOUTH);

        controllerAsignacion = new ControllerAsignacion();

        buttonAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String dniCientifico = JOptionPane.showInputDialog("Introduce el DNI del científico:");
                String idProyecto = JOptionPane.showInputDialog("Introduce el ID del proyecto:");
                if (dniCientifico != null && idProyecto != null) {
                    controllerAsignacion.asignarProyectoACientifico(dniCientifico, idProyecto);
                    modeloTabla.addRow(new Object[]{dniCientifico, idProyecto});
                }
            }
        });

        buttonEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tabla.getSelectedRow();
                if (filaSeleccionada != -1) {
                    String dniCientifico = (String) modeloTabla.getValueAt(filaSeleccionada, 0);
                    String idProyecto = (String) modeloTabla.getValueAt(filaSeleccionada, 1);
                    controllerAsignacion.eliminarAsignacion(dniCientifico, idProyecto);
                    modeloTabla.removeRow(filaSeleccionada);
                } else {
                    JOptionPane.showMessageDialog(ViewAsignacion.this, "Por favor, selecciona una asignación para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ViewAsignacion().setVisible(true);
            }
        });
    }        
}     
        
        
        
