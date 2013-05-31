import java.util.*;




abstract public class  Squadra{
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
	//FINE MODIFICA


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

	private int getAbilitaDifesa() {
		return abilitaDifesa;
	}
	private int getAbilitaAttacco() {
		return abilitaAttacco;
	}
	private int getAbilitaCentrocampo() {
		return abilitaCentrocampo;
	}

	//FINE MODIFICA

	private int getGolSubiti() {
		return golsubiti;
	}

	private int getGolFatti() {
		return golfatti;
	}

	private int getSconfitte() {
		return sconfitte;
	}

	private int getPareggi() {
		return pareggi;
	}

	private int getVittorie() {
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


	// XXX - Aggiunto da Simon
	public ArrayList <Giocatore> getGiocatori() {
		// TODO
		return null;
	}
	
	//MODIFICTO  14 MAGGIO ORE 18:00

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



	abstract public void scambio(String Cognomes, String Cognomes1, Squadra s1);
	abstract public void acquisto(String Cognome,Squadra s1);
	abstract public Giocatore[] OrganizzaSquadra();
	//CREDO CHE CREARE IL METODO VENDITA SIA INUTILE... DATO CHE ABBIAMO ACQUISTI CHE IN UN CERTO SENSO GUARDANDOLA DAL 
	//PUNTO DI VISTA DELLA SQUADRAS1 È UNA VENDITA..

	///////////////////////////////////////////////****************************************/////////////////////////////////////////////	



	protected Giocatore Search(Squadra s,String Cognome){
		for(Giocatore i : s.GetSquadra()){
			if(i.GetAnagrafe().GetCognome().equalsIgnoreCase(Cognome)){
				return i;
			}
		}
		return null;
	}

	///////////////////////////////////////////////////************************************/////////////////////////////////////


	public ArrayList<Giocatore> GetSquadra(){
		return miasquadra;
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
				int rdm = (int)(Math.random()*10);
				if(rdm <5) System.out.println("Il pronostico è a favore della squadra "+a.GetNomeSquadra());
				else System.out.println("Il pronostico è a favore della squadra "+b.GetNomeSquadra());
			}
			else {
				int fortuna = (int)(Math.random()*2);
				int rdm = (int)(Math.random()*10)+fortuna;
				if(rdm <=3) System.out.println("Il pronostico è a favore della squadra "+a.GetNomeSquadra());
				else System.out.println("Il pronostico è a favore della squadra "+b.GetNomeSquadra());
			}
		}
		else if (b.getTotalePronostico() == 0){

			int fortuna = (int)(Math.random()*2);
			int rdm = (int)(Math.random()*10)+fortuna;
			if(rdm <=3) System.out.println("Il pronostico è a favore della squadra "+b.GetNomeSquadra());
			else System.out.println("Il pronostico è a favore della squadra "+a.GetNomeSquadra());
		}
		else if(a.getTotalePronostico()<b.getTotalePronostico()){
			int fortuna = (int)(Math.random()*2);
			int rdm = (int)(Math.random()*10)+fortuna;
			if(rdm <=3) System.out.println("Il pronostico è a favore della squadra "+b.GetNomeSquadra());
			else System.out.println("Il pronostico è a favore della squadra "+a.GetNomeSquadra());
		}
		else{
			int fortuna = (int)(Math.random()*2);
			int rdm = (int)(Math.random()*10)+fortuna;
			if(rdm <=3) System.out.println("Il pronostico è a favore della squadra "+a.GetNomeSquadra());
			else System.out.println("Il pronostico è a favore della squadra "+b.GetNomeSquadra());
		}
	}
	//MODIFICTO  14 MAGGIO ORE 18:00

}