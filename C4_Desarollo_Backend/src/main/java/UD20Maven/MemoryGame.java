package UD20Maven;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
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
    private List<String> history;
    private long startTime;
    private String player1Name;
    private String player2Name;
    private boolean isPlayer1Turn;
    private boolean isGameOver;
    private int pairsFound;
    private int attempts;
    private int player1Pairs;
    private int player2Pairs;
    private int player1Attempts;
    private int player2Attempts;
    private long player1Time;
    private long player2Time;
    private boolean isMultiplayer;

    public MemoryGame() {
        history = new ArrayList<>();
        selectThemeAndMode();
        initializeGame();
    }

    private void selectThemeAndMode() {
        String[] themes = {"Animales", "Frutas"};
        String[] gameModes = {"Singleplayer", "Multiplayer"};

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JComboBox<String> themeComboBox = new JComboBox<>(themes);
        JComboBox<String> modeComboBox = new JComboBox<>(gameModes);

        panel.add(new JLabel("Selecciona un tema:"));
        panel.add(themeComboBox);
        panel.add(new JLabel("Selecciona el modo de juego:"));
        panel.add(modeComboBox);

        int result = JOptionPane.showConfirmDialog(
                this,
                panel,
                "Configuración del Juego",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String selectedTheme = (String) themeComboBox.getSelectedItem();
            String selectedMode = (String) modeComboBox.getSelectedItem();

            if (selectedTheme != null && selectedMode != null) {
                if (selectedTheme.equals("Animales")) {
                    names = new String[]{"Leon", "Tigre", "Elefante", "Jirafa", "Cebra", "Mono", "Canguro", "Panda"};
                } else if (selectedTheme.equals("Frutas")) {
                    names = new String[]{"Manzana", "Platano", "Fresa", "Naranja", "Pera", "Uva", "Kiwi", "Piña"};
                }

                isMultiplayer = selectedMode.equals("Multiplayer");

                if (isMultiplayer) {
                    initializeMultiplayer();
                } else {
                    initializeSingleplayer();
                }
            } else {
                System.exit(0);
            }
        } else {
            System.exit(0);
        }
    }

    private void initializeSingleplayer() {
        player1Name = JOptionPane.showInputDialog(this, "Nombre del Jugador:", "MemoryGame", JOptionPane.PLAIN_MESSAGE);
        isPlayer1Turn = true; // Un solo jugador, siempre es su turno
    }

    private void initializeMultiplayer() {
        player1Name = JOptionPane.showInputDialog(this, "Nombre del Jugador 1:", "MemoryGame", JOptionPane.PLAIN_MESSAGE);
        player2Name = JOptionPane.showInputDialog(this, "Nombre del Jugador 2:", "MemoryGame", JOptionPane.PLAIN_MESSAGE);
        isPlayer1Turn = true;
        player1Pairs = 0;
        player2Pairs = 0;
        player1Attempts = 0;
        player2Attempts = 0;
        player1Time = 0;
        player2Time = 0;
    }

    private void initializeGame() {
        setTitle("MemoryGame");
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
            if (isMultiplayer) {
                isPlayer1Turn = !isPlayer1Turn;
                setTitle(isPlayer1Turn ? "Turno de " + player1Name : "Turno de " + player2Name);
            }
        });
        timer.setRepeats(false);

        startTime = System.currentTimeMillis();

        setVisible(true);
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
        getContentPane().removeAll();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cardLayouts[i][j] = new CardLayout();
                panels[i][j] = new JPanel(cardLayouts[i][j]);

                JButton button = new JButton();
                button.addActionListener(this);
                button.setActionCommand(shuffledNames[i * cols + j]);
                button.setName(i + "," + j);
                panels[i][j].add(button, "back");

                ImageIcon imageIcon = new ImageIcon("C:\\Users\\Ana-Maria B\\Desktop\\imagenes_cartas_memorygame\\" + shuffledNames[i * cols + j] + ".jpg");
                Image image = imageIcon.getImage();
                Image newimg = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
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
        String message = "Memory Game\nVersión 4.0\nDesarrollado por: JAS";
        JOptionPane.showMessageDialog(this, message, "Acerca de", JOptionPane.INFORMATION_MESSAGE, icon);
    }

    @Override
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
        if (isPlayer1Turn) {
            player1Attempts++;
        } else {
            player2Attempts++;
        }

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
                if (isPlayer1Turn) {
                    player1Pairs++;
                } else {
                    player2Pairs++;
                }

                if (pairsFound == (rows * cols) / 2) {
                    long endTime = System.currentTimeMillis();
                    if (isPlayer1Turn) {
                        player1Time = endTime - startTime;
                    } else {
                        player2Time = endTime - startTime;
                    }

                    if (isMultiplayer) {
                        handleMultiplayerEndOfTurn();
                    } else {
                        handleSingleplayerEndOfGame();
                    }
                }
            }
        }
    }

    private void handleSingleplayerEndOfGame() {
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

        String message = "¡Felicidades, " + player1Name + "!\nHas completado el juego en " + attempts + " intentos y " + timeElapsed + ".";
        JOptionPane.showMessageDialog(this, message);
        history.add(player1Name + ": " + attempts + " intentos, " + timeElapsed);

        // Aquí podrías guardar el resultado en un archivo o base de datos si quieres mantener un historial persistente
    }

    private void handleMultiplayerEndOfTurn() {
        isPlayer1Turn = !isPlayer1Turn;
        setTitle(isPlayer1Turn ? "Turno de " + player1Name : "Turno de " + player2Name);

        if (pairsFound == (rows * cols) / 2) {
            if (player1Pairs > player2Pairs) {
                showWinner(player1Name, player1Attempts, player1Time);
            } else if (player2Pairs > player1Pairs) {
                showWinner(player2Name, player2Attempts, player2Time);
            } else {
                if (player1Attempts < player2Attempts) {
                    showWinner(player1Name, player1Attempts, player1Time);
                } else if (player2Attempts < player1Attempts) {
                    showWinner(player2Name, player2Attempts, player2Time);
                } else {
                    if (player1Time < player2Time) {
                        showWinner(player1Name, player1Attempts, player1Time);
                    } else if (player2Time < player1Time) {
                        showWinner(player2Name, player2Attempts, player2Time);
                    } else {
                        JOptionPane.showMessageDialog(this, "¡Empate!");
                    }
                }
            }
            resetGame();
        }
    }

    private void showWinner(String winner, int attempts, long time) {
        long elapsedTime = time / 1000; // Tiempo transcurrido en segundos
        long minutes = elapsedTime / 60; // Obtener los minutos
        long seconds = elapsedTime % 60; // Obtener los segundos restantes

        String timeElapsed;
        if (minutes > 0) {
            timeElapsed = String.format("%d minutos y %d segundos", minutes, seconds);
        } else {
            timeElapsed = String.format("%d segundos", seconds);
        }

        String message = "¡Felicidades, " + winner + "!\nHas ganado en " + attempts + " intentos y " + timeElapsed + ".";
        JOptionPane.showMessageDialog(this, message);
        history.add(winner + ": " + attempts + " intentos, " + timeElapsed);
    }

    private void flipButton(int row, int col) {
        cardLayouts[row][col].next(panels[row][col]);
    }

    private void flipBack(JButton button) {
        int[] position = getButtonPosition(button);
        cardLayouts[position[0]][position[1]].previous(panels[position[0]][position[1]]);
    }

    private int[] getButtonPosition(JButton button) {
        String[] position = button.getName().split(",");
        return new int[]{Integer.parseInt(position[0]), Integer.parseInt(position[1])};
    }
    
    private void resetGame() {
        initializeGame();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MemoryGame::new);
    }
}