package Project;
import java.util.ArrayList;
import static java.lang.System.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Random;


public class SquadraAvversaria extends Squadra{

	//Queste costanti li dobbiamo modificare credo, poichè non si effettuerebbe il calciomercato dato
	//che tutte le squadre hanno il minimo di calciotori possibili


	public SquadraAvversaria(ArrayList<Giocatore> vett, String nome) {
		super(vett, nome);
	}
	///////////////////////////////////////////////////////***************INIZIO DI SCAMBIO***********************//////////////////////////////	

	public void scambio (SquadraAvversaria[] s1,SquadraUmano squadrautente){
	
		int j = SearchIndiceGiocatoreMia(this.GetNomeSquadra()); //indice giocatore che vorrei scambiare (è nella mia squadra)
		int i = SearchIndiceGiocatoreNomeSquadra(this.GetNomeSquadra(), db.GetDb()[j].getRuolo()); //indice del giocatore che vorrei dal database

		int indicesquadraavversaria = SearchSquadra(s1,i);

		if(db.GetDb()[i].getSquadra().equalsIgnoreCase(squadrautente.GetNomeSquadra())){
			int dialogResult = JOptionPane.YES_NO_OPTION;
			dialogResult = JOptionPane.showConfirmDialog (null,  this.GetNomeSquadra()+"vuole scambiare un TUO giocatore, "+
					db.GetDb()[i].GetAnagrafe().GetCognome()+"con valore generale "+ 
					db.GetDb()[i].getValoreGenerale()+" con il ruolo: " +db.GetDb()[i].getRuolo()+ 
					"con il SUO giocatore: "+db.GetDb()[j].GetAnagrafe().GetCognome()+ "con valore generale "+
					db.GetDb()[j].getValoreGenerale()+ " con il ruolo: "+db.GetDb()[j].getRuolo() +"accetti?","Attenzione",dialogResult);

			if(dialogResult == JOptionPane.YES_OPTION) 			
				TrasferimentoPerScambio(db.GetDb()[i].getClass(),i,j,indicesquadraavversaria,s1);
		}
		else{
			j = SearchIndiceGiocatoreMia(this.GetNomeSquadra());
			TrasferimentoPerScambio(db.GetDb()[i].getClass(),i,j,indicesquadraavversaria,s1);
		}
	}
	///////////////////////////////////////////////////////*****************FINE DI SCAMBIO***********************//////////////////////////////

	///////////////////////////////////////////////////////***************INIZIO METODI DI SCAMBIO*********************///////////////////////

	private int SearchIndiceGiocatoreNomeSquadra(String nomesquadra, String ruolo){
		//dato che lo scambio potrebbe essere richiamato quando si hanno i minimi giocatori per ogni ruolo, facciamo un controllo 
		//per cercare di fare scambiare due giocatori con lo stesso ruolo, così da evitare sbilanciamenti.
		Random rand = new Random();
		int casuale = 0;

		ArrayList<Giocatore> array = new ArrayList<Giocatore>();
		for(int i = 0; i<db.GetDb().length;i++)
			if(db.GetDb()[i].getRuolo().equalsIgnoreCase(ruolo) && !(db.GetDb()[i].getSquadra().equalsIgnoreCase(nomesquadra))) 
				array.add(db.GetDb()[i]);
		casuale = rand.nextInt(array.toArray().length);

		return casuale;

	}

	private int SearchIndiceGiocatoreMia (String nomesquadra){ //serve per lo scambio per cercare il giocatore che voglio scambiare nella mia sq.
		Random rand = new Random();
		int casuale = 0;

		casuale = rand.nextInt(this.GetSquadra().toArray().length);

		for(int i = 0; i<db.GetDb().length; i++){
			if(db.GetDb()[i].GetAnagrafe().GetCognome().equalsIgnoreCase(this.GetSquadra().get(casuale).GetAnagrafe().GetCognome()))
				return i;
		}
		return -1;
	}

	private void TrasferimentoPerScambio (Class<? extends Giocatore> clazz, int i, int j, int indicesquadraavversaria,Squadra s1[]){
		if(clazz.cast(db.GetDb()[i]).getDotiRuolo()>((clazz.cast(db.GetDb()[j])).getDotiRuolo())){
			if((int)(Math.random()*5)+1<3){
				this.GetSquadra().add(db.GetDb()[i]);
				s1[indicesquadraavversaria].GetSquadra().add(db.GetDb()[j]);
				db.GetDb()[i].setNomeSquadra(this.GetNomeSquadra());
				db.GetDb()[j].setNomeSquadra(s1[indicesquadraavversaria].GetNomeSquadra());
				this.GetSquadra().remove(db.GetDb()[j]);
				s1[indicesquadraavversaria].GetSquadra().remove(db.GetDb()[i]);   
			}
		}
	}

