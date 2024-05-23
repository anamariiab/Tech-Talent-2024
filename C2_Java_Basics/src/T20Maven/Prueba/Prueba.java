package T20Maven.Prueba;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Prueba extends JFrame implements ActionListener {
    private final int rows = 4;
    private final int cols = 4;
    private JPanel[][] panels;
    private CardLayout[][] cardLayouts;
    private String[] names = {
        "Leon", "Tigre", "Elefante", "Jirafa",
        "Cebra", "Mono", "Canguro", "Panda"
    };
    private String[] shuffledNames;
    private JButton firstButton;
    private JButton secondButton;
    private Timer timer;
    private String playerName;
    private int pairsFound;
    private int attempts;
    private List<String> history;
    private long startTime;
    
    public Prueba() {
        history = new ArrayList<>();
        initializeGame();
        ImageIcon icon = new ImageIcon("C:\\Users\\Ana-Maria B\\Desktop\\imagenes_cartas_memorygame\\memory_icon.jpg");
        setIconImage(icon.getImage());
    }

    private void initializeGame() {
        playerName = getPlayerName();
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
        return JOptionPane.showInputDialog(this, "Gamertag:", "Gamertag del Player", JOptionPane.PLAIN_MESSAGE);
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
        getContentPane().removeAll();  // Clear previous panels
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cardLayouts[i][j] = new CardLayout();
                panels[i][j] = new JPanel(cardLayouts[i][j]);

                JButton button = new JButton();
                button.addActionListener(this);
                button.setActionCommand(shuffledNames[i * cols + j]);
                button.setName(i + "," + j);
                panels[i][j].add(button, "back");

                // Load image from file
                ImageIcon imageIcon = new ImageIcon("C:\\Users\\Ana-Maria B\\Desktop\\imagenes_cartas_memorygame\\" + shuffledNames[i * cols + j] + ".jpg");
                Image image = imageIcon.getImage(); 
                Image newimg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); 
                imageIcon = new ImageIcon(newimg);  

                JLabel label = new JLabel(imageIcon);
                panels[i][j].add(label, "front");

                add(panels[i][j]);
            }
        }
        revalidate();
        repaint();
    }

    private void initializeMenu() {
        JMenuBar barraMenu = new JMenuBar();
        JMenu menuOpciones = new JMenu("Opciones");

        JMenuItem itemHistorial = new JMenuItem("Historial");
        itemHistorial.addActionListener(e -> showHistory());
        menuOpciones.add(itemHistorial);

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
        StringBuilder historyMessage = new StringBuilder("Historial de jugadores:\n");
        for (String record : history) {
            historyMessage.append(record).append("\n");
        }
        JOptionPane.showMessageDialog(this, historyMessage.toString(), "Historial", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showAbout() {
        Icon icon = UIManager.getIcon("OptionPane.informationIcon");
        String message = "Memory Game\nVersión 1.0\nDesarrollado por: JAS";
        JOptionPane.showMessageDialog(this, message, "Acerca de", JOptionPane.INFORMATION_MESSAGE, icon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        String[] position = clickedButton.getName().split(",");
        int row = Integer.parseInt(position[0]);
        int col = Integer.parseInt(position[1]);

        if (firstButton != null && secondButton != null) {
            return; // Ignore clicks if two cards are already flipped
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
                    long endTime = System.currentTimeMillis();
                    long elapsedTime = (endTime - startTime) / 1000; // Tiempo transcurrido en segundos
                    long minutes = elapsedTime / 60; // Obtener los minutos
                    long seconds = elapsedTime % 60; // Obtener los segundos restantes

                    String timeElapsed;
                    if (minutes > 0) {
                        timeElapsed = String.format("%d minutos y %d segundos", minutes, seconds);
                    } else {
                        timeElapsed = String.format("%d segundos", seconds);
                    }

                    String message = "¡Felicidades " + playerName + "! Has encontrado todas las parejas en " + attempts + " intentos y " + timeElapsed + ".";
                    history.add(playerName + " - " + attempts + " intentos en " + timeElapsed); // Añadir al historial
                    JOptionPane.showMessageDialog(this, message, "¡Felicidades!", JOptionPane.INFORMATION_MESSAGE);
                    resetGame();
                }
            }
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
        initializeGame();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Prueba::new);
    }
}
