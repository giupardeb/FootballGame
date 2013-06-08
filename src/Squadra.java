import java.util.*;




abstract public class  Squadra{
	private final int RandomNumber = 10;
	private final int RandomNumber1 = 2;

	static DatabaseGiocatori db = new DatabaseGiocatori();
	String nome;
	private double budget;
	private ArrayList <Giocatore> miasquadra = new ArrayList<Giocatore>();
	int vittorie;
	int pareggi;
	int sconfitte;
	int golfatti;
	int golsubiti;
	int punti;

	int totalepronostico; //serve per il pronostico, sara la somma dei gol fatti, subiti, vittorie sconfitte, pareggi + le abilita totali di difesa,attacco,centrocampo
	int abilitaDifesa; //serve per il pronostico
	int abilitaCentrocampo; //serve per il pronostico
	int abilitaAttacco; //serve per il pronostico

	//Costruttore di Squadra!!!
	public Squadra(ArrayList <Giocatore> vett, String nome){
		miasquadra = vett;//aggiunta con array dinamici
		this.nome = nome;
		totalepronostico = 0;


		/*non faccio altro che mettere nelle variabili abilita,  tutte le abilita specifiche di ogni giocatore alla fine le variabili abilita
		 * avranno la somma di tutte le abilita dei giocatori (difensori attaccanti centrocampisi)
		 * ciò è utile per il pronostico*/
		int d=0,c=0,a=0; 
		double b=0; // calcolare il budget
		for(Giocatore i : miasquadra){
			if(i instanceof Difensore) {
				abilitaDifesa += ((Difensore)i).getAbilitaDifesa();
				d++;
				b+=((Difensore)i).getValoreMercato();
			}
			else{
				if(i instanceof Portiere){
					abilitaDifesa += ((Portiere)i).getValoreGenerale();
					d++;
					b+=((Portiere)i).getValoreMercato();
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
				b+=((Attaccante)i).getValoreMercato();
			}
		}
		abilitaDifesa/=d;
		abilitaCentrocampo/=c;
		abilitaAttacco/=a;
		this.budget = b + (double)(Math.random()*1000)+1;

	}

	//serve per il pronostico, sara la somma dei gol fatti, subiti, vittorie sconfitte, pareggi + le abilita totali di difesa,attacco,centrocampo
	public void setTotalePronostico(){
		totalepronostico = (getVittorie()+ getPareggi()-getSconfitte()+getGolFatti()-getGolSubiti() + getAbilitaCentrocampo()+getAbilitaAttacco()+getAbilitaDifesa());
	}

	public int getAbilitaDifesa() {
		return abilitaDifesa;
	}
	public int getAbilitaAttacco() {
		return abilitaAttacco;
	}
	public int getAbilitaCentrocampo() {
		return abilitaCentrocampo;
	}

	public int getGolSubiti() {
		return golsubiti;
	}

	public int getGolFatti() {
		return golfatti;
	}

	public int getSconfitte() {
		return sconfitte;
	}

	public int getPareggi() {
		return pareggi;
	}


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
	//FINE MODIFICA
	public String GetNomeSquadra(){
		return nome;
	}

	public void SetGolfatti(){
		golfatti++;
	}
	public void setGolSubiti(){
		golsubiti++;
	}

	//	abstract public void scambio(String Cognomes, String Cognomes1, Squadra s1);
	//	abstract public void acquisto(String Cognome,Squadra s1);
	abstract public Giocatore[] OrganizzaSquadra();
	//CREDO CHE CREARE IL METODO VENDITA SIA INUTILE... DATO CHE ABBIAMO ACQUISTI CHE IN UN CERTO SENSO GUARDANDOLA DAL 
	//PUNTO DI VISTA DELLA SQUADRAS1 È UNA VENDITA..

	///////////////////////////////////////////////****************************************/////////////////////////////////////////////	

	public void trasferimento(Class<? extends Squadra> clazz){

	}
	
	
	///////////////////////////////////////////////////************************************/////////////////////////////////////


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

	public double SetBudgetAdd(double z){
		return budget+z;
	}
	public double SetBudgetRemove(double z){
		return budget-z;
	}

	//MODIFICTO  14 MAGGIO ORE 18:00

	//////////////////che ve ne pare!!?!?!!?
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

}