	///////////////////////////////////////////////////////***************FINE METODI DI SCAMBIO***********************/////////////////////////

	///////////////////////////////////////////////////****************INIZIO ACQUISTA***********************///////////////////////////////////	

	//GetTotaleDifensori() metodo implementato nella super classe Squadra
	public void acquisto(SquadraAvversaria[] s1,SquadraUmano squadrautente){ 

		String ruolodaacquistare = new String ("");
		if(GetTotaleDifensori()<MINDIFENSORI) ruolodaacquistare = "difensore";
		else if(GetTotaleCentrocampisti()<MINCENTROCAMPISTI) ruolodaacquistare = "centrocampista";
		else if(GetTotaleAttaccanti()<MINATTACCANTI) ruolodaacquistare = "attaccante";
		else if(GetTotalePortieri()<MINPORTIERI) ruolodaacquistare = "portiere";

		int i = INITIALISE;


		if(!(ruolodaacquistare.equalsIgnoreCase(""))) {
			i = SearchIndiceGiocatore(ruolodaacquistare);
		}
		else i = SearchIndiceGiocatore();

		if(db.GetDb()[i].getSquadra().equals(squadrautente.GetNomeSquadra()))
		{
			int dialogResult = JOptionPane.YES_NO_OPTION;
			dialogResult = JOptionPane.showConfirmDialog (null,  this.GetNomeSquadra()+"vuole acquistare un tuo giocatore, "+
					db.GetDb()[i].GetAnagrafe().GetCognome()+"con valore generale "+ 
					db.GetDb()[i].getValoreGenerale()+" con il ruolo: " +db.GetDb()[i].getRuolo()+ 
					"vuoi contrattare? attenzione hai: "+squadrautente.GetTotaleAttaccanti()+" Attaccanti"+
					squadrautente.GetTotaleCentrocampisti()+" Centrocampisti"+squadrautente.GetTotaleDifensori()+" Difensori"+
					squadrautente.GetTotalePortieri()+" Portieri","Attenzione",dialogResult);
			if(dialogResult == JOptionPane.YES_OPTION)
			{
				dialogResult = JOptionPane.showConfirmDialog (null,  this.GetNomeSquadra()+"ti propone "+ 
						db.GetDb()[i].getValoreMercato()+"€"+ "Accetti? ","Attenzione",dialogResult);

				if(dialogResult == JOptionPane.YES_OPTION)
					TrasferimentoAcquistaDaUtente(this,i,squadrautente,db.GetDb()[i].getValoreMercato());				
				else
				{
					double offerta = 0;
					offerta = Offerta(db.GetDb()[i]);
					dialogResult = JOptionPane.showConfirmDialog (null,  this.GetNomeSquadra()+"ti propone "+ offerta+
							" €, per l'acquisto del giocatore, Accetti?","Attenzione",dialogResult);
					if(dialogResult == JOptionPane.YES_OPTION)
						TrasferimentoAcquistaDaUtente(this,i,squadrautente,offerta);
					else
					{
						JFrame  frame = new JFrame("Show Message Dialog");
						JOptionPane.showMessageDialog(frame,"La trattativa non si è conclusa");
						int indicesquadraavversaria = SearchSquadra(s1,i);
						if(this.GetBudget()>db.GetDb()[i].getValoreMercato())
							if(db.GetDb()[i] instanceof Difensore && s1[indicesquadraavversaria].GetTotaleDifensori()>MINDIFENSORI)
								TrasferimentoAcquista (this,i,s1,indicesquadraavversaria,db.GetDb()[i].getValoreMercato());
							else if(db.GetDb()[i] instanceof Centrocampista && s1[indicesquadraavversaria].GetTotaleCentrocampisti()>MINCENTROCAMPISTI)
								TrasferimentoAcquista (this,i,s1,indicesquadraavversaria,db.GetDb()[i].getValoreMercato());

							else if(db.GetDb()[i] instanceof Attaccante && s1[indicesquadraavversaria].GetTotaleAttaccanti()>MINATTACCANTI)
								TrasferimentoAcquista (this,i,s1,indicesquadraavversaria,db.GetDb()[i].getValoreMercato());

							else if(db.GetDb()[i] instanceof Portiere && s1[indicesquadraavversaria].GetTotalePortieri()>MINPORTIERI)
								TrasferimentoAcquista (this,i,s1,indicesquadraavversaria,db.GetDb()[i].getValoreMercato());
					}
				}
			}
			else
			{
				int indicesquadraavversaria = SearchSquadra(s1,i);
				if(this.GetBudget()>db.GetDb()[i].getValoreMercato()) 
					if(db.GetDb()[i] instanceof Difensore && s1[indicesquadraavversaria].GetTotaleDifensori()>MINDIFENSORI)
						TrasferimentoAcquista (this,i,s1,indicesquadraavversaria,db.GetDb()[i].getValoreMercato());

					else if(db.GetDb()[i] instanceof Centrocampista && s1[indicesquadraavversaria].GetTotaleCentrocampisti()>MINCENTROCAMPISTI)
						TrasferimentoAcquista (this,i,s1,indicesquadraavversaria,db.GetDb()[i].getValoreMercato());

					else if(db.GetDb()[i] instanceof Attaccante && s1[indicesquadraavversaria].GetTotaleAttaccanti()>MINATTACCANTI)
						TrasferimentoAcquista (this,i,s1,indicesquadraavversaria,db.GetDb()[i].getValoreMercato());

					else if(db.GetDb()[i] instanceof Portiere && s1[indicesquadraavversaria].GetTotalePortieri()>MINPORTIERI)
						TrasferimentoAcquista (this,i,s1,indicesquadraavversaria,db.GetDb()[i].getValoreMercato());
			}
		}
		else
		{
			int indicesquadraavversaria = SearchSquadra(s1,i);
			if(this.GetBudget()>db.GetDb()[i].getValoreMercato())
				if(db.GetDb()[i] instanceof Difensore ) 
					if (s1[indicesquadraavversaria].GetTotaleDifensori()>MINDIFENSORI)
						TrasferimentoAcquista (this,i,s1,indicesquadraavversaria,db.GetDb()[i].getValoreMercato());

				else if(db.GetDb()[i] instanceof Centrocampista) 
						if (s1[indicesquadraavversaria].GetTotaleCentrocampisti()>MINCENTROCAMPISTI)
							TrasferimentoAcquista (this,i,s1,indicesquadraavversaria,db.GetDb()[i].getValoreMercato());

				else if(db.GetDb()[i] instanceof Attaccante && s1[indicesquadraavversaria].GetTotaleAttaccanti()>MINATTACCANTI)
					TrasferimentoAcquista (this,i,s1,indicesquadraavversaria,db.GetDb()[i].getValoreMercato());

				else if(db.GetDb()[i] instanceof Portiere && s1[indicesquadraavversaria].GetTotalePortieri()>MINPORTIERI) 
					TrasferimentoAcquista (this,i,s1,indicesquadraavversaria,db.GetDb()[i].getValoreMercato());
		}
	}
	///////////////////////////////////////////////////****************FINE ACQUISTA***********************///////////////////////////////////////	
	///////////////////////////////////////////////////****************INIZIO METODI DI ACQUISTA***********************//////////////////////////	

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

