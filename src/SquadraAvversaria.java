import java.util.ArrayList;
import static java.lang.System.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Random;


public class SquadraAvversaria extends Squadra{

    // NOTE - questi limiti non dovrebbero essere imposti anche alla squadra umana quando fa il mercato?
    // okay, vedo che tutti gli scambi sono fatti a caso e senza interazione dell'utente
	private static final int MINCENTROCAMPISTI = 4;
	private static final int MINPORTIERI = 2;
	private static final int MINATTACCANTI = 4;
	private static final int MINDIFENSORI = 4;
	//Queste costanti li dobbiamo modificare credo, poichè non si effettuerebbe il calciomercato dato
	//che tutte le squadre hanno il minimo di calciotori possibili


	public SquadraAvversaria(ArrayList<Giocatore> vett, String nome) {
		super(vett, nome);
		// TODO Auto-generated constructor stub
	}
	
	// PARLARNE CON SIMO
	public void scambio (SquadraAvversaria[] s1,SquadraUmano squadrautente){ 
		int i = SearchIndiceGiocatoreNomeSquadra(this.GetNomeSquadra()); //indice del giocatore che vorrei dal database
		int j = SearchIndiceGiocatoreMia(this.GetSquadra()); //indice giocatore che vorrei scambiare (è nella mia squadra)
    	int indicesquadraavversaria = SearchSquadra(s1,i);

		    // NOTE - Avevi indentato di 12 spazi, mentre è buon uso indentare sempre di 4 spazi alla volta (o 1 tab)
            // Il codice sotto non lo controllo ma ti faccio notare una cosa: c'è lo stesso codice 4-5 volte. 
            // usa un metodo e chiami il metodo.
            /*

                if(((RUOLO)db.giocatori[i]).getDotiRuolo()>((RUOLO)db.giocatori[j]).getDotiRuolo()){
                    if((int)(Math.random()*5)+1<3){
                        this.GetSquadra().add(db.giocatori[i]);
                        s1[indicesquadraavversaria].GetSquadra().add(db.giocatori[j]);
                        db.giocatori[i].setNomeSquadra(this.GetNomeSquadra());
                        db.giocatori[j].setNomeSquadra(s1[indicesquadraavversaria].GetNomeSquadra());

                        this.GetSquadra().remove(db.giocatori[j]);
                        s1[indicesquadraavversaria].GetSquadra().remove(db.giocatori[i]);   
                        System.out.println("Scambio effettuato con successo!");
                    }
                    else System.out.println("Il giocatore ha rifiutato l'offerta");
                }
                else System.out.println("La squadra ha rifiutato l'offerta");

                */	

                /* puoi mettere il codice su in un metodo del tipo
                    private void A (Class<? extends Giocatore> clazz, altri parametri) {
                          if((clazz.cast(db.giocatori[i])).getDotiRuolo()>(clazz.cast(db.giocatori[j])).getDotiRuolo()){
                            .....
                            }
                    }
                */
                /*

                Per capire un pò meglio questo esempio di polimorfismo ti metto di seguito del codice che ho appena scritto:

                public static void main(String[] args) {
                Gioc difensore = new Dif();
                Gioc difensore1 = new Dif();
                Gioc attaccante = new Attac();
                Gioc attaccante1 = new Attac();

                Gioc[] giocatori = new Gioc[4];
                giocatori[0] = difensore;
                giocatori[1] = difensore1;
                giocatori[2] = attaccante;
                giocatori[3] = attaccante1;

                testArrayGiocatori(giocatori);
            }

            public static void testArrayGiocatori(Gioc[] giocatori) {
                for(Gioc singleGiocatore:giocatori) {
                    C(singleGiocatore.getClass(), singleGiocatore);
                }
            }
            
            public static <T> void C(Class<? extends Gioc> clazz, Gioc singleGiocatore) {
                // cast
                singleGiocatore = clazz.cast(singleGiocatore);
                singleGiocatore.print();

            }

            Dove Gio, Dif e Attac sono delle semplici classi che contengono un metodo chiamato print e che stampa il nome della classe

            Quando si esegue il codice su il risultato è:
                Difensore
                Difensore
                Attaccante
                Attaccante
            
            Questo a dimostrazione che l'operazione di cast è avvenuta con successo.
            */
    		if(db.giocatori[i] instanceof Difensore){
    			if(((Difensore)db.giocatori[i]).getDotiRuolo()>((Difensore)db.giocatori[j]).getDotiRuolo()){
    				if((int)(Math.random()*5)+1<3){
    					this.GetSquadra().add(db.giocatori[i]);
    					s1[indicesquadraavversaria].GetSquadra().add(db.giocatori[j]);
    					db.giocatori[i].setNomeSquadra(this.GetNomeSquadra());
    					db.giocatori[j].setNomeSquadra(s1[indicesquadraavversaria].GetNomeSquadra());

    			    	this.GetSquadra().remove(db.giocatori[j]);
    			    	s1[indicesquadraavversaria].GetSquadra().remove(db.giocatori[i]);	
    			    	System.out.println("Scambio effettuato con successo!");
    				}
    				else System.out.println("Il giocatore ha rifiutato l'offerta");
    			}
    			else System.out.println("La squadra ha rifiutato l'offerta");
    		}
    		else if(db.giocatori[i] instanceof Centrocampista){
    			if(((Centrocampista)db.giocatori[i]).getDotiRuolo()>((Difensore)db.giocatori[j]).getDotiRuolo()){
    				
    				if((int)(Math.random()*5)+1<3){
    					this.GetSquadra().add(db.giocatori[i]);
    					s1[indicesquadraavversaria].GetSquadra().add(db.giocatori[j]);
    					db.giocatori[i].setNomeSquadra(this.GetNomeSquadra());
    					db.giocatori[j].setNomeSquadra(s1[indicesquadraavversaria].GetNomeSquadra());

    			    	this.GetSquadra().remove(db.giocatori[j]);
    			    	s1[indicesquadraavversaria].GetSquadra().remove(db.giocatori[i]);	
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
    					s1[indicesquadraavversaria].GetSquadra().add(db.giocatori[j]);
    					db.giocatori[i].setNomeSquadra(this.GetNomeSquadra());
    					db.giocatori[j].setNomeSquadra(s1[indicesquadraavversaria].GetNomeSquadra());

    			    	this.GetSquadra().remove(db.giocatori[j]);
    			    	s1[indicesquadraavversaria].GetSquadra().remove(db.giocatori[i]);	
    			    	System.out.println("Scambio effettuato con successo!");
    				}
    				else System.out.println("Il giocatore ha rifiutato l'offerta");
    			}
    			else System.out.println("La squadra ha rifiutato l'offerta");
    		}
    		else{
    			if(((Portiere)db.giocatori[i]).getDotiRuolo()>((Portiere)db.giocatori[j]).getDotiRuolo()){
    				if((int)(Math.random()*5)+1<3){
    					this.GetSquadra().add(db.giocatori[i]);
    					s1[indicesquadraavversaria].GetSquadra().add(db.giocatori[j]);
    					db.giocatori[i].setNomeSquadra(this.GetNomeSquadra());
    					db.giocatori[j].setNomeSquadra(s1[indicesquadraavversaria].GetNomeSquadra());

    			    	this.GetSquadra().remove(db.giocatori[j]);
    			    	s1[indicesquadraavversaria].GetSquadra().remove(db.giocatori[i]);	
    			    	System.out.println("Scambio effettuato con successo!");
    				}
    				else System.out.println("Il giocatore ha rifiutato l'offerta");
    			}
    			else System.out.println("La squadra ha rifiutato l'offerta");
    		}
	}
///////////////////////////////////////////////****************************************/////////////////////////////////////////////	
	

