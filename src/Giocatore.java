abstract public class Giocatore
{
	private Anagrafe anagrafe;
	private String squadra;
	private byte velocita;
	private byte resistenza;
	private byte forza;
	private byte morale; 
	private byte condizione; 
	private byte tecnica;
	private byte aggressivita;
	private byte creativita;
	private byte decisione;
	private byte carisma;
	private String ruolo;
	private byte giocoDiSquadra;
	private boolean essenziale;
	private byte mediaVoti;
	private double valoreMercato;
	private byte valoreGenerale;
	 
	
	
	Giocatore(String cognome,String squadra,String nazionalita,byte velocita,
			byte resistenza,byte forza,byte morale,byte eta,byte condizione,
			byte tecnica,byte aggressivita,byte creativita,byte decisione,
			byte carisma,String posizione,byte giocoDiSquadra,boolean essenziale,
			byte mediaVoti,byte valoreGenerale,double valoreMercato) 
	{
		anagrafe = new Anagrafe(cognome,eta,nazionalita);
		this.squadra=squadra;
		this.velocita=velocita;
		this.resistenza=resistenza;
		this.forza=forza;
		this.morale=morale;
		this.condizione=condizione;
		this.tecnica=tecnica;
		this.aggressivita=aggressivita;
		this.creativita=creativita;
		this.decisione=decisione;
		this.carisma=carisma;
		this.ruolo=posizione;
		this.giocoDiSquadra =giocoDiSquadra;
		this.essenziale=essenziale;
		this.mediaVoti=mediaVoti;
		this.valoreMercato = valoreMercato;
		this.valoreGenerale = valoreGenerale;
	}
		
	
	//metodi di get()
	
	public Anagrafe GetAnagrafe(){
		return anagrafe;
	}
	
	public byte getVelocita()
	{
		return(velocita);
	}
	
	public byte getValoreGenerale(){
		return valoreGenerale;
	}
	
	public byte getResistenza()
	{
		return(resistenza);
	}
	
	public byte getForza()
	{
		return(forza);
	}
	
	public byte getMorale()
	{
		return(morale);
	}
	
	
	public byte getCondizione()
	{
		return(condizione);
	}
	
	public byte getTecnica()
	{
		return(tecnica);
	}
	
	public byte getAggressivita()
	{
		return(aggressivita);
	}
	
	public String getSquadra(){
		return squadra;
	}
	
	public byte getCreativita()
	{
		return(creativita);
	}
	
	public byte getDecisione()
	{
		return(decisione);
	}
	
	public byte getCarisma()
	{
		return(carisma);
	}
	
	public String getRuolo()
	{
		return(ruolo);
	}
	
	public byte getGiocoDiSquadra()
	{
		return(giocoDiSquadra);
	}
	
	
	public boolean getEssenziale()
	{
		return(essenziale);
	}
	
	public byte getMediaVoti()
	{
		return(mediaVoti);
	}
	
	public double getValoreMercato()
	{
		return(valoreMercato);
	}
	
	
	//metodi di set()
	
	public void setNomeSquadra(String parola)
	{
		squadra = parola;
	}
	
	public void setvelocita(byte valore)
	{
		velocita += valore;
		
		if(velocita >= 100)
			velocita = 100;
	}
	
	public void setResistenza(byte valore)
	{
		resistenza += valore;
		
		if(resistenza >= 100)
			resistenza = 100;
		
	}
	
	public void setForza(byte valore)
	{
		forza += valore;
		
		if(forza >= 100)
			forza = 100;
		
	}
	
	public void setMorale(byte valore)
	{
		morale += valore;
		
		if(morale >= 100)
			morale = 100;
	}
	
	public void setCondizione(byte valore)
	{
		condizione += valore;
		
		if(condizione >= 100)
			condizione = 100;
	}
	
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
	
	public void setDecisione(byte valore)
	{
		decisione += valore;
		
		if(decisione >= 100)
			decisione = 100;
	}
	
	public void setCarisma(byte valore) 
	{
		carisma += valore;
		
		if(carisma >= 100)
			carisma = 100;
	}
	
	public void setPosizione(byte valore)  //posizione nella matrice??
	{
		
	}
			
	public void setGiocoDiSquadra(byte valore)
	{
		giocoDiSquadra += valore;
		
		if(giocoDiSquadra >= 100)
			giocoDiSquadra = 100;
	}
	
	
	public void setEssenziale(boolean valore)
	{
		essenziale = valore;
	}
	
	public void setMediaVoti(double mediaVoti, int contatore)
	{
		mediaVoti /= contatore;
		
	}
	
	public void setValoreMercato(double denaro)
	{
		if(denaro <= 10000.01f)
		{
			System.out.println("Valore Giocatore troppo basso il valore è rimasto invariato");
		}
		else 
			valoreMercato = (byte)denaro;
	}
	
	/*
	public String toString()
	{
		return("Giocatore \n" + "Nome: " + getNome() + "\n" + "velocita: " + getvelocita() + "\n" + "Resistenza: " + getResistenza() + "\n" + "Forza: " + getForza() + "\n" + "Morale: " + getMorale() + "\n" + "eta" + geteta() + "\n" + "Condizione" + getCondizione() + "\n" + "Tecnica" + getTecnica() + "\n" + "aggressivita" + getaggressivita() + "\n" + "creativita" + getcreativita() + "\n" + "Decisione" + getDecisione() + "\n"  + "Carisma" + getCarisma() + "\n" + "Posizione: " + getPosizione() + "\n" + "Gioco di squadra: " + getGiocoDiSquadra() +"\n" + "Valore generale: " + getValoreGenerale() + "\n"  + "Media voti: " + getMediaVoti() + "\n" + "Valore generale: " + getValoreGiocatore() + "\n" );
	}
	*/
	// Altri metodi
	
	abstract public void Crescita(byte valore);
	abstract public int getDotiRuolo();
	//abstract public Giocatore SearchBestPlayer(Giocatore array[],int k);
}





///////////////////////************************/*/*/*///////////////

	