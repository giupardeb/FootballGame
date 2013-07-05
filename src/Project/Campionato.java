package Project;
import graphic.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Campionato extends Thread
{
	private static final int TIRA = 1;
	private static final int PASSAGGIO = 2;
	private static final int ABILITÀMINATTACCO = 80;
	private static final int ABILITÀMINATTACCOSVANTAGGIO = 70;

	public static int durataPartita = 0;
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
			if(squadre[i] == null)
				i--;
			else
				Incontri.push(squadre[i]);
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
		Scelta.setVisible(true);

	}

	public void RichiamaFinestraCampionato(DatabaseGiocatori db){
		FinestraCampionato fc = new FinestraCampionato(this);
		fc.setVisible(true);

	}


	public void partita(final Uman umano, final IA computer,final JFrame frame){
		durataPartita = 0;

		if((int)(Math.random()*10)>5){
			((FinestraPartita) frame).setGiocatoreCorrente((Portiere) Search(12,168,umano.getGiocatori()));
			((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
		}
		else{
			((FinestraPartita) frame).setGiocatoreCorrente((Portiere) Search(638,168,computer.getGiocatori()));
			((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
		}

		//	((FinestraPartita) frame).setGiocatoreCorrente((Attaccante) Search(457,226,umano.getGiocatori()));
		//	((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);

		// continuare. . . . . 
		while(durataPartita < 50){
			if (((FinestraPartita) frame).getGiocatoreCorrente().getSquadra().equalsIgnoreCase(squadra.GetNomeSquadra()))	{
				// Chiedi all'utente
				int dialogResult = JOptionPane.YES_NO_OPTION;
				Object[] options = {"Rilancia",  "Tira", "Passa"};

				int n = JOptionPane.showOptionDialog(null , "Se sei un portiere Rilancia, altrimenti premi Tira o Passa", null, dialogResult, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);	


				switch (n){

				case 0: 
					if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Portiere){
						((FinestraPartita) frame).getPanelInfo().setText("");
						durataPartita++;
						umano.Rilancia(frame, (SquadraUmano) umano.getSquadra(), umano.getGiocatori());
					}
					else JOptionPane.showMessageDialog(null, "Solo il Portiere può RILANCIARE");

					break;

				case 1: 
					if(!(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Portiere)){
						durataPartita++;
						umano.Tira(frame, computer.getGiocatori(), (SquadraAvversaria)computer.getSquadra(), (SquadraUmano)umano.getSquadra());
					}
					else JOptionPane.showMessageDialog(null, "Il portiere non Tira, premi RILANCIA!");

					break;

				case 2: 
					if(!(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Portiere)){
						durataPartita++;
						if(Math.random()*2 > 1)
							umano.Contrasta(frame, umano.getGiocatori(), computer.getGiocatori(), (SquadraUmano)umano.getSquadra(), (SquadraAvversaria)computer.getSquadra());
						if(((FinestraPartita) frame).getGiocatoreCorrente().getSquadra().equalsIgnoreCase(umano.getSquadra().GetNomeSquadra()))
							umano.Passa(frame, (SquadraAvversaria)computer.getSquadra(), umano.getGiocatori(), computer.getGiocatori());
					}
					else JOptionPane.showMessageDialog(null, "Il portiere non Passa, premi RILANCIA!");
				}

			}
			else{
				//computer
				TurnoComputer(frame, computer, umano);
			}
		}
		((FinestraPartita) frame).getPanelInfo().setText("");
		if(((FinestraPartita) frame).getPunteggioUmano() > ((FinestraPartita) frame).getPunteggioComputer()){
			//far spuntare nella textarea che ha vinto il giovatore umano
			((FinestraPartita) frame).getPanelInfo().append("HAI VINTOOOO "+ ((FinestraPartita) frame).getPunteggioUmano() +" A "+((FinestraPartita) frame).getPunteggioComputer()+"\n");
			umano.getSquadra().setPunti(3);
		}
		else if(((FinestraPartita) frame).getPunteggioUmano() < ((FinestraPartita) frame).getPunteggioComputer()){
			//far spuntare nella textarea che ha vinto il giovatore computer
			((FinestraPartita) frame).getPanelInfo().append("HAI PERSO "+ ((FinestraPartita) frame).getPunteggioUmano() +" A "+((FinestraPartita) frame).getPunteggioComputer()+"\n");

			computer.getSquadra().setPunti(3);
		}
		else{
			//far spuntare nella textarea che è finita in parità
			((FinestraPartita) frame).getPanelInfo().append("È FINITA IN PARITÀ "+ ((FinestraPartita) frame).getPunteggioUmano() +" A "+((FinestraPartita) frame).getPunteggioComputer()+"\n");
			computer.getSquadra().setPunti(1);
			umano.getSquadra().setPunti(1);
		}

		for(int i=0; i<umano.getGiocatori().length;i++){
			umano.getGiocatori()[i].DiminuisciMorale(1);
			umano.getGiocatori()[i].DiminuisciCondizione(2);
			umano.getGiocatori()[i].DiminuisciCarisma(1);
		}

		for(int i=0; i<computer.getGiocatori().length;i++){
			computer.getGiocatori()[i].DiminuisciMorale(1);
			computer.getGiocatori()[i].DiminuisciCondizione(2);
			computer.getGiocatori()[i].DiminuisciCarisma(1);
		}
	}




	public Giocatore Search(int x, int y,Giocatore array[]){
		for (int i=0; i<array.length;i++)
			if(((Giocatore)array[i]).getPosizione().getX() == x && ((Giocatore)array[i]).getPosizione().getY() == y)
				return array[i];
		return null;
	}
	public Giocatore SearchGiocatoreACaso(Giocatore array[], String ruolo){
		ArrayList <Giocatore> tmp = new ArrayList <Giocatore>();
		for(int i=0; i<array.length;i++) if(array[i].getRuolo().equalsIgnoreCase(ruolo)) tmp.add(array[i]);

		Random rand = new Random();
		int casuale = rand.nextInt(tmp.size());


		return tmp.get(casuale);

	}

	public void TurnoComputer(JFrame frame, IA computer,Uman umano) {

		// computer
		do{


			if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Portiere){
				((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(false);
				((FinestraPartita) frame).setPoint((((Portiere) ((FinestraPartita) frame).getGiocatoreCorrente()).rilancia(umano.getSquadra().GetNomeSquadra())));
				((FinestraPartita) frame).setGiocatoreCorrente(Search((int)((FinestraPartita) frame).getPoint().getX(),(int)((FinestraPartita) frame).getPoint().getY(),computer.getGiocatori()));
				((FinestraPartita) frame).getPanelInfo().append("Il portiere avversario rilancia la palla a: "+ ((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+"\n");
				((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);

			}
			else{
				if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Difensore) {
					if((int)(Math.random()*2) == 0){
						((FinestraPartita) frame).getPanelInfo().append("Contrasto Avversario effettuato da: "+ ((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+"\n");
						((FinestraPartita) frame).setPoint(((Difensore) ((FinestraPartita) frame).getGiocatoreCorrente()).Contrasto(umano.getGiocatori(),computer.getGiocatori(),computer.getSquadra()));


						if(((FinestraPartita) frame).getPoint().getX() != 0 && ((FinestraPartita) frame).getPoint().getY() != 0){

							ContrastoEffettuato(frame,computer,umano);
						}
						else {//nessun contrasto da fare
							((FinestraPartita) frame).getPanelInfo().append("L'avversario non deve fare nessun contrasto, passa la palla\n");
							try {
								sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							computer.PassaggioComputer((FinestraPartita) frame, umano);
						}

					}
					else computer.PassaggioComputer((FinestraPartita) frame, umano);
				}
				else {
					if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Centrocampista){
						if((int)(Math.random()*2) == 0){
							((FinestraPartita) frame).getPanelInfo().append("Contrasto Avversario effettuato da: "+ ((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+"\n");
							((FinestraPartita) frame).setPoint(((Centrocampista) ((FinestraPartita) frame).getGiocatoreCorrente()).Contrasto(umano.getGiocatori(),computer.getGiocatori(),computer.getSquadra()));

							if(((FinestraPartita) frame).getPoint().getX() != 0 && ((FinestraPartita) frame).getPoint().getY() != 0){

								ContrastoEffettuato(frame,computer,umano);

							}
							else{ //nessun contrasto da fare
								((FinestraPartita) frame).getPanelInfo().append("L'avversario non deve fare nessun contrasto passa la palla\n");
								try {
									sleep(2000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								computer.PassaggioComputer((FinestraPartita) frame, umano);

							}

						}
						else computer.PassaggioComputer((FinestraPartita) frame, umano);

					}
					else {
						if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Attaccante){
							if((int)(Math.random()*3) == 0){
								computer.PassaggioComputer((FinestraPartita) frame, umano);
								durataPartita++;
								try {
									sleep(2000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}
				}

				if(((FinestraPartita) frame).getGiocatoreCorrente().getSquadra().equalsIgnoreCase(computer.getSquadra().GetNomeSquadra())){
					//il giocatore è ancora il computer
					durataPartita++;
					//scegliere il tipo di azione
					int differenza = Math.abs(((FinestraPartita) frame).getPunteggioComputer() - ((FinestraPartita) frame).getPunteggioUmano());
					try {
						sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Attaccante){
						((FinestraPartita) frame).setAzione(TIRA);
					}
					else{
						if(differenza >= 2){
							if(computer.getSquadra().getAbilitaAttacco() >= ABILITÀMINATTACCOSVANTAGGIO){
								if((int)(Math.random()*4) >1) ((FinestraPartita) frame).setAzione(PASSAGGIO);
								else ((FinestraPartita) frame).setAzione(TIRA);
							}
							else{
								if((int)(Math.random()*2) == 0) ((FinestraPartita) frame).setAzione(TIRA);
								else ((FinestraPartita) frame).setAzione(PASSAGGIO);
							}

						}
						else{
							if(computer.getSquadra().getAbilitaAttacco() >= ABILITÀMINATTACCO){
								if((int)(Math.random()*2) == 0) ((FinestraPartita) frame).setAzione(TIRA);
								else ((FinestraPartita) frame).setAzione(PASSAGGIO);
							}
							else if((int)(Math.random()*3) == 0) ((FinestraPartita) frame).setAzione(TIRA);
							else ((FinestraPartita) frame).setAzione(PASSAGGIO);
						}
					}

					switch(((FinestraPartita) frame).getAzione())
					{
					case TIRA:
						computer.TiraComputer((FinestraPartita)frame,umano);
						try {
							sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;

					case PASSAGGIO:
						computer.PassaggioComputer((FinestraPartita) frame, umano);
						try {
							sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}
				} // end switch
			}
			durataPartita++;
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while(((FinestraPartita) frame).getGiocatoreCorrente().getSquadra().equalsIgnoreCase(computer.getSquadra().GetNomeSquadra()));
	}

	private void ContrastoEffettuato(JFrame frame, User computer, User umano){

		((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(false);
		((FinestraPartita) frame).setGiocatoreCorrente(Search((int)((FinestraPartita) frame).getPoint().getX(),(int)((FinestraPartita) frame).getPoint().getY(),computer.getGiocatori()));
		if(((FinestraPartita) frame).getGiocatoreCorrente() == null){
			((FinestraPartita) frame).setGiocatoreCorrente(Search((int)((FinestraPartita) frame).getPoint().getX(),(int)((FinestraPartita) frame).getPoint().getY(),umano.getGiocatori()));
			((FinestraPartita) frame).getPanelInfo().append("Il giocatore avversario perde il contrasto, e la palla è di:  "+ ((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+"\n");
			((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
		}
		else{
			((FinestraPartita) frame).getPanelInfo().append("Il giocatore avversario vince il contrasto e la palla è ancora sua \n");
			((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
		}
	}
}