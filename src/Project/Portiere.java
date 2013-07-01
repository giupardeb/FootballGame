package Project;

import java.awt.Point;

class Portiere extends Giocatore
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7774987130855878995L;
	/**
	 * @uml.property  name="dotiAeree"
	 */
	private byte dotiAeree;
	/**
	 * @uml.property  name="agilita"
	 */
	private byte agilita;
	/**
	 * @uml.property  name="comunicazione"
	 */
	private byte comunicazione;
	/**
	 * @uml.property  name="bloccareTiri"
	 */
	private byte bloccareTiri;
	/**
	 * @uml.property  name="calciare"
	 */
	private byte calciare;
	/**
	 * @uml.property  name="riflessi"
	 */
	private byte riflessi;
	/**
	 * @uml.property  name="rimessa"
	 */
	private byte rimessa;
	//private float valoreDiMercato;

	public Portiere(String nome,String nomeSquadraAppartenente,String nazionalita,byte velocita,byte resistenza,
			byte forza,byte morale,byte eta,byte condizione,byte tecnica,byte aggressivita,
			byte creativita,byte decisione,byte carisma,String posizione,byte giocoDiSquadra,
			boolean essenziale,byte mediaVoti,byte dotiAeree,byte agilita,byte comunicazione,
			byte bloccareTiri,byte calciare,byte riflessi,byte rimessa,byte valoreGenerale,
			double valoreMercato)
	{
		super(nome,nomeSquadraAppartenente,nazionalita,velocita,resistenza,forza,morale,eta,condizione,tecnica,aggressivita,creativita,decisione,carisma,
				posizione,giocoDiSquadra,essenziale,mediaVoti,valoreGenerale,valoreMercato);

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

	/**
	 * @return
	 * @uml.property  name="dotiAeree"
	 */
	public byte getDotiAeree()
	{
		return(dotiAeree);
	}

	/**
	 * @return
	 * @uml.property  name="agilita"
	 */
	public byte getAgilita ()
	{
		return(agilita);
	}

	/**
	 * @return
	 * @uml.property  name="comunicazione"
	 */
	public byte getComunicazione()
	{
		return(comunicazione);
	}

	/**
	 * @return
	 * @uml.property  name="bloccareTiri"
	 */
	public byte getBloccareTiri()
	{
		return(bloccareTiri);
	}

	/**
	 * @return
	 * @uml.property  name="calciare"
	 */
	public byte getCalciare()
	{
		return(calciare);
	}

	/**
	 * @return
	 * @uml.property  name="riflessi"
	 */
	public byte getRiflessi()
	{
		return(riflessi);
	}

	/**
	 * @return
	 * @uml.property  name="rimessa"
	 */
	public byte getRimessa()
	{
		return(rimessa);
	}



	//metodi di set()

	/**
	 * @param valore
	 * @uml.property  name="dotiAeree"
	 */
	public void setDotiAeree(byte valore)
	{
		dotiAeree += valore;

	}

	public void setagilita (byte valore)
	{
		agilita += valore;

	}

	/**
	 * @param valore
	 * @uml.property  name="comunicazione"
	 */
	public void setComunicazione(byte valore)
	{
		comunicazione += valore;

	}

	/**
	 * @param valore
	 * @uml.property  name="bloccareTiri"
	 */
	public void setBloccareTiri(byte valore)
	{
		bloccareTiri += valore;

	}

	/**
	 * @param valore
	 * @uml.property  name="calciare"
	 */
	public void setCalciare(byte valore)
	{
		calciare += valore;

	}

	/**
	 * @param valore
	 * @uml.property  name="riflessi"
	 */
	public void setRiflessi(byte valore)
	{
		riflessi += valore;

	}

	/**
	 * @param valore
	 * @uml.property  name="rimessa"
	 */
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

	public Point rilancia(String Nomesquadra){
		Point p = this.getLocation();
		Point pavv = new Point();
		int random = (int)(Math.random()*4);


		if (this.getSquadra().equalsIgnoreCase(Nomesquadra)){
			if(random == 0)pavv.setLocation(p.getX()+98, p.getY()-142);
			else if(random == 1) pavv.setLocation(p.getX()+98, p.getY()-42);
			else if(random == 2) pavv.setLocation(p.getX()+98, p.getY()+58);
			else if(random == 3) pavv.setLocation(p.getX()+98, p.getY()+158);
		}
	else{
			if(random == 0) pavv.setLocation(p.getX()-90, p.getY()-142);
			else if(random == 1) pavv.setLocation(p.getX()-90, p.getY()-42);
			else if(random == 2) pavv.setLocation(p.getX()-90, p.getY()+58);
			else if(random == 3) pavv.setLocation(p.getX()-90, p.getY()+158);
		}
		return pavv;
	}










}