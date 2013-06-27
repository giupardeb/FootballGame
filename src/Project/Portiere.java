package Project;
class Portiere extends Giocatore
{

	private byte dotiAeree;
	private byte agilita;
	private byte comunicazione;
	private byte bloccareTiri;
	private byte calciare;
	private byte riflessi;
	private byte rimessa;
	//private float valoreDiMercato;

	public Portiere(String nome,String nomeSquadraAppartenente,String nazionalita,byte velocita,byte resistenza,
			byte forza,byte morale,byte eta,byte condizione,byte tecnica,byte aggressivita,
			byte creativita,byte decisione,byte carisma,String posizione,byte giocoDiSquadra,
			boolean essenziale,byte mediaVoti,Squadra squadra,byte dotiAeree,byte agilita,byte comunicazione,
			byte bloccareTiri,byte calciare,byte riflessi,byte rimessa,byte valoreGenerale,
			double valoreMercato)
	{
		super(nome,nomeSquadraAppartenente,nazionalita,velocita,resistenza,forza,morale,eta,condizione,tecnica,aggressivita,creativita,decisione,carisma,
				posizione,giocoDiSquadra,essenziale,mediaVoti,squadra, valoreGenerale,valoreMercato);

		this.dotiAeree = dotiAeree;
		this.agilita = agilita;
		this.comunicazione = comunicazione;
		this.bloccareTiri = bloccareTiri;
		this.calciare = calciare;
		this.riflessi = riflessi;
		this.rimessa = rimessa;
		this.tipoRuolo = 0;
	}


	//metodi di get()
	
	public int getAbilita(){
		return dotiAeree+agilita+comunicazione+bloccareTiri+calciare+riflessi+rimessa;
	}


	public int getDotiRuolo(){ //ritorna le doti caratterizzanti del ruolo. utile x il calciomercato.

		return (getDotiAeree()+getAgilita()+getComunicazione()+getBloccareTiri()+getCalciare()+getRiflessi()+getRimessa());

	}

	public byte getDotiAeree()
	{
		return(dotiAeree);
	}

	public byte getAgilita ()
	{
		return(agilita);
	}

	public byte getComunicazione()
	{
		return(comunicazione);
	}

	public byte getBloccareTiri()
	{
		return(bloccareTiri);
	}

	public byte getCalciare()
	{
		return(calciare);
	}

	public byte getRiflessi()
	{
		return(riflessi);
	}

	public byte getRimessa()
	{
		return(rimessa);
	}



	//metodi di set()

	public void setDotiAeree(byte valore)
	{
		dotiAeree += valore;

	}

	public void setagilita (byte valore)
	{
		agilita += valore;

	}

	public void setComunicazione(byte valore)
	{
		comunicazione += valore;

	}

	public void setBloccareTiri(byte valore)
	{
		bloccareTiri += valore;

	}

	public void setCalciare(byte valore)
	{
		calciare += valore;

	}

	public void setRiflessi(byte valore)
	{
		riflessi += valore;

	}

	public void setRimessa(byte valore)
	{
		rimessa += valore;

	}

	public void setValoreGenerale()
	{
		int media = 0;
		media=(getVelocita() + getResistenza() + getForza() + getMorale() + getCondizione() + getTecnica() + getAggressivita() + getCreativita() +
				getDecisione() + getCarisma() + getGiocoDiSquadra() + getDotiAeree() + getAgilita() + getComunicazione() + getBloccareTiri() +
				getCalciare() + getRiflessi()+ getRimessa() );

		media = (byte)(media/18);
	}


	public String toString()
	{
		return(super.toString() + "\n" + " Statistiche specifiche: " + "\n" + " Doti aeree: " + getDotiAeree() + "\n" + " agilita: " + 
				getAgilita() + "\n" + " Comunicazione: " + getComunicazione() + "\n" + " Bloccaggio tiri: " + getBloccareTiri() + "\n" + " Calciare" + 
				getCalciare() + "\n" + " Riflessi: " + getRiflessi() + "\n" + " Rimessa" + getRimessa() + "\n");
	}


	//METODI!
}