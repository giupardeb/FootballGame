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
	
	// NOTE
	// Non so se utilizzi questo file, quindi ti faccio notare che qui c'era un errore di sintassi
	// In pratica non tornavi Giocatori[] ma qualcos'altro.
	private static Giocatori[] read(String fileName)  throws IOException  {
		// Ha più senso avere queste due linee dentro
		Giocatori vett[] = new Giocatore [568];
		int i = 0; // TIP: usa degli spazi invece di i=0. il codice è più leggibile.

		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String currentLine;
		while ((currentLine = br.readLine()) != null) {
			Giocatore player = giocatore(currentLine);
			vett[i++] = player;
		}
		br.close();
		return vett;
	}
	
	private static final String CENTROCAMPISTA = "Centrocampista";
	private static final String PORTIERE = "Portiere";
	private static final String ATTACCANTE = "Attaccante";
	private static final String DIFENSORE = "Difensore";

	// TODO Questo torner� Giocatore e non Object
	private static Giocatore giocatore(String line) {
		String[] giocatoreString = line.split(",");
		
		String ruolo = giocatoreString[0]; // Difensore, Centrocampista, Attaccante o Portiere
		
			String nome = giocatoreString[1];
			String squadra = giocatoreString[2];
			String nazionalita = giocatoreString[3];
			byte velocita = Byte.parseByte(giocatoreString[4]);
			byte resistenza = Byte.parseByte(giocatoreString[5]);
			byte forza = Byte.parseByte(giocatoreString[6]);
			byte morale = Byte.parseByte(giocatoreString[7]);
			byte eta = Byte.parseByte(giocatoreString[8]);
			byte condizione = Byte.parseByte(giocatoreString[9]);
			byte tecnica = Byte.parseByte(giocatoreString[10]);
			byte aggressivita = Byte.parseByte(giocatoreString[11]);
			byte creativita = Byte.parseByte(giocatoreString[12]);
			byte decisione = Byte.parseByte(giocatoreString[13]);
			byte carisma = Byte.parseByte(giocatoreString[14]);
			String posizione = giocatoreString[15];
			byte giocoDiSquadra = Byte.parseByte(giocatoreString[16]);
			boolean essenziale = Boolean.parseBoolean(giocatoreString[17]);
			byte mediaVoti = Byte.parseByte(giocatoreString[18]);
			
			if(ruolo == CENTROCAMPISTA || ruolo == ATTACCANTE || ruolo == DIFENSORE){
				byte cross = Byte.parseByte(giocatoreString[19]);
				byte dribling = Byte.parseByte(giocatoreString[20]);
				byte colpoDiTesta = Byte.parseByte(giocatoreString[21]);
				byte passaggio = Byte.parseByte(giocatoreString[22]);
				byte tiro = Byte.parseByte(giocatoreString[23]);
				byte contrasto = Byte.parseByte(giocatoreString[24]);
				byte movimento = Byte.parseByte(giocatoreString[25]);
				byte abilitaDifesa = Byte.parseByte(giocatoreString[26]);
				byte abilitaAttacco = Byte.parseByte(giocatoreString[27]);
				byte abilitaCentrcampo = Byte.parseByte(giocatoreString[28]);
				byte valoreGenerale = Byte.parseByte(giocatoreString[29]);
				double valoreMercato = Double.parseDouble(giocatoreString[30]);
			}
			else{
				byte dotiAeree = Byte.parseByte(giocatoreString[19]);
				byte agilita = Byte.parseByte(giocatoreString[20]);
				byte comunicazione = Byte.parseByte(giocatoreString[21]);
				byte bloccareTiro = Byte.parseByte(giocatoreString[22]);
				byte calciare = Byte.parseByte(giocatoreString[23]);
				byte riflessi = Byte.parseByte(giocatoreString[24]);
				byte rimessa = Byte.parseByte(giocatoreString[25]);
				byte valoreGenerale = Byte.parseByte(giocatoreString[26]);
				double valoreMercato = Double.parseDouble(giocatoreString[27]);
			}
		
		
		// TODO - per ogni caratteristica! 
		// TODO casting per (byte)'s e booleans 
		
		// NOTE devi definire il giocatore, altrimenti non lo puoi ritornare.
		// Inoltre ti ho aggiustato un pò gli else if, così il codice è + leggibile
		Giocatore giocatore = null;
		if (ruolo == CENTROCAMPISTA) {
			 giocatore = new Centrocampista(nome, squadra, nazionalita, 
			 								velocita, resistenza, forza, 
			 								morale, eta, condizione, 
			 								tecnica, aggressivita, creativita, 
			 								decisione, carisma, posizione, 
			 								giocoDiSquadra, essenziale, mediaVoti, 
			 								cross, dribling, colpoDiTesta, 
			 								passaggio, tiro, contrasto, 
			 								movimento, abilitaDifesa, abilitaAttacco, 
			 								abilitaCentrcampo, valoreGenerale, valoreMercato);
		} else if(ruolo == PORTIERE) {
			giocatore = new Portiere(nome, squadra, nazionalita, 
									velocita, resistenza, forza, 
									morale, eta, condizione, 
									tecnica, aggressivita, creativita, 
									decisione, carisma, posizione, 
									giocoDiSquadra, essenziale, mediaVoti, 
									dotiAeree, agilita, comunicazione, 
									bloccareTiro, calciare, riflessi, 
									rimessa, valoreGenerale, valoreMercato);
		} else if (ruolo == ATTACCANTE) {
			giocatore = new Attaccante(nome, squadra, nazionalita, 
									velocita, resistenza, forza, 
									morale, eta, condizione, 
									tecnica, aggressivita, creativita, 
									decisione, carisma, posizione, 
									giocoDiSquadra, essenziale, mediaVoti, 
									cross, dribling, colpoDiTesta, 
									passaggio, tiro, contrasto, 
									movimento, abilitaDifesa, abilitaAttacco, 
									abilitaCentrcampo, valoreGenerale, valoreMercato);
		} else if(ruolo == DIFENSORE) {
			 giocatore = new Difensore(nome, squadra, nazionalita, 
			 						velocita, resistenza, forza, 
			 						morale, eta, condizione, 
			 						tecnica, aggressivita, creativita, 
			 						decisione, carisma, posizione, 
			 						giocoDiSquadra, essenziale, mediaVoti, 
			 						cross, dribling, colpoDiTesta, 
			 						passaggio, tiro, contrasto, 
			 						movimento, abilitaDifesa, abilitaAttacco, 
			 						abilitaCentrcampo, valoreGenerale, valoreMercato);
		}
		
		return giocatore;
	}

}
