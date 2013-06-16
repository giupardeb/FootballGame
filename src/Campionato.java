import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.text.DefaultCaret;
import Graphic.FinestraScambio;

public class Campionato 
{
	SquadraUmano squadra;

	SquadraAvversaria squadre[] = new SquadraAvversaria [18];

	DatabaseGiocatori db;

	boolean continua = false;


	public Campionato(String miasquadra) //la squadra che l'utente sceglie viene decisa nel main.. tanto per fargli fare qualcosa dal main.. 
	{
		db = new DatabaseGiocatori();
		squadra = db.CreaSquadra(miasquadra);

		for(int i = 0; i<squadre.length; i++){
			squadre[i] = db.CreaSquadre(miasquadra);
			if(squadre[i] == null) i--;
		}


		System.out.println("1.Vedere la classifica attuale");
		System.out.println("2.Gioca una partita");
		System.out.println("3.Calciomercato");
		System.out.println("4.Esci");

		int scelta = Integer.parseInt(JOptionPane.showInputDialog("cosa vuoi fare?")); //input da finestra

		switch(scelta){

		case 1: System.out.println("Metodo CLASSIFICA");
		break;

		case 2: System.out.println("Metodo partita");
		break;

		case 3: 
			//inserire un ciclo in maniera tale che le squadre avversarie facciano il calciomercato e controllino se è meglio effettuare uno
			//scambio oppure un' acquisto (che fa..la facciamo a random ??)
			System.out.println("1. acquista");
			System.out.println("2.scambio");
			Giocatore [] giocatoridavisualizzare = null;

			int scelta1 = Integer.parseInt(JOptionPane.showInputDialog("cosa vuoi fare?")); //input da finestra
			switch(scelta1){

			case 1:
				System.out.println("1.Attaccante");
				System.out.println("2.Centrocampista");
				System.out.println("3.Difensore");
				System.out.println("4.Portiere");
				int scelta2 = Integer.parseInt(JOptionPane.showInputDialog("cosa vuoi fare?")); //input da finestra
				switch(scelta2){
				case 1: 
					//fa visualizzare solo l'ultimo elemento inserito. CHECK!!!!
					giocatoridavisualizzare = VisualizzaGiocatori("Attaccante", squadra.GetNomeSquadra());
					for(int i = 0; i<giocatoridavisualizzare.length;i++){
						//finestra.getAreaGiocMia().append(i+". "+giocatoridavisualizzare[i] + "\n");
					}
			//		finestra.Go();
					//System.out.println(i+". "+giocatoridavisualizzare[i]); 
					Trasferimento();
					break;

				case 2:
					giocatoridavisualizzare = VisualizzaGiocatori("Centrocampista", squadra.GetNomeSquadra());
					for(int i = 0; i<giocatoridavisualizzare.length;i++)
						System.out.println(i+". "+giocatoridavisualizzare[i]); 

					Trasferimento();

					break;

				case 3:
					giocatoridavisualizzare = VisualizzaGiocatori("Difensore", squadra.GetNomeSquadra());
					for(int i = 0; i<giocatoridavisualizzare.length;i++)
						System.out.println(i+". "+giocatoridavisualizzare[i]);

					Trasferimento();
					break;

				case 4: giocatoridavisualizzare = VisualizzaGiocatori("Portiere", squadra.GetNomeSquadra());
				for(int i = 0; i<giocatoridavisualizzare.length;i++)
					System.out.println(i+". "+giocatoridavisualizzare[i]);
				Trasferimento();
				break;

				}

			case 2: System.out.println("Metodo scambio");
			FinestraScambio finestra = new FinestraScambio();
			giocatoridavisualizzare = VisualizzaGiocatori(squadra.GetNomeSquadra());

			for(int i = 0; i<giocatoridavisualizzare.length;i++)
				finestra.getAreaGiocAvv().append(i+". "+giocatoridavisualizzare[i] + "\n");
			
			giocatoridavisualizzare = VisualizzaGiocatoriMiei();
			finestra.getAreaGiocMia().append("\n\n");
			for(int i = 0; i<giocatoridavisualizzare.length;i++)
				finestra.getAreaGiocMia().append(i+". "+giocatoridavisualizzare[i] + "\n");
			
			finestra.Go();

			String sceltagiocatore = 
			String	Scelta [] = sceltagiocatore.split(",");

			squadra.scambio(Scelta[0].trim(), Scelta[1].trim(), squadre[SearchSquadra(Scelta[2].trim())]);
			break;

			}
			break;

		case 4: System.out.println("esci dal gioco");
		}
	}



	private int SearchSquadra(String nome){
		for(int i = 0; i<squadre.length;i++)
			if (squadre[i].GetNomeSquadra().equalsIgnoreCase(nome)) return i;
		return -1;

	}

	private Giocatore [] VisualizzaGiocatori(String ruolo, String squadrautente){
		ArrayList <Giocatore> giocatoridavisualizzare = new ArrayList <Giocatore>();
		for(int z = 0; z<squadre.length;z++)
			for(Giocatore giocatore : squadre[z].GetSquadra())
				if(giocatore.getRuolo().equalsIgnoreCase(ruolo) && (!(giocatore.getSquadra().equalsIgnoreCase(squadrautente))))	
					giocatoridavisualizzare.add(giocatore);
		return giocatoridavisualizzare.toArray(new Giocatore [giocatoridavisualizzare.size()]);
	}
	
	//per lo scambio..
	private Giocatore [] VisualizzaGiocatori(String squadrautente){
		ArrayList <Giocatore> giocatoridavisualizzare = new ArrayList <Giocatore>();
		for(int z = 0; z<squadre.length;z++)
			for(Giocatore giocatore : squadre[z].GetSquadra())
				if(!(giocatore.getSquadra().equalsIgnoreCase(squadrautente)))
					giocatoridavisualizzare.add(giocatore);
		return giocatoridavisualizzare.toArray(new Giocatore [giocatoridavisualizzare.size()]);
	}
	
	private Giocatore [] VisualizzaGiocatoriMiei(){
		ArrayList <Giocatore> giocatoridavisualizzare = new ArrayList <Giocatore>();
			for(Giocatore giocatore : squadra.GetSquadra())
					giocatoridavisualizzare.add(giocatore);
		return giocatoridavisualizzare.toArray(new Giocatore [giocatoridavisualizzare.size()]);
	}

	private void Trasferimento(){
		do{
			String sceltagiocatore = (JOptionPane.showInputDialog("Inserisci il COGNOME del giocatore che vorresti acquistare " +
					"e la SQUADRA appartenente separati da una virgola (es.Totti,roma): ")); //input da finestra
			String	giocatoresquadra [] = sceltagiocatore.split(",");
			squadra.acquisto(giocatoresquadra[0].trim(), squadre[SearchSquadra(giocatoresquadra[1].trim())]);
			System.out.println("Vuoi acquistare ancora? si o no: ");
			Scanner tastiera = new Scanner (System.in);
			String ricontinua = "";
			if (tastiera.hasNextLine())
				ricontinua = tastiera.nextLine().trim(); //continua ad acquistare
			tastiera.close();
			if(ricontinua.equalsIgnoreCase("si")) continua = true;
		}
		while(continua == true);
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

    }*/
}