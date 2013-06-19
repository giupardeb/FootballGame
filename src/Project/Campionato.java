package Project;
import graphic.*;

import java.util.ArrayList;

import javax.swing.JFrame;

public class Campionato 
{
	public SquadraUmano squadra;

	public SquadraAvversaria squadre[] = new SquadraAvversaria [18];

	DatabaseGiocatori db;

	String continua = ""; //utile per i cicli

	public Giocatore [] giocatoridavisualizzare = null;

	public Campionato(String miasquadra) //la squadra che l'utente sceglie viene decisa nel main.. tanto per fargli fare qualcosa dal main.. 
	{
		db = new DatabaseGiocatori();
		squadra = db.CreaSquadra(miasquadra);
		for(int i = 0; i<squadre.length; i++){
			squadre[i] = db.CreaSquadre(miasquadra);
			if(squadre[i] == null) i--;
		}


		FinestraCampionato f = new FinestraCampionato(this);
	}



	public int SearchSquadra(String nome){
		for(int i = 0; i<squadre.length;i++)
			if (squadre[i].GetNomeSquadra().equalsIgnoreCase(nome)) return i;
		return -1;

	}

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
		FinestraCampionato fc = new FinestraCampionato(this);
	}

	public void Calciomercato(JFrame frame){
		frame.dispose();
		SceltaScambioAcquista Scelta = new SceltaScambioAcquista(this); 
	}


}


/*public Squadra partita (Squadra a,Squadra b){

		boolean vinto;
	   	Giocatore provvC = new Giocatore ();
       	Giocatore provvCavv = new Giocatore ();
       	Giocatore provvA = new Giocatore ();



	    a.arrg[5].pallasi();
	    provvC = a.arrg[5].cntrcaso(a.arrg[6],a.arrg[7]);
	    //calcio d'inizio squadra A
	  	a.arrg[5].calcioInizio(provvC);
	    //scontro cntrA vs cntrB
	 	provvCavv = b.arrg[5].acasoNo(b.arrg[6],b.arrg[7]);
	 	vinto = provvC.Scontro(provvCavv);
	 	provvDavv = b.arrg[1].difcaso(b.arrg[2],b.arrg[3],b.arrg[4]);
	   	provvA = a.arrg[8].acaso(a.arrg[9],a.arrg[10]);

	   	int var;
	   	if(vinto)
	   		var=1;
	   	else var=2;
	   	switch (var){
	   		case 1:
	   			provvC.passaggio(provvA);
	   			//nul provvC, Scontro attaccante A difensore B
	   			vinto = provvA.Scontro(provvDavv);
	   			if(vinto)
	   				var=3;
	   			else var=4;
	   			switch(var){
	   				case 3:
	   					//Attaccante A passa la palla a un attaccante A il quale tirerà, dopo aver vinto lo scontro col difensore B
	   					provvC=provvA.acasoNo(a.arrg[8],a.arrg[9],a.arrg[10]);
	   					provvA.passaggio(provvC);
	   					//nul provvA, attaccante A tira in porta
	   					vinto=provvC.Gol(b.arrg[0]);
	   					if(vinto){
	   						a.punteggio++;
	   						var=3;
	   						break;
	   						//calcio d'inizio dei B
	   					}
	   					else{
	   						//dif B a caso al quale il portiere passa la palla, dopo la parata
	   						provvDavv = b.arrg[1].difcaso(b.arrg[2],b.arrg[3],b.arrg[4]);
	   						b.arrg[0].passaggio(provvDavv);
	   						//centrocampista B a caso al quale il difensore B passa la palla
	   						provvA = a.arrg[5].cntrcaso(a.arrg[6],a.arrg[7]);
	   						provvDavv.passaggio(provvA);
	   						var=2;
	   						break;
	   						//la palla a centrocampo dei B salta al case 2 sotto
	   					}
	   				case 4:
	   						//centrocampista B a caso al quale il difensore B passa la palla, dopo aver vinto lo scontro con l'attaccante A
	   						provvA = b.arrg[5].cntrcaso(b.arrg[6],b.arrg[7]);
	   						provvDavv.passaggio(provvA);
	   						var=2;
	   						break;
	   						//la palla a centrocampo dei B salta al case 2 sotto
	   			}
	   			break;
	   		case 2:// centrocampista B guadagna la palla dopo aver vinto lo scontro con il centrocampista A
	   				provvC.perdepalla(provvCavv);
	   				var=2;
	   				break;
	   				//case 2 sotto palla a centrocampo B
	   	}

		//la palla è a centrocampo

		switch (var){
			case 2:
					//centrocampista B passa a un attaccante B a caso
					provvA.acaso(b.arrg[8],b.arrg[9],b.arrg[10]);
					provvCavv.passaggio(ProvvA);
				   	//difensore A a caso che contrasterà l'attaccante B
					provvDavv = a.arrg[1].difcaso(a.arrg[2],a.arrg[3],a.arrg[4]);
	   				vinto = provvA.Scontro(provvDavv);
	   			if(vinto)
	   				var=5;
	   			else var=6;
	   			switch(var){
	   				case 5:
	   					//Attaccante B che ha vinto il contrasto col difensore A passa a un attaccante B a caso che tirerà in porta
	   					provvC=provvA.acasoNo(b.arrg[8],b.arrg[9],b.arrg[10]);
	   					provvA.passaggio(provvC);
	   					//nul provvA
	   					vinto=provvC.Gol(a.arrg[0]);
	   					if(vinto){
	   						b.punteggio++;
	   						break;
	   						//calcio d'inizio A
	   					}
	   					else{
	   						//dif A al quale il portiere passa la palla, dopo la parata
	   						provvDavv = a.arrg[1].difcaso(a.arrg[2],a.arrg[3],a.arrg[4]);
	   						a.arrg[0].passaggio(provvDavv);
	   						//centrocampista A a caso al quale il difensore B passa la palla
	   						provvA = a.arrg[5].cntrcaso(a.arrg[6],a.arrg[7]);
	   						provvDavv.passaggio(provvA);
	   						var=1;
	   						break;
	   						//palla A a centrocampo case 1 sopra
	   					}
	   				case 6:
	   						//centrocampista A a caso al quale il difensore A passa la palla, dopo aver vinto lo scontro con l'attaccante B
	   						provvA = a.arrg[5].cntrcaso(a.arrg[6],a.arrg[7]);
	   						provvDavv.passaggio(provvA);
	   						var 1;
	   						break;
	   						//palla A a centrocampo case 1 sopra
	   			}
	   			break;
	   		case 3 //calcio d'inizio dei B cntr B passa a cntr B poi case 2
	   		case //sistemare calcio d'inizio A
	   	}








       provvD = difAvv1.difcaso(difAvv2,difAvv3,difAvv4);

       if(provvC.DifAtt(provvD)==false){
	       provvC.perdePalla(provvD);
	       System.out.println(provvD.nome+" entra in takle e prende palla a "+provvC.nome);
	       provvC = cntrAvv1.cntrcaso(cntrAvv2,cntrAvv3);
	       provvD.passaggio(provvC);
       }
       else{
       		System.out.println(provvC.nome+" vince lo scontro con " +provvD.nome);
			System.out.println(provvC.nome+" tenta il tiro");
			if(provvC.Gol(p2)){
				System.out.println(provvC.nome+" della squadra 1 ha fatto gol");
			}
			else
				System.out.println("Parata del portiere della squadra 2");
		}

    }
}*/