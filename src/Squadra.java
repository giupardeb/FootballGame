import java.util.*;
import javax.swing.*;



/*Per quanto riguarda sia la vendita che l'acquista, dato che può esistere la possibilità che più giocatori abbiano lo stesso cognome,
 * bisognerebbe gestire la cosa fornendo in outoput tutti i giocatori che hanno lo stesso cognome così da poter scegliere*/






class Squadra{
	String nome;
	private double budget;
	private ArrayList <Giocatore> miasquadra = new ArrayList<Giocatore>();
	int vittorie;
	int pareggi;
	int sconfitte;
	int golfatti;
	int golsubiti;
	int punti;
	//MODIFICTO  14 MAGGIO ORE 18:00

	int totalepronostico; //serve per il pronostico, sarà la somma dei gol fatti, subiti, vittorie sconfitte, pareggi + le abilità totali di difesa,attacco,centrocampo
	int abilitaDifesa; //serve per il pronostico
	int abilitaCentrocampo; //serve per il pronostico
	int abilitaAttacco; //serve per il pronostico
	//FINE MODIFICA
	
	
	//Costruttore di Squadra!!!
	public Squadra(ArrayList <Giocatore> vett,double budget, String nome){
			miasquadra = vett;//aggiunta con array dinamici
			this.budget = budget;
			this.nome = nome;
			totalepronostico= 0;
			//MODIFICTO  14 MAGGIO ORE 18:00
			
			/*non faccio altro che mettere nelle variabili abilità,  tutte le abilità specifiche di ogni giocatore alla fine le variabili abilità
			 * avranno la somma di tutte le abilità dei giocatori (difensori attaccanti centrocampisi)
			 * ciò è utile per il pronostico*/
			int d=0,c=0,a=0; 
			for(Giocatore i : miasquadra){
				if(i instanceof Difensore) {
					abilitaDifesa += ((Difensore)i).getAbilitàDifesa();
					d++;
				}
				else{
					if(i instanceof Portiere){
						abilitaDifesa += ((Portiere)i).getValoreGenerale();
						d++;
					}
				}
				
				if(i instanceof Centrocampista){
					abilitaCentrocampo += ((Centrocampista)i).getAbilitàCentrocampo();
					c++;
				}
				if(i instanceof Attaccante){
					abilitaAttacco += ((Attaccante)i).getAbilitàAttacco();
					a++;
				}
			}
			abilitaDifesa/=d;
			abilitaCentrocampo/=c;
			abilitaAttacco/=a;
		
	}
	//serve per il pronostico, sarà la somma dei gol fatti, subiti, vittorie sconfitte, pareggi + le abilità totali di difesa,attacco,centrocampo
	public void setTotalePronostico(){
		totalepronostico = (getVittorie()+ getPareggi()-getSconfitte()+getGolFatti()-getGolSubiti() + getAbilitàCentrocampo()+getAbilitàAttacco()+getAbilitàDifesa());
	}
	