    // NOTE - lo stesso discorso di su. Hai tanto codice che è uguale tranne per poche cose. Riduci! 
	public void acquisto(SquadraAvversaria[] s1,SquadraUmano squadrautente){ 
		String ruolodaacquistare = "";
		if(GetTotaleDifensori()<MINDIFENSORI) ruolodaacquistare = "difensore";
		else if(GetTotaleCentrocampisti()<MINCENTROCAMPISTI) ruolodaacquistare = "centrcampista";
		else if(GetTotaleAttaccanti()<MINATTACCANTI) ruolodaacquistare = "attaccante";
		else if(GetTotalePortieri()<MINPORTIERI) ruolodaacquistare = "portiere";
		int i = -1;
		if(ruolodaacquistare != ""){
			 i = SearchIndiceGiocatore(ruolodaacquistare);
		 }
		else{
			 i = SearchIndiceGiocatore();
		}
		
		if (db.giocatori[i].getSquadra().equals(squadrautente.GetNomeSquadra())){
            int dialogResult = JOptionPane.YES_NO_OPTION;
   		    dialogResult = JOptionPane.showConfirmDialog (null,  this.GetNomeSquadra()+"vuole acquistare un tuo giocatore, "+
   		    											  db.giocatori[i].GetAnagrafe().GetCognome()+"con valore generale "+ 
   		    											  db.giocatori[i].getValoreGenerale()+" con il ruolo: " +db.giocatori[i].getRuolo()+ "vuoi contrattare? attenzione hai: "+squadrautente.GetTotaleAttaccanti()+" Attaccanti"+
   		    											  squadrautente.GetTotaleCentrocampisti()+" Centrocampisti"+squadrautente.GetTotaleDifensori()+" Difensori"+
   		    											  squadrautente.GetTotalePortieri()+" Portieri","Attenzione",dialogResult);
            if(dialogResult == JOptionPane.YES_OPTION){
            	
            	dialogResult = JOptionPane.showConfirmDialog (null,  this.GetNomeSquadra()+"ti propone "+ db.giocatori[i].getValoreMercato()+"€"+ "Accetti? ","Attenzione",dialogResult);
                if(dialogResult == JOptionPane.YES_OPTION){
                	this.SetBudgetRemove(db.giocatori[i].getValoreMercato());
					db.giocatori[i].setNomeSquadra(this.GetNomeSquadra());
					this.GetSquadra().add(db.giocatori[i]);
					squadrautente.SetBudgetAdd(db.giocatori[i].getValoreMercato());
					squadrautente.GetSquadra().remove(db.giocatori[i]); 
                }
                else{
                	double offerta = 0;
                	offerta = Offerta(db.giocatori[i]);
                	dialogResult = JOptionPane.showConfirmDialog (null,  this.GetNomeSquadra()+"ti propone "+ offerta+" €, per l'acquisto del giocatore, Accetti?","Attenzione",dialogResult);
                    if(dialogResult == JOptionPane.YES_OPTION){
                    	
                    	this.SetBudgetRemove(offerta);
    					db.giocatori[i].setNomeSquadra(this.GetNomeSquadra());
    					this.GetSquadra().add(db.giocatori[i]);
    					squadrautente.SetBudgetAdd(offerta);
    					squadrautente.GetSquadra().remove(db.giocatori[i]);
                    	
                    }
                    else{
                    	JFrame  frame = new JFrame("Show Message Dialog");
                    	JOptionPane.showMessageDialog(frame,"La trattativa non si è conclusa");
                    	int indicesquadraavversaria = SearchSquadra(s1,i);
                    	if(this.GetBudget()>db.giocatori[i].getValoreMercato()){
                    		if(db.giocatori[i] instanceof Difensore && s1[indicesquadraavversaria].GetTotaleDifensori()>MINDIFENSORI){
                        		if(((Math.random()*10)+1)>6){	
                            		this.SetBudgetRemove(db.giocatori[i].getValoreMercato());
                            		db.giocatori[i].setNomeSquadra(this.GetNomeSquadra());
                            		this.GetSquadra().add(db.giocatori[i]);
                            		s1[indicesquadraavversaria].SetBudgetAdd(db.giocatori[i].getValoreMercato());
                            		s1[indicesquadraavversaria].GetSquadra().remove(db.giocatori[i]);
                            	}                      				
                        	}
                    		else if(db.giocatori[i] instanceof Centrocampista && s1[indicesquadraavversaria].GetTotaleCentrocampisti()>MINCENTROCAMPISTI){
                    				if(((Math.random()*10)+1)>6){	
                    					this.SetBudgetRemove(db.giocatori[i].getValoreMercato());
                    					db.giocatori[i].setNomeSquadra(this.GetNomeSquadra());
                    					this.GetSquadra().add(db.giocatori[i]);
                    					s1[indicesquadraavversaria].SetBudgetAdd(db.giocatori[i].getValoreMercato());
                    					s1[indicesquadraavversaria].GetSquadra().remove(db.giocatori[i]);
                    				} 
                    		}
                    		else if(db.giocatori[i] instanceof Attaccante && s1[indicesquadraavversaria].GetTotaleAttaccanti()>MINATTACCANTI){
                				if(((Math.random()*10)+1)>6){	
                					this.SetBudgetRemove(db.giocatori[i].getValoreMercato());
                					db.giocatori[i].setNomeSquadra(this.GetNomeSquadra());
                					this.GetSquadra().add(db.giocatori[i]);
                					s1[indicesquadraavversaria].SetBudgetAdd(db.giocatori[i].getValoreMercato());
                					s1[indicesquadraavversaria].GetSquadra().remove(db.giocatori[i]);
                				}
                        }
                      else if(db.giocatori[i] instanceof Portiere && s1[indicesquadraavversaria].GetTotalePortieri()>MINPORTIERI){
            				if(((Math.random()*10)+1)>6){	
            					this.SetBudgetRemove(db.giocatori[i].getValoreMercato());
            					db.giocatori[i].setNomeSquadra(this.GetNomeSquadra());
            					this.GetSquadra().add(db.giocatori[i]);
            					s1[indicesquadraavversaria].SetBudgetAdd(db.giocatori[i].getValoreMercato());
            					s1[indicesquadraavversaria].GetSquadra().remove(db.giocatori[i]);
            				}
                    }
                }
            }
                }
            }
           else{
        	   int indicesquadraavversaria = SearchSquadra(s1,i);
           	if(this.GetBudget()>db.giocatori[i].getValoreMercato()){
           		if(db.giocatori[i] instanceof Difensore && s1[indicesquadraavversaria].GetTotaleDifensori()>MINDIFENSORI){
               		if(((Math.random()*10)+1)>6){	
                   		this.SetBudgetRemove(db.giocatori[i].getValoreMercato());
                   		db.giocatori[i].setNomeSquadra(this.GetNomeSquadra());
                   		this.GetSquadra().add(db.giocatori[i]);
                   		s1[indicesquadraavversaria].SetBudgetAdd(db.giocatori[i].getValoreMercato());
                   		s1[indicesquadraavversaria].GetSquadra().remove(db.giocatori[i]);
                   	}                      				
               	}
           		else if(db.giocatori[i] instanceof Centrocampista && s1[indicesquadraavversaria].GetTotaleCentrocampisti()>MINCENTROCAMPISTI){
           				if(((Math.random()*10)+1)>6){	
           					this.SetBudgetRemove(db.giocatori[i].getValoreMercato());
           					db.giocatori[i].setNomeSquadra(this.GetNomeSquadra());
           					this.GetSquadra().add(db.giocatori[i]);
           					s1[indicesquadraavversaria].SetBudgetAdd(db.giocatori[i].getValoreMercato());
           					s1[indicesquadraavversaria].GetSquadra().remove(db.giocatori[i]);
           				} 
           		}
           		else if(db.giocatori[i] instanceof Attaccante && s1[indicesquadraavversaria].GetTotaleAttaccanti()>MINATTACCANTI){
       				if(((Math.random()*10)+1)>6){	
       					this.SetBudgetRemove(db.giocatori[i].getValoreMercato());
       					db.giocatori[i].setNomeSquadra(this.GetNomeSquadra());
       					this.GetSquadra().add(db.giocatori[i]);
       					s1[indicesquadraavversaria].SetBudgetAdd(db.giocatori[i].getValoreMercato());
       					s1[indicesquadraavversaria].GetSquadra().remove(db.giocatori[i]);
       				}
               }
             else if(db.giocatori[i] instanceof Portiere && s1[indicesquadraavversaria].GetTotalePortieri()>MINPORTIERI){
   				if(((Math.random()*10)+1)>6){	
   					this.SetBudgetRemove(db.giocatori[i].getValoreMercato());
   					db.giocatori[i].setNomeSquadra(this.GetNomeSquadra());
   					this.GetSquadra().add(db.giocatori[i]);
   					s1[indicesquadraavversaria].SetBudgetAdd(db.giocatori[i].getValoreMercato());
   					s1[indicesquadraavversaria].GetSquadra().remove(db.giocatori[i]);
   				}
           }
           }
           }		
		}
		else{
			int indicesquadraavversaria = SearchSquadra(s1,i);
        	if(this.GetBudget()>db.giocatori[i].getValoreMercato()){
        		if(db.giocatori[i] instanceof Difensore && s1[indicesquadraavversaria].GetTotaleDifensori()>MINDIFENSORI){
            		if(((Math.random()*10)+1)>6){	
                		this.SetBudgetRemove(db.giocatori[i].getValoreMercato());
                		db.giocatori[i].setNomeSquadra(this.GetNomeSquadra());
                		this.GetSquadra().add(db.giocatori[i]);
                		s1[indicesquadraavversaria].SetBudgetAdd(db.giocatori[i].getValoreMercato());
                		s1[indicesquadraavversaria].GetSquadra().remove(db.giocatori[i]);
                	}                      				
            	}
        		else if(db.giocatori[i] instanceof Centrocampista && s1[indicesquadraavversaria].GetTotaleCentrocampisti()>MINCENTROCAMPISTI){
        				if(((Math.random()*10)+1)>6){	
        					this.SetBudgetRemove(db.giocatori[i].getValoreMercato());
        					db.giocatori[i].setNomeSquadra(this.GetNomeSquadra());
        					this.GetSquadra().add(db.giocatori[i]);
        					s1[indicesquadraavversaria].SetBudgetAdd(db.giocatori[i].getValoreMercato());
        					s1[indicesquadraavversaria].GetSquadra().remove(db.giocatori[i]);
        				} 
        		}
        		else if(db.giocatori[i] instanceof Attaccante && s1[indicesquadraavversaria].GetTotaleAttaccanti()>MINATTACCANTI){
    				if(((Math.random()*10)+1)>6){	
    					this.SetBudgetRemove(db.giocatori[i].getValoreMercato());
    					db.giocatori[i].setNomeSquadra(this.GetNomeSquadra());
    					this.GetSquadra().add(db.giocatori[i]);
    					s1[indicesquadraavversaria].SetBudgetAdd(db.giocatori[i].getValoreMercato());
    					s1[indicesquadraavversaria].GetSquadra().remove(db.giocatori[i]);
    				}
            }
          else if(db.giocatori[i] instanceof Portiere && s1[indicesquadraavversaria].GetTotalePortieri()>MINPORTIERI){
				if(((Math.random()*10)+1)>6){	
					this.SetBudgetRemove(db.giocatori[i].getValoreMercato());
					db.giocatori[i].setNomeSquadra(this.GetNomeSquadra());
					this.GetSquadra().add(db.giocatori[i]);
					s1[indicesquadraavversaria].SetBudgetAdd(db.giocatori[i].getValoreMercato());
					s1[indicesquadraavversaria].GetSquadra().remove(db.giocatori[i]);
				}
        }
		}
		}
}
	
