package Project;
abstract class AltriRuoli extends Giocatore
{
	private byte cross;
	private byte dribling;
	private byte colpoDiTesta;
	private byte passaggio;
	private byte tiro;
	private byte contrasto;
	private byte movimento;
	private byte abilitaDifesa;
	private byte abilitaAttacco;
	private byte abilitaCentrocampo;


	public AltriRuoli(String cognome,String squadra,String nazionalita,byte velocita,byte resistenza,
			byte forza,byte morale,byte eta,byte condizione,byte tecnica,byte aggressivita,
			byte creativita,byte decisione,byte carisma,String posizione,byte giocoDiSquadra,
			boolean essenziale,byte mediaVoti,byte cross,byte dribling,byte colpoDiTesta,
			byte passaggio, byte tiro, byte contrasto, byte movimento, byte abilitaDifesa,
			byte abilitaAttacco,byte abilitaCentrocampo,byte valoreGenerale,double valoreMercato){

		super (cognome, squadra, nazionalita, velocita, resistenza, forza, morale, eta,condizione, 
				tecnica, aggressivita, creativita, decisione, carisma, posizione, giocoDiSquadra,
				essenziale,mediaVoti,valoreGenerale,valoreMercato);

		this.cross = cross;
		this.dribling = dribling;
		this.colpoDiTesta = colpoDiTesta;
		this.passaggio = passaggio;
		this.tiro = tiro;
		this.contrasto = contrasto;
		this.movimento = movimento;
		this.abilitaDifesa = abilitaDifesa;
		this.abilitaAttacco = abilitaAttacco;
		this.abilitaCentrocampo = abilitaCentrocampo;
	}

	//metodi di get()

	public byte getCross()
	{
		return(cross);
	}

	public byte getDribling()
	{
		return(dribling);
	}

	public byte getColpoDiTesta()
	{
		return(colpoDiTesta);
	}

	public byte getPassaggio()
	{
		return(passaggio);
	}

	public byte getTiro()
	{
		return(tiro);
	}

	public byte getContrasto()
	{
		return(contrasto);
	}

	public byte getMovimento()
	{
		return(movimento);
	}

	public byte getAbilitaDifesa()
	{
		return(abilitaDifesa);
	}

	public byte getAbilitaAttacco()
	{
		return(abilitaAttacco);
	}

	public byte getAbilitaCentrocampo()
	{
		return(abilitaCentrocampo);
	}


	//metodi di set()

	public void setCross(byte valore)
	{
		cross += valore;

		if(cross >= 100)
			cross = 100;

	}

	public void setDribling(byte valore)
	{
		dribling += valore;

		if(dribling >= 100)
			dribling = 100;

	}

	public void setColpoDiTesta(byte valore)
	{
		colpoDiTesta += valore;

		if(colpoDiTesta >= 100)
			colpoDiTesta = 100;

	}

	public void setPassaggio(byte valore)
	{
		passaggio += valore;

		if(passaggio >= 100)
			passaggio = 100;

	}

	public void setTiro(byte valore)
	{
		tiro += valore;

		if(tiro >= 100)
			tiro = 100;

	}

	public void setcontrasto(byte valore)
	{
		contrasto += valore;

		if(contrasto >= 100)
			contrasto = 100;

	}

	public void setMovimento(byte valore)
	{
		movimento += valore;

		if(movimento >= 100)
			movimento = 100;

	}

	public void setabilitaDifesa(byte valore)
	{
		abilitaDifesa += valore;

		if(abilitaDifesa >= 100)
			abilitaDifesa = 100;

	}

	public void setabilitaAttacco(byte valore)
	{
		abilitaAttacco += valore;

		if(abilitaAttacco >= 100)
			abilitaAttacco = 100;

	}

	public void setabilitaCentrocampo(byte valore)
	{
		abilitaCentrocampo += valore;

		if(abilitaCentrocampo >= 100)
			abilitaCentrocampo = 100;

	}

	public void setValoreGenerale()
	{
		int media = 0;
	
		media = (getCross()+ getDribling()+ getColpoDiTesta() + getPassaggio() + getTiro() + 
				getContrasto() + getMovimento() + getAbilitaDifesa() + getAbilitaAttacco() + 
				getAbilitaCentrocampo()+ getVelocita() + getResistenza() + getForza() + getMorale() 
				+ getCondizione() + getTecnica() + getAggressivita() + getCreativita() + getDecisione()
				+ getCarisma() + getGiocoDiSquadra());
		
		media = (byte)(media/21);

	}


	public String toString()
	{
		return(super.toString() + "\n" + " Statistiche specifiche: " + "\n" + " Cross: " + getCross() + "\n" + " Dribling: " +
				getDribling() + "\n" + " Colpo di testa: " + getColpoDiTesta() + "\n" + " Passaggio: " + getPassaggio() + "\n" + " Tiro: " + 
				getTiro() + "\n" + " contrasto: " + getContrasto() + "\n" + " Movimento: " + getMovimento() + "\n" + " abilita difesa: " + 
				getAbilitaDifesa() + "\n" + " abilita attacco: " + getAbilitaAttacco() + "\n" + 
				" abilita centrocampo: " + getAbilitaCentrocampo() + "\n");
	}
	// altri metodi

}