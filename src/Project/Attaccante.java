package Project;
class Attaccante extends AltriRuoli
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4930043839328074880L;

	public Attaccante(String cognome,String NomeSquadraAppartenente,String nazionalita,byte velocita,byte resistenza,byte forza,byte morale,
			byte eta,byte condizione,byte tecnica,byte aggressivita,byte creativita,byte decisione,byte carisma,String posizione,
			byte giocoDiSquadra,boolean essenziale,byte mediaVoti,byte cross,byte dribling,byte colpoDiTesta,byte passaggio, byte tiro,
			byte contrasto,	byte movimento, byte abilitaDifesa,byte abilitaAttacco,byte abilitaCentrocampo,byte valoreGenerale,
			double valoreMercato)
	{
		super(cognome,NomeSquadraAppartenente,nazionalita,velocita,resistenza,forza,morale,eta,condizione,tecnica,aggressivita,creativita,decisione,carisma,
				posizione,giocoDiSquadra,essenziale,mediaVoti,cross,dribling,colpoDiTesta,passaggio,tiro,contrasto,movimento,abilitaDifesa,
				abilitaAttacco,abilitaCentrocampo,valoreGenerale,valoreMercato);
		this.tipoRuolo = 3;
	}

	public int getDotiRuolo(){
		return (getDribling()+getColpoDiTesta()+getTiro()+getAbilitaAttacco());
	}
}