import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class parseFromCSV {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			read("database.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// TODO Return list giocatori
	private static void read(String fileName)  throws IOException  {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String currentLine;
		while ((currentLine = br.readLine()) != null) {
			// TODO aggiungere giocatore ad arraylist di giocatori
			Object player = giocatore(currentLine);
		}
		br.close();
	}
	
	private static final String CENTROCAMPISTA = "Centrocampista";
	private static final String PORTIERE = "Portiere";
	private static final String ATTACCANTE = "Attaccante";
	private static final String DIFENSORE = "Difensore";

	// TODO Questo tornerˆ Giocatore e non Object
	private static Object giocatore(String line) {
		String[] giocatoreString = line.split(",");
		
		String ruolo = giocatoreString[0]; // Difensore, Centrocampista, Attaccante o Portiere
		
		String nome = giocatoreString[1];
		// TODO - per ogni caratteristica! 
		// TODO casting per (byte)'s e booleans 
		
		// Giocatore giocatore = null;
		if (ruolo == CENTROCAMPISTA) {
			// giocatore = new centrocampista(....)
		} else {
			// TODO - per ogni ruolo
		}
		
		// TODO return giocatore;
		return null;
	}

}
