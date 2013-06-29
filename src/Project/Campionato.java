package Project;
import graphic.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;

public class Campionato 
{
	private static final int TIRA = 1;
	private static final int PASSAGGIO = 2;
	private static final int ABILITÀMINATTACCO = 70;
	private static final int PARATA = 9;
	private static final int FUORI = 10;
	private static final long TEMPO_PARTITA = 300000;
	// per il metodo partita, serve a far interagire l'utente con il gioco
	public int rilancia = 0;
	public	int tira = 0; 
	public	int passa = 0;
	public	int contrasto = 0;
	/**
	 * @uml.property  name="squadra"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public SquadraUmano squadra;

	/**
	 * @uml.property  name="squadre"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	public SquadraAvversaria squadre[] = new SquadraAvversaria [19];

	/**
	 * @uml.property  name="db"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public DatabaseGiocatori db;
	/**
	 * @uml.property  name="incontri"
	 */
	public Stack<SquadraAvversaria> Incontri = new Stack<SquadraAvversaria>(); //contiene le squadre con cui l'utente dovrà scontrarsi

	/**
	 * @uml.property  name="giocatoridavisualizzare"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	public Giocatore [] giocatoridavisualizzare = null;

	public Campionato(String miasquadra, JFrame j) //la squadra che l'utente sceglie viene decisa nel main.. tanto per fargli fare qualcosa dal main.. 
	{
		j.dispose();
		db = new DatabaseGiocatori();

		squadra = db.CreaSquadra(miasquadra);

		for(int i = 0; i<squadre.length; i++){
			squadre[i] = db.CreaSquadre(miasquadra);
			Incontri.push(squadre[i]);
			if(squadre[i] == null) i--;
		}

		RichiamaFinestraCampionato(db);
	}


	public int SearchSquadra(String nome){
		for(int i = 0; i<squadre.length;i++)
			if (squadre[i].GetNomeSquadra().equalsIgnoreCase(nome)) return i;
		return -1;

	}
	//per l'acquista
	public Giocatore [] VisualizzaGiocatori(String ruolo, String squadrautente){
		ArrayList <Giocatore> giocatoridavisualizzare = new ArrayList <Giocatore>();
		for(int z = 0; z<squadre.length;z++)
			for(Giocatore giocatore : squadre[z].GetSquadra())
				if(giocatore.getRuolo().equalsIgnoreCase(ruolo) && (!(giocatore.getSquadra().equalsIgnoreCase(squadrautente))))	
					giocatoridavisualizzare.add(giocatore);
		return giocatoridavisualizzare.toArray(new Giocatore [giocatoridavisualizzare.size()]);
	}

	//per lo scambio..
	public Giocatore [] VisualizzaGiocatori(String squadrautente){
		ArrayList <Giocatore> giocatoridavisualizzare = new ArrayList <Giocatore>();
		for(int z = 0; z<squadre.length;z++)
			for(Giocatore giocatore : squadre[z].GetSquadra())
				if(!(giocatore.getSquadra().equalsIgnoreCase(squadrautente)))
					giocatoridavisualizzare.add(giocatore);
		return giocatoridavisualizzare.toArray(new Giocatore [giocatoridavisualizzare.size()]);
	}

	public Giocatore [] VisualizzaGiocatoriMiei(){
		ArrayList <Giocatore> giocatoridavisualizzare = new ArrayList <Giocatore>();
		for(Giocatore giocatore : squadra.GetSquadra())
			giocatoridavisualizzare.add(giocatore);
		return giocatoridavisualizzare.toArray(new Giocatore [giocatoridavisualizzare.size()]);
	}

	public void Trasferimento(String [] giocatoresquadra){
		squadra.acquisto(giocatoresquadra[0].trim(), squadre[SearchSquadra(giocatoresquadra[1].trim())]);
		RichiamaFinestraCampionato(db);
	}

	public void TrasferimentoPerScambio(String [] Scelta){
		squadra.scambio(Scelta[0].trim(), Scelta[1].trim(), squadre[SearchSquadra(Scelta[2].trim())]);
		RichiamaFinestraCampionato(db);
	}

	public void Calciomercato(JFrame frame){
		frame.dispose();
		SceltaScambioAcquistaVendita Scelta = new SceltaScambioAcquistaVendita(this); 
	}

	public void RichiamaFinestraCampionato(DatabaseGiocatori db){
		FinestraCampionato fc = new FinestraCampionato(this);
	}


	public void partita(SquadraUmano umano, SquadraAvversaria computer,JFrame frame,Giocatore arrayMio[], Giocatore arrayAvv[]){
		Giocatore giocatore;
		
		long init  = System.currentTimeMillis();
		int puntiUmano = 0;
		int puntiComputer = 0;

		if(Math.random()*10>5){
			giocatore = (Portiere) Search(0,2,arrayMio);
			((Portiere) giocatore).setPalla(true);
			giocatore.setVisible(true);
		}
		else{
			giocatore = (Portiere) Search(7,2,arrayAvv);
			((Portiere) giocatore).setPalla(true);
			giocatore.setVisible(true);
		}


		// continuare. . . . . 

		do {
			int azione; //Serve per il tiro
			Point punto = new Point(); // serve per il passaggio  per il contrasto i rilancio
			int esito = 0;


			if (giocatore.getSquadra().equalsIgnoreCase(squadra.GetNomeSquadra()))	{
				// Chiedi all'utente
				//NELLA TEXTAREA COSA VUOI FARE?
				rilancia = 0;
				tira = 0; 
				passa = 0;
				contrasto = 0;
				if(giocatore instanceof Portiere){
					//disattiva i bottoni tira passaggio contrasto
					do{
						
					}
					while(rilancia == 0);
					if(rilancia != 0) punto.setLocation(((Portiere) giocatore).rilancia(computer.GetNomeSquadra()));
				}
				else
					//attiva gli altri bottoni
					do{
						try {
							wait(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					while(tira == 0 || passa == 0 || contrasto == 0);
				if(passa != 0){
					giocatore.setVisible(false);
					punto.setLocation(((AltriRuoli) giocatore).Passaggio(computer,arrayMio,arrayAvv));
					giocatore = Search((int)punto.getX(),(int)punto.getY(),arrayMio);
					giocatore.setVisible(true);

				}
				else if(contrasto != 0){
					giocatore.setVisible(false);
					punto.setLocation(((AltriRuoli) giocatore).Contrasto(arrayMio,arrayAvv,umano.getAbilitaCentrocampo(),computer));
					giocatore = Search((int)punto.getX(),(int)punto.getY(),arrayMio);
					giocatore.setVisible(true);
				}
				else if(tira != 0){
					Portiere portiere = (Portiere)Search(7,2,arrayAvv);
					esito = ((AltriRuoli) giocatore).Tiro(umano.getAbilitaAttacco(),portiere,computer.getAbilitaDifesa());
					if(esito == PARATA) {
						giocatore.setVisible(false);
						giocatore = (Portiere)Search(7,2,arrayAvv);
						giocatore.setVisible(true);
						//nella text area far spuntara parata
					}
					else if(esito == FUORI){
						portiere.setVisible(true);
						giocatore = (Portiere)Search(7,2,arrayAvv);
						giocatore.setVisible(true);
						//nella text area far spuntara FUORI
					}
					else {
						giocatore = (Portiere)Search(7,2,arrayAvv);
						giocatore.setVisible(true);
						puntiUmano++;
						umano.SetGolfatti();
						computer.setGolSubiti();
						//nella text area far spuntara GOOOOOOOL
					}
				}

			}
			else {
				// computer

				if(giocatore instanceof Portiere)	punto.setLocation(((Portiere) giocatore).rilancia(computer.GetNomeSquadra()));
				else{
					if(giocatore instanceof Difensore) 
						punto.setLocation(((Difensore) giocatore).Contrasto(arrayMio,arrayAvv,umano.getAbilitaDifesa(),computer));
					else if(giocatore instanceof Centrocampista)
						punto.setLocation(((Centrocampista) giocatore).Contrasto(arrayMio,arrayAvv,umano.getAbilitaCentrocampo(),computer));
					else if(giocatore instanceof Attaccante)
						punto.setLocation(((Difensore) giocatore).Contrasto(arrayMio,arrayAvv,umano.getAbilitaAttacco(),computer));

					giocatore.setVisible(false);
					giocatore = Search((int)punto.getX(),(int)punto.getY(),arrayMio);

					if(giocatore == null) giocatore = Search((int)punto.getX(),(int)punto.getY(),arrayAvv);
					giocatore.setVisible(true);

					if(giocatore.getSquadra().equalsIgnoreCase(computer.GetNomeSquadra())){
						//il giocatore è ancora il computer

						//scegliere il tipo di azione

						if(computer.getAbilitaAttacco() >= ABILITÀMINATTACCO){
							if(Math.random()*2 == 0) azione = TIRA;
							else azione = PASSAGGIO;
						}
						else if(Math.random()*4 == 0) azione = TIRA;
						else azione = PASSAGGIO;

						switch(azione)
						{
						//SE FA ERRORE NEL CASTING ALTRI RUOLI.. ALLORA DEVI GESTIRE CASO X CASO
						case TIRA:
							Portiere portiere = (Portiere)Search(0,2,arrayMio);
							esito = ((AltriRuoli) giocatore).Tiro(computer.getAbilitaAttacco(),portiere,umano.getAbilitaDifesa());
							if(esito == PARATA) {
								giocatore.setVisible(false);
								giocatore = (Portiere)Search(0,2,arrayMio);
								giocatore.setVisible(true);
								//nella text area far spuntara parata
							}
							else if(esito == FUORI){
								portiere.setVisible(true);
								giocatore = (Portiere)Search(0,2,arrayMio);
								giocatore.setVisible(true);
								//nella text area far spuntara FUORI
							}
							else {
								giocatore = (Portiere)Search(0,2,arrayMio);
								giocatore.setVisible(true);
								puntiComputer++;
								computer.SetGolfatti();
								umano.setGolSubiti();
								//nella text area far spuntara GOOOOOOOL
							}


							break;

						case PASSAGGIO:
							punto.setLocation(((AltriRuoli) giocatore).Passaggio(computer, arrayMio,arrayAvv));

							giocatore = Search((int)punto.getX(),(int)punto.getY(),arrayMio);
							if(giocatore == null) Search((int)punto.getX(),(int)punto.getY(),arrayAvv);
							break;
						} // end switch
					}
				}
			}

		} while (System.currentTimeMillis() + init < TEMPO_PARTITA);


		if(puntiUmano > puntiComputer){
			//far spuntare nella textarea che ha vinto il giovatore umano
			umano.setPunti(3);
		}
		else if(puntiUmano < puntiComputer){
			//far spuntare nella textarea che ha vinto il giovatore computer
			computer.setPunti(3);
		}
		else{
			//far spuntare nella textarea che è finita in parità
			computer.setPunti(1);
			umano.setPunti(1);
		}

		for(int i=0; i<arrayMio.length;i++){
			arrayMio[i].DiminuisciMorale(1);
			arrayMio[i].DiminuisciCondizione(2);
			arrayMio[i].DiminuisciCarisma(1);
		}

		for(int i=0; i<arrayAvv.length;i++){
			arrayAvv[i].DiminuisciMorale(1);
			arrayAvv[i].DiminuisciCondizione(2);
			arrayAvv[i].DiminuisciCarisma(1);
		}
	}




	public Giocatore Search(int x, int y,Giocatore array[]){
		for (int i=0; i<array.length;i++)
			if(((Giocatore)array[i]).getPosizione().getX() == x && ((Giocatore)array[i]).getPosizione().getY() == y)
				return array[i];
		return null;
	}

	public void CreaAssociazioniSquadre(){

	}
}