package Project;

import java.awt.Point;

abstract class AltriRuoli extends Giocatore
{
	private byte cross;
	private byte dribling;
	private byte colpoDiTesta;
	private byte passaggio;
	private byte tiro;
	private byte contrasto;
	private byte movimento;
	private byte abilitaDifesa;
	private byte abilitaAttacco;
	private byte abilitaCentrocampo;
	
	//metodi per metodo constrasto
	private final int CONTRASTO = 1;
	private final int NIENTECONTRASTO = 2;
	private final int CONTRASTOPERSO = 4; 
	private final int NUMrIUSCITAsCARSOcONaBILITÀ = 6;
	private final int NUMrIUSCITAsCARSO = 8;
	private final int NUMrIUSCITAmEDIO = 7;
	private final int NUMrIUSCITAbRAVO = 3;
	private final int MINABILITAPERBONUS = 70;
	//FINE

	private final int ABILITAPASSAGGIOSCARSO = 50;
	private final int ABILITAPASSAGGIOBUONE = 70;
	
	private final int PERCENTUALE = 100;
	
	//Costanti per il metodo tiro
	private final int GOAL = 7;
	private final int PARATA = 9;
	private final int FUORI = 10;
	private final int INTERCETTATA = 11;
	private final int ABILITADITIROBUONE = 80; 
	private final int ABILITADITIRODISCRETE = 70; 
	private final int ABILITADITIROSCARSE = 60;
	private final int COSTANTEPERRIUSCITATIROBUONE = 3; 
	private final int COSTANTEPERRIUSCITATIROMEDIE = 5; 
	private final int COSTANTEPERRIUSCITATIROSCARSE = 7;
	private final int ABILITADIATTACCOMINIME = 65;
	private final int ABILITADIATTACCOMASSIME = 75;
	private final int ABILITADIDIFESAMINIME = 65;
	private final int ABILITADIDIFESAMASSIME = 75;
	private final int ABILITADIPARATABUONE = 80; 
	private final int ABILITADIPARATADISCRETE = 70; 
	private final int ABILITADIPARATASCARSE = 60;
	//FINE
	


	public AltriRuoli(String cognome,String squadra,String nazionalita,byte velocita,byte resistenza,
			byte forza,byte morale,byte eta,byte condizione,byte tecnica,byte aggressivita,
			byte creativita,byte decisione,byte carisma,String posizione,byte giocoDiSquadra,
			boolean essenziale,byte mediaVoti,byte cross,byte dribling,byte colpoDiTesta,
			byte passaggio, byte tiro, byte contrasto, byte movimento, byte abilitaDifesa,
			byte abilitaAttacco,byte abilitaCentrocampo,byte valoreGenerale,double valoreMercato){

		super (cognome, squadra, nazionalita, velocita, resistenza, forza, morale, eta,condizione, 
				tecnica, aggressivita, creativita, decisione, carisma, posizione, giocoDiSquadra,
				essenziale,mediaVoti,valoreGenerale,valoreMercato);

		this.cross = cross;
		this.dribling = dribling;
		this.colpoDiTesta = colpoDiTesta;
		this.passaggio = passaggio;
		this.tiro = tiro;
		this.contrasto = contrasto;
		this.movimento = movimento;
		this.abilitaDifesa = abilitaDifesa;
		this.abilitaAttacco = abilitaAttacco;
		this.abilitaCentrocampo = abilitaCentrocampo;
	}

	//metodi di get()

	public byte getCross()
	{
		return(cross);
	}

	public byte getDribling()
	{
		return(dribling);
	}

	public byte getColpoDiTesta()
	{
		return(colpoDiTesta);
	}

	public byte getPassaggio()
	{
		return(passaggio);
	}

	public byte getTiro()
	{
		return(tiro);
	}

	public byte getContrasto()
	{
		return(contrasto);
	}

	public byte getMovimento()
	{
		return(movimento);
	}

	public byte getAbilitaDifesa()
	{
		return(abilitaDifesa);
	}

	public byte getAbilitaAttacco()
	{
		return(abilitaAttacco);
	}

	public byte getAbilitaCentrocampo()
	{
		return(abilitaCentrocampo);
	}


	//metodi di set()

	public void setCross(byte valore)
	{
		cross += valore;

		if(cross >= 100)
			cross = 100;

	}

	public void setDribling(byte valore)
	{
		dribling += valore;

		if(dribling >= 100)
			dribling = 100;

	}