	private void TrasferimentoAcquistaDaUtente (SquadraAvversaria squadra,int i,SquadraUmano squadrautente,double denaro){
		squadra.SetBudgetRemove(denaro); 
		db.GetDb()[i].setNomeSquadra(squadra.GetNomeSquadra());
		squadra.GetSquadra().add(db.GetDb()[i]);
		squadrautente.SetBudgetAdd(denaro);
		squadrautente.GetSquadra().remove(db.GetDb()[i]);
	}
	//chiedere a simo se questi due metodi posso unificarli, credi di si, ma nn sono sicuro per il casting delle squadre

	private void TrasferimentoAcquista (SquadraAvversaria squadra,int i,SquadraAvversaria squadre[],int indice,double denaro){
		squadra.SetBudgetRemove(denaro); 
		db.GetDb()[i].setNomeSquadra(squadra.GetNomeSquadra());
		squadra.GetSquadra().add(db.GetDb()[i]);
		squadre[indice].SetBudgetAdd(denaro);
		squadre[indice].GetSquadra().remove(db.GetDb()[i]);
	}

	private int SearchIndiceGiocatore(String ruolo){
		ArrayList <Giocatore> tmp = new ArrayList <Giocatore>();
		for(int i = 0; i<db.GetDb().length;i++){
			if(ruolo.equalsIgnoreCase("Difensore") && db.GetDb()[i] instanceof Difensore){
				tmp.add((Difensore)db.GetDb()[i]);
			}
			else if(ruolo.equalsIgnoreCase("Centrocampista") && db.GetDb()[i] instanceof Centrocampista){
				tmp.add((Centrocampista)db.GetDb()[i]);
			}
			else if(ruolo.equalsIgnoreCase("Attaccante") && db.GetDb()[i] instanceof Attaccante){
				tmp.add((Attaccante)db.GetDb()[i]);
			}
			else if(ruolo.equalsIgnoreCase("Portiere") && db.GetDb()[i] instanceof Portiere){
				tmp.add((Portiere)db.GetDb()[i]);
			}
		}
		Random rand = new Random();
		int casuale = rand.nextInt(tmp.size());
		for(int i = 0; i<db.GetDb().length ;i++){
			Giocatore g = (Giocatore) tmp.toArray()[casuale];
			if(db.GetDb()[i].GetAnagrafe().GetCognome().equals(g.GetAnagrafe().GetCognome())) return i;
		}
		return -1;
	}

