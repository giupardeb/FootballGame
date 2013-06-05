import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class SquadraUmano extends Squadra{

	public SquadraUmano(ArrayList<Giocatore> vett, String nome) {
		super(vett, nome);
		// TODO Auto-generated constructor stub
	}
	
public void scambio (String Cognomes, String Cognomes1, Squadra s1){ //Cognomes viene scambiato con Cognomes1 dalla squadra s1
		int i = Search(Cognomes);
		int j = Search(Cognomes1);
		
			    if(i!=-1 && j!=-1){
			    	
			    		if(db.giocatori[i] instanceof Difensore){
			    			if(((Difensore)db.giocatori[i]).getDotiRuolo()>((Difensore)db.giocatori[j]).getDotiRuolo()){
			    				if((int)(Math.random()*5)+1<3){
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
			    		else if(db.giocatori[i] instanceof Centrocampista){
			    			if(((Centrocampista)db.giocatori[i]).getDotiRuolo()>((Centrocampista)db.giocatori[j]).getDotiRuolo()){
			    				
			    				if((int)(Math.random()*5)+1<3){
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
			    		else if(db.giocatori[i] instanceof Attaccante){
			    			if(((Attaccante)db.giocatori[i]).getDotiRuolo()>((Attaccante)db.giocatori[j]).getDotiRuolo()){
			    				if((int)(Math.random()*5)+1<3){
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
			    }
	}



public void acquisto(String Cognome,Squadra s1){ // miasquadra acquista Cognome da s1
	
	int i = Search(Cognome); 
	
	Scanner tastiera = new Scanner (System.in);
	if(i!=-1){
		
		if(this.GetBudget()>db.giocatori[i].getValoreMercato()){
			float offerta = 0;
			System.out.print("inserisci offerta");
			
			offerta = tastiera.nextFloat(); //offerta immessa dall'utente
			if(offerta > db.giocatori[i].getValoreMercato() ){
				if(db.giocatori[i].getEssenziale() == false){
					
					if(((int)(Math.random()*10)+1)>4){
						
						this.SetBudgetRemove(db.giocatori[i].getValoreMercato());
						db.giocatori[i].setNomeSquadra(this.GetNomeSquadra());
						this.GetSquadra().add(db.giocatori[i]);

						s1.SetBudgetAdd(db.giocatori[i].getValoreMercato());
						s1.GetSquadra().remove(db.giocatori[i]); 
						System.out.print("il giocatore ha accettato l'offerta!");
					}
					else System.out.print("il giocatore ha rifiutato l'offerta");
				}
				else{
					double denaroBastardo=((db.giocatori[i].getValoreMercato()*75)/100)+db.giocatori[i].getValoreMercato();
					System.out.println("La squadra: " + db.giocatori[i].getSquadra() + "non ha accettato l' offerta.");
					System.out.println("Ma ti ha proposto una controfferta: " + denaroBastardo + " accettare? si /no ");
					
					String scelta = tastiera.nextLine();
					if(scelta.equalsIgnoreCase("si")){
						if(this.GetBudget()>denaroBastardo){
							
							this.SetBudgetRemove(denaroBastardo);
							//	s1.GetSquadra().get(i).setNomeSquadra(this.GetNomeSquadra());
								db.giocatori[i].setNomeSquadra(this.GetNomeSquadra());
								this.GetSquadra().add(db.giocatori[i]);

								s1.SetBudgetAdd(denaroBastardo);
								s1.GetSquadra().remove(db.giocatori[i]); 
								System.out.print("il giocatore ha accettato l'offerta!");
							
						}
						else System.out.print("Non hai il Budget sufficente per acquistare il giocatore!");
					}
					else System.out.print("Giocatore non Acquistato");
				}
			 }
			else {
				if(offerta>CalcPercent(offerta)){
					if((int)((Math.random()*10)+1)==9){
						
						this.SetBudgetRemove(db.giocatori[i].getValoreMercato());
					//	s1.GetSquadra().get(i).setNomeSquadra(this.GetNomeSquadra());
						db.giocatori[i].setNomeSquadra(this.GetNomeSquadra());
						this.GetSquadra().add(db.giocatori[i]);

						s1.SetBudgetAdd(db.giocatori[i].getValoreMercato());
						s1.GetSquadra().remove(db.giocatori[i]); 
						System.out.print("il giocatore ha accettato l'offerta!");
					}
					else System.out.print("il giocatore ha rifiutato l'offerta");
				}
				else System.out.print("Hai fatto un offerta minore del prezzo di mercato del giocatore ");
			}
		 }
		else System.out.print("Non hai il Budget sufficente per acquistare il giocatore!");
	}
	else System.out.println("Giocatore non esistente nella Squadra");
	tastiera.close();

}

private double CalcPercent(double offerta){
	double sconto = offerta * 70 /100;
	return offerta-sconto;
}

// Parlarne con simo!!!
public Giocatore[] OrganizzaSquadra(){
	Giocatore array[] = new Giocatore [15];
	ArrayList <Giocatore> arrayusiliario = new ArrayList <Giocatore>();
	System.out.println("Organizza la tua squadra: ");
	int j = 0;

	// NOTE - non usare i, ma giocatore.
	// i viene usato, generalmente, come contatore
	// qui invece i è il singolo giocatore
	for(Giocatore i : this.GetSquadra()){
		System.out.println(j+1 + ". " + i.GetAnagrafe()+i.getValoreGenerale()+i.getRuolo());
		arrayusiliario.add(db.giocatori[Search(i.GetAnagrafe().GetCognome())]); //chiedere a simo se si può fare
		j++;
	}
	

	// NOTE - invece di usare j, puoi semplicemente usare arrayusiliaro.size()
	// inoltre usa una costante invece di 14 ed è meglio usare 15 (ha più senso).
	// e scrivi: arrayusiliaro.size() < 15 (MIN_GIOCATORY_PER_MERCATO)
	if(j<14) System.out.println("non puoi organizzarti la squadra poichè hai meno di 15 giocatori, prova ad acquistare qualcuno"); //eventualmente metodo acquista
	else{
		// NOTE - perché 14 e non tutta la squadra?
		for(int i=0;i<14;i++){
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

}