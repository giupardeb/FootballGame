package Project;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.util.Random;


public class SquadraAvversaria extends Squadra{

	//Queste costanti li dobbiamo modificare credo, poichè non si effettuerebbe il calciomercato dato
	//che tutte le squadre hanno il minimo di calciotori possibili

	//Servono per l'organizzazione della squadra

	/**
	 * @uml.property  name="pORTIERI"
	 */
	final int PORTIERI = 1;
	/**
	 * @uml.property  name="dIFENSORI"
	 */
	final int DIFENSORI = 4;
	/**
	 * @uml.property  name="cENTROCAMPISTI"
	 */
	final int CENTROCAMPISTI = 4;
	/**
	 * @uml.property  name="aTTACCANTI"
	 */
	final int ATTACCANTI = 2;


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
			i = SearchIndiceGiocatore(ruolodaacquistare,db.getGiocatoriInVendita());
			if(i == -1) i = SearchIndiceGiocatore(ruolodaacquistare);
		}
		else {
			i = SearchIndiceGiocatore(db.getGiocatoriInVendita());
			if(i == -1) i = SearchIndiceGiocatore();
		}
		boolean acquistofatto = false;

		while(db.GetDb()[i].getSquadra().equalsIgnoreCase(squadrautente.GetNomeSquadra()) && acquistofatto != true)
		{
			if(AcquistaDaUtente(squadrautente,i)){
				acquistofatto = true;
			}
			else{
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
				acquistofatto = true;
			}

		}
	}
	///////////////////////////////////////////////////****************FINE ACQUISTA***********************///////////////////////////////////////	
	///////////////////////////////////////////////////****************INIZIO METODI DI ACQUISTA***********************//////////////////////////	


	private boolean AcquistaDaUtente(SquadraUmano squadrautente, int i){
		int dialogResult = JOptionPane.YES_NO_OPTION;
		dialogResult = JOptionPane.showConfirmDialog (null,  this.GetNomeSquadra()+" vuole acquistare un tuo giocatore, "+
				db.GetDb()[i].GetAnagrafe().GetCognome()+" con valore generale "+ 
				db.GetDb()[i].getValoreGenerale()+" con il ruolo: " +db.GetDb()[i].getRuolo()+ 
				". vuoi contrattare? attenzione hai: "+squadrautente.GetTotaleAttaccanti()+" Attaccanti "+
				squadrautente.GetTotaleCentrocampisti()+" Centrocampisti "+squadrautente.GetTotaleDifensori()+" Difensori "+
				squadrautente.GetTotalePortieri()+" Portieri ","Attenzione",dialogResult);
		if(dialogResult == JOptionPane.YES_OPTION)
		{
			dialogResult = JOptionPane.showConfirmDialog (null,  this.GetNomeSquadra()+" ti propone "+ 
					db.GetDb()[i].getValoreMercato()+"€"+ " Accetti? ","Attenzione",dialogResult);

			if(dialogResult == JOptionPane.YES_OPTION){
				TrasferimentoAcquistaDaUtente(this,i,squadrautente,db.GetDb()[i].getValoreMercato());
				return true;
			}
			else
			{
				double offerta = 0;
				offerta = Offerta(db.GetDb()[i]);
				dialogResult = JOptionPane.showConfirmDialog (null,  this.GetNomeSquadra()+" ti ripropone "+ offerta+
						" €, per l'acquisto del giocatore, Accetti?","Attenzione",dialogResult);
				if(dialogResult == JOptionPane.YES_OPTION){
					TrasferimentoAcquistaDaUtente(this,i,squadrautente,offerta);
					return true;
				}
				else
				{
					JFrame  frame = new JFrame("Show Message Dialog");
					JOptionPane.showMessageDialog(frame,"La trattativa non si è conclusa");
					return false;
				}
			}
		}
		else return false;
	}




	private int SearchIndiceGiocatore(ArrayList<Giocatore> giocatoriInVendita) {
		Giocatore tmp1[] =  giocatoriInVendita.toArray(new Giocatore[giocatoriInVendita.size()]);
		if(tmp1.length != 0){
			Random rand = new Random();
			int casuale = rand.nextInt(tmp1.length);
			Giocatore g = tmp1[casuale];

			for(int i = 0; i<db.GetDb().length ;i++)
				if(db.GetDb()[i].GetAnagrafe().GetCognome().equals(g.GetAnagrafe().GetCognome()))
					return i;
			return -1;
		}
		else return -1;
	}

	private int  SearchIndiceGiocatore(String ruolo,ArrayList<Giocatore> giocatoriInVendita) {

		ArrayList <Giocatore> tmp = new ArrayList <Giocatore>();

		Giocatore tmp1[] =  giocatoriInVendita.toArray(new Giocatore[giocatoriInVendita.size()]);
		if(tmp1.length != 0){
			for(int i = 0; i<tmp1.length;i++){
				if(ruolo.equalsIgnoreCase("Difensore") && tmp1[i] instanceof Difensore){
					tmp.add((Difensore)tmp1[i]);
				}
				else if(ruolo.equalsIgnoreCase("Centrocampista") && tmp1[i] instanceof Centrocampista){
					tmp.add((Centrocampista)tmp1[i]);
				}
				else if(ruolo.equalsIgnoreCase("Attaccante") && tmp1[i] instanceof Attaccante){
					tmp.add((Attaccante)tmp1[i]);
				}
				else if(ruolo.equalsIgnoreCase("Portiere") && tmp1[i] instanceof Portiere){
					tmp.add((Portiere)tmp1[i]);
				}
			}
			Random rand = new Random();
			int casuale = rand.nextInt(tmp.size());
			for(int i = 0; i<db.GetDb().length ;i++){
				Giocatore g =  (Giocatore) tmp.toArray()[casuale];
				if(db.GetDb()[i].GetAnagrafe().GetCognome().equals(g.GetAnagrafe().GetCognome())) return i;
			}
		}

		return -1;
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
		Giocatore array[] = new Giocatore [11];
		int j = 0;
		Integer indicegiocatoremigliore = INITIALISE ;

		for(@SuppressWarnings("unused") Giocatore i : this.GetSquadra()) j++; //conta i giocatori

		//	int arrayausiliario [] = new int[j]; //conterrà gli indici del database dei giocatori della squadra
		//	int z = 0;
		ArrayList<Integer> arrayausiliario = new ArrayList <Integer>(j);

		for(Giocatore i : this.GetSquadra()) arrayausiliario.add(SearchIndiceGiocatoreCognome(i.GetAnagrafe().GetCognome()));

		//	arrayausiliario[z] = SearchIndiceGiocatoreCognome(i.GetAnagrafe().GetCognome()); 
		//		z++;

		boolean finito = false;

		int portieri = 0,centrocampisti = 0,attaccanti = 0, difensori = 0;


		int f = 0;
		int arrayausiliario1 [] = new int[arrayausiliario.size()];
		for(Integer indice : arrayausiliario){
			arrayausiliario1[f] = indice;
			f++;
		}

		int k = 0;

		for( int z = 0; z<arrayausiliario1.length && !finito;z++){
			//	for(Integer i : arrayausiliario){
			finito = false;

			if(db.GetDb()[arrayausiliario1[z]] instanceof Portiere && portieri != PORTIERI ){
				indicegiocatoremigliore = SearchBestPlayer(arrayausiliario,"Portiere");
				portieri++;
				arrayausiliario.remove(indicegiocatoremigliore);
				if(k<11){
					array[k] = db.GetDb()[indicegiocatoremigliore];
					k++;
				}
				else finito = true;
			}
			else if(db.GetDb()[arrayausiliario1[z]] instanceof Difensore && difensori != DIFENSORI ){
				indicegiocatoremigliore = SearchBestPlayer(arrayausiliario,"Difensore");
				difensori++;
				arrayausiliario.remove(indicegiocatoremigliore);
				if(k<11){
					array[k] = db.GetDb()[indicegiocatoremigliore];
					k++;
				}
				else finito = true;
			}
			else if(db.GetDb()[arrayausiliario1[z]] instanceof Centrocampista && centrocampisti != CENTROCAMPISTI ){
				indicegiocatoremigliore = SearchBestPlayer(arrayausiliario,"Centrocampista");
				centrocampisti++;
				arrayausiliario.remove(indicegiocatoremigliore);
				if(k<11){
					array[k] = db.GetDb()[indicegiocatoremigliore];
					k++;
				}
				else finito = true;
			}
			else if(db.GetDb()[arrayausiliario1[z]] instanceof Attaccante && attaccanti != ATTACCANTI){
				indicegiocatoremigliore = SearchBestPlayer(arrayausiliario,"Attaccante");
				attaccanti++;
				arrayausiliario.remove(indicegiocatoremigliore);

				if(k<11){
					array[k] = db.GetDb()[indicegiocatoremigliore];
					k++;
				}
				else finito = true;
			}
			if(k == 11) finito = true;
		}
		return array;
	}
	///////////////////////////////////////////////////////****************FINE ORGA.SQUADRA***********************//////////////////////////////	
	///////////////////////////////////////////////////////****************INIZIO METODI ORGA.SQUADRA***********************/////////////////////
	private int SearchBestPlayer(/*int array[]*/ ArrayList <Integer>array,String ruolo){
		//array vettore degli indici che si riferiscono al database
		int migliore = INITIALISE; //indice del migliore nel database

		int j = 0;
		//	for(int i = 0; i<array.length; i++){
		for (Integer i : array)
			if(db.GetDb()[/*array[*/i.intValue()/*]*/].getRuolo().equalsIgnoreCase(ruolo)) j++;

		int vett [] = new int [j];
		for (int i=0; i<vett.length; i++) vett[i] = -1;
		int z = 0;
		//	for(int i = 0; i<array.length; i++){ 
		for(Integer i : array){
			if(db.GetDb()[/*array[*/i.intValue()/*]*/].getRuolo().equalsIgnoreCase(ruolo)){
				vett[z] = /*array[*/i.intValue()/*]*/;
				z++;
			}
		}

		for(int i = 0; i<vett.length-1;i++){
			if(db.GetDb()[vett[i]].getMorale() > db.GetDb()[vett[i+1]].getMorale()
					&& db.GetDb()[vett[i]].getCondizione() > db.GetDb()[vett[i+1]].getCondizione()){
				migliore = vett[i];
			}
			else migliore = vett[i+1];
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