	private int SearchIndiceGiocatore(){
		Random rand = new Random();
		int casuale = rand.nextInt(db.GetDb().length);
		return casuale;
	}
	///////////////////////////////////////////////////////****************FINE METODI DI ACQUISTA***********************//////////////////////////////	
	///////////////////////////////////////////////////////****************INIZIO ORGA.SQUADRA***********************//////////////////////////////	

	public Giocatore[] OrganizzaSquadra(){
		Giocatore array[] = new Giocatore [15];
		int j = 0;
		int indicegiocatoremigliore = INITIALISE ;
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
			if(db.GetDb()[arrayausiliario[z]] instanceof Portiere && portiere == false){
				indicegiocatoremigliore = SearchBestPlayer(arrayausiliario,"Portiere");
				portiere = true;
			}
			else{
				if(db.GetDb()[arrayausiliario[z]] instanceof Difensore && difensore == false){
					indicegiocatoremigliore = SearchBestPlayer(arrayausiliario,"Difensore");
					difensore = true;
				}
				else{
					if(db.GetDb()[arrayausiliario[z]] instanceof Centrocampista && centrocampista == false){
						indicegiocatoremigliore = SearchBestPlayer(arrayausiliario,"Centrocampista");
						portiere = true;
					}
					else{
						if(db.GetDb()[arrayausiliario[z]] instanceof Attaccante && attaccante == false){
							indicegiocatoremigliore = SearchBestPlayer(arrayausiliario,"Attaccante");
							attaccante = true;
						}

					}
				}
			}
			array[z] = db.GetDb()[indicegiocatoremigliore];
		}
		return array;
	}
	///////////////////////////////////////////////////////****************FINE ORGA.SQUADRA***********************//////////////////////////////	
	///////////////////////////////////////////////////////****************INIZIO METODI ORGA.SQUADRA***********************/////////////////////
	private int SearchBestPlayer(int array[],String ruolo){
		//array vettore degli indici che si riferiscono al database
		int migliore = -1; //indice del migliore nel database

		int j = 0;
		for(int i = 0; i<array.length; i++){
			if(db.GetDb()[array[i]].getRuolo().equalsIgnoreCase(ruolo)){
				j++;
			}
		}
		int vett [] = new int [j];
		int z = 0;
		for(int i = 0; i<array.length; i++){
			if(db.GetDb()[array[i]].getRuolo() == ruolo){
				vett[z] = i;
			}
		}

		for(int i = 0; i<vett.length-1;i++){
			if(db.GetDb()[vett[i]].getValoreGenerale() > db.GetDb()[vett[i+1]].getValoreGenerale()
					&& db.GetDb()[vett[i]].getCondizione() > db.GetDb()[vett[i+1]].getCondizione()){
				migliore = i;
			}
			else migliore = i+1;
		}
		return migliore;
	}

	private int SearchIndiceGiocatoreCognome (String Cognome){ 
		for(int i = 0; i<db.GetDb().length; i++){
			if(db.GetDb()[i].GetAnagrafe().GetCognome().equalsIgnoreCase(Cognome)) return i;
		}
		return -1;
	}

	///////////////////////////////////////////////////////****************FINE METODI ORGA.SQUADRA***********************///////////////////////

	//////////////////////////////////////////////////////****************INIZIO METODI IN COMUNE************************///////////////////////
	private int SearchSquadra(SquadraAvversaria[] s, int i){
		for(int j = 0; j<s.length; j++){
			if(db.GetDb()[i].getSquadra().equalsIgnoreCase(s[j].GetNomeSquadra())) return j;
		}
		return -1;
	}
	//////////////////////////////////////////////////////****************FINE METODI IN COMUNE************************////////////////////////

}
