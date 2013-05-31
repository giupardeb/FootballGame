import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

	public class DatabaseGiocatori {
		private final static byte INITIALISE = -1;
		private static final String CENTROCAMPISTA = "Centrocampista";
		private static final String PORTIERE = "Portiere";
		private static final String ATTACCANTE = "Attaccante";
		private static final String DIFENSORE = "Difensore";
		ArrayList <String> squadrecreate = new ArrayList<String>();
		String squadreesistenti[] = new String [19];

		static public Giocatore giocatori[];


		 

			
			
		
		///////////////////////////////////////////////////****////////////////////////////////////////////////	
		//crea il database
		
		public DatabaseGiocatori(){
			
			 
				 	squadreesistenti[0] = "Atalanta";
					squadreesistenti[1] = "Catania";
					squadreesistenti[2] = "Parma";
					squadreesistenti[3] = "Chievoverona";
					squadreesistenti[4] = "Inter";
					squadreesistenti[5] = "Milan";
					squadreesistenti[6] = "Juventus";
					squadreesistenti[7] = "Palermo";
					squadreesistenti[8] = "Cagliari";
					squadreesistenti[9] = "Pescara";
					squadreesistenti[10] = "Lazio";
					squadreesistenti[11] = "Roma";
					squadreesistenti[12] = "Sampdoria";
					squadreesistenti[13] = "Genoa";		
					squadreesistenti[14] = "Siene";
					squadreesistenti[15] = "Udinese";
					squadreesistenti[16] = "Bologna";
					squadreesistenti[17] = "Fiorentina";
					squadreesistenti[18] = "Napoli";
			
			
			
			
			
			try{
				giocatori = read("database.csv");
			}
			catch(IOException e){
				e.printStackTrace();

			}
			
		}
			
		
		

		
		private  Giocatore[] read(String fileName)  throws IOException  {
			// Ha più senso avere queste due linee dentro
			ArrayList <Giocatore> players  = new ArrayList<Giocatore>();
			int i = 0; // TIP: usa degli spazi invece di i=0. il codice è più leggibile.

			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String currentLine;
			while ((currentLine = br.readLine()) != null) {
				Giocatore player = giocatore(currentLine);
				 players.add(player);
			}
			br.close();
			return (Giocatore[]) players.toArray(); //che ne pensi di sta cosa SIMO? 
		}
		
		
		
		
		
		
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
				
				if(ruolo == CENTROCAMPISTA || ruolo == ATTACCANTE || ruolo == DIFENSORE){
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
		
	///////////////////////////////////////////////////****////////////////////////////////////////////////	
		
		
		public SquadraUmano CreaSquadra(String nome) {
			squadrecreate.add(nome);
			
			SquadraUmano squadraMia = new SquadraUmano(GetGiocatori(nome),nome);
			return squadraMia;
			
		}
		
		private ArrayList <Giocatore> GetGiocatori(String nome){
			ArrayList <Giocatore> squadra = new ArrayList <Giocatore>();
			for(int i = 0; i<giocatori.length;i++)
				if(giocatori[i].getSquadra().equalsIgnoreCase(nome)) squadra.add(giocatori[i]);
			
			return squadra;
			
		}
		
		public SquadraAvversaria CreaSquadre(){
			String nomesquadradacreare = "";
			for(int i = 0; i<squadreesistenti.length;i++)
				for(String j : squadrecreate)
					if(!(squadreesistenti[i].equalsIgnoreCase(j))) nomesquadradacreare = j;
			
			
			squadrecreate.add(nomesquadradacreare);
			
			
			SquadraAvversaria squadra = new SquadraAvversaria(GetGiocatori(nomesquadradacreare),nomesquadradacreare);
			return squadra;
			
			
		}
		
		
		
	}
	