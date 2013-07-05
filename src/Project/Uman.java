package Project;

import graphic.FinestraPartita;

import java.awt.Point;

import javax.swing.JFrame;

public class Uman extends User {

	public Uman(Squadra squadra, Giocatore [] giocatori){
		super (squadra,giocatori);
	}


	//TUTTI METODI RICHIAMATI DALLA FINESTRA PARTITA.

	public void Rilancia(JFrame frame,SquadraUmano umano, Giocatore[] arrayMio){
		//	this.resume();
		if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Portiere){

			((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(false);
			((FinestraPartita) frame).setPoint((((Portiere) ((FinestraPartita) frame).getGiocatoreCorrente()).rilancia(umano.GetNomeSquadra())));
			((FinestraPartita) frame).setGiocatoreCorrente(Search((int)((FinestraPartita) frame).getPoint().getX(),(int)((FinestraPartita) frame).getPoint().getY(),arrayMio));
			((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+" "
					+"Ha ricevuto la palla\n");
			((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
		}
		else ((FinestraPartita) frame).getPanelInfo().append("PREMI PASSA \n");
	}

	public void Passa(JFrame frame, SquadraAvversaria computer, Giocatore[] arrayMio, Giocatore[] arrayAvv){
		if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Portiere){
			Rilancia(frame,(SquadraUmano)this.getSquadra(),arrayMio);
		}

		((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(false);
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
			((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
		}
		else{
			if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Centrocampista){
				if((int)(Math.random()*2) == 0){
					((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+" "
							+"Ha effettuato un passaggio sbagliato e ha buttato fuori la palla\n");
					((FinestraPartita) frame).setGiocatoreCorrente(SearchGiocatoreACaso(arrayAvv,"Centrocampista"));
					((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+" "
							+"Ha la palla\n");
					((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
				}
				else{
					((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+" "
							+"il passaggio è stato intercettato\n");

					((FinestraPartita) frame).setGiocatoreCorrente(SearchGiocatoreACaso(arrayAvv,"Centrocampista"));
					((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+" "
							+"Ha la palla\n");
					((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
				}
			}
			else if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Difensore){
				if((int)(Math.random()*2) == 0){
					((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+" "
							+"Ha effettuato un passaggio sbagliato e ha buttato fuori la palla\n");
					((FinestraPartita) frame).setGiocatoreCorrente(SearchGiocatoreACaso(arrayAvv,"Attaccante"));
					((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+" "
							+"Ha la palla\n");
					((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
				}
				else{
					((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+" "
							+"il passaggio è stato intercettato\n");

					((FinestraPartita) frame).setGiocatoreCorrente(SearchGiocatoreACaso(arrayAvv,"Attaccante"));
					((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+" "
							+"Ha la palla\n");
					((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
				}
			}
			else if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Attaccante){
				if((int)(Math.random()*2) == 0){
					((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+" "
							+"Ha effettuato un passaggio sbagliato e ha buttato fuori la palla\n");
					((FinestraPartita) frame).setGiocatoreCorrente(SearchGiocatoreACaso(arrayAvv,"Difensore"));
					((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+" "
							+"Ha la palla\n");
					((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
				}
				else{
					((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+" "
							+"il passaggio è stato intercettato\n");

					((FinestraPartita) frame).setGiocatoreCorrente(SearchGiocatoreACaso(arrayAvv,"Difensore"));
					((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+" "
							+"Ha la palla\n");
					((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
				}
			}
		}
	}

	public void Contrasta(JFrame frame, Giocatore[] arrayMio, Giocatore[] arrayAvv, SquadraUmano umano, SquadraAvversaria computer){
		if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Portiere){
			((FinestraPartita) frame).getPanelInfo().append("IL portiere non contrasta.\n PREMI RILANCIA");
		}
		else{
			((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(false);

			Point puntoGiocatoreChiamante = new Point(((FinestraPartita) frame).getGiocatoreCorrente().getLocation());

			if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Difensore)
				((FinestraPartita) frame).setPoint((((Difensore) ((FinestraPartita) frame).getGiocatoreCorrente()).Contrasto(arrayMio,arrayAvv,computer)));
			else if (((FinestraPartita) frame).getGiocatoreCorrente() instanceof Centrocampista)
				((FinestraPartita) frame).setPoint((((Centrocampista) ((FinestraPartita) frame).getGiocatoreCorrente()).Contrasto(arrayMio,arrayAvv,computer)));
			else if (((FinestraPartita) frame).getGiocatoreCorrente() instanceof Attaccante)
				((FinestraPartita) frame).setPoint((((Attaccante)((FinestraPartita) frame).getGiocatoreCorrente()).Contrasto(arrayMio,arrayAvv,computer)));

			if(((FinestraPartita) frame).getPoint().getX() != 0  && ((FinestraPartita) frame).getPoint().getY() != 0){
				if(puntoGiocatoreChiamante.getX() == ((FinestraPartita) frame).getPoint().getX() &&
						puntoGiocatoreChiamante.getY() == ((FinestraPartita) frame).getPoint().getY()){
					((FinestraPartita) frame).setGiocatoreCorrente(Search((int)((FinestraPartita) frame).getPoint().getX(),(int)((FinestraPartita) frame).getPoint().getY(),arrayMio));
					((FinestraPartita) frame).getPanelInfo().append("Hai vinto il contrasto\n");
					((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
				}
				else{
					((FinestraPartita) frame).setGiocatoreCorrente(Search((int)((FinestraPartita) frame).getPoint().getX(),(int)((FinestraPartita) frame).getPoint().getY(),arrayAvv));
					((FinestraPartita) frame).getPanelInfo().append("Hai perso il contrasto\n la palla è di "+((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+ "\n");
					((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
				}
			}
			else{
				//visualizzare nella textarea che non c'è nessun contrasto dA FARE
				((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
				((FinestraPartita) frame).getPanelInfo().append("non c'è nessun contrasto da FARE\n");
			}
		}
	}



	public void Tira(JFrame frame, Giocatore[] arrayAvv, SquadraAvversaria computer, SquadraUmano umano){

		Portiere portiere = (Portiere)Search(638,168,arrayAvv);
		if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Difensore){
			((FinestraPartita) frame).setEsito(((Difensore) ((FinestraPartita) frame).getGiocatoreCorrente()).Tiro(umano.getAbilitaAttacco(),portiere,
					computer.getAbilitaDifesa(),((FinestraPartita) frame).getPunteggioUmano(),((FinestraPartita) frame).getPunteggioComputer(),
					computer.GetNomeSquadra()));
		}

		else if (((FinestraPartita) frame).getGiocatoreCorrente() instanceof Centrocampista)
			((FinestraPartita) frame).setEsito(((Centrocampista) ((FinestraPartita) frame).getGiocatoreCorrente()).Tiro(umano.getAbilitaAttacco(),portiere,computer.getAbilitaDifesa(),
					((FinestraPartita) frame).getPunteggioUmano(),((FinestraPartita) frame).getPunteggioComputer(),computer.GetNomeSquadra()));

		else if (((FinestraPartita) frame).getGiocatoreCorrente() instanceof Attaccante)
			((FinestraPartita) frame).setEsito(((Attaccante)((FinestraPartita) frame).getGiocatoreCorrente()).Tiro(umano.getAbilitaAttacco(),portiere,computer.getAbilitaDifesa(),
					((FinestraPartita) frame).getPunteggioUmano(),((FinestraPartita) frame).getPunteggioComputer(),computer.GetNomeSquadra()));

		if(((FinestraPartita) frame).getEsito() == PARATA) {
			((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(false);
			((FinestraPartita) frame).setGiocatoreCorrente((Portiere)Search(638,168,arrayAvv));
			((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
			((FinestraPartita) frame).getPanelInfo().append("Tiro parato\n");
			//nella text area far spuntara parata
		}
		else if(((FinestraPartita) frame).getEsito() == FUORI){
			((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(false);
			((FinestraPartita) frame).setGiocatoreCorrente((Portiere)Search(638,168,arrayAvv));
			((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
			((FinestraPartita) frame).getPanelInfo().append("Fuori!!!\n");

			//nella text area far spuntara FUORI
		}
		else if(((FinestraPartita) frame).getEsito() == GOAL){

			((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(false);
			((FinestraPartita) frame).setGiocatoreCorrente((Portiere)Search(638,168,arrayAvv));
			((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
			((FinestraPartita) frame).setPunteggioUmano();
			umano.SetGolfatti();
			computer.setGolSubiti();
			frame.setTitle(this.getSquadra().GetNomeSquadra()+" "+((FinestraPartita) frame).getPunteggioUmano()+ " "+computer.GetNomeSquadra()+" "+ ((FinestraPartita) frame).getPunteggioComputer());
			((FinestraPartita) frame).getPanelInfo().append("GOOOOOOOAL!!!\n");

			//nella text area far spuntara GOOOOOOOL
		}
		else{ // palla intercettata
			if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Difensore){
				//palla intercettata attaccante avversario
				((FinestraPartita) frame).getPanelInfo().append("il tiro è stato intercettato\n");
				((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(false);
				((FinestraPartita) frame).setGiocatoreCorrente(SearchGiocatoreACaso(arrayAvv,"Attaccante"));
				((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+" "	+"Ha la palla\n");
				((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
			}
			else if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Centrocampista){
				//palla intercettata centrocampista avversario
				((FinestraPartita) frame).getPanelInfo().append("il tiro è stato intercettato\n");
				((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(false);
				((FinestraPartita) frame).setGiocatoreCorrente(SearchGiocatoreACaso(arrayAvv,"Centrocampista"));
				((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+" "	+"Ha la palla\n");
				((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
			}
			else if (((FinestraPartita) frame).getGiocatoreCorrente() instanceof Attaccante){
				//palla intercettarta difensore avversario
				((FinestraPartita) frame).getPanelInfo().append("il tiro è stato intercettato\n");
				((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(false);
				((FinestraPartita) frame).setGiocatoreCorrente(SearchGiocatoreACaso(arrayAvv,"Difensore"));
				((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+" "	+"Ha la palla\n");
				((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
			}
		}
	}
}