	public void setColpoDiTesta(byte valore)
	{
		colpoDiTesta += valore;

		if(colpoDiTesta >= 100)
			colpoDiTesta = 100;

	}

	public void setPassaggio(byte valore)
	{
		passaggio += valore;

		if(passaggio >= 100)
			passaggio = 100;

	}

	public void setTiro(byte valore)
	{
		tiro += valore;

		if(tiro >= 100)
			tiro = 100;

	}

	public void setcontrasto(byte valore)
	{
		contrasto += valore;

		if(contrasto >= 100)
			contrasto = 100;

	}

	public void setMovimento(byte valore)
	{
		movimento += valore;

		if(movimento >= 100)
			movimento = 100;

	}

	public void setabilitaDifesa(byte valore)
	{
		abilitaDifesa += valore;

		if(abilitaDifesa >= 100)
			abilitaDifesa = 100;

	}

	public void setabilitaAttacco(byte valore)
	{
		abilitaAttacco += valore;

		if(abilitaAttacco >= 100)
			abilitaAttacco = 100;

	}

	public void setabilitaCentrocampo(byte valore)
	{
		abilitaCentrocampo += valore;

		if(abilitaCentrocampo >= 100)
			abilitaCentrocampo = 100;

	}

	public void setValoreGenerale()
	{
		int media = 0;

		media = (getCross()+ getDribling()+ getColpoDiTesta() + getPassaggio() + getTiro() + 
				getContrasto() + getMovimento() + getAbilitaDifesa() + getAbilitaAttacco() + 
				getAbilitaCentrocampo()+ getVelocita() + getResistenza() + getForza() + getMorale() 
				+ getCondizione() + getTecnica() + getAggressivita() + getCreativita() + getDecisione()
				+ getCarisma() + getGiocoDiSquadra());

		media = (byte)(media/21);

	}

//NON DOVREBBERO ESSERCI PROBLEMI.. KMQ BISOGNEREBBE PROVARLO
	public Point Passaggio(Giocatore campo [][]){ //int così capisco se la palla è andata fuori così posso darla alla squadra avversaria + versatile
		Point p = this.posizione.getLocation();
		Point newp = ControllaPosGioc(p,campo);
		
		if(this.getPassaggio()<ABILITAPASSAGGIOSCARSO)
			if((int)(Math.random()*10)+1>NUMrIUSCITAsCARSO) return newp;
		else
			if(this.getPassaggio()<ABILITAPASSAGGIOBUONE)
				if((int)(Math.random()*10)+1>NUMrIUSCITAmEDIO) return newp;
			else if((int)(Math.random()*10)+1>NUMrIUSCITAbRAVO) return newp;
		
		return null;
	}


	public Point ControllaPosGioc(Point p,Giocatore campo [][]){
		Point p1 = new Point();
		if((int)Math.random()*2 == 0){
			p1.setLocation(p.getX(), p.getY()-1);
			if(campo[(int) p1.getX()][(int) p1.getY()] == null){
				if((int)Math.random()*2 == 0){
					p1.setLocation(p.getX(), p.getY()+1);
				}
				else{
					p1.setLocation(p.getX()+2, p.getY());
					if(campo[(int)p1.getX()][(int)p1.getY()] == null){
						p1.setLocation(p.getX(), p.getY()+1);
					}
				}
			}
		}
		else{
			p1.setLocation(p.getX()+2, p.getY());
			if(campo[(int)p1.getX()][(int)p1.getY()] == null){
				p1.setLocation(p.getX(), p.getY()+1);
				if(campo[(int)p1.getX()][(int)p1.getY()] == null){
					p1.setLocation(p.getX(), p.getY()+1);
				}
			}
				
		}
		return p1;
		
	}
	
	
	////////****METODO CONTRASTO///*/*/*/*////***
	
