import java.util.ArrayList;
import static java.lang.System.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Random;


public class SquadraAvversaria extends Squadra{
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
	
	
	
	public void scambio (SquadraAvversaria[] s1,SquadraUmano squadrautente){ 
		int i = SearchIndiceGiocatore(db.giocatori); //indice del giocatore che vorrei dal database
		int j = SearchIndiceGiocatoreMia(this.GetSquadra());//indice giocatore che vorrei scambiare (è nella mia squadra)
    	int indicesquadraavversaria = SearchSquadra(s1,i);

					    	
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
	
	public void acquisto(SquadraAvversaria[] s1,SquadraUmano squadrautente){ 
		String ruolodaacquistare = "";
		if(GetTotaleDifensori()<MINDIFENSORI) ruolodaacquistare = "difensore";
		else if(GetTotaleCentrocampisti()<MINCENTROCAMPISTI) ruolodaacquistare = "centrcampista";
		else if(GetTotaleAttaccanti()<MINATTACCANTI) ruolodaacquistare = "attaccante";
		else if(GetTotalePortieri()<MINPORTIERI) ruolodaacquistare = "portiere";
		int i = -1;
		if(ruolodaacquistare != ""){
			 i = SearchIndiceGiocatore(db.giocatori,ruolodaacquistare);
		 }
		else{
			 i = SearchIndiceGiocatore(db.giocatori);
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
					 percent = g.getValoreMercato()*50/100;

				}
				else  percent = g.getValoreMercato()*60/100;
			}
		}
		return percent;
	}
	

	
	
	public Giocatore[] OrganizzaSquadra(){
		Giocatore array[] = new Giocatore [15];
		int j=0;
		for(Giocatore i : this.GetSquadra()) j++;
		
		Giocatore arrayusiliario[] = new Giocatore [j];
		int f=0;
		for(Giocatore i : this.GetSquadra()){
			if(i instanceof Portiere){
				arrayusiliario[f] = new Portiere (i.GetAnagrafe().GetCognome(),i.GetAnagrafe().GetProvenienza(),i.getSquadra(),i.getVelocita(),i.getResistenza(),i.getForza(),i.getMorale(),i.GetAnagrafe().GetEta(),i.getCondizione(),i.getTecnica(),i.getAggressivita(),i.getCreativita(),i.getDecisione(),i.getCarisma(),i.getRuolo(),i.getGiocoDiSquadra(),i.getEssenziale(),i.getMediaVoti(),((Portiere) i).getDotiAeree(),((Portiere) i).getAgilita(),((Portiere) i).getComunicazione(),((Portiere) i).getBloccareTiri(),((Portiere) i).getCalciare(),((Portiere) i).getRiflessi(),((Portiere) i).getRimessa(),((Portiere) i).getValoreGenerale(),i.getValoreMercato());
			
			}
			else if(i instanceof Difensore){
				arrayusiliario[f] = new Difensore (i.GetAnagrafe().GetCognome(),i.GetAnagrafe().GetProvenienza(),i.getSquadra(),i.getVelocita(),i.getResistenza(),i.getForza(),i.getMorale(),i.GetAnagrafe().GetEta(),i.getCondizione(),i.getTecnica(),i.getAggressivita(),i.getCreativita(),i.getDecisione(),i.getCarisma(),i.getRuolo(),i.getGiocoDiSquadra(),i.getEssenziale(),i.getMediaVoti(),((Difensore) i).getCross(),((Difensore) i).getDribling(),((Difensore) i).getColpoDiTesta(),((Difensore) i).getPassaggio(),((Difensore) i).getTiro(),((Difensore) i).getContrasto(),((Difensore) i).getMovimento(),((Difensore) i).getAbilitaDifesa(),((Difensore) i).getAbilitaAttacco(),((Difensore) i).getAbilitaCentrocampo(),((Difensore) i).getValoreGenerale(),i.getValoreMercato());
				
			}
			else if(i instanceof Centrocampista){
				arrayusiliario[f] = new Centrocampista (i.GetAnagrafe().GetCognome(),i.GetAnagrafe().GetProvenienza(),i.getSquadra(),i.getVelocita(),i.getResistenza(),i.getForza(),i.getMorale(),i.GetAnagrafe().GetEta(),i.getCondizione(),i.getTecnica(),i.getAggressivita(),i.getCreativita(),i.getDecisione(),i.getCarisma(),i.getRuolo(),i.getGiocoDiSquadra(),i.getEssenziale(),i.getMediaVoti(),((Centrocampista) i).getCross(),((Centrocampista) i).getDribling(),((Centrocampista) i).getColpoDiTesta(),((Centrocampista) i).getPassaggio(),((Centrocampista) i).getTiro(),((Centrocampista) i).getContrasto(),((Centrocampista) i).getMovimento(),((Centrocampista) i).getAbilitaDifesa(),((Centrocampista) i).getAbilitaAttacco(),((Centrocampista) i).getAbilitaCentrocampo(),((Centrocampista) i).getValoreGenerale(),i.getValoreMercato());
				
			}
			else if (i instanceof Attaccante){
				arrayusiliario[f] = new Attaccante (i.GetAnagrafe().GetCognome(),i.GetAnagrafe().GetProvenienza(),i.getSquadra(),i.getVelocita(),i.getResistenza(),i.getForza(),i.getMorale(),i.GetAnagrafe().GetEta(),i.getCondizione(),i.getTecnica(),i.getAggressivita(),i.getCreativita(),i.getDecisione(),i.getCarisma(),i.getRuolo(),i.getGiocoDiSquadra(),i.getEssenziale(),i.getMediaVoti(),((Attaccante) i).getCross(),((Attaccante) i).getDribling(),((Attaccante) i).getColpoDiTesta(),((Attaccante) i).getPassaggio(),((Attaccante) i).getTiro(),((Attaccante) i).getContrasto(),((Attaccante) i).getMovimento(),((Attaccante) i).getAbilitaDifesa(),((Attaccante) i).getAbilitaAttacco(),((Attaccante) i).getAbilitaCentrocampo(),((Attaccante) i).getValoreGenerale(),i.getValoreMercato());
				
			}
			f++;
		}
		
				for(int i=0;i<15;i++){ //ciclo x array da ritornare
				
				if(arrayusiliario[i] instanceof Portiere) array[i]=((Portiere)arrayusiliario[i]).SearchBestPlayer(arrayusiliario,i);
			
				else if(arrayusiliario[i] instanceof Difensore)	array[i]=((Difensore)arrayusiliario[i]).SearchBestPlayer(arrayusiliario,i);		
				
				else if(arrayusiliario[i] instanceof Centrocampista) array[i]=((Centrocampista)arrayusiliario[i]).SearchBestPlayer(arrayusiliario,i);			
				
				else if (arrayusiliario[i] instanceof Attaccante) array[i]=((Attaccante)arrayusiliario[i]).SearchBestPlayer(arrayusiliario,i);
			    }	
				
		
		return array;
	}
	
