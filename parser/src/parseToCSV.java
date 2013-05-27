import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class parseToCSV {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			parse("DatabaseGiocatori.java");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void parse(String nameFile) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(nameFile));
		String currentLine;
		ArrayList<ArrayList<String>> giocatori = new ArrayList<ArrayList<String>>();
		while ((currentLine = br.readLine()) != null) {
			ArrayList<String> player = giocatore(currentLine);
			if (player != null) {
				giocatori.add(player);
			}
		}
		br.close();
		
		// Write to file
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("database.csv"), "utf-8"));
		for(ArrayList<String> list:giocatori) {
			for(int i = 0; i < list.size(); i++) {
				writer.write(list.get(i));
				if (i != list.size() - 1)
					writer.write(",");
			}
			writer.write("\n");
		}
		writer.close();
	}

	private static final String NEW = "new";
	private static final String GIOCATORE = "Giocatore";
	private static final String VETT = "vett";

	private static final String CENTROCAMPISTA = "Centrocampista";
	private static final String PORTIERE = "Portiere";
	private static final String ATTACCANTE = "Attaccante";
	private static final String DIFENSORE = "Difensore";

	private static final String REGEX = "new (.*?)\\((.*?)\\);";
	private static final String NUMBER_REGEX = "\\(byte\\)(\\d+)";
	private static final String STRING_REGEX = "\"(.*?)\"";

	public static ArrayList<String> giocatore(String line) {
		ArrayList<String> player = null;
		if (line.contains(NEW) && line.contains(VETT) && !line.contains(GIOCATORE)) {
			 player = new ArrayList<String>();

			// Primo elemento in lista è il ruolo
			if (line.contains(CENTROCAMPISTA)) {
				player.add(CENTROCAMPISTA);
			} else if (line.contains(PORTIERE)) {
				player.add(PORTIERE);
			} else if (line.contains(ATTACCANTE)) {
				player.add(ATTACCANTE);
			} else if (line.contains(DIFENSORE)) {
				player.add(DIFENSORE);
			}

			// Aggiungi tutti gli altri ruoli
			Pattern r = Pattern.compile(REGEX);
			Pattern r_0 = Pattern.compile(STRING_REGEX);
			Pattern r_1 = Pattern.compile(NUMBER_REGEX);
			
			Matcher m = r.matcher(line);
			if(m.find()) {
				String[] caratteristiche = m.group(2).split(",");
				for(int i = 0; i < caratteristiche.length; i++) {
					Matcher m_0 = r_0.matcher(caratteristiche[i]);
					if (m_0.find()) 
						caratteristiche[i] = m_0.group(1);
					
					Matcher m_1 = r_1.matcher(caratteristiche[i]);
					if(m_1.find()) {
						caratteristiche[i] = m_1.group(1);
					}
					
					player.add(caratteristiche[i]);
				}
				
				/*
				for(String s : caratteristiche)
					System.out.print(s + " ");
				 */
			}
		}

		return player;

	}
}
