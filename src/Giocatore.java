abstract public class Giocatore
{
	private Anagrafe anagrafe;
//	private String nome;
//	private String cognome;
//	private String nazionalità;
	private String squadra;
	private byte velocità;
	private byte resistenza;
	private byte forza;
	private byte morale; 
//	private byte età;
	private byte condizione; 
	private byte tecnica;
	private byte aggressività;
	private byte creatività;
	private byte decisione;
	private byte carisma;
	private byte posizione;
	private byte giocoDiSquadra;
	private boolean essenziale;
	private double mediaVoti;
	private double valoreMercato;
	
	
	Giocatore(String nome,String cognome,String nazionalità,String squadra,byte velocità,byte resistenza,byte forza,byte morale,byte età,byte condizione,byte tecnica,byte aggressività,byte creatività,byte decisione,byte carisma,byte posizione,byte giocoDiSquadra,boolean essenziale,double mediaVoti,double valoreMercato) 
	{
		anagrafe = new Anagrafe(nome,cognome,età,nazionalità);
		//this.nome=nome;
		//this.cognome=cognome;
		//this.nazionalità=nazionalità;
		this.squadra=squadra;
		this.velocità=velocità;
		this.resistenza=resistenza;
		this.forza=forza;
		this.morale=morale;
		//this.età=età;
		this.condizione=condizione;
		this.tecnica=tecnica;
		this.aggressività=aggressività;
		this.creatività=creatività;
		this.decisione=decisione;
		this.carisma=carisma;
		this.posizione=posizione; //serve per l' allocazione dell' array,???
		this.giocoDiSquadra =giocoDiSquadra;
		this.essenziale=essenziale;
		this.mediaVoti=mediaVoti;
		this.valoreMercato = valoreMercato;
	}
		
	
	//metodi di get()
	
	public Anagrafe GetAnagrafe(){
		return anagrafe;
	}
	
	/*public String getNome()
	{
		return(nome);
	}
	
	
	public String getCognome()
	{
		return(cognome);
	}
	
	public String getNazionalità()
	{
		return(nazionalità);
	}*/
	
	public String getSquadra()
	{
		return(squadra);
	}
	
	public byte getVelocità()
	{
		return(velocità);
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
	
	/*public byte getEtà()
	{
		return(età);
	}*/
	
	public byte getCondizione()
	{
		return(condizione);
	}
	
	public byte getTecnica()
	{
		return(tecnica);
	}
	
	public byte getAggressività()
	{
		return(aggressività);
	}
	
	public byte getCreatività()
	{
		return(creatività);
	}
	
	public byte getDecisione()
	{
		return(decisione);
	}
	
	public byte getCarisma()
	{
		return(carisma);
	}
	
	public byte getPosizione()
	{
		return(posizione);
	}
	
	public byte getGiocoDiSquadra()
	{
		return(giocoDiSquadra);
	}
	
	
	public boolean getEssenziale()
	{
		return(essenziale);
	}
	
	public double getMediaVoti()
	{
		return(mediaVoti);
	}
	
	public double getValoreMercato()
	{
		return(valoreMercato);
	}
	
	
	//metodi di set()
	
	/*public void setNome(String parola)
	{
		nome=parola;
	}
	
	public void setCognome(String parola)
	{
		cognome=parola;
	}
	
	public void setNazionalità(String parola)
	{
		nazionalità=parola;
	}*/
	
	public void setNomeSquadra(String parola)
	{
		squadra=parola;
	}
	
	public void setVelocità(byte valore)
	{
		velocità+=valore;
		
		if(velocità>=100)
			velocità=100;
	}
	
	public void setResistenza(byte valore)
	{
		resistenza+=valore;
		
		if(resistenza>=100)
			resistenza=100;
		
	}
	
	public void setForza(byte valore)
	{
		forza+=valore;
		
		if(forza>=100)
			forza=100;
		
	}
	
	public void setMorale(byte valore)
	{
		morale+=valore;
		
		if(morale>=100)
			morale=100;
	}
	
	/*public void setEtà()  //come fai a creare un metodo set senza passaggio di parametri??=??
	 * forse hai voluto mettere ciò per far si che il giocatore diventi più grande durante il gioco? se è così non è meglio
	 * metterlo nel metodo crescita??
	{
		età++;
		if(età>=40)
			System.out.println("Attenzione!!! Giocatore prossimo al ritiro");
	}*/
	
	public void setCondizione(byte valore)
	{
		condizione+=valore;
		
		if(condizione>=100)
			condizione=100;
	}
	
	public void setTecnica(byte valore)
	{
		tecnica+=valore;
		
		if(tecnica>=100)
			tecnica=100;
	}
	
	public void setAggressività(byte valore)
	{
		aggressività+=valore;
		
		if(aggressività>=100)
			aggressività=100;
	}
	
	public void setCreatività(byte valore)
	{
		creatività+=valore;
		
		if(creatività>=100)
			creatività=100;
	}
	
	public void setDecisione(byte valore)
	{
		decisione+=valore;
		
		if(creatività>=100)
			creatività=100;
	}
	
	public void setCarisma(byte valore) 
	{
		carisma+=valore;
		
		if(carisma>=100)
			carisma=100;
	}
	
	public void setPosizione(byte valore) 
	{
		
	}
			
	public void setGiocoDiSquadra(byte valore)
	{
		giocoDiSquadra+=valore;
		
		if(giocoDiSquadra>=100)
			giocoDiSquadra=100;
	}
	
	
	public void setEssenziale(boolean valore)
	{
		essenziale=valore;
	}
	
	public void setMediaVoti(double mediaVoti, int contatore)
	{
		mediaVoti/=contatore;
		
	}
	
	public void setValoreMercato(double denaro)
	{
		if(denaro<=10000.01f)
		{
			System.out.println("Valore Giocatore troppo basso il valore è rimasto invariato");
		}
		else 
			valoreMercato=denaro;
	}
	
	/*
	public String toString()
	{
		return("Giocatore \n" + "Nome: " + getNome() + "\n" + "velocità: " + getvelocità() + "\n" + "Resistenza: " + getResistenza() + "\n" + "Forza: " + getForza() + "\n" + "Morale: " + getMorale() + "\n" + "età" + getetà() + "\n" + "Condizione" + getCondizione() + "\n" + "Tecnica" + getTecnica() + "\n" + "aggressività" + getaggressività() + "\n" + "creatività" + getcreatività() + "\n" + "Decisione" + getDecisione() + "\n"  + "Carisma" + getCarisma() + "\n" + "Posizione: " + getPosizione() + "\n" + "Gioco di squadra: " + getGiocoDiSquadra() +"\n" + "Valore generale: " + getValoreGenerale() + "\n"  + "Media voti: " + getMediaVoti() + "\n" + "Valore generale: " + getValoreGiocatore() + "\n" );
	}
	*/
	// Altri metodi
	
	abstract public void Crescita(byte valore);
	abstract public int getDotiRuolo();
	abstract public Giocatore SearchBestPlayer(Giocatore array[],int k);
}

class Portiere extends Giocatore
{
	
	private byte dotiAeree;
	private byte agilità;
	private byte comunicazione;
	private byte bloccareTiri;
	private byte calciare;
	private byte riflessi;
	private byte rimessa;
	private byte valoreGenerale;
	//private float valoreDiMercato;
	
	public Portiere(String nome,String cognome,String nazionalità,String squadra,byte velocità,byte resistenza,byte forza,byte morale,byte età,byte condizione,byte tecnica,byte aggressività,byte creatività,byte decisione,byte carisma,byte posizione,byte giocoDiSquadra,boolean essenziale,double mediaVoti,byte dotiAeree,byte agilità,byte comunicazione,byte bloccareTiri,byte calciare,byte riflessi,byte rimessa,byte valoreGenerale,double valoreMercato)
	{
		super(nome,cognome,nazionalità,squadra,velocità,resistenza,forza,morale,età,condizione,tecnica,aggressività,creatività,decisione,carisma,posizione,giocoDiSquadra,essenziale,mediaVoti,valoreMercato);
		this.dotiAeree=dotiAeree;
		this.agilità=agilità;
		this.comunicazione=comunicazione;
		this.bloccareTiri=bloccareTiri;
		this.calciare=calciare;
		this.riflessi=riflessi;
		this.rimessa=rimessa;
		this.valoreGenerale=valoreGenerale;
		//this.valoreDiMercato=valoreDiMercato;
	}
	
	
	//metodi di get()
	
	
	public int getDotiRuolo(){ //ritorna le doti caratterizzanti del ruolo. utile x il calciomercato.
		
		return (getDotiAeree()+getAgilità()+getComunicazione()+getBloccareTiri()+getCalciare()+getRiflessi()+getRimessa());
			
	}
	
	public byte getDotiAeree()
	{
		return(dotiAeree);
	}
	
	public byte getAgilità ()
	{
		return(agilità);
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
	
	public byte getValoreGenerale()
	{
		return(valoreGenerale);
	}
	
	
	//metodi di set()
	
	public void setDotiAeree(byte valore)
	{
		dotiAeree+=valore;
		
	}
	
	public void setagilità (byte valore)
	{
		agilità+=valore;
		
	}
	
	public void setComunicazione(byte valore)
	{
		comunicazione+=valore;
		
	}
	
	public void setBloccareTiri(byte valore)
	{
		bloccareTiri+=valore;
		
	}
	
	public void setCalciare(byte valore)
	{
		calciare+=valore;
		
	}
	
	public void setRiflessi(byte valore)
	{
		riflessi+=valore;
		
	}
	
	public void setRimessa(byte valore)
	{
		rimessa+=valore;
	
	}

	public void setValoreGenerale()
	{
		int media=0;
		media=(getVelocità() + getResistenza() + getForza() + getMorale() + getCondizione() + getTecnica() + getAggressività() + getCreatività() + getDecisione() + getCarisma() + getPosizione() + getGiocoDiSquadra() + getDotiAeree() + getAgilità() + getComunicazione() + getBloccareTiri() + getCalciare() + getRiflessi()+ getRimessa() );
		media=(byte)(media/19);
	}
	
	/*
	
	public String toString()
	{
		return(super.toString() + "\n" + "Statistiche specifiche: " + "\n" + "Doti aeree: " + getDotiAeree() + "\n" + "agilità: " + getagilità() + "\n" + "Comunicazione: " + getComunicazione() + "\n" + "Bloccaggio tiri: " + getBloccareTiri() + "\n" + "Calciare" + getCalciare() + "\n" + "Riflessi: " + getRiflessi() + "\n" + "Rimessa" + getRimessa() + "\n");
	}
	
	*/
	
	//METODI!
	
	public void Crescita(byte prova)
	{
		int a=0;
	}
	
	
	public Giocatore SearchBestPlayer(Giocatore array[],int k){
		
		Portiere tmp = this; //oggetto chiamante è un portiere
		int sommatmp = 0;
		sommatmp = this.getValoreGenerale();
	//	boolean trovato = false;
	
		for(int i=k+1; i<array.length /*&& trovato !=true*/;i++){
			if(array[i] instanceof Portiere ){
				int somma = ((Portiere)array[i]).getValoreGenerale();
				if((sommatmp<somma) && (this.getCondizione()<array[i].getCondizione())) {
					tmp = (Portiere)array[i];
					//trovato = true;
				}
			}
		}
		return tmp;
		
	}
	
	
}

abstract class AltriRuoli extends Giocatore
{
	private byte cross;
	private byte dribling;
	private byte colpoDiTesta;
	private byte passaggio;
	private byte tiro;
	private byte contrasti;
	private byte movimento;
	private byte abilitàDifesa;
	private byte abilitàAttacco;
	private byte abilitàCentrocampo;
	private byte valoreGenerale;
	//private float valoreDiMercato;
	
	
	public AltriRuoli(String nome,String cognome,String nazionalità,String squadra,byte velocità,byte resistenza,byte forza,byte morale,byte età,byte condizione,byte tecnica,byte aggressività,byte creatività,byte decisione,byte carisma,byte posizione,byte giocoDiSquadra,boolean essenziale,double mediaVoti,byte cross,byte dribling,byte colpoDiTesta,byte passaggio,byte tiro,byte contrasti,byte movimento,byte abilitàDifesa,byte abilitàAttacco,byte abilitàCentrocampo,byte valoreGenerale,double valoreMercato)
	{
		super(nome,cognome,nazionalità,squadra,velocità,resistenza,forza,morale,età,condizione,tecnica,aggressività,creatività,decisione,carisma,posizione,giocoDiSquadra,essenziale,mediaVoti,valoreMercato);
		this.cross=cross;
		this.dribling=dribling;
		this.colpoDiTesta=colpoDiTesta;
		this.passaggio=passaggio;
		this.tiro=tiro;
		this.contrasti=contrasti;
		this.movimento=movimento;
		this.abilitàDifesa=abilitàDifesa;
		this.abilitàAttacco=abilitàAttacco;
		this.abilitàCentrocampo=abilitàCentrocampo;
		this.valoreGenerale=valoreGenerale;
	//	this.valoreDiMercato=valoreDiMercato;
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
	
	public byte getContrasti()
	{
		return(contrasti);
	}
	
	public byte getMovimento()
	{
		return(movimento);
	}
	
	public byte getAbilitàDifesa()
	{
		return(abilitàDifesa);
	}
	
	public byte getAbilitàAttacco()
	{
		return(abilitàAttacco);
	}
	
	public byte getAbilitàCentrocampo()
	{
		return(abilitàCentrocampo);
	}
	
	public byte getValoreGenerale()
	{
		return(valoreGenerale);
	}
	
/*	public float getValoreDiMercato()
	{
		return(valoreDiMercato);
	}*/
	
	//metodi di set()
	
	public void setCross(byte valore)
	{
		cross+=valore;
		
		if(cross>=100)
			cross=100;
		
	}
	
	public void setDribling(byte valore)
	{
		dribling+=valore;
		
		if(dribling>=100)
			dribling=100;
		
	}
	
	public void setColpoDiTesta(byte valore)
	{
		colpoDiTesta+=valore;
		
		if(colpoDiTesta>=100)
			colpoDiTesta=100;
		
	}
	
	public void setPassaggio(byte valore)
	{
		passaggio+=valore;
		
		if(passaggio>=100)
			passaggio=100;
		
	}
	
	public void setTiro(byte valore)
	{
		tiro+=valore;
		
		if(tiro>=100)
			tiro=100;
		
	}
	
	public void setContrasti(byte valore)
	{
		contrasti+=valore;
		
		if(contrasti>=100)
			contrasti=100;
		
	}
	
	public void setMovimento(byte valore)
	{
		movimento+=valore;
		
		if(movimento>=100)
			movimento=100;
		
	}
	
	public void setabilitàDifesa(byte valore)
	{
		abilitàDifesa+=valore;
		
		if(abilitàDifesa>=100)
			abilitàDifesa=100;
	
	}
	
	public void setabilitàAttacco(byte valore)
	{
		abilitàAttacco+=valore;
		
		if(abilitàAttacco>=100)
			abilitàAttacco=100;
	
	}
	
	public void setabilitàCentrocampo(byte valore)
	{
		abilitàCentrocampo+=valore;
		
		if(abilitàCentrocampo>=100)
			abilitàCentrocampo=100;
	
	}
	
	public void setValoreGenerale()
	{
		int media=0;
		media=(getCross()+ getDribling()+ getColpoDiTesta() + getPassaggio() + getTiro() + getContrasti() + getMovimento() + getAbilitàDifesa() + getAbilitàAttacco() + getAbilitàCentrocampo()+ getVelocità() + getResistenza() + getForza() + getMorale() + getCondizione() + getTecnica() + getAggressività() + getCreatività() + getDecisione() + getCarisma() + getPosizione()+ getGiocoDiSquadra() );
		media=(byte)(media/22);
		
	}
	
/*	public void setValoreDiMercato(float denaro)
	{
		if(denaro<=10000.01f)
		{
			System.out.println("Valore Giocatore troppo basso il valore � rimasto invariato");
		}
		else 
			valoreDiMercato=denaro;
	}*/
	
	/*
	public String toString()
	{
		return(super.toString() + "\n" + "Statistiche specifiche: " + "\n" + "Cross: " + getCross() + "\n" + "Dribling: " + getDribling() + "\n" + "Colpo di testa: " + getColpoDiTesta() + "\n" + "Passaggio: " + getPassaggio() + "\n" + "Tiro" + getTiro() + "\n" + "Contrasti: " + getContrasti() + "\n" + "Movimento: " + getMovimento() + "\n" + "abilità difesa: " + getabilitàDifesa() + "\n" + "abilità attacco: " + getabilitàAttacco() + "\n" + "abilità centrocampo: " + getabilitàCentrocampo() + "\n");
	}
	*/
	
	// altri metodi
	
	abstract public void Crescita(byte valore);
	
}
//////////////*******//////////*/*/*
class Difensore extends AltriRuoli
{
	public Difensore(String nome,String cognome,String nazionalità,String squadra,byte velocità,byte resistenza,byte forza,byte morale,byte età,byte condizione,byte tecnica,byte aggressività,byte creatività,byte decisione,byte carisma,byte posizione,byte giocoDiSquadra,boolean essenziale,double mediaVoti,byte cross,byte dribling,byte colpoDiTesta,byte passaggio,byte tiro,byte contrasti,byte movimento,byte abilitàDifesa,byte abilitàAttacco,byte abilitàCentrocampo,byte valoreGenerale,double valoreMercato)
	{
		super(nome,cognome,nazionalità,squadra,velocità,resistenza,forza,morale,età,condizione,tecnica,aggressività,creatività,decisione,carisma,posizione,giocoDiSquadra,essenziale,mediaVoti,cross,dribling,colpoDiTesta,passaggio,tiro,contrasti,movimento,abilitàDifesa,abilitàAttacco,abilitàCentrocampo,valoreGenerale,valoreMercato);
	}
	
	
	public void Crescita(byte valore)
	{
		int a=0;
	}
	
public Giocatore SearchBestPlayer(Giocatore array[],int k){
		
		Difensore tmp = this; //oggetto chiamante è un portiere
		int sommatmp = 0;
		sommatmp= this.getValoreGenerale();
	//	boolean trovato = false;
		
		for(int i=k+1; i<array.length/* && trovato !=true*/;i++){
			if(array[i] instanceof Difensore ){
				int somma = ((Difensore)array[i]).getValoreGenerale();
				if((sommatmp<somma) && (this.getCondizione()<array[i].getCondizione())) {
					tmp = (Difensore)array[i];
				//	trovato = true;
				}
			}
		}
		return tmp;
		
	}


public int getDotiRuolo(){
	return (getContrasti()+getColpoDiTesta()+getPassaggio()+getAbilitàDifesa());
}
	
}
//////////////*/*/*///////////******************
class Attaccante extends AltriRuoli
{
	public Attaccante(String nome,String cognome,String nazionalità,String squadra,byte velocità,byte resistenza,byte forza,byte morale,byte età,byte condizione,byte tecnica,byte aggressività,byte creatività,byte decisione,byte carisma,byte posizione,byte giocoDiSquadra,boolean essenziale,double mediaVoti,byte cross,byte dribling,byte colpoDiTesta,byte passaggio,byte tiro,byte contrasti,byte movimento,byte abilitàDifesa,byte abilitàAttacco,byte abilitàCentrocampo,byte valoreGenerale,double valoreMercato)
	{
		super(nome,cognome,nazionalità,squadra,velocità,resistenza,forza,morale,età,condizione,tecnica,aggressività,creatività,decisione,carisma,posizione,giocoDiSquadra,essenziale,mediaVoti,cross,dribling,colpoDiTesta,passaggio,tiro,contrasti,movimento,abilitàDifesa,abilitàAttacco,abilitàCentrocampo,valoreGenerale,valoreMercato);
	}
	
	public void Crescita(byte valore)
	{
		int a=0;
	}
	
public Giocatore SearchBestPlayer(Giocatore array[],int k){
		
		Attaccante tmp = this; //oggetto chiamante è un portiere
		int sommatmp = 0;
		sommatmp= this.getValoreGenerale();
	//	boolean trovato = false;
		
		for(int i=k+1; i<array.length /*&& trovato !=true*/;i++){
			if(array[i] instanceof Attaccante ){
				int somma = ((Attaccante)array[i]).getValoreGenerale();
				if((sommatmp<somma) && (this.getCondizione()<array[i].getCondizione())) {
					tmp = (Attaccante)array[i];
				//	trovato = true;
				}
			}
		}
		return tmp;
		
	}

public int getDotiRuolo(){
	return (getDribling()+getColpoDiTesta()+getTiro()+getAbilitàAttacco());
}
	
}
///////////////////////************************/*/*/*///////////////
class Centrocampista extends AltriRuoli
{
	public Centrocampista(String nome,String cognome,String nazionalità,String squadra,byte velocità,byte resistenza,byte forza,byte morale,byte età,byte condizione,byte tecnica,byte aggressività,byte creatività,byte decisione,byte carisma,byte posizione,byte giocoDiSquadra,boolean essenziale,double mediaVoti,byte cross,byte dribling,byte colpoDiTesta,byte passaggio,byte tiro,byte contrasti,byte movimento,byte abilitàDifesa,byte abilitàAttacco,byte abilitàCentrocampo,byte valoreGenerale,double valoreMercato)
	{
		super(nome,cognome,nazionalità,squadra,velocità,resistenza,forza,morale,età,condizione,tecnica,aggressività,creatività,decisione,carisma,posizione,giocoDiSquadra,essenziale,mediaVoti,cross,dribling,colpoDiTesta,passaggio,tiro,contrasti,movimento,abilitàDifesa,abilitàAttacco,abilitàCentrocampo,valoreGenerale,valoreMercato);
	}
	
	public void Crescita(byte valore)
	{
		int a=0;
	}
	
public Giocatore SearchBestPlayer(Giocatore array[],int k){
		
		Centrocampista tmp = this; //oggetto chiamante è un portiere
		int sommatmp = 0;
		sommatmp= this.getValoreGenerale();
		//boolean trovato = false;
		
		for(int i=k+1; i<array.length /*&& trovato !=true*/;i++){
			if(array[i] instanceof Centrocampista ){
				int somma = ((Centrocampista)array[i]).getValoreGenerale();
				if((sommatmp<somma) && (this.getCondizione()<array[i].getCondizione())) {
					tmp = (Centrocampista)array[i];
				//	trovato = true;
				}
			}
		}
		return tmp;
		
	}

public int getDotiRuolo(){
	return (getPassaggio()+getCross()+getMovimento()+getAbilitàCentrocampo());
}
	
}
	