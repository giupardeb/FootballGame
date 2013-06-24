package Project;
import java.util.ArrayList;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class DatabaseGiocatori {
	private final static byte INITIALISE = -1;
	private static final String CENTROCAMPISTA = "Centrocampista";
	private static final String PORTIERE = "Portiere";
	private static final String ATTACCANTE = "Attaccante";
	private static final String DIFENSORE = "Difensore";
	Stack<String> squadreesistenti = new Stack<String>();


	private static Giocatore giocatori[];

	///////////////////////////////////////////////////****////////////////////////////////////////////////	
	//crea il database

	public DatabaseGiocatori(){

		//Sto creando una pila, in maniera tale da facilitarmi il compito di creare le squadre avversarie.

		squadreesistenti.push("Atalanta");
		squadreesistenti.push("Catania");
		squadreesistenti.push("Parma");
		squadreesistenti.push("Chievo");
		squadreesistenti.push("Inter");
		squadreesistenti.push("Milan");
		squadreesistenti.push("Juventus");
		squadreesistenti.push("Palermo");
		squadreesistenti.push("Cagliari");
		squadreesistenti.push("Pescara");
		squadreesistenti.push("Lazio");
		squadreesistenti.push("Roma");
		squadreesistenti.push("Sampdoria");
		squadreesistenti.push("Genoa");
		squadreesistenti.push("Siena");
		squadreesistenti.push("Udinese");
		squadreesistenti.push("Bologna");
		squadreesistenti.push("Fiorentina");
		squadreesistenti.push("Napoli");
		squadreesistenti.push("Torino");

		try{
			giocatori = read("database.csv");
		}
		catch(IOException e){
			e.printStackTrace();

		}

	}





	private  Giocatore[] read(String fileName)  throws IOException  {
		ArrayList <Giocatore> players  = new ArrayList<Giocatore>();
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String currentLine;

		while ((currentLine = br.readLine()) != null) {
			Giocatore player = giocatore(currentLine);
			players.add(player);
		}
		br.close();
		return players.toArray(new Giocatore[players.size()]); 
	}






	private Giocatore giocatore(String line) {
		String[] giocatoreString = line.split(",");

		String ruolo = giocatoreString[0]; // Difensore, Centrocampista, Attaccante o Portiere

		String nome = giocatoreString[1];
		String NomeSquadraAppartenente = giocatoreString[2];
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
		//Altriruoli
		byte cross = INITIALISE;
		byte dribling = INITIALISE;
		byte colpoDiTesta = INITIALISE;
		byte passaggio = INITIALISE;
		byte tiro = INITIALISE;
		byte contrasto = INITIALISE;
		byte movimento = INITIALISE;
		byte abilitaDifesa = INITIALISE;
		byte abilitaAttacco = INITIALISE;
		byte abilitaCentrcampo = INITIALISE;
		byte valoreGenerale = INITIALISE;
		double valoreMercato = INITIALISE;

		//Portiere

		byte dotiAeree = INITIALISE;
		byte agilita = INITIALISE;
		byte comunicazione = INITIALISE;
		byte bloccareTiro = INITIALISE;
		byte calciare = INITIALISE;
		byte riflessi = INITIALISE;
		byte rimessa = INITIALISE;

		if(ruolo.equalsIgnoreCase(CENTROCAMPISTA) || ruolo.equalsIgnoreCase(ATTACCANTE) || ruolo.equalsIgnoreCase(DIFENSORE)){
			cross = Byte.parseByte(giocatoreString[19]);
			dribling = Byte.parseByte(giocatoreString[20]);
			colpoDiTesta = Byte.parseByte(giocatoreString[21]);
			passaggio = Byte.parseByte(giocatoreString[22]);
			tiro = Byte.parseByte(giocatoreString[23]);
			contrasto = Byte.parseByte(giocatoreString[24]);
			movimento = Byte.parseByte(giocatoreString[25]);
			abilitaDifesa = Byte.parseByte(giocatoreString[26]);
			abilitaAttacco = Byte.parseByte(giocatoreString[27]);
			abilitaCentrcampo = Byte.parseByte(giocatoreString[28]);
			valoreGenerale = Byte.parseByte(giocatoreString[29]);
			valoreMercato = Double.parseDouble(giocatoreString[30]);
		}
		else{
			dotiAeree = Byte.parseByte(giocatoreString[19]);
			agilita = Byte.parseByte(giocatoreString[20]);
			comunicazione = Byte.parseByte(giocatoreString[21]);
			bloccareTiro = Byte.parseByte(giocatoreString[22]);
			calciare = Byte.parseByte(giocatoreString[23]);
			riflessi = Byte.parseByte(giocatoreString[24]);
			rimessa = Byte.parseByte(giocatoreString[25]);
			valoreGenerale = Byte.parseByte(giocatoreString[26]);
			valoreMercato = Double.parseDouble(giocatoreString[27]);
		}

		// IL VALORE NULL NEL COSTRUTTORE DI GIOCATORE SI RIFERISCE ALL'OGGETTO SQUADRA AL QUALE APPARTIENE

		Giocatore giocatore = null;
		if (ruolo.equalsIgnoreCase(CENTROCAMPISTA)) {
			giocatore = new Centrocampista(nome, NomeSquadraAppartenente, nazionalita, 
					velocita, resistenza, forza, 
					morale, eta, condizione, 
					tecnica, aggressivita, creativita, 
					decisione, carisma, posizione, 
					giocoDiSquadra, essenziale, mediaVoti,null, 
					cross, dribling, colpoDiTesta, 
					passaggio, tiro, contrasto, 
					movimento, abilitaDifesa, abilitaAttacco, 
					abilitaCentrcampo, valoreGenerale, valoreMercato);

		} else if(ruolo.equalsIgnoreCase(PORTIERE)) {
			giocatore = new Portiere(nome, NomeSquadraAppartenente, nazionalita, 
					velocita, resistenza, forza, 
					morale, eta, condizione, 
					tecnica, aggressivita, creativita, 
					decisione, carisma, posizione, 
					giocoDiSquadra, essenziale, mediaVoti,null, 
					dotiAeree, agilita, comunicazione, 
					bloccareTiro, calciare, riflessi, 
					rimessa, valoreGenerale, valoreMercato);
		} else if (ruolo.equalsIgnoreCase(ATTACCANTE)) {
			giocatore = new Attaccante(nome, NomeSquadraAppartenente, nazionalita, 
					velocita, resistenza, forza, 
					morale, eta, condizione, 
					tecnica, aggressivita, creativita, 
					decisione, carisma, posizione, 
					giocoDiSquadra, essenziale, mediaVoti,null,
					cross, dribling, colpoDiTesta, 
					passaggio, tiro, contrasto, 
					movimento, abilitaDifesa, abilitaAttacco, 
					abilitaCentrcampo, valoreGenerale, valoreMercato);
		} else if(ruolo.equalsIgnoreCase(DIFENSORE)) {
			giocatore = new Difensore(nome, NomeSquadraAppartenente, nazionalita, 
					velocita, resistenza, forza, 
					morale, eta, condizione, 
					tecnica, aggressivita, creativita, 
					decisione, carisma, posizione, 
					giocoDiSquadra, essenziale, mediaVoti,null, 
					cross, dribling, colpoDiTesta, 
					passaggio, tiro, contrasto, 
					movimento, abilitaDifesa, abilitaAttacco, 
					abilitaCentrcampo, valoreGenerale, valoreMercato);
		}

		return giocatore;
	}

	///////////////////////////////////////////////////****////////////////////////////////////////////////	


	public SquadraUmano CreaSquadra(String nome) {

		SquadraUmano squadraMia = new SquadraUmano(GetGiocatori(nome),nome);
		return squadraMia;

	}

	private ArrayList <Giocatore> GetGiocatori(String nome){
		ArrayList <Giocatore> squadra = new ArrayList <Giocatore>();
		for(int i = 0; i<giocatori.length; i++)
			if(giocatori[i].getSquadra().equalsIgnoreCase(nome)) squadra.add(giocatori[i]);

		return squadra;

	}

	public SquadraAvversaria CreaSquadre(String squadrautente){
		String nomesquadradacreare = new String(squadreesistenti.pop());
		if(!(nomesquadradacreare.equalsIgnoreCase(squadrautente))){
			SquadraAvversaria squadra = new SquadraAvversaria(GetGiocatori(nomesquadradacreare),nomesquadradacreare);
			return squadra;
		}
		return null;
	}

	public Giocatore [] GetDb(){
		return giocatori;
	}
	
	
	public int GetIndice(String cognome){
		for(int i = 0; i<giocatori.length; i++)
			if(giocatori[i].GetAnagrafe().GetCognome().equalsIgnoreCase(cognome)) return i;
		return -1;
	}
}
