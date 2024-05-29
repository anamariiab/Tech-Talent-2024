package T22MVC.Ejercicio2.Views;
import T22MVC.Ejercicio2.ConexionBD;
import T22MVC.Ejercicio2.Controllers.ControllerProyecto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewProyecto extends JFrame {

	private JPanel panelProyectos;
	private JLabel labelID, labelNombre, labelHoras;
	private JTextField textFieldID, textFieldNombre, textFieldHoras;
	private JButton buttonInsertar, buttonMostrar, buttonActualizar, buttonEliminar;
	private ConexionBD conexionBD;
	private ControllerProyecto controllerProyecto;

	public ViewProyecto() {
		configurarVentana();
	//	conexionBD = new ConexionBD();
		agregarComponentes();
	}

	private void configurarVentana() {
		setTitle("PROYECTO");
        setSize(525, 230);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        ImageIcon icono = new ImageIcon(getClass().getResource("/icon/Notebook.png"));
        setIconImage(icono.getImage());
	}

	private void agregarComponentes() {
		panelProyectos = new JPanel();
		panelProyectos.setLayout(null);
		panelProyectos.setBackground(new Color(230, 230, 250)); 
        getContentPane().add(panelProyectos);

		labelID = new JLabel("ID:");
		labelID.setBounds(20, 40, 80, 20);
		panelProyectos.add(labelID);

		textFieldID = new JTextField();
		textFieldID.setBounds(120, 40, 200, 20);
		panelProyectos.add(textFieldID);

		labelNombre = new JLabel("NOMBRE:");
		labelNombre.setBounds(20, 85, 80, 20);
		panelProyectos.add(labelNombre);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(120, 88, 200, 20);
		panelProyectos.add(textFieldNombre);

		labelHoras = new JLabel("HORAS:");
		labelHoras.setBounds(20, 130, 80, 20);
		panelProyectos.add(labelHoras);

		textFieldHoras = new JTextField();
		textFieldHoras.setBounds(120, 132, 200, 20);
		panelProyectos.add(textFieldHoras);

		buttonInsertar = new JButton("INSERTAR");
		buttonInsertar.setBounds(380, 20, 110, 30);
		buttonInsertar.setBackground(new Color(221, 160, 221));
		panelProyectos.add(buttonInsertar);

		buttonMostrar = new JButton("MOSTRAR");
		buttonMostrar.setBounds(380, 60, 110, 30);
		buttonMostrar.setBackground(new Color(221, 160, 221));
		panelProyectos.add(buttonMostrar);

		buttonActualizar = new JButton("ACTUALIZAR");
		buttonActualizar.setBounds(380, 100, 110, 30);
		buttonActualizar.setBackground(new Color(221, 160, 221));
		panelProyectos.add(buttonActualizar);

		buttonEliminar = new JButton("ELIMINAR");
		buttonEliminar.setBounds(380, 140, 110, 30);
		buttonEliminar.setBackground(new Color(221, 160, 221));
		panelProyectos.add(buttonEliminar);
		
		buttonInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = textFieldID.getText();
                String nombre = textFieldNombre.getText();
                int horas = Integer.parseInt(textFieldHoras.getText());
                controllerProyecto.insertarProyecto(ID, nombre, horas);
            }
        });

        buttonMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	controllerProyecto.mostrarProyectos();
            }
        });

        buttonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = textFieldID.getText();
                String nombre = textFieldNombre.getText();
                int horas = Integer.parseInt(textFieldHoras.getText());
                controllerProyecto.actualizarProyecto(ID, nombre, horas);
            }
        });

        buttonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = textFieldID.getText();
                controllerProyecto.eliminarProyecto(ID);
            }
        });
	}
	
	   public static void main(String[] args) {
		   
	        ViewProyecto ventanaProyectos = new ViewProyecto();
	        ventanaProyectos.setVisible(true);
	    }
	}