	private double Offerta(Giocatore g){
		double percent = 0;
		if(g.getValoreGenerale()>0 && g.getValoreGenerale()<30){
			 percent = g.getValoreMercato()*20/100;
		}
		else{
			if(g.getValoreGenerale()>=30 && g.getValoreGenerale()<60){
				 percent = g.getValoreMercato()*40/100;
			}
			else{
				if(g.getValoreGenerale()>=60 && g.getValoreGenerale()<90){
					 percent = g.getValoreMercato()*50/100;  // NOTE - costanti !!!!

				}
				else  percent = g.getValoreMercato()*60/100;
			}
		}
		return percent;
	}
	

	//PARLARE CON SIMONE
	// NOTE - qui non so che cosa devo controllare. Al solito, usa le costanti!!!!
	public Giocatore[] OrganizzaSquadra(){
		Giocatore array[] = new Giocatore [15];
		int j = 0;
		int indicegiocatoremigliore = -1;
		boolean portiere = false;
		boolean attaccante = false;
		boolean difensore = false;
		boolean centrocampista = false;
		
		for(Giocatore i : this.GetSquadra()) j++; //conta i giocatori
		
		int arrayausiliario [] = new int[j]; //conterrà gli indici del database dei giocatori della squadra
		int z = 0;
		for(Giocatore i : this.GetSquadra()) {
			arrayausiliario[z] = SearchIndiceGiocatoreCognome(i.GetAnagrafe().GetCognome()); //dire a gianmaroc se nel database ci sono omonimi
			z++;
		}
		
		for( z = 0; z<arrayausiliario.length;z++){
			if(db.giocatori[arrayausiliario[z]] instanceof Portiere && portiere == false){
				indicegiocatoremigliore = SearchBestPlayer(arrayausiliario,"Portiere");
				portiere = true;
			}
			else{
				if(db.giocatori[arrayausiliario[z]] instanceof Difensore && difensore == false){
					indicegiocatoremigliore = SearchBestPlayer(arrayausiliario,"Difensore");
					difensore = true;
				}
				else{
					if(db.giocatori[arrayausiliario[z]] instanceof Centrocampista && centrocampista == false){
						indicegiocatoremigliore = SearchBestPlayer(arrayausiliario,"Centrocampista");
						portiere = true;
					 }
					else{
						if(db.giocatori[arrayausiliario[z]] instanceof Attaccante && attaccante == false){
							indicegiocatoremigliore = SearchBestPlayer(arrayausiliario,"Attaccante");
							attaccante = true;
						}
						
					}
				}
			}
			array[z] = db.giocatori[indicegiocatoremigliore]; // OCCCHIO CHE POTREBBE GENERARTI UNA ECEZZIONE
		}
		return array;
	}
	//PARLARE CON SIMONE
private int SearchBestPlayer(int array[],String ruolo){
		//array vettore degli indici che si riferiscono al database
	int migliore = -1; //indice del migliore nel database
	
	int j = 0;
	for(int i = 0; i<array.length; i++){
		if(db.giocatori[array[i]].getRuolo().equalsIgnoreCase(ruolo)){
			j++;
		}
	}
	int vett [] = new int [j];
	int z = 0;
	for(int i = 0; i<array.length; i++){
		if(db.giocatori[array[i]].getRuolo() == ruolo){
			vett[z] = i;
		}
	}
	
	for(int i = 0; i<vett.length-1;i++){
		if(db.giocatori[vett[i]].getValoreGenerale() > db.giocatori[vett[i+1]].getValoreGenerale()
				&& db.giocatori[vett[i]].getCondizione() > db.giocatori[vett[i+1]].getCondizione()){
			migliore = i;
		}
		else migliore = i+1;
	}
	return migliore;
	
		
}
	
	
private int SearchIndiceGiocatore(String ruolo){
	ArrayList <Giocatore> tmp = new ArrayList <Giocatore>();
	for(int i = 0; i<db.giocatori.length;i++){
		if(ruolo.equalsIgnoreCase("Difensore") && db.giocatori[i] instanceof Difensore){
				tmp.add((Difensore)db.giocatori[i]);
		}
		else if(ruolo.equalsIgnoreCase("Centrocampista") && db.giocatori[i] instanceof Centrocampista){
			tmp.add((Centrocampista)db.giocatori[i]);
		}
		else if(ruolo.equalsIgnoreCase("Attaccante") && db.giocatori[i] instanceof Attaccante){
			tmp.add((Attaccante)db.giocatori[i]);
		}
		else if(ruolo.equalsIgnoreCase("Portiere") && db.giocatori[i] instanceof Portiere){
			tmp.add((Portiere)db.giocatori[i]);
		}
	}
	Random rand = new Random();
	int casuale = rand.nextInt(tmp.toArray().length);
	for(int i = 0; i<db.giocatori.length ;i++){
		Giocatore g = (Giocatore) tmp.toArray()[casuale];
		if(db.giocatori[i].GetAnagrafe().GetCognome().equals(g.GetAnagrafe().GetCognome())) return i;
	}
	return -1;
}

private int SearchIndiceGiocatore(){
	Random rand = new Random();
	int casuale = rand.nextInt(db.giocatori.length);
	return casuale;
}

private int SearchIndiceGiocatoreMia (ArrayList <Giocatore> array){ //serve per lo scambio per cercare il giocatore che voglio scambiare.
	Random rand = new Random();
	int casuale = rand.nextInt(array.toArray().length);
	
	return casuale;
}
private int SearchIndiceGiocatoreCognome (String Cognome){ 
	for(int i = 0; i<db.giocatori.length; i++){
		if(db.giocatori[i].GetAnagrafe().GetCognome().equalsIgnoreCase(Cognome)) return i;
	}
	return -1;
}


private int SearchSquadra(SquadraAvversaria[] s, int i){
	for(int j = 0; j<s.length; j++){
		if(db.giocatori[i].getSquadra().equalsIgnoreCase(s[j].GetNomeSquadra())) return j;
	}
 return -1;
	}
//CON SIMO
private int SearchIndiceGiocatoreNomeSquadra(String squadra){
	Random rand = new Random();
	int casuale = rand.nextInt(db.giocatori.length);
	if(db.giocatori[casuale].getSquadra().equalsIgnoreCase(squadra)){
		casuale = rand.nextInt(db.giocatori.length);
	}
	
	return casuale;
	
}

public int GetMinDif(){
	return MINDIFENSORI;
}
public int GetMinAtt(){
	return MINATTACCANTI;
}
public int GetMinCent(){
	return MINCENTROCAMPISTI;
}
public int GetMinPor(){
	return MINPORTIERI;
}


	
}
