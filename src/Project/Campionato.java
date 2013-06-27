package Project;
import graphic.*;

import java.awt.Component;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Campionato 
{
	public SquadraUmano squadra;

	public SquadraAvversaria squadre[] = new SquadraAvversaria [19];

	public DatabaseGiocatori db;
	public Stack<SquadraAvversaria> Incontri = new Stack<SquadraAvversaria>(); //contiene le squadre con cui l'utente dovrà scontrarsi
	private String continua = ""; //utile per i cicli
	private boolean ferma = false;

	public Giocatore [] giocatoridavisualizzare = null;

	public Campionato(String miasquadra, JFrame j) //la squadra che l'utente sceglie viene decisa nel main.. tanto per fargli fare qualcosa dal main.. 
	{
		j.dispose();
		db = new DatabaseGiocatori();

		squadra = db.CreaSquadra(miasquadra);

		for(int i = 0; i<squadre.length; i++){
			squadre[i] = db.CreaSquadre(miasquadra);
			Incontri.push(squadre[i]);
			if(squadre[i] == null) i--;
		}

		RichiamaFinestraCampionato(db);
	}


	public int SearchSquadra(String nome){
		for(int i = 0; i<squadre.length;i++)
			if (squadre[i].GetNomeSquadra().equalsIgnoreCase(nome)) return i;
		return -1;

	}
	//per l'acquista
	public Giocatore [] VisualizzaGiocatori(String ruolo, String squadrautente){
		ArrayList <Giocatore> giocatoridavisualizzare = new ArrayList <Giocatore>();
		for(int z = 0; z<squadre.length;z++)
			for(Giocatore giocatore : squadre[z].GetSquadra())
				if(giocatore.getRuolo().equalsIgnoreCase(ruolo) && (!(giocatore.getSquadra().equalsIgnoreCase(squadrautente))))	
					giocatoridavisualizzare.add(giocatore);
		return giocatoridavisualizzare.toArray(new Giocatore [giocatoridavisualizzare.size()]);
	}

	//per lo scambio..
	public Giocatore [] VisualizzaGiocatori(String squadrautente){
		ArrayList <Giocatore> giocatoridavisualizzare = new ArrayList <Giocatore>();
		for(int z = 0; z<squadre.length;z++)
			for(Giocatore giocatore : squadre[z].GetSquadra())
				if(!(giocatore.getSquadra().equalsIgnoreCase(squadrautente)))
					giocatoridavisualizzare.add(giocatore);
		return giocatoridavisualizzare.toArray(new Giocatore [giocatoridavisualizzare.size()]);
	}

	public Giocatore [] VisualizzaGiocatoriMiei(){
		ArrayList <Giocatore> giocatoridavisualizzare = new ArrayList <Giocatore>();
		for(Giocatore giocatore : squadra.GetSquadra())
			giocatoridavisualizzare.add(giocatore);
		return giocatoridavisualizzare.toArray(new Giocatore [giocatoridavisualizzare.size()]);
	}

	public void Trasferimento(String [] giocatoresquadra){
		squadra.acquisto(giocatoresquadra[0].trim(), squadre[SearchSquadra(giocatoresquadra[1].trim())]);
		RichiamaFinestraCampionato(db);
	}

	public void TrasferimentoPerScambio(String [] Scelta){
		squadra.scambio(Scelta[0].trim(), Scelta[1].trim(), squadre[SearchSquadra(Scelta[2].trim())]);
		RichiamaFinestraCampionato(db);
	}

	public void Calciomercato(JFrame frame){
		frame.dispose();
		SceltaScambioAcquista Scelta = new SceltaScambioAcquista(this); 
	}

	public void RichiamaFinestraCampionato(DatabaseGiocatori db){
		FinestraCampionato fc = new FinestraCampionato(this,db);
	}


	public void partita(SquadraUmano umano, SquadraAvversaria computer,JPanel panel,Component arrayMio[], Component arrayAvv[]){
		
		if(Math.random()*10>5){
			Component a = Search(0,2,arrayMio);
			((Giocatore) a).setPalla(true);
			a.setVisible(true);
		}
		else{
			Component a = Search(7,2,arrayAvv);
			((Giocatore) a).setPalla(true);
			a.setVisible(true);
		}
		
		//continuare. . . . . 
		
	}
	
	public Component Search(int x, int y,Component array[]){
		for (int i=0; i<array.length;i++)
			if(((Giocatore)array[i]).getPosizione().getX() == x && ((Giocatore)array[i]).getPosizione().getY() == y)
				return array[i];
		return null;
	}
	
	public void CreaAssociazioniSquadre(){
		
	}
	
	public void setFerma(boolean a){
		ferma = a;
	}

}