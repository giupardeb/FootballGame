package Project;
class Centrocampista extends AltriRuoli
{
	public Centrocampista(String cognome,String NomeSquadraAppartenente,String nazionalita,byte velocita,byte resistenza,byte forza,byte morale,byte eta,
			byte condizione,byte tecnica,byte aggressivita,byte creativita,byte decisione,byte carisma,String posizione,byte giocoDiSquadra,
			boolean essenziale,byte mediaVoti,Squadra squadra,byte cross,byte dribling,byte colpoDiTesta,byte passaggio, byte tiro, byte contrasto, 
			byte movimento, byte abilitaDifesa,byte abilitaAttacco,byte abilitaCentrocampo,byte valoreGenerale,
			double valoreMercato)
	{
		super(cognome,NomeSquadraAppartenente,nazionalita,velocita,resistenza,forza,morale,eta,condizione,tecnica,aggressivita,creativita,decisione,carisma,posizione,
				giocoDiSquadra,essenziale,mediaVoti,squadra,cross,dribling,colpoDiTesta,passaggio,tiro,contrasto,movimento,abilitaDifesa,abilitaAttacco,
				abilitaCentrocampo,valoreGenerale,valoreMercato);
		this.tipoRuolo = 2;
	}

	/*public Giocatore SearchBestPlayer(Giocatore array[],int k){

		Centrocampista tmp = this; //oggetto chiamante è un portiere
		double sommatmp= this.getValoreGenerale();
		double somma = 0;

		//boolean trovato = false;

		for(int i=k+1; i<array.length /*&& trovato !=true;i++){
			if(array[i] instanceof Centrocampista ){
				 somma = ((Centrocampista)array[i]).getValoreGenerale();
				if((sommatmp<somma) && (this.getCondizione()<array[i].getCondizione())) {
					tmp = (Centrocampista)array[i];
				//	trovato = true;
				}
			}
		}
		return tmp;

	}*/

	public int getDotiRuolo(){
		return (getPassaggio()+getCross()+getMovimento()+getAbilitaCentrocampo());
	}

}