	private int getAbilitàDifesa() {
		return abilitaDifesa;
	}
	private int getAbilitàAttacco() {
		return abilitaAttacco;
	}
	private int getAbilitàCentrocampo() {
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
	
	
	
	//CREDO CHE CREARE IL METODO VENDITA SIA INUTILE... DATO CHE ABBIAMO ACQUISTI CHE IN UN CERTO SENSO GUARDANDOLA DAL 
	//PUNTO DI VISTA DELLA SQUADRAS1 È UNA VENDITA..
	
	public void scambio (String Cognomes, String Cognomes1, Squadra s1){ //Cognomes viene scambiato con Cognomes1
		boolean esistes = false;
		boolean esistes1 = false;
		
		Giocatore g1=null;
		Giocatore g2=null;
				for( Giocatore i : s1.GetSquadra()){
					if(i.GetAnagrafe().GetCognome().equalsIgnoreCase(Cognomes1)){
						esistes = true;
						if(i instanceof Portiere){
							g1 = new Portiere (i.GetAnagrafe().GetNome(),i.GetAnagrafe().GetCognome(),i.GetAnagrafe().GetProvenienza(),i.getSquadra(),i.getVelocità(),i.getResistenza(),i.getForza(),i.getMorale(),i.GetAnagrafe().GetEta(),i.getCondizione(),i.getTecnica(),i.getAggressività(),i.getCreatività(),i.getDecisione(),i.getCarisma(),i.getPosizione(),i.getGiocoDiSquadra(),i.getEssenziale(),i.getMediaVoti(),((Portiere) i).getDotiAeree(),((Portiere) i).getAgilità(),((Portiere) i).getComunicazione(),((Portiere) i).getBloccareTiri(),((Portiere) i).getCalciare(),((Portiere) i).getRiflessi(),((Portiere) i).getRimessa(),((Portiere) i).getValoreGenerale(),i.getValoreMercato());
							break;
						}
						else if(i instanceof Difensore){
							g1 = new Difensore (i.GetAnagrafe().GetNome(),i.GetAnagrafe().GetCognome(),i.GetAnagrafe().GetProvenienza(),i.getSquadra(),i.getVelocità(),i.getResistenza(),i.getForza(),i.getMorale(),i.GetAnagrafe().GetEta(),i.getCondizione(),i.getTecnica(),i.getAggressività(),i.getCreatività(),i.getDecisione(),i.getCarisma(),i.getPosizione(),i.getGiocoDiSquadra(),i.getEssenziale(),i.getMediaVoti(),((Difensore) i).getCross(),((Difensore) i).getDribling(),((Difensore) i).getColpoDiTesta(),((Difensore) i).getPassaggio(),((Difensore) i).getTiro(),((Difensore) i).getContrasti(),((Difensore) i).getMovimento(),((Difensore) i).getAbilitàDifesa(),((Difensore) i).getAbilitàAttacco(),((Difensore) i).getAbilitàCentrocampo(),((Difensore) i).getValoreGenerale(),i.getValoreMercato());
							break;
						}
						else if(i instanceof Centrocampista){
							g1 = new Centrocampista (i.GetAnagrafe().GetNome(),i.GetAnagrafe().GetCognome(),i.GetAnagrafe().GetProvenienza(),i.getSquadra(),i.getVelocità(),i.getResistenza(),i.getForza(),i.getMorale(),i.GetAnagrafe().GetEta(),i.getCondizione(),i.getTecnica(),i.getAggressività(),i.getCreatività(),i.getDecisione(),i.getCarisma(),i.getPosizione(),i.getGiocoDiSquadra(),i.getEssenziale(),i.getMediaVoti(),((Centrocampista) i).getCross(),((Centrocampista) i).getDribling(),((Centrocampista) i).getColpoDiTesta(),((Centrocampista) i).getPassaggio(),((Centrocampista) i).getTiro(),((Centrocampista) i).getContrasti(),((Centrocampista) i).getMovimento(),((Centrocampista) i).getAbilitàDifesa(),((Centrocampista) i).getAbilitàAttacco(),((Centrocampista) i).getAbilitàCentrocampo(),((Centrocampista) i).getValoreGenerale(),i.getValoreMercato());
							break;
						}
						else if (i instanceof Attaccante){
							g1 = new Attaccante (i.GetAnagrafe().GetNome(),i.GetAnagrafe().GetCognome(),i.GetAnagrafe().GetProvenienza(),i.getSquadra(),i.getVelocità(),i.getResistenza(),i.getForza(),i.getMorale(),i.GetAnagrafe().GetEta(),i.getCondizione(),i.getTecnica(),i.getAggressività(),i.getCreatività(),i.getDecisione(),i.getCarisma(),i.getPosizione(),i.getGiocoDiSquadra(),i.getEssenziale(),i.getMediaVoti(),((Attaccante) i).getCross(),((Attaccante) i).getDribling(),((Attaccante) i).getColpoDiTesta(),((Attaccante) i).getPassaggio(),((Attaccante) i).getTiro(),((Attaccante) i).getContrasti(),((Attaccante) i).getMovimento(),((Attaccante) i).getAbilitàDifesa(),((Attaccante) i).getAbilitàAttacco(),((Attaccante) i).getAbilitàCentrocampo(),((Attaccante) i).getValoreGenerale(),i.getValoreMercato());
							break;
						}
						
					}
				}
				
			    for(Giocatore i : this.GetSquadra()){
			    	if(i.GetAnagrafe().GetCognome().equalsIgnoreCase(Cognomes)){
						esistes1 = true;
						if(i instanceof Portiere){
							g2 = new Portiere (i.GetAnagrafe().GetNome(),i.GetAnagrafe().GetCognome(),i.GetAnagrafe().GetProvenienza(),i.getSquadra(),i.getVelocità(),i.getResistenza(),i.getForza(),i.getMorale(),i.GetAnagrafe().GetEta(),i.getCondizione(),i.getTecnica(),i.getAggressività(),i.getCreatività(),i.getDecisione(),i.getCarisma(),i.getPosizione(),i.getGiocoDiSquadra(),i.getEssenziale(),i.getMediaVoti(),((Portiere) i).getDotiAeree(),((Portiere) i).getAgilità(),((Portiere) i).getComunicazione(),((Portiere) i).getBloccareTiri(),((Portiere) i).getCalciare(),((Portiere) i).getRiflessi(),((Portiere) i).getRimessa(),((Portiere) i).getValoreGenerale(),i.getValoreMercato());
							break;
						}
						else if(i instanceof Difensore){
							g2 = new Difensore (i.GetAnagrafe().GetNome(),i.GetAnagrafe().GetCognome(),i.GetAnagrafe().GetProvenienza(),i.getSquadra(),i.getVelocità(),i.getResistenza(),i.getForza(),i.getMorale(),i.GetAnagrafe().GetEta(),i.getCondizione(),i.getTecnica(),i.getAggressività(),i.getCreatività(),i.getDecisione(),i.getCarisma(),i.getPosizione(),i.getGiocoDiSquadra(),i.getEssenziale(),i.getMediaVoti(),((Difensore) i).getCross(),((Difensore) i).getDribling(),((Difensore) i).getColpoDiTesta(),((Difensore) i).getPassaggio(),((Difensore) i).getTiro(),((Difensore) i).getContrasti(),((Difensore) i).getMovimento(),((Difensore) i).getAbilitàDifesa(),((Difensore) i).getAbilitàAttacco(),((Difensore) i).getAbilitàCentrocampo(),((Difensore) i).getValoreGenerale(),i.getValoreMercato());
							break;
						}
						else if(i instanceof Centrocampista){
							g2 = new Centrocampista (i.GetAnagrafe().GetNome(),i.GetAnagrafe().GetCognome(),i.GetAnagrafe().GetProvenienza(),i.getSquadra(),i.getVelocità(),i.getResistenza(),i.getForza(),i.getMorale(),i.GetAnagrafe().GetEta(),i.getCondizione(),i.getTecnica(),i.getAggressività(),i.getCreatività(),i.getDecisione(),i.getCarisma(),i.getPosizione(),i.getGiocoDiSquadra(),i.getEssenziale(),i.getMediaVoti(),((Centrocampista) i).getCross(),((Centrocampista) i).getDribling(),((Centrocampista) i).getColpoDiTesta(),((Centrocampista) i).getPassaggio(),((Centrocampista) i).getTiro(),((Centrocampista) i).getContrasti(),((Centrocampista) i).getMovimento(),((Centrocampista) i).getAbilitàDifesa(),((Centrocampista) i).getAbilitàAttacco(),((Centrocampista) i).getAbilitàCentrocampo(),((Centrocampista) i).getValoreGenerale(),i.getValoreMercato());
							break;
						}
						else if (i instanceof Attaccante){
							g2 = new Attaccante (i.GetAnagrafe().GetNome(),i.GetAnagrafe().GetCognome(),i.GetAnagrafe().GetProvenienza(),i.getSquadra(),i.getVelocità(),i.getResistenza(),i.getForza(),i.getMorale(),i.GetAnagrafe().GetEta(),i.getCondizione(),i.getTecnica(),i.getAggressività(),i.getCreatività(),i.getDecisione(),i.getCarisma(),i.getPosizione(),i.getGiocoDiSquadra(),i.getEssenziale(),i.getMediaVoti(),((Attaccante) i).getCross(),((Attaccante) i).getDribling(),((Attaccante) i).getColpoDiTesta(),((Attaccante) i).getPassaggio(),((Attaccante) i).getTiro(),((Attaccante) i).getContrasti(),((Attaccante) i).getMovimento(),((Attaccante) i).getAbilitàDifesa(),((Attaccante) i).getAbilitàAttacco(),((Attaccante) i).getAbilitàCentrocampo(),((Attaccante) i).getValoreGenerale(),i.getValoreMercato());
							break;
						}
						
					}
				}
/////////////////////////////////////////////////////			    
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
				g1 = new Portiere (i.GetAnagrafe().GetNome(),i.GetAnagrafe().GetCognome(),i.GetAnagrafe().GetProvenienza(),i.getSquadra(),i.getVelocità(),i.getResistenza(),i.getForza(),i.getMorale(),i.GetAnagrafe().GetEta(),i.getCondizione(),i.getTecnica(),i.getAggressività(),i.getCreatività(),i.getDecisione(),i.getCarisma(),i.getPosizione(),i.getGiocoDiSquadra(),i.getEssenziale(),i.getMediaVoti(),((Portiere) i).getDotiAeree(),((Portiere) i).getAgilità(),((Portiere) i).getComunicazione(),((Portiere) i).getBloccareTiri(),((Portiere) i).getCalciare(),((Portiere) i).getRiflessi(),((Portiere) i).getRimessa(),((Portiere) i).getValoreGenerale(),i.getValoreMercato());
			
			}
			else if(i instanceof Difensore){
				g1 = new Difensore (i.GetAnagrafe().GetNome(),i.GetAnagrafe().GetCognome(),i.GetAnagrafe().GetProvenienza(),i.getSquadra(),i.getVelocità(),i.getResistenza(),i.getForza(),i.getMorale(),i.GetAnagrafe().GetEta(),i.getCondizione(),i.getTecnica(),i.getAggressività(),i.getCreatività(),i.getDecisione(),i.getCarisma(),i.getPosizione(),i.getGiocoDiSquadra(),i.getEssenziale(),i.getMediaVoti(),((Difensore) i).getCross(),((Difensore) i).getDribling(),((Difensore) i).getColpoDiTesta(),((Difensore) i).getPassaggio(),((Difensore) i).getTiro(),((Difensore) i).getContrasti(),((Difensore) i).getMovimento(),((Difensore) i).getAbilitàDifesa(),((Difensore) i).getAbilitàAttacco(),((Difensore) i).getAbilitàCentrocampo(),((Difensore) i).getValoreGenerale(),i.getValoreMercato());
				
			}
			else if(i instanceof Centrocampista){
				g1 = new Centrocampista (i.GetAnagrafe().GetNome(),i.GetAnagrafe().GetCognome(),i.GetAnagrafe().GetProvenienza(),i.getSquadra(),i.getVelocità(),i.getResistenza(),i.getForza(),i.getMorale(),i.GetAnagrafe().GetEta(),i.getCondizione(),i.getTecnica(),i.getAggressività(),i.getCreatività(),i.getDecisione(),i.getCarisma(),i.getPosizione(),i.getGiocoDiSquadra(),i.getEssenziale(),i.getMediaVoti(),((Centrocampista) i).getCross(),((Centrocampista) i).getDribling(),((Centrocampista) i).getColpoDiTesta(),((Centrocampista) i).getPassaggio(),((Centrocampista) i).getTiro(),((Centrocampista) i).getContrasti(),((Centrocampista) i).getMovimento(),((Centrocampista) i).getAbilitàDifesa(),((Centrocampista) i).getAbilitàAttacco(),((Centrocampista) i).getAbilitàCentrocampo(),((Centrocampista) i).getValoreGenerale(),i.getValoreMercato());
				
			}
			else if (i instanceof Attaccante){
				g1 = new Attaccante (i.GetAnagrafe().GetNome(),i.GetAnagrafe().GetCognome(),i.GetAnagrafe().GetProvenienza(),i.getSquadra(),i.getVelocità(),i.getResistenza(),i.getForza(),i.getMorale(),i.GetAnagrafe().GetEta(),i.getCondizione(),i.getTecnica(),i.getAggressività(),i.getCreatività(),i.getDecisione(),i.getCarisma(),i.getPosizione(),i.getGiocoDiSquadra(),i.getEssenziale(),i.getMediaVoti(),((Attaccante) i).getCross(),((Attaccante) i).getDribling(),((Attaccante) i).getColpoDiTesta(),((Attaccante) i).getPassaggio(),((Attaccante) i).getTiro(),((Attaccante) i).getContrasti(),((Attaccante) i).getMovimento(),((Attaccante) i).getAbilitàDifesa(),((Attaccante) i).getAbilitàAttacco(),((Attaccante) i).getAbilitàCentrocampo(),((Attaccante) i).getValoreGenerale(),i.getValoreMercato());
				
			}
			if(this.GetBudget()>g1.getValoreMercato()){
				if(((Math.random()*10)+1)>6){
					
					this.GetSquadra().add(g1);
					this.SetBudgetRemove(g1.getValoreMercato());
					g1.setNomeSquadra(this.GetNomeSquadra());

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
	
	private Giocatore Search(Squadra s,String Cognome){
		for(Giocatore i : s.GetSquadra()){
			if(i.GetAnagrafe().GetCognome().equalsIgnoreCase(Cognome)){
				return i;
			 }
		}
		return null;
	}
	
	////////////////////////////////////////////////***************************************///////////////////////////////////////////////////
															//RIVEDETELO !!! CERCATE DI CAPIRLO E IN TAL CASO MODIFICATELO
															// SEMPRE OCCHIO E INFORMATEMI IN RUNTIME DELLE MODIFICHE
	public Giocatore[] OrganizzaSquadra(){
		Giocatore array[] = new Giocatore [11];
		int j=0;
		System.out.println("Organizza la tua squadra: ");

		for(Giocatore i : this.GetSquadra()){
			System.out.println(j+1 + " " + i.GetAnagrafe());
			j++;
			
		}
		Giocatore arrayusiliario[] = new Giocatore [j];
		int f=0;
		for(Giocatore i : this.GetSquadra()){
			if(i instanceof Portiere){
				arrayusiliario[f] = new Portiere (i.GetAnagrafe().GetNome(),i.GetAnagrafe().GetCognome(),i.GetAnagrafe().GetProvenienza(),i.getSquadra(),i.getVelocità(),i.getResistenza(),i.getForza(),i.getMorale(),i.GetAnagrafe().GetEta(),i.getCondizione(),i.getTecnica(),i.getAggressività(),i.getCreatività(),i.getDecisione(),i.getCarisma(),i.getPosizione(),i.getGiocoDiSquadra(),i.getEssenziale(),i.getMediaVoti(),((Portiere) i).getDotiAeree(),((Portiere) i).getAgilità(),((Portiere) i).getComunicazione(),((Portiere) i).getBloccareTiri(),((Portiere) i).getCalciare(),((Portiere) i).getRiflessi(),((Portiere) i).getRimessa(),((Portiere) i).getValoreGenerale(),i.getValoreMercato());
			
			}
			else if(i instanceof Difensore){
				arrayusiliario[f] = new Difensore (i.GetAnagrafe().GetNome(),i.GetAnagrafe().GetCognome(),i.GetAnagrafe().GetProvenienza(),i.getSquadra(),i.getVelocità(),i.getResistenza(),i.getForza(),i.getMorale(),i.GetAnagrafe().GetEta(),i.getCondizione(),i.getTecnica(),i.getAggressività(),i.getCreatività(),i.getDecisione(),i.getCarisma(),i.getPosizione(),i.getGiocoDiSquadra(),i.getEssenziale(),i.getMediaVoti(),((Difensore) i).getCross(),((Difensore) i).getDribling(),((Difensore) i).getColpoDiTesta(),((Difensore) i).getPassaggio(),((Difensore) i).getTiro(),((Difensore) i).getContrasti(),((Difensore) i).getMovimento(),((Difensore) i).getAbilitàDifesa(),((Difensore) i).getAbilitàAttacco(),((Difensore) i).getAbilitàCentrocampo(),((Difensore) i).getValoreGenerale(),i.getValoreMercato());
				
			}
			else if(i instanceof Centrocampista){
				arrayusiliario[f] = new Centrocampista (i.GetAnagrafe().GetNome(),i.GetAnagrafe().GetCognome(),i.GetAnagrafe().GetProvenienza(),i.getSquadra(),i.getVelocità(),i.getResistenza(),i.getForza(),i.getMorale(),i.GetAnagrafe().GetEta(),i.getCondizione(),i.getTecnica(),i.getAggressività(),i.getCreatività(),i.getDecisione(),i.getCarisma(),i.getPosizione(),i.getGiocoDiSquadra(),i.getEssenziale(),i.getMediaVoti(),((Centrocampista) i).getCross(),((Centrocampista) i).getDribling(),((Centrocampista) i).getColpoDiTesta(),((Centrocampista) i).getPassaggio(),((Centrocampista) i).getTiro(),((Centrocampista) i).getContrasti(),((Centrocampista) i).getMovimento(),((Centrocampista) i).getAbilitàDifesa(),((Centrocampista) i).getAbilitàAttacco(),((Centrocampista) i).getAbilitàCentrocampo(),((Centrocampista) i).getValoreGenerale(),i.getValoreMercato());
				
			}
			else if (i instanceof Attaccante){
				arrayusiliario[f] = new Attaccante (i.GetAnagrafe().GetNome(),i.GetAnagrafe().GetCognome(),i.GetAnagrafe().GetProvenienza(),i.getSquadra(),i.getVelocità(),i.getResistenza(),i.getForza(),i.getMorale(),i.GetAnagrafe().GetEta(),i.getCondizione(),i.getTecnica(),i.getAggressività(),i.getCreatività(),i.getDecisione(),i.getCarisma(),i.getPosizione(),i.getGiocoDiSquadra(),i.getEssenziale(),i.getMediaVoti(),((Attaccante) i).getCross(),((Attaccante) i).getDribling(),((Attaccante) i).getColpoDiTesta(),((Attaccante) i).getPassaggio(),((Attaccante) i).getTiro(),((Attaccante) i).getContrasti(),((Attaccante) i).getMovimento(),((Attaccante) i).getAbilitàDifesa(),((Attaccante) i).getAbilitàAttacco(),((Attaccante) i).getAbilitàCentrocampo(),((Attaccante) i).getValoreGenerale(),i.getValoreMercato());
				
			}			f++;
		}
		if(arrayusiliario.length<14) System.out.println("non puoi organizzarti la squadra poichè hai meno di 15 giocatori, prova ad acquistare qualcuno"); //eventualmente metodo acquista
		else{
			//MODIFICTO  14 MAGGIO ORE 18:00

			//dobbiamo decidere se l'array che andrà a formare il campo di gioco sarà ordinato oppure no, CHE FARE????? ooooks
			
			//MODIFICTO  14 MAGGIO ORE 18:00

			for(int i=0;i<14;i++){
				String elemento = JOptionPane.showInputDialog("inserire il numero corrispondente al giocatore desiderato nell'ordine(P,4D,4C,2A): ");
				int h = Integer.parseInt(elemento);
				if(h==1){
					array[i] = arrayusiliario[i]; 
				}
				else if(h>1&&h<=5){
					array[i] = arrayusiliario[i];
				}
				else if(h>5 && h<=9){
					array[i] = arrayusiliario[i];
				}
				else if(h>9 && h<=11){
					array[i] = arrayusiliario[i];
				}
				else if(h==12)array[i] = arrayusiliario[i];
				else if(h==13)array[i] = arrayusiliario[i];
				else if(h==14)array[i] = arrayusiliario[i];
			}
		}
		
		
		return array;
	}
	////////////////////////////////////////////////////************************************/////////////////////////////////////
	
	
	
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