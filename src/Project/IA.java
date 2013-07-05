package Project;

import graphic.FinestraPartita;

public class IA extends User{

	public IA(Squadra squadra, Giocatore[] giocatori){
		super (squadra,giocatori);
	}


	public void TiraComputer(FinestraPartita frame, Uman umano){
		Portiere portiere = (Portiere)Search(12,168,umano.getGiocatori());
		if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Difensore){
			((FinestraPartita) frame).setEsito(((Difensore) ((FinestraPartita) frame).getGiocatoreCorrente()).
					Tiro(this.getSquadra().getAbilitaAttacco(),portiere,umano.getSquadra().getAbilitaDifesa(),
							((FinestraPartita) frame).getPunteggioUmano(),((FinestraPartita) frame).getPunteggioComputer(),
							umano.getSquadra().GetNomeSquadra()));

			((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+
					" TIRA\n");
		}
		else if (((FinestraPartita) frame).getGiocatoreCorrente() instanceof Centrocampista){
			((FinestraPartita) frame).setEsito(((Centrocampista) ((FinestraPartita) frame).getGiocatoreCorrente()).Tiro(this.getSquadra().getAbilitaAttacco(),
					portiere,umano.getSquadra().getAbilitaDifesa(),((FinestraPartita) frame).getPunteggioUmano(),
					((FinestraPartita) frame).getPunteggioComputer(),umano.getSquadra().GetNomeSquadra()));

			((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+
					" TIRA\n");
		}
		else if (((FinestraPartita) frame).getGiocatoreCorrente() instanceof Attaccante){
			((FinestraPartita) frame).setEsito(((Attaccante) ((FinestraPartita) frame).getGiocatoreCorrente()).Tiro(this.getSquadra().getAbilitaAttacco(),portiere,umano.getSquadra().getAbilitaDifesa(),
					((FinestraPartita) frame).getPunteggioUmano(),((FinestraPartita) frame).getPunteggioComputer(),umano.getSquadra().GetNomeSquadra()));

			((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+
					" TIRA\n");
		}
		if(((FinestraPartita) frame).getEsito() == PARATA) {
			((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(false);
			((FinestraPartita) frame).setGiocatoreCorrente((Portiere)Search(12,168,umano.getGiocatori()));
			((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
			((FinestraPartita) frame).getPanelInfo().append("Il tuo portiere ha parato il tiro\n");
		}
		else if(((FinestraPartita) frame).getEsito() == FUORI){
			((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(false);
			((FinestraPartita) frame).setGiocatoreCorrente((Portiere)Search(12,168,umano.getGiocatori()));
			((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
			((FinestraPartita) frame).getPanelInfo().append("La palla è andata fuori\n");
		}
		else if(((FinestraPartita) frame).getEsito() == GOAL){
			((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(false);
			((FinestraPartita) frame).setGiocatoreCorrente((Portiere)Search(12,168,umano.getGiocatori()));
			((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
			((FinestraPartita) frame).setPunteggioComputer();
			this.getSquadra().SetGolfatti();
			umano.getSquadra().setGolSubiti();
			((FinestraPartita) frame).getPanelInfo().append("GOOOOL "+this.getSquadra().GetNomeSquadra()+"\n");
			frame.setTitle(umano.getSquadra().GetNomeSquadra()+" "+((FinestraPartita) frame).getPunteggioUmano()+ " "+this.getSquadra().GetNomeSquadra()+" "+ ((FinestraPartita) frame).getPunteggioComputer());

		}
		else{ //palla intercettata
			if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Difensore){
				//palla intercettata attaccante avversario
				((FinestraPartita) frame).getPanelInfo().append("il tiro è stato intercettato\n");
				((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(false);
				((FinestraPartita) frame).setGiocatoreCorrente(SearchGiocatoreACaso(umano.getGiocatori(),"Attaccante"));
				((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+" "	+"Ha la palla\n");
				((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
			}
			else if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Centrocampista){
				//palla intercettata centrocampista avversario
				((FinestraPartita) frame).getPanelInfo().append("il tiro è stato intercettato\n");
				((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(false);
				((FinestraPartita) frame).setGiocatoreCorrente(SearchGiocatoreACaso(umano.getGiocatori(),"Centrocampista"));
				((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+" "	+"Ha la palla\n");
				((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
			}
			else if (((FinestraPartita) frame).getGiocatoreCorrente() instanceof Attaccante){
				//palla intercettarta difensore avversario
				((FinestraPartita) frame).getPanelInfo().append("il tiro è stato intercettato\n");
				((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(false);
				((FinestraPartita) frame).setGiocatoreCorrente(SearchGiocatoreACaso(umano.getGiocatori(),"Difensore"));
				((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+" "	+"Ha la palla\n");
				((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
			}
		}
	}

	public void PassaggioComputer(FinestraPartita frame, Uman umano){

		if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Difensore)
			((FinestraPartita) frame).setPoint((((Difensore) ((FinestraPartita) frame).getGiocatoreCorrente()).Passaggio(this.getSquadra(),umano.getGiocatori(),this.getGiocatori())));
		else if (((FinestraPartita) frame).getGiocatoreCorrente() instanceof Centrocampista)
			((FinestraPartita) frame).setPoint((((Centrocampista) ((FinestraPartita) frame).getGiocatoreCorrente()).Passaggio(this.getSquadra(), umano.getGiocatori(),this.getGiocatori())));
		else if (((FinestraPartita) frame).getGiocatoreCorrente() instanceof Attaccante)
			((FinestraPartita) frame).setPoint((((Attaccante) ((FinestraPartita) frame).getGiocatoreCorrente()).Passaggio(this.getSquadra(),umano.getGiocatori(),this.getGiocatori())));


		((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(false);
		((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+" passa la palla\n");
		
		if(((FinestraPartita) frame).getPoint().getX() != 0 && ((FinestraPartita) frame).getPoint().getY() != 0){
			((FinestraPartita) frame).setGiocatoreCorrente(Search((int)((FinestraPartita) frame).getPoint().getX(),(int)((FinestraPartita) frame).getPoint().getY(),this.getGiocatori()));
			if(((FinestraPartita) frame).getGiocatoreCorrente() == null){
				((FinestraPartita) frame).setGiocatoreCorrente(Search((int)((FinestraPartita) frame).getPoint().getX(),(int)((FinestraPartita) frame).getPoint().getY(),umano.getGiocatori()));
				((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+
						" Ha intercettato la palla\n");
				((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
			}
			else{
				((FinestraPartita) frame).getPanelInfo().append(((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+
						" Ha ricevuto la palla\n");
				((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
			}
		}
		else{
			if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Centrocampista){
				((FinestraPartita) frame).setGiocatoreCorrente(SearchGiocatoreACaso(umano.getGiocatori(),"Centrocampista"));
				if((int)(Math.random()*2) == 0){
					((FinestraPartita) frame).getPanelInfo().append("palla fuori,\n " + ((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+ " ha la palla\n");
					((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
				}
				else{
					((FinestraPartita) frame).setGiocatoreCorrente(SearchGiocatoreACaso(umano.getGiocatori(),"Difensore"));
					((FinestraPartita) frame).getPanelInfo().append("palla fuori,\n " + ((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+ " ha la palla\n");
					((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
				}
			}
			else if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Difensore){
				((FinestraPartita) frame).setGiocatoreCorrente(SearchGiocatoreACaso(umano.getGiocatori(),"Attaccante"));
				if((int)(Math.random()*2) == 0){
					((FinestraPartita) frame).getPanelInfo().append("palla fuori,\n " + ((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+ " ha la palla\n");
					((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
				}
				else{
					((FinestraPartita) frame).setGiocatoreCorrente(SearchGiocatoreACaso(umano.getGiocatori(),"Centrocampista"));
					((FinestraPartita) frame).getPanelInfo().append("palla fuori,\n " + ((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+ " ha la palla\n");
					((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
				}
			}
			else if(((FinestraPartita) frame).getGiocatoreCorrente() instanceof Attaccante){
				((FinestraPartita) frame).setGiocatoreCorrente(SearchGiocatoreACaso(umano.getGiocatori(),"Difensore"));
				if((int)(Math.random()*2) == 0){
					((FinestraPartita) frame).getPanelInfo().append("palla fuori,\n " + ((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+ " ha la palla \n");
					((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
				}
				else{
					((FinestraPartita) frame).setGiocatoreCorrente(SearchGiocatoreACaso(umano.getGiocatori(),"Centrocampista"));
					((FinestraPartita) frame).getPanelInfo().append("palla fuori,\n" + ((FinestraPartita) frame).getGiocatoreCorrente().GetAnagrafe().GetCognome()+ " ha la palla \n");
					((FinestraPartita) frame).getGiocatoreCorrente().setEnabled(true);
				}
			}
		}
	}
}
