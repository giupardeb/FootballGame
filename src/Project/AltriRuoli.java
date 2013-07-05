package Project;

import java.awt.Point;

abstract class AltriRuoli extends Giocatore
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8669599988577506600L;
	/**
	 * @uml.property  name="cross"
	 */
	private byte cross;
	//I DUE SUFFISSI INDICANO IL LIVELLO DI ATTACCO E DI DIFESA DELLE SQUADRE
	private final int SOGLIAATTMAXMAX = 50;
	private final int SOGLIACENMAXMAX = 60;
	private final int SOGLIADIFMAXMAX = 70;
	private final int SOGLIAATTMAXMED = 40;
	private final int SOGLIACENMAXMED = 50;
	private final int SOGLIADIFMAXMED = 60;
	private final int SOGLIAATTMAXSCA = 30;
	private final int SOGLIACENMAXSCA = 40;
	private final int SOGLIADIFMAXSCA = 50;

	private final int SOGLIAATTMEDMAX = 60;
	private final int SOGLIACENMEDMAX = 70;
	private final int SOGLIADIFMEDMAX = 80;
	private final int SOGLIAATTMEDMED = 50;
	private final int SOGLIACENMEDMED = 60;
	private final int SOGLIADIFMEDMED = 70;
	private final int SOGLIAATTMEDSCA = 30;
	private final int SOGLIACENMEDSCA = 40;
	private final int SOGLIADIFMEDSCA = 50;

	private final int SOGLIAATTSCAMAX = 50;
	private final int SOGLIACENSCAMAX = 60;
	private final int SOGLIADIFSCAMAX = 70;
	private final int SOGLIAATTSCAMED = 40;
	private final int SOGLIACENSCAMED = 50;
	private final int SOGLIADIFSCAMED = 60;
	private final int SOGLIAATTSCASCA = 30;
	private final int SOGLIACENSCASCA = 40;
	private final int SOGLIADIFSCASCA = 50;



	private final int PROBABILITAATT = 100;
	private final int PROBABILITACEN = 100;
	private final int PROBABILITADIF = 100;


	/**
	 * @uml.property  name="dribling"
	 */
	private byte dribling;
	/**
	 * @uml.property  name="colpoDiTesta"
	 */
	private byte colpoDiTesta;
	/**
	 * @uml.property  name="passaggio"
	 */
	private byte passaggio;
	/**
	 * @uml.property  name="tiro"
	 */
	private byte tiro;
	/**
	 * @uml.property  name="contrasto"
	 */
	private byte contrasto;
	/**
	 * @uml.property  name="movimento"
	 */
	private byte movimento;
	/**
	 * @uml.property  name="abilitaDifesa"
	 */
	private byte abilitaDifesa;
	/**
	 * @uml.property  name="abilitaAttacco"
	 */
	private byte abilitaAttacco;
	/**
	 * @uml.property  name="abilitaCentrocampo"
	 */
	private byte abilitaCentrocampo;

	//metodi per metodo constrasto
	//	private final int CONTRASTO = 1;
	//	private final int NIENTECONTRASTO = 2;
	//	private final int CONTRASTOPERSO = 4; 
	/**
	 * @uml.property  name="nUMrIUSCITAsCARSOcONaBILITÀ"
	 */
	private final int NUMrIUSCITAsCARSO = 5;
	/**
	 * @uml.property  name="nUMrIUSCITAmEDIO"
	 */
	private final int NUMrIUSCITAmEDIO = 4;
	/**
	 * @uml.property  name="nUMrIUSCITAbRAVO"
	 */
	private final int NUMrIUSCITAbRAVO = 3;
	/**
	 * @uml.property  name="mINABILITAPERBONUS"
	 */
	//si riferiscono ai passaggi tiri  e contrasti
	private final int ZEROEFFETTUATI = 0;
	private final int MEDIEFFETTUATI = 4;
	//FINE

	/**
	 * @uml.property  name="aBILITAPASSAGGIOSCARSO"
	 */
	private final int ABILITAPASSAGGIOSCARSO = 70;
	/**
	 * @uml.property  name="aBILITAPASSAGGIOBUONE"
	 */
	private final int PERCENTUALE = 100;

	//Costanti per il metodo tiro
	/**
	 * @uml.property  name="gOAL"
	 */
	private final int GOAL = 7;
	/**
	 * @uml.property  name="pARATA"
	 */
	private final int PARATA = 9;
	/**
	 * @uml.property  name="fUORI"
	 */
	private final int FUORI = 10;
	/**
	 * @uml.property  name="iNTERCETTATA"
	 */
	private final int INTERCETTATA = 11;
	/**
	 * @uml.property  name="aBILITADITIROBUONE"
	 */
	private final int ABILITADITIROBUONE = 80; 
	/**
	 * @uml.property  name="aBILITADITIRODISCRETE"
	 */
	private final int ABILITADITIRODISCRETE = 70; 
	/**
	 * @uml.property  name="aBILITADITIROSCARSE"
	 */
	private final int ABILITADITIROSCARSE = 60;
	/**
	 * @uml.property  name="cOSTANTEPERRIUSCITATIROBUONE"
	 */
	private final int COSTANTEPERRIUSCITATIROBUONE = 4; 
	/**
	 * @uml.property  name="cOSTANTEPERRIUSCITATIROMEDIE"
	 */
	private final int COSTANTEPERRIUSCITATIROMEDIE = 5; 
	/**
	 * @uml.property  name="cOSTANTEPERRIUSCITATIROSCARSE"
	 */
	private final int COSTANTEPERRIUSCITATIROSCARSE = 6;
	/**
	 * @uml.property  name="aBILITADIATTACCOMINIME"
	 */
	private final int ABILITADIATTACCOMINIME = 65;
	/**
	 * @uml.property  name="aBILITADIATTACCOMASSIME"
	 */
	private final int ABILITADIATTACCOMASSIME = 75;
	/**
	 * @uml.property  name="aBILITADIDIFESAMINIME"
	 */
	private final int ABILITADIDIFESAMINIME = 65;
	/**
	 * @uml.property  name="aBILITADIDIFESAMASSIME"
	 */
	private final int ABILITADIDIFESAMASSIME = 75;
	/**
	 * @uml.property  name="aBILITADIPARATABUONE"
	 */
	private final int ABILITADIPARATABUONE = 75; 
	/**
	 * @uml.property  name="aBILITADIPARATADISCRETE"
	 */
	private final int ABILITADIPARATADISCRETE = 70; 
	/**
	 * @uml.property  name="aBILITADIPARATASCARSE"
	 */
	private final int ABILITADIPARATASCARSE = 65;

	private final int COSTANTEPERRIUSCITAPARATABUONE = 2; 
	/**
	 * @uml.property  name="cOSTANTEPERRIUSCITATIROMEDIE"
	 */
	private final int COSTANTEPERRIUSCITAPARATAMEDIE = 3; 
	/**
	 * @uml.property  name="cOSTANTEPERRIUSCITATIROSCARSE"
	 */
	private final int COSTANTEPERRIUSCITAPARATASCARSE = 4;
	//FINE



	public AltriRuoli(String cognome,String NomeSquadraAppartenente,String nazionalita,byte velocita,byte resistenza,
			byte forza,byte morale,byte eta,byte condizione,byte tecnica,byte aggressivita,
			byte creativita,byte decisione,byte carisma,String posizione,byte giocoDiSquadra,
			boolean essenziale,byte mediaVoti,byte cross,byte dribling,byte colpoDiTesta,
			byte passaggio, byte tiro, byte contrasto, byte movimento, byte abilitaDifesa,
			byte abilitaAttacco,byte abilitaCentrocampo,byte valoreGenerale,double valoreMercato){

		super (cognome, NomeSquadraAppartenente, nazionalita, velocita, resistenza, forza, morale, eta,condizione, 
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

	/**
	 * @return
	 * @uml.property  name="cross"
	 */
	public byte getCross()
	{
		return(cross);
	}

	/**
	 * @return
	 * @uml.property  name="dribling"
	 */
	public byte getDribling()
	{
		return(dribling);
	}

	/**
	 * @return
	 * @uml.property  name="colpoDiTesta"
	 */
	public byte getColpoDiTesta()
	{
		return(colpoDiTesta);
	}

	/**
	 * @return
	 * @uml.property  name="passaggio"
	 */
	public byte getPassaggio()
	{
		return(passaggio);
	}

	/**
	 * @return
	 * @uml.property  name="tiro"
	 */
	public byte getTiro()
	{
		return(tiro);
	}

	/**
	 * @return
	 * @uml.property  name="contrasto"
	 */
	public byte getContrasto()
	{
		return(contrasto);
	}

	/**
	 * @return
	 * @uml.property  name="movimento"
	 */
	public byte getMovimento()
	{
		return(movimento);
	}

	/**
	 * @return
	 * @uml.property  name="abilitaDifesa"
	 */
	public byte getAbilitaDifesa()
	{
		return(abilitaDifesa);
	}

	/**
	 * @return
	 * @uml.property  name="abilitaAttacco"
	 */
	public byte getAbilitaAttacco()
	{
		return(abilitaAttacco);
	}

	/**
	 * @return
	 * @uml.property  name="abilitaCentrocampo"
	 */
	public byte getAbilitaCentrocampo()
	{
		return(abilitaCentrocampo);
	}


	//metodi di set()

	/**
	 * @param valore
	 * @uml.property  name="cross"
	 */
	public void setCross(byte valore)
	{
		cross += valore;

		if(cross >= 100)
			cross = 100;

	}

	/**
	 * @param valore
	 * @uml.property  name="dribling"
	 */
	public void setDribling(byte valore)
	{
		dribling += valore;

		if(dribling >= 100)
			dribling = 100;

	}

	/**
	 * @param valore
	 * @uml.property  name="colpoDiTesta"
	 */
	public void setColpoDiTesta(byte valore)
	{
		colpoDiTesta += valore;

		if(colpoDiTesta >= 100)
			colpoDiTesta = 100;

	}

	/**
	 * @param valore
	 * @uml.property  name="passaggio"
	 */
	public void setPassaggio(byte valore)
	{
		passaggio += valore;

		if(passaggio >= 100)
			passaggio = 100;

	}

	/**
	 * @param valore
	 * @uml.property  name="tiro"
	 */
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

	/**
	 * @param valore
	 * @uml.property  name="movimento"
	 */
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

	public Point Passaggio(Squadra squadra,Giocatore arrayMio[], Giocatore arrayAvv[]){  
		//così posso darla alla squadra avversaria + versatile
		Point p = this.getPosizione().getLocation();
		Point newp = ControllaPosGioc(p,squadra,arrayMio,arrayAvv);

		if(this.getPassaggio() <= ABILITAPASSAGGIOSCARSO){
			if(this.getPassaggiFatti() == ZEROEFFETTUATI){
				if((int)(Math.random()*10)+1 > NUMrIUSCITAsCARSO) {
					this.setPassaggiFatti();
					return newp;
				}
				else{
					this.setPassaggiFatti();
					newp.setLocation(0,0);
					return newp;
				}
			}
			else if(this.getPassaggiFatti() > ZEROEFFETTUATI && this.getPassaggiFatti() <= MEDIEFFETTUATI){
				if((int)(Math.random()*10)+1 > NUMrIUSCITAmEDIO) {
					this.setPassaggiFatti();
					return newp;
				}
				else{
					this.setPassaggiFatti();
					newp.setLocation(0,0);
					return newp;
				}
			}
			else{
				if((int)(Math.random()*10)+1 > NUMrIUSCITAbRAVO) {
					this.setPassaggiFatti();
					return newp;
				}
				else{
					this.setPassaggiFatti();
					newp.setLocation(0,0);
					return newp;
				}
			}
		}
		else{
			if(this.getPassaggiFatti() == ZEROEFFETTUATI){
				if((int)(Math.random()*10)+1>NUMrIUSCITAmEDIO){
					this.setPassaggiFatti();
					return newp;
				}
				else {
					this.setPassaggiFatti();
					newp.setLocation(0,0);
					return newp;
				}
			}
			else{
				if((int)(Math.random()*10)+1 > NUMrIUSCITAbRAVO) {
					this.setPassaggiFatti();
					return newp;
				}
				else{
					this.setPassaggiFatti();
					newp.setLocation(0,0);
					return newp;
				}
			}
		}
	}


	public Point ControllaPosGioc(Point p,Squadra squadra,Giocatore []arrayMio,Giocatore arrayAvv[]){ // Squadra avversaria rispetto al chiamante
		Point p1 = new Point();
		Giocatore b = null; //è il giocatore corrente
		if(this.getSquadra().equalsIgnoreCase(squadra.GetNomeSquadra())){ //sono della squadra Avversaria computer
			b = Search((int)p.getX(),(int)p.getY(),arrayAvv);
			if((int)(Math.random()*2) == 0 && squadra.getAbilitaDifesa() > squadra.getAbilitaAttacco()) //controllo a scendere
				ControlloVerticaleComputer(p1, p, arrayAvv, b);

			else //controllo orizzontale
				ControlloOrizzontaleComputer(b, p1, p, arrayAvv);
		}

		else{ //Sono nella mia Squadra utente
			b = Search((int)p.getX(),(int)p.getY(),arrayMio);

			if((int)(Math.random()*2) == 0 && squadra.getAbilitaDifesa() > squadra.getAbilitaAttacco()) //controllo a scendere
				ControlloVerticaleUmano(p1, p, arrayMio, b);

			else //controllo orizzontale
				ControlloOrizzontaleUmano(b, p1, p, arrayMio);
		}

		return p1;

	}

	////////****METODO CONTRASTO///*/*/*/*////***

	public Point Contrasto(Giocatore arrayMio[],Giocatore arrayAvv[],Squadra squadraAvv){ 
		Point p = this.getPosizione().getLocation();
		Point pavv = new Point();
		Point puntoDaTornare = new Point();
		Giocatore b = null;
		if(this.getSquadra().equalsIgnoreCase(squadraAvv.GetNomeSquadra())){  		
			//chi ha chiamato il metodo è un computer
			if(this instanceof Difensore){
				pavv = new Point((int)p.getX()-91,(int)p.getY()); 
				b = Search((int)pavv.getX(),(int)pavv.getY(),arrayMio);
			}
			else if(this instanceof Centrocampista){
				pavv = new Point((int)p.getX()-103,(int)p.getY()); 
				b = Search((int)pavv.getX(),(int)pavv.getY(),arrayMio);
			}
			else if(this instanceof Attaccante){
				pavv = new Point((int)p.getX()-83,(int)p.getY()); 
				b = Search((int)pavv.getX(),(int)pavv.getY(),arrayMio);
			}

		}
		else{
			if(this instanceof Difensore){
				pavv = new Point((int)p.getX()+83,(int)p.getY()); 
				b = Search((int)pavv.getX(),(int)pavv.getY(),arrayAvv);
			}
			else if(this instanceof Centrocampista){
				pavv = new Point((int)p.getX()+103,(int)p.getY()); 
				b = Search((int)pavv.getX(),(int)pavv.getY(),arrayAvv);
			}
			else if(this instanceof Attaccante){
				pavv = new Point((int)p.getX()+91,(int)p.getY()); 
				b = Search((int)pavv.getX(),(int)pavv.getY(),arrayAvv);
			}

		}

		if(b != null){
			if(this.getDotiRuolo() > b.getDotiRuolo()){
				if(this.getContrastiFatti() == ZEROEFFETTUATI){
					if((int)(Math.random()*10)+1>NUMrIUSCITAsCARSO){
						this.setContrastiFatti();
						puntoDaTornare.setLocation(this.getLocation()); //contrasto vinto
					}
					else{
						this.setContrastiFatti();
						puntoDaTornare.setLocation(pavv.getLocation());;// CONTRASTOPERSO;
					}
				}
				else if(this.getContrastiFatti() > ZEROEFFETTUATI && this.getContrastiFatti() <= MEDIEFFETTUATI){
					if((int)(Math.random()*10)+1>NUMrIUSCITAmEDIO){
						this.setContrastiFatti();
						puntoDaTornare.setLocation(this.getLocation()); //contrasto vinto
					}
					else{
						this.setContrastiFatti();
						puntoDaTornare.setLocation(pavv.getLocation());// CONTRASTOPERSO;
					}
				}
				else{
					if((int)(Math.random()*10)+1>NUMrIUSCITAbRAVO){
						this.setContrastiFatti();
						puntoDaTornare.setLocation(this.getLocation()); //contrasto vinto
					}
					else {
						this.setContrastiFatti();
						puntoDaTornare.setLocation(pavv.getLocation());// CONTRASTOPERSO;
					}
				}
			}
			else if(this.getDotiRuolo() >= CalcolaDotiIntermedie(b.getDotiRuolo())){
				if(this.getContrastiFatti() == ZEROEFFETTUATI){
					if((int)(Math.random()*10)+1>NUMrIUSCITAsCARSO){
						this.setContrastiFatti();
						puntoDaTornare.setLocation(this.getLocation());		
					}
					else {
						this.setContrastiFatti();
						puntoDaTornare.setLocation(pavv.getLocation());	
					}
				}
				if(this.getContrastiFatti() > ZEROEFFETTUATI){
					if((int)(Math.random()*10)+1>NUMrIUSCITAmEDIO){
						this.setContrastiFatti();
						puntoDaTornare.setLocation(this.getLocation());	
					}
					else {
						this.setContrastiFatti();
						puntoDaTornare.setLocation(pavv.getLocation());	
					}
				}
			}
			else if(this.getContrastiFatti() == ZEROEFFETTUATI){
				if((int)(Math.random()*10)+1 > NUMrIUSCITAsCARSO){
					this.setContrastiFatti();
					puntoDaTornare.setLocation(this.getLocation());	
				}
				else{
					this.setContrastiFatti();
					puntoDaTornare.setLocation(pavv.getLocation());	
				}
			}
			else if(this.getContrastiFatti() > ZEROEFFETTUATI){
				if((int)(Math.random()*10)+1>NUMrIUSCITAmEDIO){
					this.setContrastiFatti();
					puntoDaTornare.setLocation(this.getLocation());
				}
				else {
					this.setContrastiFatti();
					puntoDaTornare.setLocation(pavv.getLocation());	
				}
			}
		}
		else { //Non c'è nessun contrasto da fare
			Point newp = new Point();
			return newp;
		}
		return puntoDaTornare;
	}

	private int CalcolaDotiIntermedie(int DotiPiuForte){
		int tmp = DotiPiuForte*30/PERCENTUALE; // VOGLIO CALCOLARE IL 30% DELLE DOTI DEL GIOCATORE PIÙ FORTE
		return DotiPiuForte - tmp;
	}

	private Giocatore Search(int x, int y,Giocatore array[]){
		for (int i=0; i<array.length;i++)
			if(((Giocatore)array[i]).getPosizione().getX() == x && ((Giocatore)array[i]).getPosizione().getY() == y)
				return array[i];
		return null;
	}



	//abilità di attacco della squadra attaccante, abilita difesa della squadra che difende 
	public int Tiro(int abilitaattacco, Portiere portiere, int abilitadifesa,int PunteggioUmano, int PunteggioComputer,String SquadraAvv){	 
		if (abilitaattacco > ABILITADIATTACCOMASSIME){
			if(abilitadifesa > ABILITADIDIFESAMASSIME){

				return ControllaChiTira( portiere,SOGLIAATTMAXMAX,SOGLIACENMAXMAX,SOGLIADIFMAXMAX, PunteggioUmano, PunteggioComputer,SquadraAvv);

			}
			else {
				if (abilitadifesa >= ABILITADIDIFESAMINIME && abilitadifesa <= ABILITADIDIFESAMASSIME){ //ATTACCO MASSIMO DIFESA MEDIA

					return ControllaChiTira( portiere,SOGLIAATTMAXMED,SOGLIACENMAXMED,SOGLIADIFMAXMED,PunteggioUmano, PunteggioComputer,SquadraAvv);

				}
				else{ //ATTACCO MASSIMO DIFESA SCARSA 

					return ControllaChiTira( portiere,SOGLIAATTMAXSCA,SOGLIACENMAXSCA,SOGLIADIFMAXSCA,PunteggioUmano, PunteggioComputer,SquadraAvv);

				}
			}

		}
		else {
			if(abilitaattacco >= ABILITADIATTACCOMINIME && abilitaattacco <= ABILITADIATTACCOMASSIME){				
				if(abilitadifesa >= ABILITADIDIFESAMASSIME){ //ATTACCO MEDIO DIFESA MASSIMA

					return ControllaChiTira(portiere,SOGLIAATTMEDMAX,SOGLIACENMEDMAX,SOGLIADIFMEDMAX,PunteggioUmano, PunteggioComputer,SquadraAvv);

				}
				else { //ATTACCO MEDIO DIFESA MEDIA
					if (abilitadifesa >= ABILITADIDIFESAMINIME && abilitadifesa <= ABILITADIDIFESAMASSIME){

						return ControllaChiTira( portiere,SOGLIAATTMEDMED,SOGLIACENMEDMED,SOGLIADIFMEDMED,PunteggioUmano, PunteggioComputer,SquadraAvv);

					}
					else{ //ATTACCO MEDIO DIFESA SCARSA

						return ControllaChiTira( portiere,SOGLIAATTMEDSCA,SOGLIACENMEDSCA,SOGLIADIFMEDSCA,PunteggioUmano, PunteggioComputer,SquadraAvv);

					}
				}

			}
			else{ //ATTACCO SCARSO DIFESA MASSIMA
				if(abilitadifesa > ABILITADIDIFESAMASSIME){

					return ControllaChiTira( portiere,SOGLIAATTSCAMAX,SOGLIACENSCAMAX,SOGLIADIFSCAMAX,PunteggioUmano, PunteggioComputer,SquadraAvv);

				}
				else { //ATTACCO SCARSO DIFESA MEDIA
					if (abilitadifesa >= ABILITADIDIFESAMINIME && abilitadifesa <= ABILITADIDIFESAMASSIME){

						return ControllaChiTira( portiere,SOGLIAATTSCAMED,SOGLIACENSCAMED,SOGLIADIFSCAMED,PunteggioUmano, PunteggioComputer,SquadraAvv);

					}
					else{ //ATTACCO SCARCO DIFESA SCARSA

						return ControllaChiTira( portiere,SOGLIAATTSCASCA,SOGLIACENSCASCA,SOGLIADIFSCASCA,PunteggioUmano, PunteggioComputer,SquadraAvv);
					}
				}
			}
		}
	}



	private int ControllaChiTira(Portiere portiere, int sogliaMinAtt, int sogliaMinCen,int sogliaMinDif,int PunteggioUmano, int PunteggioComputer, String SquadraAvv){

		if(this instanceof Attaccante){

			if((Math.random()*PROBABILITAATT) > sogliaMinAtt){//probabilità che l'attacante tiri
				if(this.getTiro()+this.getColpoDiTesta()+this.getDribling() > 
				portiere.getBloccareTiri()+portiere.getAgilita()+portiere.getRiflessi()){
					return EsecuzioneTiro(COSTANTEPERRIUSCITATIROBUONE,COSTANTEPERRIUSCITATIROMEDIE,COSTANTEPERRIUSCITATIROSCARSE);
				}
				else{
					return EsecuzioneParata(COSTANTEPERRIUSCITAPARATABUONE,COSTANTEPERRIUSCITAPARATAMEDIE,COSTANTEPERRIUSCITAPARATASCARSE
							,portiere,PunteggioUmano, PunteggioComputer,SquadraAvv);
				}
			}
			else return INTERCETTATA;
		}
		else{
			if(this instanceof Centrocampista){

				//	if((Math.random()*PROBABILITACEN) > sogliaMinCen){ //probabilità che il centrcampista tiri
				if(this.getTiro()+this.getColpoDiTesta()+this.getDribling() > 
				portiere.getBloccareTiri()+portiere.getAgilita()+portiere.getRiflessi()){
					return EsecuzioneTiro(COSTANTEPERRIUSCITATIROBUONE,COSTANTEPERRIUSCITATIROMEDIE,COSTANTEPERRIUSCITATIROSCARSE);
				}
				else {
					return EsecuzioneParata(COSTANTEPERRIUSCITAPARATABUONE,COSTANTEPERRIUSCITAPARATAMEDIE,COSTANTEPERRIUSCITAPARATASCARSE,
							portiere,PunteggioUmano, PunteggioComputer,SquadraAvv);
				}
				//	}
				//	else return INTERCETTATA;
			}
			if(this instanceof Difensore){


				//	if((Math.random()*PROBABILITADIF) > sogliaMinDif){ //probabilità che il difensore tiri
				if(this.getTiro()+this.getColpoDiTesta()+this.getDribling() > 
				portiere.getBloccareTiri()+portiere.getAgilita()+portiere.getRiflessi()) {
					return EsecuzioneTiro(COSTANTEPERRIUSCITATIROBUONE,COSTANTEPERRIUSCITATIROMEDIE,COSTANTEPERRIUSCITATIROSCARSE);
				}
				else {
					return EsecuzioneParata(COSTANTEPERRIUSCITAPARATABUONE,COSTANTEPERRIUSCITAPARATAMEDIE,COSTANTEPERRIUSCITAPARATASCARSE,
							portiere,PunteggioUmano, PunteggioComputer,SquadraAvv);
				}
				//	}
				//	else return INTERCETTATA;
			}
		}
		return -1;
	}


	private int EsecuzioneTiro(int j, int k, int i){

		if(this.getTiro() >= ABILITADITIROBUONE){
			if(this.getTiriFatti() == ZEROEFFETTUATI && (int)(Math.random()*10) > NUMrIUSCITAbRAVO){
				if((int)(Math.random()*10) >= j){
					this.setTiriFatti();
					return GOAL;
				}
				else{
					this.setTiriFatti();
					return FUORI;
				}
			}
			else if (this.getTiriFatti() > ZEROEFFETTUATI && (int)(Math.random()*10) > NUMrIUSCITAsCARSO){
				if((int)(Math.random()*10) >= j) {
					this.setTiriFatti();
					return GOAL;
				}
				else {
					this.setTiriFatti();
					return FUORI;
				}
			}
			else{
				if((int)(Math.random()*10) >= j) {
					this.setTiriFatti();
					return GOAL;
				}
				else {
					this.setTiriFatti();
					return FUORI;
				}
			}
		}
		else{
			if(this.getTiro() >= ABILITADITIRODISCRETE){
				if(this.getTiriFatti() == ZEROEFFETTUATI && (int)(Math.random()*10) > NUMrIUSCITAmEDIO){
					if((int)(Math.random()*10) >= k){
						this.setTiriFatti();
						return GOAL;
					}
					else {
						this.setTiriFatti();
						return FUORI;
					}
				}
				else if(this.getTiriFatti() > ZEROEFFETTUATI && (int)(Math.random()*10) > NUMrIUSCITAbRAVO){
					if((int)(Math.random()*10) >= k){
						this.setTiriFatti();
						return GOAL;
					}
					else {
						this.setTiriFatti();
						return FUORI;
					}
				}
				else{
					if((int)(Math.random()*10) >= k){
						this.setTiriFatti();
						return GOAL;
					}
					else {
						this.setTiriFatti();
						return FUORI;
					}
				}
			}
			else{
				if(this.getTiro() >= ABILITADITIROSCARSE){
					if(this.getTiriFatti() == ZEROEFFETTUATI && (int)(Math.random()*10) > NUMrIUSCITAsCARSO){
						if((int)(Math.random()*10) >= i){
							this.setTiriFatti();
							return GOAL;
						}
						else {
							this.setTiriFatti();
							return FUORI;
						}
					}
					else if(this.getTiriFatti() > ZEROEFFETTUATI && (int)(Math.random()*10) > NUMrIUSCITAmEDIO){
						if((int)(Math.random()*10) >= i){
							this.setTiriFatti();
							return GOAL;
						}
						else {
							this.setTiriFatti();
							return FUORI;
						}
					}
					else{
						if((int)(Math.random()*10) >= i){
							this.setTiriFatti();
							return GOAL;
						}
						else {
							this.setTiriFatti();
							return FUORI;
						}
					}
				}
			}
		}
		return -1;
	}

	private int EsecuzioneParata(int j, int k, int i, Portiere portiere, int PunteggioUmano, int PunteggioComputer,String SquadraAvv){
		if(portiere.getSquadra().equalsIgnoreCase(SquadraAvv)){
			if(PunteggioComputer < PunteggioUmano){
				if(portiere.getBloccareTiri() >= ABILITADIPARATABUONE){
					if((int)(Math.random()*10) >= j-1) return PARATA;
					else return GOAL;
				}
				else{
					if(portiere.getBloccareTiri() >= ABILITADIPARATADISCRETE){
						if((int)(Math.random()*10) >= k-1) return PARATA;
						else return GOAL;
					}
					else{
						if(portiere.getBloccareTiri() >= ABILITADIPARATASCARSE){
							if((int)(Math.random()*10) >= i-1) return PARATA;
							else return GOAL;
						}
					}
				}
			}
			else if(PunteggioComputer >= PunteggioUmano){
				if(portiere.getBloccareTiri() >= ABILITADIPARATABUONE){
					if((int)(Math.random()*10) >= j) return PARATA;
					else return GOAL;
				}
				else{
					if(portiere.getBloccareTiri() >= ABILITADIPARATADISCRETE){
						if((int)(Math.random()*10) >= k) return PARATA;
						else return GOAL;
					}
					else{
						if(portiere.getBloccareTiri() >= ABILITADIPARATASCARSE){
							if((int)(Math.random()*10) >= i) return PARATA;
							else return GOAL;
						}
					}
				}
			}
		}
		else{
			if(PunteggioComputer > PunteggioUmano){
				if(portiere.getBloccareTiri() >= ABILITADIPARATABUONE){
					if((int)(Math.random()*10) >= j-1) return PARATA;
					else return GOAL;
				}
				else{
					if(portiere.getBloccareTiri() >= ABILITADIPARATADISCRETE){
						if((int)(Math.random()*10) >= k-1) return PARATA;
						else return GOAL;
					}
					else{
						if(portiere.getBloccareTiri() >= ABILITADIPARATASCARSE){
							if((int)(Math.random()*10) >= i-1) return PARATA;
							else return GOAL;
						}
					}
				}
			}
			else if(PunteggioComputer <= PunteggioUmano){
				if(portiere.getBloccareTiri() >= ABILITADIPARATABUONE){
					if((int)(Math.random()*10) >= j) return PARATA;
					else return GOAL;
				}
				else{
					if(portiere.getBloccareTiri() >= ABILITADIPARATADISCRETE){
						if((int)(Math.random()*10) >= k) return PARATA;
						else return GOAL;
					}
					else{
						if(portiere.getBloccareTiri() >= ABILITADIPARATASCARSE){
							if((int)(Math.random()*10) >= i) return PARATA;
							else return GOAL;
						}
					}
				}
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
	// METODI PER IL PASSAGGIO

	private void ControlloOrizzontaleUmano(Giocatore b, Point p1, Point p, Giocatore[] arrayMio){
		Giocatore c = null;
		if(b instanceof Difensore){
			p1.setLocation(p.getX()+167, p.getY());
		}
		if(b instanceof Centrocampista){
			p1.setLocation(p.getX()+180, p.getY()); 
			c = Search((int)p1.getX(),(int)p1.getY(),arrayMio);
			if(c == null){ //può non avere giocatori davanti a se x passare
				p1.setLocation(p.getX(), p.getY()+100);
				c = Search((int)p1.getX(),(int)p1.getY(),arrayMio);
				if(c == null){ // non ha nessun giocatore a cui passare la palla sotto di se
					p1.setLocation(p.getX(), p.getY()-100);
				}
			}
		}
		else if (b instanceof Attaccante){
			p1.setLocation(p.getX(), p.getY()+100);
			c = Search((int)p1.getX(),(int)p1.getY(),arrayMio);
			if(c == null){
				p1.setLocation(p.getX(), p.getY()-100);
			}
		}
	}
	private void ControlloVerticaleUmano(Point p1, Point p, Giocatore[] arrayMio, Giocatore b){
		Giocatore c = null;
		p1.setLocation(p.getX(), p.getY()+100);
		c = Search((int)p1.getX(),(int)p1.getY(),arrayMio);
		if(c == null){
			if((int)(Math.random()*2) == 0){ //controllo a salire
				p1.setLocation(p.getX(), p.getY()-100);
			}
			else{ // controllo in orizzontale
				ControlloOrizzontaleUmano(b, p1, p, arrayMio);
			}
		}
	}

	private void ControlloVerticaleComputer(Point p1, Point p, Giocatore[] arrayAvv, Giocatore b){
		Giocatore c = null;
		p1.setLocation(p.getX(), p.getY()+100);
		c = Search((int)p1.getX(),(int)p1.getY(),arrayAvv);
		if(c == null){
			if((int)(Math.random()*2) == 0){ //controllo a salire
				p1.setLocation(p.getX(), p.getY()-100);
			}
			else{ // controllo in orizzontale
				ControlloOrizzontaleComputer(b, p1, p, arrayAvv);
			}
		}
	}

	private void ControlloOrizzontaleComputer(Giocatore b, Point p1, Point p, Giocatore[] arrayAvv){
		Giocatore c = null;
		if(b instanceof Difensore){
			p1.setLocation(p.getX()-168, p.getY());
		}
		if(b instanceof Centrocampista){
			p1.setLocation(p.getX()-187, p.getY()); 
			c = Search((int)p1.getX(),(int)p1.getY(),arrayAvv);
			if(c == null){ //può non avere giocatori davanti a se x passare
				p1.setLocation(p.getX(), p.getY()+100);
				c = Search((int)p1.getX(),(int)p1.getY(),arrayAvv);
				if(c == null){ // non ha nessun giocatore a cui passare la palla sotto di se
					p1.setLocation(p.getX(), p.getY()-100);
				}
			}
		}
		else if (b instanceof Attaccante){
			p1.setLocation(p.getX(), p.getY()+100);
			c = Search((int)p1.getX(),(int)p1.getY(),arrayAvv);
			if(c == null){
				p1.setLocation(p.getX(), p.getY()-100);
			}
		}
	}
}