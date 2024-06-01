package T22MVC;

import javax.swing.JOptionPane;

public class Utilidades {

	public static String obtenerEntrada(String mensaje) {
		return JOptionPane.showInputDialog(null, mensaje);
	}

	public static void mostrarMensajeExito(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "¡Éxito!", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void mostrarMensajeAdvertencia(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "¡Atención!", JOptionPane.WARNING_MESSAGE);
	}

	public static void mostrarMensajeError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "¡Error!", JOptionPane.ERROR_MESSAGE);
	}

}
