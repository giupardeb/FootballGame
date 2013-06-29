package Project;
import java.util.*;

/**
 * @uml.dependency   supplier="Project.DatabaseGiocatori"
 */
abstract public class  Squadra {
	/**
	 * @uml.property  name="randomNumber"
	 */
	private final int RandomNumber = 10;
	/**
	 * @uml.property  name="randomNumber1"
	 */
	private final int RandomNumber1 = 2;
	protected final static int RandomNumber2 = 5;
	protected final static int MIN_GIOCATORY_PER_MERCATO = 15;
	protected final static int INITIALISE = -1;
	protected static final int MINCENTROCAMPISTI = 5;
	protected static final int MINPORTIERI = 2;
	protected static final int MINATTACCANTI = 5;
	protected static final int MINDIFENSORI = 5;

	static DatabaseGiocatori db = new DatabaseGiocatori();

	/**
	 * @uml.property  name="nome"
	 */
	String nome;
	/**
	 * @uml.property  name="budget"
	 */
	private float budget;
	/**
	 * @uml.property  name="miasquadra"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="Project.Giocatore"
	 */
	private ArrayList <Giocatore> miasquadra = new ArrayList<Giocatore>();
	/**
	 * @uml.property  name="vittorie"
	 */
	int vittorie;
	/**
	 * @uml.property  name="pareggi"
	 */
	int pareggi;
	/**
	 * @uml.property  name="sconfitte"
	 */
	int sconfitte;
	/**
	 * @uml.property  name="golfatti"
	 */
	int golfatti;
	/**
	 * @uml.property  name="golsubiti"
	 */
	int golsubiti;
	/**
	 * @uml.property  name="punti"
	 */
	int punti;

	/**
	 * @uml.property  name="totalepronostico"
	 */
	int totalepronostico; //serve per il pronostico, sara la somma dei gol fatti, subiti, vittorie sconfitte, pareggi + le abilita totali di difesa,attacco,centrocampo
	/**
	 * @uml.property  name="abilitaDifesa"
	 */
	int abilitaDifesa;
	/**
	 * @uml.property  name="abilitaCentrocampo"
	 */
	int abilitaCentrocampo; 
	/**
	 * @uml.property  name="abilitaAttacco"
	 */
	int abilitaAttacco; 

	//Costruttore di Squadra!!!
	public Squadra(ArrayList <Giocatore> vett, String nome){
		miasquadra.addAll(vett);//aggiunta con array dinamici
		this.nome = nome;
		totalepronostico = 0;


		int d = 0,c = 0,a = 0; //VARIABILI CONTATORI PER POI CREARE LE ABILITÀ RISPETTIVE
		double b = 0; // calcolare il budget
		for(Giocatore i : miasquadra){
			if(i instanceof Difensore) {
				abilitaDifesa += ((Difensore)i).getAbilitaDifesa();
				d++;
				b += ((Difensore)i).getValoreMercato();
			}
			else{
				if(i instanceof Portiere){
					abilitaDifesa += ((Portiere)i).getValoreGenerale();
					d++;
					b += ((Portiere)i).getValoreMercato();
				}
			}

			if(i instanceof Centrocampista){
				abilitaCentrocampo += ((Centrocampista)i).getAbilitaCentrocampo();
				c++;
				b+=((Centrocampista)i).getValoreMercato();
			}
			if(i instanceof Attaccante){
				abilitaAttacco += ((Attaccante)i).getAbilitaAttacco();
				a++;
				b += ((Attaccante)i).getValoreMercato();
			}
		}
		if(abilitaDifesa == 0) abilitaDifesa = 0;
		else abilitaDifesa /= d;

		if(abilitaCentrocampo == 0)	abilitaCentrocampo = 0;
		else abilitaCentrocampo /= c;

		if(abilitaAttacco == 0) abilitaAttacco = 0;
		else abilitaAttacco /= a;

		this.budget = (float) (b/ (d + c + a));

	}

	//serve per il pronostico, sara la somma dei gol fatti, subiti, vittorie sconfitte, pareggi + le abilita totali di difesa,attacco,centrocampo
	public void setTotalePronostico(){
		totalepronostico = (getVittorie()+ getPareggi()-getSconfitte()+getGolFatti()-getGolSubiti() + getAbilitaCentrocampo()+getAbilitaAttacco()+getAbilitaDifesa());
	}

	/**
	 * @return
	 * @uml.property  name="punti"
	 */
	public int getPunti(){
		return punti;
	}
	
	/**
	 * @return
	 * @uml.property  name="abilitaDifesa"
	 */
	public int getAbilitaDifesa() {
		return abilitaDifesa;
	}
	/**
	 * @return
	 * @uml.property  name="abilitaAttacco"
	 */
	public int getAbilitaAttacco() {
		return abilitaAttacco;
	}
	/**
	 * @return
	 * @uml.property  name="abilitaCentrocampo"
	 */
	public int getAbilitaCentrocampo() {
		return abilitaCentrocampo;
	}