	public int Contrasto(Giocatore campo[][], byte abilita){ //in maniera tale che se una squadra ha più abilità difensive è più probabile che 
																//vincerà un contrasto
		Point p = this.posizione.getLocation();
		Point pavv = new Point((int)p.getX()+1,(int)p.getY()); // posizione giocatore avversario
		
		if(campo[(int) pavv.getX()][(int) p.getY()] != null){
			if(this.getDotiRuolo() >= campo[(int) pavv.getX()][(int) p.getY()].getDotiRuolo()){
				if(((int)Math.random()*10)+1>NUMrIUSCITAbRAVO){
					return CONTRASTO;
				}
				else return CONTRASTOPERSO;
			}
			else if(this.getDotiRuolo()>=CalcolaDotiIntermedie(campo[(int) pavv.getX()][(int) p.getY()].getDotiRuolo())){
				if(((int)Math.random()*10)+1>NUMrIUSCITAmEDIO){
					return CONTRASTO;
				}
				else return CONTRASTOPERSO;
			}
			else if(abilita>MINABILITAPERBONUS){
				if(((int)Math.random()*10)+1>NUMrIUSCITAsCARSOcONaBILITÀ){
					return CONTRASTO;
				}
				else return CONTRASTOPERSO;
			}
			else{
				if(((int)Math.random()*10)+1>NUMrIUSCITAsCARSO){
					return CONTRASTO;
				}
				else return CONTRASTOPERSO;
			}			
		}
	else return NIENTECONTRASTO;
}
	
	public int CalcolaDotiIntermedie(int DotiPiuForte){
		int tmp = DotiPiuForte*30/PERCENTUALE; // VOGLIO CALCOLARE IL 30% DELLE DOTI DEL GIOCATORE PIÙ FORTE
		return DotiPiuForte - tmp;
	}

	
	//abilità di attacco della squadra attaccante, abilita difesa della squadra che difende 
	public int Tiro(byte abilitaattacco, Portiere portiere, byte abilitadifesa){	 
		if (abilitaattacco>ABILITADIATTACCOMASSIME){
			if(abilitadifesa>ABILITADIDIFESAMASSIME){
				//probabilità di tirare pari è 1/4 per att, 1/5 per centracmp, 1/6 difensore
				
				return ControllaChiTira( portiere,4,5,6);
				
			}
			else {
				if (abilitadifesa>ABILITADIDIFESAMINIME && abilitadifesa<ABILITADIDIFESAMASSIME){ //ATTACCO MASSIMO DIFESA MEDIA
					//probabilità di tirare pari è 1/3 per attaccante, 1/4 percentrcampista, 1/5 difensore
					
					return ControllaChiTira( portiere,3,4,5);

				}
				else{ //ATTACCO MASSIMO DIFESA SCARSA 
					//probabilità di tirare 1/2 per attaccante, 1/3 centrocampista, 1/4 difensore
					
					return ControllaChiTira( portiere,2,3,4);

				}
			}
			
		}
		else {
			if(abilitaattacco>ABILITADIATTACCOMINIME && abilitaattacco<ABILITADIATTACCOMASSIME){				
				if(abilitadifesa>ABILITADIDIFESAMASSIME){ //ATTACCO MEDIO DIFESA MASSIMA
					//probabilità di tirare pari è 1/5 per att, 1/6 per centracmp, 1/7 difensore
					
					return ControllaChiTira( portiere,5,6,7);
					
				}
				else { //ATTACCO MEDIO DIFESA MEDIA
					if (abilitadifesa>ABILITADIDIFESAMINIME && abilitadifesa<ABILITADIDIFESAMASSIME){
						//probabilità di tirare pari è 1/4 per attaccante, 1/5 percentrcampista, 1/6 difensore
						
						return ControllaChiTira( portiere,4,5,6);

					}
					else{ //ATTACCO MEDIO DIFESA SCARSA
						//probabilità di tirare 1/2 per attaccante, 1/3 centrocampista, 1/4 difensore
						
						return ControllaChiTira( portiere,2,3,4);

					}
				}
				
			}
			else{ //ATTACCO SCARSO DIFESA MASSIMA
				if(abilitadifesa>ABILITADIDIFESAMASSIME){
					//probabilità di tirare pari è 1/7 per att, 1/8 per centracmp, 1/9 difensore
					
					return ControllaChiTira( portiere,7,8,9);

				}
				else { //ATTACCO SCARSO DIFESA MEDIA
					if (abilitadifesa>ABILITADIDIFESAMINIME && abilitadifesa<ABILITADIDIFESAMASSIME){
						//probabilità di tirare pari è 1/5 per attaccante, 1/6 percentrcampista, 1/7 difensore
						
						return ControllaChiTira( portiere,5,6,7);

					}
					else{ //ATTACCO SCARCO DIFESA SCARSA
						//probabilità di tirare 1/3 per attaccante, 1/4 centrocampista, 1/5 difensore
						
						return ControllaChiTira( portiere,3,4,5);
					}
				}
			}
		}
	}
	
	
	private int EsecuzioneTiro(int j, int k, int i){
		
		if(this.getTiro() >= ABILITADITIROBUONE){
			if((int)Math.random()*10 >= j) return GOAL;
			else return FUORI;
		}
		else{
			if(this.getTiro() >= ABILITADITIRODISCRETE){
				if((int)Math.random()*10 >= k) return GOAL;
				else return FUORI;
			}
			else{
				if(this.getTiro() >= ABILITADITIROSCARSE){
					if((int)Math.random()*10 >= i) return GOAL;
					else return FUORI;
				}
			}
		}
		return -1;
	}
	