private int SearchIndiceGiocatore(Giocatore array[],String ruolo){
	ArrayList <Giocatore> tmp = new ArrayList <Giocatore>();
	for(int i = 0; i<array.length;i++){
		if(ruolo.equalsIgnoreCase("Difensore") && array[i] instanceof Difensore){
				tmp.add((Difensore)array[i]);
		}
		else if(ruolo.equalsIgnoreCase("Centrocampista") && array[i] instanceof Centrocampista){
			tmp.add((Centrocampista)array[i]);
		}
		else if(ruolo.equalsIgnoreCase("Attaccante") && array[i] instanceof Attaccante){
			tmp.add((Attaccante)array[i]);
		}
		else if(ruolo.equalsIgnoreCase("Portiere") && array[i] instanceof Portiere){
			tmp.add((Portiere)array[i]);
		}
	}
	Random rand = new Random();
	int casuale = rand.nextInt(tmp.toArray().length);
	for(int i = 0; i<array.length ;i++){
		Giocatore g = (Giocatore) tmp.toArray()[casuale];
		if(db.giocatori[i].GetAnagrafe().GetCognome().equals(g.GetAnagrafe().GetCognome())) return i;
	}
	return -1;
}

private int SearchIndiceGiocatore(Giocatore array[]){
	Random rand = new Random();
	int casuale = rand.nextInt(array.length);
	
	return casuale;
}

private int SearchIndiceGiocatoreMia (ArrayList <Giocatore> array){
	Random rand = new Random();
	int casuale = rand.nextInt(array.toArray().length);
	
	return casuale;
}


private int SearchSquadra(SquadraAvversaria[] s, int i){
	for(int j = 0; j<s.length; j++){
		if(db.giocatori[i].getSquadra().equalsIgnoreCase(s[j].GetNomeSquadra())) return j;
	}
 return -1;
	}


	
}