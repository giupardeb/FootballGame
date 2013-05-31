import java.util.ArrayList;

public class SquadraAvversaria extends Squadra{

	public SquadraAvversaria(ArrayList<Giocatore> vett, String nome) {
		super(vett, nome);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void scambio (String Cognomes, String Cognomes1, Squadra s1){ //Cognomes viene scambiato con Cognomes1
		boolean esistes = false;
		boolean esistes1 = false;
		
		Giocatore g1=null;
		Giocatore g2=null;
				for( Giocatore i : s1.GetSquadra()){
					if(i.GetAnagrafe().GetCognome().equalsIgnoreCase(Cognomes1)){
						esistes = true;
						if(i instanceof Portiere){
							g1 = new Portiere (i.GetAnagrafe().GetCognome(),i.GetAnagrafe().GetProvenienza(),i.getSquadra(),i.getVelocita(),i.getResistenza(),i.getForza(),i.getMorale(),i.GetAnagrafe().GetEta(),i.getCondizione(),i.getTecnica(),i.getAggressivita(),i.getCreativita(),i.getDecisione(),i.getCarisma(),i.getRuolo(),i.getGiocoDiSquadra(),i.getEssenziale(),i.getMediaVoti(),((Portiere) i).getDotiAeree(),((Portiere) i).getAgilita(),((Portiere) i).getComunicazione(),((Portiere) i).getBloccareTiri(),((Portiere) i).getCalciare(),((Portiere) i).getRiflessi(),((Portiere) i).getRimessa(),((Portiere) i).getValoreGenerale(),i.getValoreMercato());
							break;
						}
						else if(i instanceof Difensore){
							g1 = new Difensore (i.GetAnagrafe().GetCognome(),i.GetAnagrafe().GetProvenienza(),i.getSquadra(),i.getVelocita(),i.getResistenza(),i.getForza(),i.getMorale(),i.GetAnagrafe().GetEta(),i.getCondizione(),i.getTecnica(),i.getAggressivita(),i.getCreativita(),i.getDecisione(),i.getCarisma(),i.getRuolo(),i.getGiocoDiSquadra(),i.getEssenziale(),i.getMediaVoti(),((Difensore) i).getCross(),((Difensore) i).getDribling(),((Difensore) i).getColpoDiTesta(),((Difensore) i).getPassaggio(),((Difensore) i).getTiro(),((Difensore) i).getContrasto(),((Difensore) i).getMovimento(),((Difensore) i).getAbilitaDifesa(),((Difensore) i).getAbilitaAttacco(),((Difensore) i).getAbilitaCentrocampo(),((Difensore) i).getValoreGenerale(),i.getValoreMercato());
							break;
						}
						else if(i instanceof Centrocampista){
							g1 = new Centrocampista (i.GetAnagrafe().GetCognome(),i.GetAnagrafe().GetProvenienza(),i.getSquadra(),i.getVelocita(),i.getResistenza(),i.getForza(),i.getMorale(),i.GetAnagrafe().GetEta(),i.getCondizione(),i.getTecnica(),i.getAggressivita(),i.getCreativita(),i.getDecisione(),i.getCarisma(),i.getRuolo(),i.getGiocoDiSquadra(),i.getEssenziale(),i.getMediaVoti(),((Centrocampista) i).getCross(),((Centrocampista) i).getDribling(),((Centrocampista) i).getColpoDiTesta(),((Centrocampista) i).getPassaggio(),((Centrocampista) i).getTiro(),((Centrocampista) i).getContrasto(),((Centrocampista) i).getMovimento(),((Centrocampista) i).getAbilitaDifesa(),((Centrocampista) i).getAbilitaAttacco(),((Centrocampista) i).getAbilitaCentrocampo(),((Centrocampista) i).getValoreGenerale(),i.getValoreMercato());
							break;
						}
						else if (i instanceof Attaccante){
							g1 = new Attaccante (i.GetAnagrafe().GetCognome(),i.GetAnagrafe().GetProvenienza(),i.getSquadra(),i.getVelocita(),i.getResistenza(),i.getForza(),i.getMorale(),i.GetAnagrafe().GetEta(),i.getCondizione(),i.getTecnica(),i.getAggressivita(),i.getCreativita(),i.getDecisione(),i.getCarisma(),i.getRuolo(),i.getGiocoDiSquadra(),i.getEssenziale(),i.getMediaVoti(),((Attaccante) i).getCross(),((Attaccante) i).getDribling(),((Attaccante) i).getColpoDiTesta(),((Attaccante) i).getPassaggio(),((Attaccante) i).getTiro(),((Attaccante) i).getContrasto(),((Attaccante) i).getMovimento(),((Attaccante) i).getAbilitaDifesa(),((Attaccante) i).getAbilitaAttacco(),((Attaccante) i).getAbilitaCentrocampo(),((Attaccante) i).getValoreGenerale(),i.getValoreMercato());
							break;
						}
						
					}
				}
				
			    for(Giocatore i : this.GetSquadra()){
			    	if(i.GetAnagrafe().GetCognome().equalsIgnoreCase(Cognomes)){
						esistes1 = true;
						if(i instanceof Portiere){
							g2 = new Portiere (i.GetAnagrafe().GetCognome(),i.GetAnagrafe().GetProvenienza(),i.getSquadra(),i.getVelocita(),i.getResistenza(),i.getForza(),i.getMorale(),i.GetAnagrafe().GetEta(),i.getCondizione(),i.getTecnica(),i.getAggressivita(),i.getCreativita(),i.getDecisione(),i.getCarisma(),i.getRuolo(),i.getGiocoDiSquadra(),i.getEssenziale(),i.getMediaVoti(),((Portiere) i).getDotiAeree(),((Portiere) i).getAgilita(),((Portiere) i).getComunicazione(),((Portiere) i).getBloccareTiri(),((Portiere) i).getCalciare(),((Portiere) i).getRiflessi(),((Portiere) i).getRimessa(),((Portiere) i).getValoreGenerale(),i.getValoreMercato());
							break;
						}
						else if(i instanceof Difensore){
							g2 = new Difensore (i.GetAnagrafe().GetCognome(),i.GetAnagrafe().GetProvenienza(),i.getSquadra(),i.getVelocita(),i.getResistenza(),i.getForza(),i.getMorale(),i.GetAnagrafe().GetEta(),i.getCondizione(),i.getTecnica(),i.getAggressivita(),i.getCreativita(),i.getDecisione(),i.getCarisma(),i.getRuolo(),i.getGiocoDiSquadra(),i.getEssenziale(),i.getMediaVoti(),((Difensore) i).getCross(),((Difensore) i).getDribling(),((Difensore) i).getColpoDiTesta(),((Difensore) i).getPassaggio(),((Difensore) i).getTiro(),((Difensore) i).getContrasto(),((Difensore) i).getMovimento(),((Difensore) i).getAbilitaDifesa(),((Difensore) i).getAbilitaAttacco(),((Difensore) i).getAbilitaCentrocampo(),((Difensore) i).getValoreGenerale(),i.getValoreMercato());
							break;
						}
						else if(i instanceof Centrocampista){
							g2 = new Centrocampista (i.GetAnagrafe().GetCognome(),i.GetAnagrafe().GetProvenienza(),i.getSquadra(),i.getVelocita(),i.getResistenza(),i.getForza(),i.getMorale(),i.GetAnagrafe().GetEta(),i.getCondizione(),i.getTecnica(),i.getAggressivita(),i.getCreativita(),i.getDecisione(),i.getCarisma(),i.getRuolo(),i.getGiocoDiSquadra(),i.getEssenziale(),i.getMediaVoti(),((Centrocampista) i).getCross(),((Centrocampista) i).getDribling(),((Centrocampista) i).getColpoDiTesta(),((Centrocampista) i).getPassaggio(),((Centrocampista) i).getTiro(),((Centrocampista) i).getContrasto(),((Centrocampista) i).getMovimento(),((Centrocampista) i).getAbilitaDifesa(),((Centrocampista) i).getAbilitaAttacco(),((Centrocampista) i).getAbilitaCentrocampo(),((Centrocampista) i).getValoreGenerale(),i.getValoreMercato());
							break;
						}
						else if (i instanceof Attaccante){
							g2 = new Attaccante (i.GetAnagrafe().GetCognome(),i.GetAnagrafe().GetProvenienza(),i.getSquadra(),i.getVelocita(),i.getResistenza(),i.getForza(),i.getMorale(),i.GetAnagrafe().GetEta(),i.getCondizione(),i.getTecnica(),i.getAggressivita(),i.getCreativita(),i.getDecisione(),i.getCarisma(),i.getRuolo(),i.getGiocoDiSquadra(),i.getEssenziale(),i.getMediaVoti(),((Attaccante) i).getCross(),((Attaccante) i).getDribling(),((Attaccante) i).getColpoDiTesta(),((Attaccante) i).getPassaggio(),((Attaccante) i).getTiro(),((Attaccante) i).getContrasto(),((Attaccante) i).getMovimento(),((Attaccante) i).getAbilitaDifesa(),((Attaccante) i).getAbilitaAttacco(),((Attaccante) i).getAbilitaCentrocampo(),((Attaccante) i).getValoreGenerale(),i.getValoreMercato());
							break;
						}
						
					}
				}//////////////////////////////////////////////////
			    
			    
			    ///			    
			    if(esistes && esistes1){
			    	
			    		if(g1 instanceof Difensore){
			    			if(((Difensore)g1).getDotiRuolo()>((Difensore)g2).getDotiRuolo()){
			    				if((int)(Math.random()*5)+1<3){
			    					this.GetSquadra().add(g1);
			    					s1.GetSquadra().add(g2);
			    					g1.setNomeSquadra(this.GetNomeSquadra());
			    					g2.setNomeSquadra(s1.GetNomeSquadra());

			    			    	this.GetSquadra().remove(g2);
			    			    	s1.GetSquadra().remove(g1);	
			    			    	System.out.println("Scambio effettuato con successo!");
			    				}
			    				else System.out.println("Il giocatore ha rifiutato l'offerta");
			    			}
			    			else System.out.println("La squadra ha rifiutato l'offerta");
			    		}
			    		else if(g1 instanceof Centrocampista){
			    			if(((Centrocampista)g1).getDotiRuolo()>((Difensore)g2).getDotiRuolo()){
			    				
			    				if((int)(Math.random()*5)+1<3){
			    					this.GetSquadra().add(g1);
			    					s1.GetSquadra().add(g2);
			    					g1.setNomeSquadra(this.GetNomeSquadra());
			    					g2.setNomeSquadra(s1.GetNomeSquadra());

			    			    	this.GetSquadra().remove(g2);
			    			    	s1.GetSquadra().remove(g1);	
			    			    	System.out.println("Scambio effettuato con successo!");
			    				}
			    				else System.out.println("Il giocatore ha rifiutato l'offerta");
			    			}
			    			else System.out.println("La squadra ha rifiutato l'offerta");
			    		}
			    		else if(g1 instanceof Attaccante){
			    			if(((Attaccante)g1).getDotiRuolo()>((Attaccante)g2).getDotiRuolo()){
			    				if((int)(Math.random()*5)+1<3){
			    					this.GetSquadra().add(g1);
			    					s1.GetSquadra().add(g2);
			    					g1.setNomeSquadra(this.GetNomeSquadra());
			    					g2.setNomeSquadra(s1.GetNomeSquadra());

			    			    	this.GetSquadra().remove(g2);
			    			    	s1.GetSquadra().remove(g1);	
			    			    	System.out.println("Scambio effettuato con successo!");
			    				}
			    				else System.out.println("Il giocatore ha rifiutato l'offerta");
			    			}
			    			else System.out.println("La squadra ha rifiutato l'offerta");
			    		}
			    }
	}
///////////////////////////////////////////////****************************************/////////////////////////////////////////////	
	
	public void acquisto(String Cognome,Squadra s1){ // miasquadra acquista Cognome da s1
		
		Giocatore g1 = null;
		Giocatore i = Search(s1,Cognome);
		
		
		if(i!=null){
			if(i instanceof Portiere){
				g1 = new Portiere (i.GetAnagrafe().GetCognome(),i.GetAnagrafe().GetProvenienza(),
									i.getSquadra(),i.getVelocita(),i.getResistenza(),i.getForza(),
									i.getMorale(),i.GetAnagrafe().GetEta(),i.getCondizione(),i.getTecnica(),
									i.getAggressivita(),i.getCreativita(),i.getDecisione(),i.getCarisma(),
									i.getRuolo(),i.getGiocoDiSquadra(),i.getEssenziale(),i.getMediaVoti(),
									((Portiere) i).getDotiAeree(),((Portiere) i).getAgilita(),((Portiere) i).getComunicazione(),
									((Portiere) i).getBloccareTiri(),((Portiere) i).getCalciare(),((Portiere) i).getRiflessi(),
									((Portiere) i).getRimessa(),((Portiere) i).getValoreGenerale(),((Portiere) i).getValoreMercato());
			
			}
			else if(i instanceof Difensore){
				g1 = new Difensore (i.GetAnagrafe().GetCognome(),i.GetAnagrafe().GetProvenienza(),
									i.getSquadra(),i.getVelocita(),i.getResistenza(),i.getForza(),i.getMorale(),
									i.GetAnagrafe().GetEta(),i.getCondizione(),i.getTecnica(),i.getAggressivita(),
									i.getCreativita(),i.getDecisione(),i.getCarisma(),i.getRuolo(),i.getGiocoDiSquadra(),
									i.getEssenziale(),i.getMediaVoti(),((Difensore) i).getCross(),((Difensore) i).getDribling(),
									((Difensore) i).getColpoDiTesta(),((Difensore) i).getPassaggio(),((Difensore) i).getTiro(),
									((Difensore) i).getContrasto(),((Difensore) i).getMovimento(),((Difensore) i).getAbilitaDifesa(),
									((Difensore) i).getAbilitaAttacco(),((Difensore) i).getAbilitaCentrocampo(),((Difensore) i).getValoreGenerale(),
									((Difensore) i).getValoreMercato());
				
			}
			else if(i instanceof Centrocampista){
				g1 = new Centrocampista (i.GetAnagrafe().GetCognome(),i.GetAnagrafe().GetProvenienza(),
										 i.getSquadra(),i.getVelocita(),i.getResistenza(),i.getForza(),i.getMorale(),
										 i.GetAnagrafe().GetEta(),i.getCondizione(),i.getTecnica(),i.getAggressivita(),
										 i.getCreativita(),i.getDecisione(),i.getCarisma(),i.getRuolo(),i.getGiocoDiSquadra(),
										 i.getEssenziale(),i.getMediaVoti(),((Centrocampista) i).getCross(),((Centrocampista) i).getDribling(),
										 ((Centrocampista) i).getColpoDiTesta(),((Centrocampista) i).getPassaggio(),((Centrocampista) i).getTiro(),
										 ((Centrocampista) i).getContrasto(),((Centrocampista) i).getMovimento(),((Centrocampista) i).getAbilitaDifesa(),
										 ((Centrocampista) i).getAbilitaAttacco(),((Centrocampista) i).getAbilitaCentrocampo(),
										 ((Centrocampista) i).getValoreGenerale(),((Centrocampista) i).getValoreMercato());
				
			}
			else if (i instanceof Attaccante){
				g1 = new Attaccante (i.GetAnagrafe().GetCognome(),i.GetAnagrafe().GetProvenienza(),
									 i.getSquadra(),i.getVelocita(),i.getResistenza(),i.getForza(),i.getMorale(),
									 i.GetAnagrafe().GetEta(),i.getCondizione(),i.getTecnica(),i.getAggressivita(),
									 i.getCreativita(),i.getDecisione(),i.getCarisma(),i.getRuolo(),i.getGiocoDiSquadra(),
									 i.getEssenziale(),i.getMediaVoti(),((Attaccante) i).getCross(),((Attaccante) i).getDribling(),
									 ((Attaccante) i).getColpoDiTesta(),((Attaccante) i).getPassaggio(),((Attaccante) i).getTiro(),
									 ((Attaccante) i).getContrasto(),((Attaccante) i).getMovimento(),((Attaccante) i).getAbilitaDifesa(),
									 ((Attaccante) i).getAbilitaAttacco(),((Attaccante) i).getAbilitaCentrocampo(),
									 ((Attaccante) i).getValoreGenerale(),((Attaccante) i).getValoreMercato());
				
			}
			if(this.GetBudget()>g1.getValoreMercato()){
				if(((Math.random()*10)+1)>6){
					
					this.SetBudgetRemove(g1.getValoreMercato());
					g1.setNomeSquadra(this.GetNomeSquadra());
					this.GetSquadra().add(g1);


					s1.SetBudgetAdd(g1.getValoreMercato());
					s1.GetSquadra().remove(i); 
					
					System.out.print("il giocatore ha accettato l'offerta!");
				}
				else System.out.print("il giocatore ha rifiutato l'offerta");
				
			 }
			else System.out.print("Non hai il Budget sufficente per acquistare il giocatore!");
		}
		else System.out.println("Giocatore non esistente nella Squadra");
			
	}
	
	
	public Giocatore[] OrganizzaSquadra(){
		Giocatore array[] = new Giocatore [15];
		int j=0;
		//System.out.println("Organizza la tua squadra: ");

		for(Giocatore i : this.GetSquadra()){
			//System.out.println(j+1 + " " + i.GetAnagrafe());
			j++;
			
		}
		
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
	
}