	private int EsecuzioneParata(int j, int k, int i, Portiere portiere){
		
		
		if(portiere.getBloccareTiri() >= ABILITADIPARATABUONE){
			if((int)Math.random()*10 >= j) return PARATA;
			else return GOAL;
		}
		else{
			if(portiere.getBloccareTiri() >= ABILITADIPARATADISCRETE){
				if((int)Math.random()*10 >= k) return PARATA;
				else return GOAL;
			}
			else{
				if(portiere.getBloccareTiri() >= ABILITADIPARATASCARSE){
					if((int)Math.random()*10 >= i) return PARATA;
					else return GOAL;
				}
			}
		}
		return -1;
	}
	
	
	private int ControllaChiTira(Portiere portiere, int probabilitatiroatt, int probabilitatirocentro,int probabilitatirodif){
		if(this instanceof Attaccante){
			if((int)(Math.random()*probabilitatiroatt) == 2){ //probabilità che l'attacante tiri
				if(this.getTiro()+this.getColpoDiTesta()+this.getDribling() > 
				portiere.getBloccareTiri()+portiere.getAgilita()+portiere.getRiflessi()){
					 return EsecuzioneTiro(COSTANTEPERRIUSCITATIROBUONE,COSTANTEPERRIUSCITATIROMEDIE,COSTANTEPERRIUSCITATIROSCARSE);
				}
				else{
					return EsecuzioneParata(COSTANTEPERRIUSCITATIROBUONE,COSTANTEPERRIUSCITATIROMEDIE,COSTANTEPERRIUSCITATIROSCARSE
							,portiere);
				}
			}
			else return INTERCETTATA;
		}
		else{
			if(this instanceof Centrocampista){
				if((int)(Math.random()*probabilitatirocentro) == 2){ //probabilità che il centrcampista tiri
					if(this.getTiro()+this.getColpoDiTesta()+this.getDribling() > 
						portiere.getBloccareTiri()+portiere.getAgilita()+portiere.getRiflessi()){
						return EsecuzioneTiro(COSTANTEPERRIUSCITATIROBUONE,COSTANTEPERRIUSCITATIROMEDIE,COSTANTEPERRIUSCITATIROSCARSE);
					}
					else {
						return EsecuzioneParata(COSTANTEPERRIUSCITATIROBUONE,COSTANTEPERRIUSCITATIROMEDIE,COSTANTEPERRIUSCITATIROSCARSE
								,portiere);
					}
				}
				else return INTERCETTATA;
			}
			if(this instanceof Difensore){
				if((int)(Math.random()*probabilitatirocentro) == 2){ //probabilità che il difensore tiri
					if(this.getTiro()+this.getColpoDiTesta()+this.getDribling() > 
						portiere.getBloccareTiri()+portiere.getAgilita()+portiere.getRiflessi()) {
						return EsecuzioneTiro(COSTANTEPERRIUSCITATIROBUONE,COSTANTEPERRIUSCITATIROMEDIE,COSTANTEPERRIUSCITATIROSCARSE);
					}
					else {
						return EsecuzioneParata(COSTANTEPERRIUSCITATIROBUONE,COSTANTEPERRIUSCITATIROMEDIE,COSTANTEPERRIUSCITATIROSCARSE
								,portiere);
					}
				}
				else return INTERCETTATA;
			}
		}
		return -1;
	}
	
	public String toString()
	{
		return(super.toString() + "\n" + " Statistiche specifiche: " + "\n" + " Cross: " + getCross() + "\n" + " Dribling: " +
				getDribling() + "\n" + " Colpo di testa: " + getColpoDiTesta() + "\n" + " Passaggio: " + getPassaggio() + "\n" + " Tiro: " + 
				getTiro() + "\n" + " contrasto: " + getContrasto() + "\n" + " Movimento: " + getMovimento() + "\n" + " abilita difesa: " + 
				getAbilitaDifesa() + "\n" + " abilita attacco: " + getAbilitaAttacco() + "\n" + 
				" abilita centrocampo: " + getAbilitaCentrocampo() + "\n");
	}
	// altri metodi

}