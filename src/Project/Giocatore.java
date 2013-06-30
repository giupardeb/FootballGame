package Project;

import java.awt.Point;

import javax.swing.JLabel;

abstract public class Giocatore extends JLabel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4291322821943770822L;
	/**
	 * @uml.property  name="anagrafe"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Anagrafe anagrafe;
	/**
	 * @uml.property  name="nomeSquadraAppartenente"
	 */
	private String nomeSquadraAppartenente;
	/**
	 * @uml.property  name="velocita"
	 */
	private byte velocita;
	/**
	 * @uml.property  name="resistenza"
	 */
	private byte resistenza;
	/**
	 * @uml.property  name="forza"
	 */
	private byte forza;
	/**
	 * @uml.property  name="morale"
	 */
	private byte morale; 
	/**
	 * @uml.property  name="condizione"
	 */
	private byte condizione; 
	/**
	 * @uml.property  name="tecnica"
	 */
	private byte tecnica;
	/**
	 * @uml.property  name="aggressivita"
	 */
	private byte aggressivita;
	/**
	 * @uml.property  name="creativita"
	 */
	private byte creativita;
	/**
	 * @uml.property  name="decisione"
	 */
	private byte decisione;
	/**
	 * @uml.property  name="carisma"
	 */
	private byte carisma;
	/**
	 * @uml.property  name="ruolo"
	 */
	private String ruolo;
	/**
	 * @uml.property  name="giocoDiSquadra"
	 */
	private byte giocoDiSquadra;
	/**
	 * @uml.property  name="essenziale"
	 */
	private boolean essenziale;
	/**
	 * @uml.property  name="mediaVoti"
	 */
	private byte mediaVoti;
	/**
	 * @uml.property  name="valoreMercato"
	 */
	private double valoreMercato;
	/**
	 * @uml.property  name="valoreGenerale"
	 */
	private byte valoreGenerale;
	/**
	 * @uml.property  name="tipoRuolo"
	 */
	protected int tipoRuolo; //per l'ordinamento di un array, 0 = portiere, 1 = difensore, 2 = centrocampista, 3 = attaccante
	/**
	 * @uml.property  name="posizione"
	 */
	private Point posizione;
	/**
	 * @uml.property  name="pallasi"
	 */
	private boolean pallasi;

	Giocatore(String nome,String nomeSquadraAppartenente,String nazionalita,byte velocita, byte resistenza,byte forza,byte morale,byte eta,byte condizione,
			byte tecnica,byte aggressivita,byte creativita,byte decisione, byte carisma,String ruolo,byte giocoDiSquadra,boolean essenziale,
			byte mediaVoti,byte valoreGenerale,double valoreMercato) 
			{
		anagrafe = new Anagrafe(nome,eta,nazionalita);
		this.nomeSquadraAppartenente = nomeSquadraAppartenente;
		this.velocita = velocita;
		this.resistenza = resistenza;
		this.forza = forza;
		this.morale = morale;
		this.condizione = condizione;
		this.tecnica = tecnica;
		this.aggressivita = aggressivita;
		this.creativita = creativita;
		this.decisione = decisione;
		this.carisma = carisma;
		this.ruolo = ruolo;
		this.giocoDiSquadra = giocoDiSquadra;
		this.essenziale = essenziale;
		this.mediaVoti = mediaVoti;
		this.valoreMercato = valoreMercato;
		this.valoreGenerale = valoreGenerale;
		posizione = new Point();
		pallasi = false;
			}


	//metodi di get()
	
