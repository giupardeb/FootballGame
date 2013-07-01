package Project;
/**
 * @uml.dependency   supplier="Project.AltriRuoli"
 */
class Difensore extends AltriRuoli
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7186361943047174970L;



	public Difensore(String cognome,String NomeSquadraAppartenente,String nazionalita,byte velocita,byte resistenza,byte forza,byte morale,
			byte eta,byte condizione,byte tecnica,byte aggressivita,byte creativita,byte decisione,byte carisma,String posizione,
			byte giocoDiSquadra,boolean essenziale,byte mediaVoti,byte cross,byte dribling,byte colpoDiTesta,byte passaggio, byte tiro,
			byte contrasto, byte movimento, byte abilitaDifesa,byte abilitaAttacco,byte abilitaCentrocampo,byte valoreGenerale,
			double valoreMercato)
	{
		super ( cognome, NomeSquadraAppartenente, nazionalita, velocita, resistenza, forza, morale, eta,condizione, tecnica, aggressivita, creativita, 
				decisione, carisma, posizione, giocoDiSquadra,essenziale,mediaVoti,cross,dribling,colpoDiTesta,passaggio,tiro,contrasto,movimento,
				abilitaDifesa,abilitaAttacco,abilitaCentrocampo,valoreGenerale,valoreMercato);
		this.tipoRuolo = 1;
	}



	public int getDotiRuolo(){
		return (getContrasto()+getColpoDiTesta()+getPassaggio()+getAbilitaDifesa());
	}

}