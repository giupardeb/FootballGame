import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class SquadraUmano extends Squadra{
	private final static int RandomNumber = 5;
	private final static int MIN_GIOCATORY_PER_MERCATO = 15;
	private final static int INITIALISE = -1;

	public SquadraUmano(ArrayList<Giocatore> vett, String nome) {
		super(vett, nome);
	}

	///////////////////////////////////////////////////****************INIZIO SCAMBIO***********************//////////////////////////////////////

	public void scambio (String Cognomes, String Cognomes1, SquadraAvversaria s1){ //Cognomes viene scambiato con Cognomes1 dalla squadra s1
		int i = Search(Cognomes);
		int j = Search(Cognomes1);

		if(i!=INITIALISE && j!=INITIALISE)
			TrasferimentoPerScambio(db.GetDb()[i].getClass(),i,j,s1);
	}
	///////////////////////////////////////////////////****************FINE SCAMBIO***********************///////////////////////////////////////

	///////////////////////////////////////////////////****************INIZIO METODI SCAMBIO***********************//////////////////////////
	private void TrasferimentoPerScambio(Class<? extends Giocatore>clazz, int i, int j, SquadraAvversaria s1){
		if(clazz.cast(db.GetDb()[i]).getDotiRuolo()>clazz.cast(db.GetDb()[j]).getDotiRuolo()){
			if((int)(Math.random()*RandomNumber)+1<3){
				this.GetSquadra().add(db.GetDb()[i]);
				s1.GetSquadra().add(db.GetDb()[j]);
				db.GetDb()[i].setNomeSquadra(this.GetNomeSquadra());
				db.GetDb()[j].setNomeSquadra(s1.GetNomeSquadra());
				this.GetSquadra().remove(db.GetDb()[j]);
				s1.GetSquadra().remove(db.GetDb()[i]);	
				System.out.println("Scambio effettuato con successo!");
			}
			else System.out.println("Il giocatore ha rifiutato l'offerta");
		}
		else System.out.println("La squadra ha rifiutato l'offerta");
	}

	///////////////////////////////////////////////////****************FINE METODI SCAMBIO***********************//////////////////////////	

	///////////////////////////////////////////////////****************INIZIO ACQUISTA***********************///////////////////////////////////
	public void acquisto(String Cognome,SquadraAvversaria s1){ // miasquadra acquista Cognome da s1

		int i = Search(Cognome); 

		Scanner tastiera = new Scanner (System.in);
		if(i!=INITIALISE){

			if(this.GetBudget()>db.GetDb()[i].getValoreMercato()){
				float offerta = 0;
				System.out.print("inserisci offerta");

				offerta = tastiera.nextFloat(); //offerta immessa dall'utente
				if(offerta > db.GetDb()[i].getValoreMercato() ){
					if(db.GetDb()[i].getEssenziale() == false)
						TrasferimentoAcquista(this, s1, i,offerta);
					else{
						double denaroBastardo = ((db.GetDb()[i].getValoreMercato()*75)/100)+db.GetDb()[i].getValoreMercato(); //+ OPZIONI

						System.out.println("La squadra: " + db.GetDb()[i].getSquadra() + "non ha accettato l' offerta.");
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
					if(offerta>CalcPercent(db.GetDb()[i].getValoreMercato()))
						TrasferimentoAcquista(this, s1, i,offerta);
					else System.out.print("Hai fatto un offerta troppo bassa rispetto al prezzo di mercato del giocatore ");
				}
			}
			else System.out.print("Non hai il Budget sufficente per acquistare il giocatore!");
		}
		else System.out.println("Giocatore non esistente nella Squadra");
		tastiera.close();
	}
	///////////////////////////////////////////////////****************FINE ACQUISTA***********************///////////////////////////////////	

	///////////////////////////////////////////////////****************INIZIO METODI ACQUISTA***********************//////////////////////////	

	private double CalcPercent(double valoremercato){
		double sconto = 0;
		sconto = valoremercato * 20 /100;
		return valoremercato-sconto;
	}

	private void TrasferimentoAcquista(SquadraUmano squadra,SquadraAvversaria s1,int i,double denaro){
		if(((int)(Math.random()*10)+1)>4){

			squadra.SetBudgetRemove(denaro);
			db.GetDb()[i].setNomeSquadra(squadra.GetNomeSquadra());
			squadra.GetSquadra().add(db.GetDb()[i]);
			s1.SetBudgetAdd(denaro);
			s1.GetSquadra().remove(db.GetDb()[i]); 
			System.out.print("il giocatore ha accettato l'offerta!");
		}
		else System.out.print("il giocatore ha rifiutato l'offerta, preferisce non cambiare squadra");
	}
	///////////////////////////////////////////////////****************FINE METODI ACQUISTA***********************///////////////////////////	


	public Giocatore[] OrganizzaSquadra(){
		Giocatore array[] = new Giocatore [15];
		ArrayList <Giocatore> arrayusiliario = new ArrayList <Giocatore>();
		System.out.println("Organizza la tua squadra: ");



		for(Giocatore giocatore : this.GetSquadra()){
			System.out.println(giocatore.GetAnagrafe() + " "+ giocatore.getValoreGenerale() +" "+ giocatore.getRuolo());
			arrayusiliario.add(db.GetDb()[Search(giocatore.GetAnagrafe().GetCognome())]); //chiedere a simo se si può fare
		}

		if(arrayusiliario.size()<MIN_GIOCATORY_PER_MERCATO) System.out.println("non puoi organizzarti la squadra poichè hai meno di 15 giocatori," +
				" prova ad acquistare qualcuno"); //eventualmente metodo acquista
		else{
			for(int i = 0; i<MIN_GIOCATORY_PER_MERCATO; i++){
				String sceltagiocatore = (JOptionPane.showInputDialog("Inserisci il COGNOME del giocatore che vorresti far giocare: "));
				int z = Search(sceltagiocatore); 
				array[i] = db.GetDb()[z];

			}
		}

		return array;
	}

	private int Search(String Cognome){
		for(int i = 0; i<db.GetDb().length;i++){
			if(db.GetDb()[i].GetAnagrafe().GetCognome().equalsIgnoreCase(Cognome)){
				return i;
			}
		}
		return -1;
	}
}