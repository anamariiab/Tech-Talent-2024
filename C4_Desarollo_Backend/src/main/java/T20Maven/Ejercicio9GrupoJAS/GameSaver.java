package T20Maven.Ejercicio9GrupoJAS;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GameSaver {

	public static void saveGame(String fileName, String gameData) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			writer.write(gameData);
			System.out.println("Partida guardada con exito en: " + fileName);
		} catch (IOException e) {
			System.err.println("ERROR al guardar la partida: " + e.getMessage());
		}
	}

}