	public int getGolSubiti() {
		return golsubiti;
	}

	public int getGolFatti() {
		return golfatti;
	}

	/**
	 * @return
	 * @uml.property  name="sconfitte"
	 */
	public int getSconfitte() {
		return sconfitte;
	}

	/**
	 * @return
	 * @uml.property  name="pareggi"
	 */
	public int getPareggi() {
		return pareggi;
	}


	/**
	 * @return
	 * @uml.property  name="vittorie"
	 */
	public int getVittorie() {
		return vittorie;
	}

	public void SetVittorie(){
		vittorie++;
	}

	public void SetSconfitte(){
		sconfitte++;
	}

	public void SetPareggi(int p){
		pareggi++;
	}


	public int getTotalePronostico(){
		return totalepronostico;
	}

	public String GetNomeSquadra(){
		return nome;
	}

	
	/**
	 * @param a
	 * @uml.property  name="punti"
	 */
	public void setPunti(int a){
		punti += a;
	}
	
	public void SetGolfatti(){
		golfatti++;
	}
	public void setGolSubiti(){
		golsubiti++;
	}

	protected int GetMinDif(){
		return MINDIFENSORI;
	}
	protected int GetMinAtt(){
		return MINATTACCANTI;
	}
	protected int GetMinCent(){
		return MINCENTROCAMPISTI;
	}
	protected int GetMinPor(){
		return MINPORTIERI;
	}

	//	abstract public void scambio(String Cognomes, String Cognomes1, Squadra s1);
	//	abstract public void acquisto(String Cognome,Squadra s1);
	abstract public Giocatore[] OrganizzaSquadra();
	//CREDO CHE CREARE IL METODO VENDITA SIA INUTILE... DATO CHE ABBIAMO ACQUISTI CHE IN UN CERTO SENSO GUARDANDOLA DAL 
	//PUNTO DI VISTA DELLA SQUADRAS1 È UNA VENDITA..

	///////////////////////////////////////////////****************************************/////////////////////////////////////////////

	public ArrayList<Giocatore> GetSquadra(){
		return miasquadra;
	}

	public int GetTotaleDifensori(){
		int d = 0;
		for(Giocatore i : GetSquadra()) if (i instanceof Difensore) d++;
		return d;
	}

	public int GetTotaleCentrocampisti(){
		int d = 0;
		for(Giocatore i : GetSquadra()) if (i instanceof Centrocampista) d++;
		return d;
	}
	public int GetTotalePortieri(){
		int d = 0;
		for(Giocatore i : GetSquadra()) if (i instanceof Portiere) d++;
		return d;
	}
	public int GetTotaleAttaccanti(){
		int d = 0;
		for(Giocatore i : GetSquadra()) if (i instanceof Attaccante) d++;
		return d;
	}

	public double GetBudget(){
		return budget;
	}

	public void SetBudgetAdd(double z){
		budget+=z;
	}
	public void SetBudgetRemove(double z){
		budget-=z;
	}


	public void Pronostico(Squadra a, SquadraAvversaria b){
		if(a.getTotalePronostico() == 0){
			if(b.getTotalePronostico() == 0){
				int rdm = (int)(Math.random()*RandomNumber);
				if(rdm <5) System.out.println("Il pronostico è a favore della squadra "+a.GetNomeSquadra());
				else System.out.println("Il pronostico è a favore della squadra "+b.GetNomeSquadra());
			}
			else {
				int fortuna = (int)(Math.random()*RandomNumber1);
				int rdm = (int)(Math.random()*RandomNumber)+fortuna;
				if(rdm <=3) System.out.println("Il pronostico è a favore della squadra "+a.GetNomeSquadra());
				else System.out.println("Il pronostico è a favore della squadra "+b.GetNomeSquadra());
			}
		}
		else if (b.getTotalePronostico() == 0){

			int fortuna = (int)(Math.random()*RandomNumber1);
			int rdm = (int)(Math.random()*RandomNumber)+fortuna;
			if(rdm <=3) System.out.println("Il pronostico è a favore della squadra "+b.GetNomeSquadra());
			else System.out.println("Il pronostico è a favore della squadra "+a.GetNomeSquadra());
		}
		else if(a.getTotalePronostico()<b.getTotalePronostico()){
			int fortuna = (int)(Math.random()*RandomNumber1);
			int rdm = (int)(Math.random()*RandomNumber)+fortuna;
			if(rdm <=3) System.out.println("Il pronostico è a favore della squadra "+b.GetNomeSquadra());
			else System.out.println("Il pronostico è a favore della squadra "+a.GetNomeSquadra());
		}
		else{
			int fortuna = (int)(Math.random()*RandomNumber1);
			int rdm = (int)(Math.random()*RandomNumber)+fortuna;
			if(rdm <=3) System.out.println("Il pronostico è a favore della squadra "+a.GetNomeSquadra());
			else System.out.println("Il pronostico è a favore della squadra "+b.GetNomeSquadra());
		}
	}
	
	public String toString(){
		return GetNomeSquadra();
	}
}