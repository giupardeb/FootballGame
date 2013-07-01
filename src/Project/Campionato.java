package Project;
import graphic.*;

import java.awt.Component;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Campionato extends Thread
{
	private static final int TIRA = 1;
	private static final int PASSAGGIO = 2;
	private static final int ABILITÀMINATTACCO = 70;
	private static final int PARATA = 9;
	private static final int FUORI = 10;
	private static final long TEMPO_PARTITA = 300000;

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


	public void partita(SquadraUmano umano, SquadraAvversaria computer,JFrame frame, Giocatore arrayMio[], Giocatore arrayAvv[]){
		long init  = System.currentTimeMillis();
		int j = 0;
		Component[] bottoni = ((FinestraPartita) frame).getPanelScelta().getComponents(); 

		//	if((int)(Math.random()*10)>5){
		((FinestraPartita) frame).setGiocatoreCorrente((Portiere) Search(12,168,arrayMio));
		((Portiere)((FinestraPartita) frame).getGiocatoreCorrente()).setPalla(true); // può essere omesso
		((FinestraPartita) frame).getGiocatoreCorrente().setVisible(true);
		//		}
		//	else{
		//	((FinestraPartita) frame).setGiocatoreCorrente((Portiere) Search(638,168,arrayAvv));
		//	((Portiere) ((FinestraPartita) frame).getGiocatoreCorrente()).setPalla(true);
		//	((FinestraPartita) frame).getGiocatoreCorrente().setVisible(true);
		//		}


		// continuare. . . . . 

		do {
			if (((FinestraPartita) frame).getGiocatoreCorrente().getSquadra().equalsIgnoreCase(squadra.GetNomeSquadra()))	{
				// Chiedi all'utente
				//chiedere a simone se va bene x dAre all'utente il tempo di decidere
				/*		((FinestraPartita) frame).getPanelInfo().append("Cosa vuoi fare ?\n");
				try {
					Thread.sleep(5000);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}*/
				

			}
			else {
				// computer

				if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Portiere){
					((FinestraPartita) frame).setPoint((((Portiere) ((FinestraPartita) frame).getGiocatoreCorrente()).rilancia(umano.GetNomeSquadra())));
					((FinestraPartita) frame).getPanelInfo().append("Il portiere avversario rilancia la palla \n");
				}
				else{
					if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Difensore) {
						((FinestraPartita) frame).setPoint(((Difensore) ((FinestraPartita) frame).getGiocatoreCorrente()).Contrasto(arrayMio,arrayAvv,umano.getAbilitaDifesa(),computer));
						((FinestraPartita) frame).getPanelInfo().append("Il difensore avversario passa la palla\n");
					}
					else if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Centrocampista){
						((FinestraPartita) frame).setPoint(((Centrocampista) ((FinestraPartita) frame).getGiocatoreCorrente()).Contrasto(arrayMio,arrayAvv,umano.getAbilitaCentrocampo(),computer));
						((FinestraPartita) frame).getPanelInfo().append("Il centrocampista avversario passa la palla\n");

					}
					else if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Attaccante){
						((FinestraPartita) frame).setPoint(((Attaccante) ((FinestraPartita) frame).getGiocatoreCorrente()).Contrasto(arrayMio,arrayAvv,umano.getAbilitaAttacco(),computer));
						((FinestraPartita) frame).getPanelInfo().append("L'attaccante avversario passa la palla\n");
					}
				}
				if(((FinestraPartita) frame).getPoint().getX() != 0 && ((FinestraPartita) frame).getPoint().getY() != 0){

					((FinestraPartita) frame).getGiocatoreCorrente().setVisible(false);
					((FinestraPartita) frame).setGiocatoreCorrente(Search((int)((FinestraPartita) frame).getPoint().getX(),(int)((FinestraPartita) frame).getPoint().getY(),arrayMio));
					if(((FinestraPartita) frame).getGiocatoreCorrente() == null) 
						((FinestraPartita) frame).setGiocatoreCorrente(Search((int)((FinestraPartita) frame).getPoint().getX(),(int)((FinestraPartita) frame).getPoint().getY(),arrayAvv));
					((FinestraPartita) frame).getGiocatoreCorrente().setVisible(true);
				}
				else //nessun contrasto da fare
					PassaggioComputer( (FinestraPartita) frame, umano, arrayMio, arrayAvv);


				if(((FinestraPartita) frame).getGiocatoreCorrente().getSquadra().equalsIgnoreCase(computer.GetNomeSquadra())){
					//il giocatore è ancora il computer

					//scegliere il tipo di azione

					if(computer.getAbilitaAttacco() >= ABILITÀMINATTACCO){
						if((int)(Math.random()*2) == 0) ((FinestraPartita) frame).setAzione(TIRA);
						else ((FinestraPartita) frame).setAzione(PASSAGGIO);
					}
					else if((int)(Math.random()*4) == 0) ((FinestraPartita) frame).setAzione(TIRA);
					else ((FinestraPartita) frame).setAzione(PASSAGGIO);

					switch(((FinestraPartita) frame).getAzione())
					{
					//SE FA ERRORE NEL CASTING ALTRI RUOLI.. ALLORA DEVI GESTIRE CASO X CASO
					case TIRA:
						Portiere portiere = (Portiere)Search(12,168,arrayMio);
						if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Difensore)
							((FinestraPartita) frame).setEsito(((Difensore) ((FinestraPartita) frame).getGiocatoreCorrente()).Tiro(computer.getAbilitaAttacco(),portiere,umano.getAbilitaDifesa()));
						else if (((FinestraPartita) frame).getGiocatoreCorrente() instanceof Centrocampista)
							((FinestraPartita) frame).setEsito(((Centrocampista) ((FinestraPartita) frame).getGiocatoreCorrente()).Tiro(computer.getAbilitaAttacco(),portiere,umano.getAbilitaDifesa()));
						else if (((FinestraPartita) frame).getGiocatoreCorrente() instanceof Attaccante)
							((FinestraPartita) frame).setEsito(((Attaccante) ((FinestraPartita) frame).getGiocatoreCorrente()).Tiro(computer.getAbilitaAttacco(),portiere,umano.getAbilitaDifesa()));

						if(((FinestraPartita) frame).getEsito() == PARATA) {
							((FinestraPartita) frame).getGiocatoreCorrente().setVisible(false);
							((FinestraPartita) frame).setGiocatoreCorrente((Portiere)Search(12,168,arrayMio));
							((FinestraPartita) frame).getGiocatoreCorrente().setVisible(true);
							((FinestraPartita) frame).getPanelInfo().append("Il tuo portiere ha parato il tiro\n");
						}
						else if(((FinestraPartita) frame).getEsito() == FUORI){
							((FinestraPartita) frame).getGiocatoreCorrente().setVisible(false);
							((FinestraPartita) frame).setGiocatoreCorrente((Portiere)Search(12,168,arrayMio));
							((FinestraPartita) frame).getGiocatoreCorrente().setVisible(true);
							((FinestraPartita) frame).getPanelInfo().append("La palla è andata fuori\n");
						}
						else {
							((FinestraPartita) frame).getGiocatoreCorrente().setVisible(false);
							((FinestraPartita) frame).setGiocatoreCorrente((Portiere)Search(12,168,arrayMio));
							((FinestraPartita) frame).getGiocatoreCorrente().setVisible(true);
							((FinestraPartita) frame).setPuntiComputer();
							computer.SetGolfatti();
							umano.setGolSubiti();
							((FinestraPartita) frame).setPuntiComputer();
							((FinestraPartita) frame).getPanelInfo().append("GOOOOL\n"+computer.GetNomeSquadra());
							frame.setTitle(squadra.GetNomeSquadra()+" "+((FinestraPartita) frame).getPuntiUmano()+ " "+computer.GetNomeSquadra()+" "+ ((FinestraPartita) frame).getPuntiComputer());

						}


						break;

					case PASSAGGIO:
						PassaggioComputer( (FinestraPartita) frame, umano, arrayMio, arrayAvv);

						/*	if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Difensore)
							((FinestraPartita) frame).setPoint((((Difensore) ((FinestraPartita) frame).getGiocatoreCorrente()).Passaggio(umano, arrayMio,arrayAvv)));
						else if (((FinestraPartita) frame).getGiocatoreCorrente() instanceof Centrocampista)
							((FinestraPartita) frame).setPoint((((Centrocampista) ((FinestraPartita) frame).getGiocatoreCorrente()).Passaggio(umano, arrayMio,arrayAvv)));
						else if (((FinestraPartita) frame).getGiocatoreCorrente() instanceof Attaccante)
							((FinestraPartita) frame).setPoint((((Attaccante) ((FinestraPartita) frame).getGiocatoreCorrente()).Passaggio(umano, arrayMio,arrayAvv)));


						((FinestraPartita) frame).getGiocatoreCorrente().setVisible(false);

						if(((FinestraPartita) frame).getPoint().getX() != 0 && ((FinestraPartita) frame).getPoint().getY() != 0){
							((FinestraPartita) frame).setGiocatoreCorrente(Search((int)((FinestraPartita) frame).getPoint().getX(),(int)((FinestraPartita) frame).getPoint().getY(),arrayAvv));
							((FinestraPartita) frame).getPanelInfo().setText(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+
									"<html>Ha ricevuto la palla <br></html>");
							((FinestraPartita) frame).getGiocatoreCorrente().setVisible(true);
						}
						else{
							if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Centrocampista){
								((FinestraPartita) frame).setGiocatoreCorrente(SearchGiocatoreACaso(arrayMio,"Centrocampista"));
								if((int)(Math.random()*2) == 0)
									((FinestraPartita) frame).getPanelInfo().setText(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+
											"<html>Ha intercettato la palla <br></html>");
								else
									((FinestraPartita) frame).getPanelInfo().setText("<html>palla fuori <br></html>");

								((FinestraPartita) frame).getGiocatoreCorrente().setVisible(true);
							}
							else if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Difensore){
								((FinestraPartita) frame).setGiocatoreCorrente(SearchGiocatoreACaso(arrayMio,"Attaccante"));
								if((int)(Math.random()*2) == 0)
									((FinestraPartita) frame).getPanelInfo().setText(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+
											"<html>Ha intercettato la palla <br></html>");
								else
									((FinestraPartita) frame).getPanelInfo().setText("<html>palla fuori <br></html>");
								((FinestraPartita) frame).getGiocatoreCorrente().setVisible(true);
							}
							else if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Attaccante){
								((FinestraPartita) frame).setGiocatoreCorrente(SearchGiocatoreACaso(arrayMio,"Difensore"));
								if((int)(Math.random()*2) == 0)
									((FinestraPartita) frame).getPanelInfo().setText(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+
											"<html>Ha intercettato la palla <br></html>");
								else
									((FinestraPartita) frame).getPanelInfo().setText("<html>palla fuori <br></html>");
								((FinestraPartita) frame).getGiocatoreCorrente().setVisible(true);
							}
						}*/
						break;
					}
				} // end switch
			}
			j++;
		} while (System.currentTimeMillis() + init < TEMPO_PARTITA);


		if(((FinestraPartita) frame).getPuntiUmano() > ((FinestraPartita) frame).getPuntiComputer()){
			//far spuntare nella textarea che ha vinto il giovatore umano
			umano.setPunti(3);
		}
		else if(((FinestraPartita) frame).getPuntiUmano() < ((FinestraPartita) frame).getPuntiComputer()){
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
	public Giocatore SearchGiocatoreACaso(Giocatore array[], String ruolo){
		ArrayList <Giocatore> tmp = new ArrayList <Giocatore>();
		for(int i=0; i<array.length;i++) if(array[i].getRuolo().equalsIgnoreCase(ruolo)) tmp.add(array[i]);

		Random rand = new Random();
		int casuale = rand.nextInt(tmp.size());


		return tmp.get(casuale);

	}


	public void Rilancia(JFrame frame,SquadraUmano umano, Giocatore[] arrayMio){
		//	this.resume();
		((FinestraPartita) frame).getGiocatoreCorrente().setVisible(false);
		((FinestraPartita) frame).setPoint((((Portiere) ((FinestraPartita) frame).getGiocatoreCorrente()).rilancia(umano.GetNomeSquadra())));
		((FinestraPartita) frame).setGiocatoreCorrente(Search((int)((FinestraPartita) frame).getPoint().getX(),(int)((FinestraPartita) frame).getPoint().getY(),arrayMio));
		((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+" "
		+"Ha ricevuto la palla\n");

		((FinestraPartita) frame).getGiocatoreCorrente().setVisible(true);
	}

	public void Passa(JFrame frame, SquadraAvversaria computer, Giocatore[] arrayMio, Giocatore[] arrayAvv){
		((FinestraPartita) frame).getGiocatoreCorrente().setVisible(false);

		if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Difensore)
			((FinestraPartita) frame).setPoint((((Difensore) ((FinestraPartita) frame).getGiocatoreCorrente()).Passaggio(computer,arrayMio,arrayAvv)));
		else if (((FinestraPartita) frame).getGiocatoreCorrente() instanceof Centrocampista)
			((FinestraPartita) frame).setPoint((((Centrocampista) ((FinestraPartita) frame).getGiocatoreCorrente()).Passaggio(computer,arrayMio,arrayAvv)));
		else if (((FinestraPartita) frame).getGiocatoreCorrente() instanceof Attaccante)
			((FinestraPartita) frame).setPoint((((Attaccante)((FinestraPartita) frame).getGiocatoreCorrente()).Passaggio(computer,arrayMio,arrayAvv)));

		if(((FinestraPartita) frame).getPoint().getX() != 0 && ((FinestraPartita) frame).getPoint().getY() != 0){
			((FinestraPartita) frame).setGiocatoreCorrente(Search((int)((FinestraPartita) frame).getPoint().getX(),(int)((FinestraPartita) frame).getPoint().getY(),arrayMio));
			((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+" "
					+"Ha ricevuto la palla\n");
			((FinestraPartita) frame).getGiocatoreCorrente().setVisible(true);
		}
		else{
			if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Centrocampista){
				if((int)(Math.random()*2) == 0)
					((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+" "
							+"Ha effettuato un passaggio sbagliato e ha buttato fuori la palla\n");
				else
					((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+" "
							+"il passaggio è stato intercettato\n");
					
				((FinestraPartita) frame).setGiocatoreCorrente(SearchGiocatoreACaso(arrayAvv,"Centrocampista"));
				((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+" "
						+"Ha la palla\n");
				((FinestraPartita) frame).getGiocatoreCorrente().setVisible(true);
			}
			else if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Difensore){
				if((int)(Math.random()*2) == 0)
					((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+" "
							+"Ha effettuato un passaggio sbagliato e ha buttato fuori la palla\n");
				else
					((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+" "
							+"il passaggio è stato intercettato\n");
				
				((FinestraPartita) frame).setGiocatoreCorrente(SearchGiocatoreACaso(arrayAvv,"Attaccante"));
				((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+" "
						+"Ha la palla\n");
				((FinestraPartita) frame).getGiocatoreCorrente().setVisible(true);
			}
			else if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Attaccante){
				if((int)(Math.random()*2) == 0)
					((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+" "
							+"Ha effettuato un passaggio sbagliato e ha buttato fuori la palla\n");
				else
					((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+" "
							+"il passaggio è stato intercettato\n");
					
				((FinestraPartita) frame).setGiocatoreCorrente(SearchGiocatoreACaso(arrayAvv,"Difensore"));
				((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+" "
						+"Ha la palla\n");
				((FinestraPartita) frame).getGiocatoreCorrente().setVisible(true);
			}
		}
	}

	public void Contrasta(JFrame frame, Giocatore[] arrayMio, Giocatore[] arrayAvv, SquadraUmano umano, SquadraAvversaria computer){
		((FinestraPartita) frame).getGiocatoreCorrente().setVisible(false);
		
		Point puntoGiocatoreChiamante = new Point(((FinestraPartita) frame).getPoint());
		
		if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Difensore)
			((FinestraPartita) frame).setPoint((((Difensore) ((FinestraPartita) frame).getGiocatoreCorrente()).Contrasto(arrayMio,arrayAvv,umano.getAbilitaCentrocampo(),computer)));
		else if (((FinestraPartita) frame).getGiocatoreCorrente() instanceof Centrocampista)
			((FinestraPartita) frame).setPoint((((Centrocampista) ((FinestraPartita) frame).getGiocatoreCorrente()).Contrasto(arrayMio,arrayAvv,umano.getAbilitaCentrocampo(),computer)));
		else if (((FinestraPartita) frame).getGiocatoreCorrente() instanceof Attaccante)
			((FinestraPartita) frame).setPoint((((Attaccante)((FinestraPartita) frame).getGiocatoreCorrente()).Contrasto(arrayMio,arrayAvv,umano.getAbilitaCentrocampo(),computer)));

		if(((FinestraPartita) frame).getPoint().getX() != 0  && ((FinestraPartita) frame).getPoint().getY() != 0){
			if(puntoGiocatoreChiamante.getX() == ((FinestraPartita) frame).getPoint().getX() &&
					 puntoGiocatoreChiamante.getY() == ((FinestraPartita) frame).getPoint().getY()){
				((FinestraPartita) frame).setGiocatoreCorrente(Search((int)((FinestraPartita) frame).getPoint().getX(),(int)((FinestraPartita) frame).getPoint().getY(),arrayMio));
				((FinestraPartita) frame).getPanelInfo().append("Hai vinto il contrasto\n");
				((FinestraPartita) frame).getGiocatoreCorrente().setVisible(true);
			}
			else{
				((FinestraPartita) frame).setGiocatoreCorrente(Search((int)((FinestraPartita) frame).getPoint().getX(),(int)((FinestraPartita) frame).getPoint().getY(),arrayAvv));
				((FinestraPartita) frame).getPanelInfo().append("Hai perso il contrasto\nla palla è di "
				+((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome());
				
				((FinestraPartita) frame).getGiocatoreCorrente().setVisible(true);
			}
		}
		else{
			//visualizzare nella textarea che non c'è nessun contrasto dA FARE
			((FinestraPartita) frame).getPanelInfo().append("non c'è nessun contrasto da FARE\n");
		}
	}

	public void Tira(JFrame frame, Giocatore[] arrayAvv, SquadraAvversaria computer, SquadraUmano umano){
		Portiere portiere = (Portiere)Search(638,168,arrayAvv);

		if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Difensore)
			((FinestraPartita) frame).setEsito(((Difensore) ((FinestraPartita) frame).getGiocatoreCorrente()).Tiro(umano.getAbilitaAttacco(),portiere,computer.getAbilitaDifesa()));
		else if (((FinestraPartita) frame).getGiocatoreCorrente() instanceof Centrocampista)
			((FinestraPartita) frame).setEsito(((Centrocampista) ((FinestraPartita) frame).getGiocatoreCorrente()).Tiro(umano.getAbilitaAttacco(),portiere,computer.getAbilitaDifesa()));
		else if (((FinestraPartita) frame).getGiocatoreCorrente() instanceof Attaccante)
			((FinestraPartita) frame).setEsito(((Attaccante)((FinestraPartita) frame).getGiocatoreCorrente()).Tiro(umano.getAbilitaAttacco(),portiere,computer.getAbilitaDifesa()));

		if(((FinestraPartita) frame).getEsito() == PARATA) {
			((FinestraPartita) frame).getGiocatoreCorrente().setVisible(false);
			((FinestraPartita) frame).setGiocatoreCorrente((Portiere)Search(638,168,arrayAvv));
			((FinestraPartita) frame).getGiocatoreCorrente().setVisible(true);
			((FinestraPartita) frame).getPanelInfo().append("Tiro parato\n");
			//nella text area far spuntara parata
		}
		else if(((FinestraPartita) frame).getEsito() == FUORI){
			((FinestraPartita) frame).getGiocatoreCorrente().setVisible(false);
			((FinestraPartita) frame).setGiocatoreCorrente((Portiere)Search(638,168,arrayAvv));
			((FinestraPartita) frame).getGiocatoreCorrente().setVisible(true);
			((FinestraPartita) frame).getPanelInfo().append("Fuori!!!\n");

			//nella text area far spuntara FUORI
		}
		else {
			((FinestraPartita) frame).getGiocatoreCorrente().setVisible(false);
			((FinestraPartita) frame).setGiocatoreCorrente((Portiere)Search(638,168,arrayAvv));
			((FinestraPartita) frame).getGiocatoreCorrente().setVisible(true);
			((FinestraPartita) frame).setPuntiUmano();
			umano.SetGolfatti();
			computer.setGolSubiti();
			frame.setTitle(squadra.GetNomeSquadra()+" "+((FinestraPartita) frame).getPuntiUmano()+ " "+computer.GetNomeSquadra()+" "+ ((FinestraPartita) frame).getPuntiComputer());
			((FinestraPartita) frame).getPanelInfo().append("GOOOOOOOAL!!!\n");

			//nella text area far spuntara GOOOOOOOL
		}
	}

	private void PassaggioComputer(FinestraPartita frame, Squadra umano, Giocatore[] arrayMio, Giocatore[] arrayAvv){
		if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Difensore)
			((FinestraPartita) frame).setPoint((((Difensore) ((FinestraPartita) frame).getGiocatoreCorrente()).Passaggio(umano, arrayMio,arrayAvv)));
		else if (((FinestraPartita) frame).getGiocatoreCorrente() instanceof Centrocampista)
			((FinestraPartita) frame).setPoint((((Centrocampista) ((FinestraPartita) frame).getGiocatoreCorrente()).Passaggio(umano, arrayMio,arrayAvv)));
		else if (((FinestraPartita) frame).getGiocatoreCorrente() instanceof Attaccante)
			((FinestraPartita) frame).setPoint((((Attaccante) ((FinestraPartita) frame).getGiocatoreCorrente()).Passaggio(umano, arrayMio,arrayAvv)));


		((FinestraPartita) frame).getGiocatoreCorrente().setVisible(false);

		if(((FinestraPartita) frame).getPoint().getX() != 0 && ((FinestraPartita) frame).getPoint().getY() != 0){
			((FinestraPartita) frame).setGiocatoreCorrente(Search((int)((FinestraPartita) frame).getPoint().getX(),(int)((FinestraPartita) frame).getPoint().getY(),arrayAvv));
			((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+
					"Ha ricevuto la palla\n");
			((FinestraPartita) frame).getGiocatoreCorrente().setVisible(true);
		}
		else{
			if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Centrocampista){
				((FinestraPartita) frame).setGiocatoreCorrente(SearchGiocatoreACaso(arrayMio,"Centrocampista"));
				if((int)(Math.random()*2) == 0)
					((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+
							"Ha intercettato la palla\n");
				else
					((FinestraPartita) frame).getPanelInfo().setText("palla fuori\n");

				((FinestraPartita) frame).getGiocatoreCorrente().setVisible(true);
			}
			else if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Difensore){
				((FinestraPartita) frame).setGiocatoreCorrente(SearchGiocatoreACaso(arrayMio,"Attaccante"));
				if((int)(Math.random()*2) == 0)
					((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+
							"Ha intercettato la palla\n");
				else
					((FinestraPartita) frame).getPanelInfo().append("palla fuori\n");
				((FinestraPartita) frame).getGiocatoreCorrente().setVisible(true);
			}
			else if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Attaccante){
				((FinestraPartita) frame).setGiocatoreCorrente(SearchGiocatoreACaso(arrayMio,"Difensore"));
				if((int)(Math.random()*2) == 0)
					((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+
							"Ha intercettato la palla\n");
				else
					((FinestraPartita) frame).getPanelInfo().append("palla fuori \n");
				((FinestraPartita) frame).getGiocatoreCorrente().setVisible(true);
			}
		}
	}

	public void CreaAssociazioniSquadre(){

	}
}