package Project;
class Difensore extends AltriRuoli
{
	public Difensore(String cognome,String NomeSquadraAppartenente,String nazionalita,byte velocita,byte resistenza,byte forza,byte morale,
			byte eta,byte condizione,byte tecnica,byte aggressivita,byte creativita,byte decisione,byte carisma,String posizione,
			byte giocoDiSquadra,boolean essenziale,byte mediaVoti,Squadra squadra,byte cross,byte dribling,byte colpoDiTesta,byte passaggio, byte tiro,
			byte contrasto, byte movimento, byte abilitaDifesa,byte abilitaAttacco,byte abilitaCentrocampo,byte valoreGenerale,
			double valoreMercato)
	{
		super ( cognome, NomeSquadraAppartenente, nazionalita, velocita, resistenza, forza, morale, eta,condizione, tecnica, aggressivita, creativita, 
				decisione, carisma, posizione, giocoDiSquadra,essenziale,mediaVoti,squadra,cross,dribling,colpoDiTesta,passaggio,tiro,contrasto,movimento,
				abilitaDifesa,abilitaAttacco,abilitaCentrocampo,valoreGenerale,valoreMercato);
		this.tipoRuolo = 1;
	}

	/*public Giocatore SearchBestPlayer(Giocatore array[],int k){

		Difensore tmp = this; //oggetto chiamante è un difensore
		double sommatmp = 0;
		sommatmp= this.getValoreGenerale();
		double somma;
	//	boolean trovato = false;

		for(int i=k+1; i<array.length/* && trovato !=true;i++){
			if(array[i] instanceof Difensore ){
				 somma = ((Difensore)array[i]).getValoreGenerale();
				if((sommatmp<somma) && (this.getCondizione()<array[i].getCondizione())) {
					tmp = (Difensore)array[i];
				//	trovato = true;
				}
			}
		}
		return tmp;

	}*/


	public int getDotiRuolo(){
		return (getContrasto()+getColpoDiTesta()+getPassaggio()+getAbilitaDifesa());
	}

}