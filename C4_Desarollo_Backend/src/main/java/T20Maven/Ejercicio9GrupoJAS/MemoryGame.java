package T20Maven.Ejercicio9GrupoJAS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class MemoryGame extends JFrame implements ActionListener {
	private final int rows = 4;
	private final int cols = 4;
	private JPanel[][] panels;
	private CardLayout[][] cardLayouts;
	private String[] names;
	private String[] shuffledNames;
	private JButton firstButton;
	private JButton secondButton;
	private Timer timer;
	private String playerName;
	private int pairsFound;
	private int attempts;
	private List<String> history;
	private long startTime;

	public MemoryGame() {
		playerName = getPlayerName();
		history = new ArrayList<>();
		selectTheme();
		initializeGame();
	}

	private void selectTheme() {
		String[] themes = { "Animales", "Frutas", "Paises" };
		String selectedTheme = (String) JOptionPane.showInputDialog(this, "Selecciona un tema:",
				"Configuración del Juego", JOptionPane.PLAIN_MESSAGE, null, themes, themes[0]);

		if (selectedTheme != null) {
			if (selectedTheme.equals("Animales")) {
				names = new String[] { "Leon", "Tigre", "Elefante", "Jirafa", "Cebra", "Mapache", "Canguro", "Panda" };
			} else if (selectedTheme.equals("Frutas")) {
				names = new String[] { "Manzana", "Platano", "Fresa", "Naranja", "Pera", "Uva", "Kiwi", "Piña" };
			} else if (selectedTheme.equals("Paises")) {
				names = new String[] { "España", "Portugal", "China", "Colombia", "Brasil", "Francia", "Japon",
						"Rumania" };
			}
			setIcon();
            initializeGame();
		}
	}
	
	private void setIcon() {
        try {
            java.net.URL imgURL = getClass().getClassLoader().getResource("icon/memory_icon.jpg");
            if (imgURL != null) {
                ImageIcon icon = new ImageIcon(imgURL);
                setIconImage(icon.getImage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "¡Ups! No se pudo cargar el icono del juego.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

	private void initializeGame() {
		setTitle("MemoryGame - Gamertag: " + playerName);
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(rows, cols));

		panels = new JPanel[rows][cols];
		cardLayouts = new CardLayout[rows][cols];
		shuffledNames = getShuffledNames();
		initializePanels();
		initializeMenu();

		timer = new Timer(1000, e -> {                         
			flipBack(firstButton);
			flipBack(secondButton);
			firstButton = null;
			secondButton = null;
		});
		timer.setRepeats(false);

		pairsFound = 0;
		attempts = 0;
		startTime = System.currentTimeMillis();

		setVisible(true);
	}

	private String getPlayerName() {
		String playerName;

		do {
			playerName = JOptionPane.showInputDialog(this, "Gamertag:", "MemoryGame", JOptionPane.PLAIN_MESSAGE);
			if (playerName == null) {
				int option = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que quieres salir del juego?",
						"Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (option == JOptionPane.YES_OPTION) {
					System.exit(0); // salir del juego si el usuario confirma
				}
			} else if (playerName.isEmpty()) {
				JOptionPane.showMessageDialog(this,
						"¡Ups! Parece que has olvidado introducir tu nombre. ¡Ingresa uno para empezar!", "Info",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} while (playerName == null || playerName.isEmpty());

		return playerName;
	}

	private String[] getShuffledNames() {
		ArrayList<String> list = new ArrayList<>();
		for (String name : names) {
			list.add(name);
			list.add(name);
		}
		Collections.shuffle(list);
		return list.toArray(new String[0]);
	}

	private void initializePanels() {
		
		Color buttonBackgroundColor = new Color(175, 238, 238);                          //coloritooooo botones
	    getContentPane().removeAll();
	    for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < cols; j++) {
	            cardLayouts[i][j] = new CardLayout();
	            panels[i][j] = new JPanel(cardLayouts[i][j]);
	            panels[i][j].setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  // agregar un borde

	            JButton button = new JButton();
	            button.addActionListener(this);
	            button.setActionCommand(shuffledNames[i * cols + j]);
	            button.setName(i + "," + j);
	            button.setPreferredSize(new Dimension(180, 180));                         // nuevo tamaño para los botones
	           
	            button.setBackground(buttonBackgroundColor);
	            
	            panels[i][j].add(button, "back");

	            addImageToPanel(panels[i][j], shuffledNames[i * cols + j]);

	            add(panels[i][j]);
	        }
	    }
	    revalidate();
	    repaint();
	}
	
	private void addImageToPanel(JPanel panel, String imageName) {
	    try {
	        java.net.URL imgURL = getClass().getClassLoader().getResource("img/" + imageName + ".jpg");
	        if (imgURL == null) {
	            throw new RuntimeException("¡Ups! No se pudo encontrar la imagen para " + imageName);
	        }
	        ImageIcon imageIcon = new ImageIcon(imgURL);
	        Image image = imageIcon.getImage();
	        Image newimg = image.getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH); 
	        imageIcon = new ImageIcon(newimg);

	        JLabel label = new JLabel(imageIcon);
	        panel.add(label, "front");
	    } catch (Exception e) {
	        System.err.println("¡Ups! Hubo un error al cargar la imagen " + imageName + ": " + e.getMessage());
	    }
	}

	private void initializeMenu() {
		JMenuBar barraMenu = new JMenuBar();
		JMenu menuOpciones = new JMenu("Opciones");

		JMenuItem itemHistorial = new JMenuItem("Historial");
		itemHistorial.addActionListener(e -> showHistory());
		menuOpciones.add(itemHistorial);

		JMenuItem itemGuardarPartida = new JMenuItem("Guardar partida");
		itemGuardarPartida.addActionListener(e -> saveGame());
		menuOpciones.add(itemGuardarPartida);

		JMenuItem itemReiniciar = new JMenuItem("Reiniciar juego");
		itemReiniciar.addActionListener(e -> resetGame());
		menuOpciones.add(itemReiniciar);

		JMenuItem itemAcercaDe = new JMenuItem("Acerca de");
		itemAcercaDe.addActionListener(e -> showAbout());
		menuOpciones.add(itemAcercaDe);

		JMenuItem itemSalir = new JMenuItem("Salir");
		itemSalir.addActionListener(e -> System.exit(0));
		menuOpciones.add(itemSalir);

		barraMenu.add(menuOpciones);
		setJMenuBar(barraMenu);
	}

	private void showHistory() {
		JTextArea areaHistorial = new JTextArea();
		areaHistorial.setEditable(false);
		areaHistorial.setRows(10);
		areaHistorial.setColumns(30);

		StringBuilder textoHistorial = new StringBuilder();
		for (String record : history) {
			textoHistorial.append(record).append("\n");
		}
		areaHistorial.setText(textoHistorial.toString());

		JScrollPane scrollPane = new JScrollPane(areaHistorial);
		JOptionPane.showMessageDialog(this, scrollPane, "Historial de jugadores", JOptionPane.PLAIN_MESSAGE);
	}

	private void showAbout() {
		Icon icon = UIManager.getIcon("OptionPane.informationIcon");
		String message = "Memory Game\nVersión 5.0\nDesarrollado por: JAS";
		JOptionPane.showMessageDialog(this, message, "Acerca de", JOptionPane.INFORMATION_MESSAGE, icon);
	}

	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();
		String[] position = clickedButton.getName().split(",");
		int row = Integer.parseInt(position[0]);
		int col = Integer.parseInt(position[1]);

		if (firstButton != null && secondButton != null) {
			return;
		}

		flipButton(row, col);
		attempts++;

		if (firstButton == null) {
			firstButton = clickedButton;
		} else if (secondButton == null && clickedButton != firstButton) {
			secondButton = clickedButton;
			if (!firstButton.getActionCommand().equals(secondButton.getActionCommand())) {
				timer.start();
			} else {
				firstButton.setEnabled(false);
				secondButton.setEnabled(false);
				firstButton = null;
				secondButton = null;
				pairsFound++;
				if (pairsFound == (rows * cols) / 2) {
					gameCompletion();
				}
			}
		}
	}

	private void gameCompletion() {
		long endTime = System.currentTimeMillis();                     // obtener tiempo actual
		Duration duration = Duration.ofMillis(endTime - startTime);
		long minutes = duration.toMinutes();
		long seconds = duration.minusMinutes(minutes).getSeconds();
		String timeElapsed;

		if (minutes > 0) {
			timeElapsed = minutes + " minutos y " + seconds + " segundos";
		} else {
			timeElapsed = seconds + " segundos";
		}

		String message = "¡Felicidades, " + playerName + "! Has encontrado todas las parejas en " + attempts + " intentos y " + timeElapsed
				+ ".";
		history.add(playerName + " - " + attempts + " intentos en " + timeElapsed);
		JOptionPane.showMessageDialog(this, message, "¡Juego completado!", JOptionPane.INFORMATION_MESSAGE);
		int choice = JOptionPane.showConfirmDialog(this, "¿Quieres volver a jugar?", "New Game",
				JOptionPane.YES_NO_OPTION);
		if (choice == JOptionPane.YES_OPTION) {
			resetGame();
		} else {
			System.exit(0);
		}
	}

	private void flipButton(int row, int col) {
		cardLayouts[row][col].next(panels[row][col]);
	}

	private void flipBack(JButton button) {
		String[] position = button.getName().split(",");
		int row = Integer.parseInt(position[0]);
		int col = Integer.parseInt(position[1]);
		cardLayouts[row][col].previous(panels[row][col]);
	}

	private void resetGame() {
		selectTheme();
	}

	private String getGameData() {
		StringBuilder data = new StringBuilder();
		data.append("Jugador: ").append(playerName).append("\n");

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				JButton button = (JButton) panels[i][j].getComponent(0);
				String cardState = button.isEnabled() ? "Oculta" : "Volteada";
				data.append("Carta en la posición (").append(i).append(",").append(j).append("): ").append(cardState)
						.append("\n");
			}
		}
		return data.toString();
	}

	private void saveGame() {
		String gameData = getGameData();
		GameSaver.saveGame("saved_game.txt", gameData);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(MemoryGame::new);
	}
}