/*	public Squadra getSquadra(){
		return squadra;
	}
*/
	public Anagrafe GetAnagrafe(){
		return anagrafe;
	}
	
	/**
	 * @return
	 * @uml.property  name="velocita"
	 */
	public byte getVelocita()
	{
		return(velocita);
	}

	/**
	 * @return
	 * @uml.property  name="valoreGenerale"
	 */
	public byte getValoreGenerale(){
		return valoreGenerale;
	}

	/**
	 * @return
	 * @uml.property  name="resistenza"
	 */
	public byte getResistenza()
	{
		return(resistenza);
	}

	/**
	 * @return
	 * @uml.property  name="forza"
	 */
	public byte getForza()
	{
		return(forza);
	}

	/**
	 * @return
	 * @uml.property  name="morale"
	 */
	public byte getMorale()
	{
		return(morale);
	}


	/**
	 * @return
	 * @uml.property  name="condizione"
	 */
	public byte getCondizione()
	{
		return(condizione);
	}

	/**
	 * @return
	 * @uml.property  name="tecnica"
	 */
	public byte getTecnica()
	{
		return(tecnica);
	}

	/**
	 * @return
	 * @uml.property  name="aggressivita"
	 */
	public byte getAggressivita()
	{
		return(aggressivita);
	}

	public String getSquadra(){
		return nomeSquadraAppartenente;
	}

	/**
	 * @return
	 * @uml.property  name="creativita"
	 */
	public byte getCreativita()
	{
		return(creativita);
	}

	/**
	 * @return
	 * @uml.property  name="decisione"
	 */
	public byte getDecisione()
	{
		return(decisione);
	}

	/**
	 * @return
	 * @uml.property  name="carisma"
	 */
	public byte getCarisma()
	{
		return(carisma);
	}

	/**
	 * @return
	 * @uml.property  name="ruolo"
	 */
	public String getRuolo()
	{
		return(ruolo);
	}

	/**
	 * @return
	 * @uml.property  name="giocoDiSquadra"
	 */
	public byte getGiocoDiSquadra()
	{
		return(giocoDiSquadra);
	}


	public boolean getEssenziale()
	{
		return(essenziale);
	}

	/**
	 * @return
	 * @uml.property  name="mediaVoti"
	 */
	public byte getMediaVoti()
	{
		return(mediaVoti);
	}

	/**
	 * @return
	 * @uml.property  name="valoreMercato"
	 */
	public double getValoreMercato()
	{
		return(valoreMercato);
	}
	
	public Point getPosizione(){
		return posizione.getLocation();
	}

	//metodi di set()
	
	public void setPalla(boolean a){
		pallasi = a;
	}

	public void setPosizione(int x, int y){
		posizione.setLocation(x, y);
	}
	
	public void setNomeSquadra(String parola)
	{
		nomeSquadraAppartenente = parola;
	}

	public void setvelocita(byte valore)
	{
		velocita += valore;

		if(velocita >= 100)
			velocita = 100;
	}

	/**
	 * @param valore
	 * @uml.property  name="resistenza"
	 */
	public void setResistenza(byte valore)
	{
		resistenza += valore;

		if(resistenza >= 100)
			resistenza = 100;

	}

	/**
	 * @param valore
	 * @uml.property  name="forza"
	 */
	public void setForza(byte valore)
	{
		forza += valore;

		if(forza >= 100)
			forza = 100;

	}

	/**
	 * @param valore
	 * @uml.property  name="morale"
	 */
	public void DiminuisciMorale(int valore)
	{
		morale -= valore;

		if(morale < 60)
			morale = 60;
	}

	/**
	 * @param valore
	 * @uml.property  name="condizione"
	 */
	public void DiminuisciCondizione(int valore)
	{
		condizione -=valore;

		if(condizione < 50)
			condizione = 50;
	}

	/**
	 * @param valore
	 * @uml.property  name="tecnica"
	 */
	public void setTecnica(byte valore)
	{
		tecnica += valore;

		if(tecnica >= 100)
			tecnica = 100;
	}

	public void setaggressivita(byte valore)
	{
		aggressivita += valore;

		if(aggressivita >= 100)
			aggressivita = 100;
	}

	public void setcreativita(byte valore)
	{
		creativita += valore;

		if(creativita >= 100)
			creativita = 100;
	}

	/**
	 * @param valore
	 * @uml.property  name="decisione"
	 */
	public void setDecisione(byte valore)
	{
		decisione += valore;

		if(decisione >= 100)
			decisione = 100;
	}

	/**
	 * @param valore
	 * @uml.property  name="carisma"
	 */
	public void DiminuisciCarisma(int valore) 
	{
		carisma -= valore;

		if(carisma < 50)
			carisma = 50;
	}

	public void setPosizione(byte valore)  //posizione nella matrice??
	{

	}

	/**
	 * @param valore
	 * @uml.property  name="giocoDiSquadra"
	 */
	public void setGiocoDiSquadra(byte valore)
	{
		giocoDiSquadra += valore;

		if(giocoDiSquadra >= 100)
			giocoDiSquadra = 100;
	}


	/**
	 * @param valore
	 * @uml.property  name="essenziale"
	 */
	public void setEssenziale(boolean valore)
	{
		essenziale = valore;
	}

	public void setMediaVoti(int contatore)
	{
		this.mediaVoti /= contatore;

	}

	/**
	 * @param denaro
	 * @uml.property  name="valoreMercato"
	 */
	public void setValoreMercato(double denaro)
	{
		if(denaro <= 10000.01f)
		{
			System.out.println("Valore Giocatore troppo basso il valore è rimasto invariato");
		}
		else 
			valoreMercato = (byte)denaro;
	}


	public String toString()
	{
		return( "Cognome: " + GetAnagrafe().GetCognome() + " Squadra di appartenenza: "+ getSquadra()+ "\n"+" Ruolo: "+getRuolo()+"\n"+" eta:" 
				+ GetAnagrafe().GetEta() +"\n"+" Valore generale: " + getValoreGenerale() + "\n" + " alore Mercato: " + getValoreMercato() + 
				"\n" + posizione.getLocation());
	}

	// Altri metodi

	abstract public int getDotiRuolo();
	
	/**
	 * @return
	 * @uml.property  name="tipoRuolo"
	 */
	public int getTipoRuolo(){
		return tipoRuolo;
	}
	
}





///////////////////////************************/*/*/*///////////////

