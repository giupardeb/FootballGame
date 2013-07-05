package Project;

import java.util.ArrayList;
import java.util.Random;


abstract class User {
	private Squadra squadra;
	private Giocatore[] giocatori;
	
	protected static final int TIRA = 1;
	protected static final int PASSAGGIO = 2;
	protected static final int ABILITÀMINATTACCO = 70;
	protected static final int PARATA = 9;
	protected static final int FUORI = 10;
	protected static final int GOAL = 7;

	
	public User(Squadra squadra, Giocatore[] giocatori){
		this.squadra = squadra;
		this.giocatori = giocatori;
	}
	
	
	protected Squadra getSquadra(){
		return squadra;
	}
	
	public Giocatore [] getGiocatori(){
		return giocatori;
	}
	
	protected static Giocatore Search(int x, int y,Giocatore array[]){
		for (int i=0; i<array.length;i++)
			if(((Giocatore)array[i]).getPosizione().getX() == x && ((Giocatore)array[i]).getPosizione().getY() == y)
				return array[i];
		return null;
	}
	
	protected Giocatore SearchGiocatoreACaso(Giocatore array[], String ruolo){
		ArrayList <Giocatore> tmp = new ArrayList <Giocatore>();
		for(int i=0; i<array.length;i++) if(array[i].getRuolo().equalsIgnoreCase(ruolo)) tmp.add(array[i]);

		Random rand = new Random();
		int casuale = rand.nextInt(tmp.size());


		return tmp.get(casuale);
	}
	
	public boolean SearchGiocatore(String cognome){
		for(int i=0; i<getGiocatori().length;i++)
			if(this.getGiocatori()[i].GetAnagrafe().GetCognome().equalsIgnoreCase(cognome)) return true;
		return false;
	}
	
}
