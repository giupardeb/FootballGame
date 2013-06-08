import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class SquadraUmano extends Squadra{
	private final static int RandomNumber = 5;
	private final static int MIN_GIOCATORY_PER_MERCATO = 15;
	private final static int INITIALISE = -1;

	public SquadraUmano(ArrayList<Giocatore> vett, String nome) {
		super(vett, nome);
		// TODO Auto-generated constructor stub
	}


	public void scambio (String Cognomes, String Cognomes1, SquadraAvversaria s1){ //Cognomes viene scambiato con Cognomes1 dalla squadra s1
		int i = Search(Cognomes);
		int j = Search(Cognomes1);

		if(i!=INITIALISE && j!=INITIALISE)
			TrasferimentoPerScambio(db.giocatori[i].getClass(),i,j,s1);
	}



	public void acquisto(String Cognome,SquadraAvversaria s1){ // miasquadra acquista Cognome da s1

		int i = Search(Cognome); 

		Scanner tastiera = new Scanner (System.in);
		if(i!=INITIALISE){

			if(this.GetBudget()>db.giocatori[i].getValoreMercato()){
				float offerta = 0;
				System.out.print("inserisci offerta");

				offerta = tastiera.nextFloat(); //offerta immessa dall'utente
				if(offerta > db.giocatori[i].getValoreMercato() ){
					if(db.giocatori[i].getEssenziale() == false)
						TrasferimentoAcquista(this, s1, i,offerta);
					else{
						double denaroBastardo=((db.giocatori[i].getValoreMercato()*75)/100)+db.giocatori[i].getValoreMercato(); //mettere più opzioni in base al valore del giocatore
						System.out.println("La squadra: " + db.giocatori[i].getSquadra() + "non ha accettato l' offerta.");
						System.out.println("Ma ti ha proposto una controfferta: " + denaroBastardo + " accettare? si /no ");

						String scelta = tastiera.nextLine();
						if(scelta.equalsIgnoreCase("si"))
							if(this.GetBudget()>denaroBastardo)
								TrasferimentoAcquista(this, s1, i,denaroBastardo);
							else System.out.print("Non hai il Budget sufficente per acquistare il giocatore!");
						else System.out.print("Giocatore non Acquistato");
					}
				}
				else {
					if(offerta>CalcPercent(db.giocatori[i].getValoreMercato()))
						TrasferimentoAcquista(this, s1, i,offerta);
					else System.out.print("Hai fatto un offerta troppo bassa rispetto al prezzo di mercato del giocatore ");
				}
			}
			else System.out.print("Non hai il Budget sufficente per acquistare il giocatore!");
		}
		else System.out.println("Giocatore non esistente nella Squadra");
		tastiera.close();

	}

	private double CalcPercent(double valoremercato){
		double sconto = valoremercato * 20 /100;
		return valoremercato-sconto;
	}


	public Giocatore[] OrganizzaSquadra(){
		Giocatore array[] = new Giocatore [15];
		ArrayList <Giocatore> arrayusiliario = new ArrayList <Giocatore>();
		System.out.println("Organizza la tua squadra: ");



		for(Giocatore giocatore : this.GetSquadra()){
			System.out.println(giocatore.GetAnagrafe() + " "+ giocatore.getValoreGenerale() +" "+ giocatore.getRuolo());
			arrayusiliario.add(db.giocatori[Search(giocatore.GetAnagrafe().GetCognome())]); //chiedere a simo se si può fare
		}


		// NOTE - invece di usare j, puoi semplicemente usare arrayusiliaro.size()
		// inoltre usa una costante invece di 14 ed è meglio usare 15 (ha più senso).
		// e scrivi: arrayusiliaro.size() < 15 (MIN_GIOCATORY_PER_MERCATO)
		if(arrayusiliario.size()<MIN_GIOCATORY_PER_MERCATO) System.out.println("non puoi organizzarti la squadra poichè hai meno di 15 giocatori, prova ad acquistare qualcuno"); //eventualmente metodo acquista
		else{
			// NOTE - perché 14 e non tutta la squadra?
			for(int i=0;i<MIN_GIOCATORY_PER_MERCATO;i++){
				String sceltagiocatore = (JOptionPane.showInputDialog("Inserisci il COGNOME del giocatore che vorresti far giocare: ")); //input da finestra
				int z = Search(sceltagiocatore); 
				array[i] = db.giocatori[z];

			}
		}

		return array;
	}

	private int Search(String Cognome){
		for(int i = 0; i<db.giocatori.length;i++){
			if(db.giocatori[i].GetAnagrafe().GetCognome().equalsIgnoreCase(Cognome)){
				return i;
			}
		}
		return -1;
	}

	private void TrasferimentoPerScambio(Class<? extends Giocatore>clazz, int i, int j, SquadraAvversaria s1){
		if(clazz.cast(db.giocatori[i]).getDotiRuolo()>clazz.cast(db.giocatori[j]).getDotiRuolo()){
			if((int)(Math.random()*RandomNumber)+1<3){
				this.GetSquadra().add(db.giocatori[i]);
				s1.GetSquadra().add(db.giocatori[j]);
				db.giocatori[i].setNomeSquadra(this.GetNomeSquadra());
				db.giocatori[j].setNomeSquadra(s1.GetNomeSquadra());
				this.GetSquadra().remove(db.giocatori[j]);
				s1.GetSquadra().remove(db.giocatori[i]);	
				System.out.println("Scambio effettuato con successo!");
			}
			else System.out.println("Il giocatore ha rifiutato l'offerta");
		}
		else System.out.println("La squadra ha rifiutato l'offerta");
	}

	private void TrasferimentoAcquista(SquadraUmano squadra,SquadraAvversaria s1,int i,double denaro){
		if(((int)(Math.random()*10)+1)>4){

			squadra.SetBudgetRemove(denaro);
			db.giocatori[i].setNomeSquadra(squadra.GetNomeSquadra());
			squadra.GetSquadra().add(db.giocatori[i]);
			s1.SetBudgetAdd(denaro);
			s1.GetSquadra().remove(db.giocatori[i]); 
			System.out.print("il giocatore ha accettato l'offerta!");
		}
		else System.out.print("il giocatore ha rifiutato l'offerta, preferisce non cambiare squadra");
	}

}