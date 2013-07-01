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
	private final int NUMrIUSCITAsCARSOcONaBILITÀ = 6;
	/**
	 * @uml.property  name="nUMrIUSCITAsCARSO"
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
	private final int MINABILITAPERBONUS = 70;
	//FINE

	/**
	 * @uml.property  name="aBILITAPASSAGGIOSCARSO"
	 */
	private final int ABILITAPASSAGGIOSCARSO = 65;
	/**
	 * @uml.property  name="aBILITAPASSAGGIOBUONE"
	 */
	private final int ABILITAPASSAGGIOBUONE = 70;

	/**
	 * @uml.property  name="pERCENTUALE"
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
	private final int COSTANTEPERRIUSCITATIROBUONE = 3; 
	/**
	 * @uml.property  name="cOSTANTEPERRIUSCITATIROMEDIE"
	 */
	private final int COSTANTEPERRIUSCITATIROMEDIE = 5; 
	/**
	 * @uml.property  name="cOSTANTEPERRIUSCITATIROSCARSE"
	 */
	private final int COSTANTEPERRIUSCITATIROSCARSE = 7;
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
	private final int ABILITADIPARATABUONE = 80; 
	/**
	 * @uml.property  name="aBILITADIPARATADISCRETE"
	 */
	private final int ABILITADIPARATADISCRETE = 70; 
	/**
	 * @uml.property  name="aBILITADIPARATASCARSE"
	 */
	private final int ABILITADIPARATASCARSE = 60;
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

	//NON DOVREBBERO ESSERCI PROBLEMI.. KMQ BISOGNEREBBE PROVARLO
	public Point Passaggio(Squadra squadra,Giocatore arrayMio[], Giocatore arrayAvv[]){ //int così capisco se la palla è andata fuori 
		//così posso darla alla squadra avversaria + versatile
		Point p = this.getPosizione().getLocation();
		Point newp = ControllaPosGioc(p,squadra,arrayMio,arrayAvv);

		if(this.getPassaggio() <= ABILITAPASSAGGIOSCARSO){
			if((int)(Math.random()*10)+1>NUMrIUSCITAsCARSO) return newp;
			else{
				newp.setLocation(0,0);
				return newp;
			}
		}
		else{
			if(this.getPassaggio() >= ABILITAPASSAGGIOBUONE){
				if((int)(Math.random()*10)+1>NUMrIUSCITAbRAVO) return newp;
				else if((int)(Math.random()*10)+1>NUMrIUSCITAmEDIO) return newp;
				else {
					newp.setLocation(0,0);
					return newp;
				}
			}
		}
		newp.setLocation(0,0);
		return newp;
	}


	public Point ControllaPosGioc(Point p,Squadra squadra,Giocatore []arrayMio,Giocatore arrayAvv[]){
		Point p1 = new Point();
		Giocatore b;
		if(this.getSquadra().equalsIgnoreCase(squadra.GetNomeSquadra())){
			b = Search((int)p.getX(),(int)p.getY(),arrayAvv);
		}
		else{
			b = Search((int)p.getX(),(int)p.getY(),arrayMio);
		}
		Giocatore c = null;

		if((int)(Math.random()*2) == 0){ //controllo a scendere
			p1.setLocation(p.getX(), p.getY()+100);
			c = Search((int)p1.getX(),(int)p1.getY(),arrayMio);
			if(c == null) c = Search((int)p1.getX(),(int)p1.getY(),arrayAvv);

			if(c == null){
				if((int)(Math.random()*2) == 0){
					p1.setLocation(p.getX(), p.getY()-100);
				}
				else{
					//controllo se il giocatore chiamante appartiene alla squadra o alla squadraAvversaria, poichè faccio uno spostamento
					//orrizzontale. controllare se il giocatore è un centrocampista, xke passarla all'attaccante costa di uno spostamento di 180

					if(this.getSquadra().equalsIgnoreCase(squadra.GetNomeSquadra())){	
						if(b instanceof Difensore){
							p1.setLocation(p.getX()-200, p.getY());
						}
						else if(b instanceof Centrocampista){
							p1.setLocation(p.getX()-187, p.getY());
							b = Search((int)p1.getX(),(int)p1.getY(),arrayAvv);
							if(b == null){
								p1.setLocation(p.getX(), p.getY()-100);
								b = Search((int)p1.getX(),(int)p1.getY(),arrayAvv);
							}
							if(b == null){
								p1.setLocation(p.getX(), p.getY()+100);
								b = Search((int)p1.getX(),(int)p1.getY(),arrayAvv);
							}
						}
						else if (b instanceof Attaccante){
							p1.setLocation(p.getX(), p.getY()+100);
							b = Search((int)p1.getX(),(int)p1.getY(),arrayAvv);
							if(b == null){
								p1.setLocation(p.getX(), p.getY()-100);
								b = Search((int)p1.getX(),(int)p1.getY(),arrayAvv);
							}
						}
					}
					else{
						if(b instanceof Difensore){
							p1.setLocation(p.getX()+167, p.getY());
						}
						else if(b instanceof Centrocampista){
							p1.setLocation(p.getX()+180, p.getY());
							b = Search((int)p1.getX(),(int)p1.getY(),arrayMio);
							if(b == null){
								p1.setLocation(p.getX(), p.getY()-100);
								b = Search((int)p1.getX(),(int)p1.getY(),arrayMio);
							}
							if(b == null){
								p1.setLocation(p.getX(), p.getY()+100);
								b = Search((int)p1.getX(),(int)p1.getY(),arrayMio);
							}
						}
						else if (b instanceof Attaccante){
							p1.setLocation(p.getX(), p.getY()+100);
							b = Search((int)p1.getX(),(int)p1.getY(),arrayMio);
							if(b == null){
								p1.setLocation(p.getX(), p.getY()-100);
								b = Search((int)p1.getX(),(int)p1.getY(),arrayMio);
							}
						}
					}
				}
			}
		}
		else{ // controllo orizzontale
			if(this.getSquadra().equalsIgnoreCase(squadra.GetNomeSquadra())){	
				if(b instanceof Difensore){
					p1.setLocation(p.getX()-200, p.getY());
				}
				else if(b instanceof Centrocampista){
					p1.setLocation(p.getX()-187, p.getY());
					b = Search((int)p1.getX(),(int)p1.getY(),arrayAvv);
					if(b == null){
						p1.setLocation(p.getX(), p.getY()-100);
						b = Search((int)p1.getX(),(int)p1.getY(),arrayAvv);
					}
					if(b == null){
						p1.setLocation(p.getX(), p.getY()+100);
						b = Search((int)p1.getX(),(int)p1.getY(),arrayAvv);
					}
				}
				else if (b instanceof Attaccante){
					p1.setLocation(p.getX(), p.getY()+100);
					b = Search((int)p1.getX(),(int)p1.getY(),arrayAvv);
					if(b == null){
						p1.setLocation(p.getX(), p.getY()-100);
						b = Search((int)p1.getX(),(int)p1.getY(),arrayAvv);
					}
				}
			}
			else{
				if(b instanceof Difensore){
					p1.setLocation(p.getX()+167, p.getY());
				}
				else if(b instanceof Centrocampista){
					p1.setLocation(p.getX()+180, p.getY());
					b = Search((int)p1.getX(),(int)p1.getY(),arrayMio);
					if(b == null){
						p1.setLocation(p.getX(), p.getY()-100);
						b = Search((int)p1.getX(),(int)p1.getY(),arrayMio);
					}
					if(b == null){
						p1.setLocation(p.getX(), p.getY()+100);
						b = Search((int)p1.getX(),(int)p1.getY(),arrayMio);
					}
				}
				else if (b instanceof Attaccante){
					p1.setLocation(p.getX(), p.getY()+100);
					b = Search((int)p1.getX(),(int)p1.getY(),arrayMio);
					if(b == null){
						p1.setLocation(p.getX(), p.getY()-100);
						b = Search((int)p1.getX(),(int)p1.getY(),arrayMio);
					}
				}
			}
		}
		return p1;

	}

	////////****METODO CONTRASTO///*/*/*/*////***

	public Point Contrasto(Giocatore arrayMio[],Giocatore arrayAvv[], int abilita,SquadraAvversaria squadraAvv){ //in maniera tale che se una 
		//squadra ha più abilità difensive è più probabile che vincerà un contrasto
		Point p = this.getPosizione().getLocation();
		Point pavv = new Point();
		Giocatore b = null;
		if(this.getSquadra().equalsIgnoreCase(squadraAvv.GetNomeSquadra())){  		//chi ha chiamato il metodo è  un umano o un computer

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
			if(this.getDotiRuolo() >= b.getDotiRuolo()){
				if((int)(Math.random()*10)+1>NUMrIUSCITAbRAVO){
					//	return CONTRASTO;
					return this.getLocation();
				}
				else return pavv.getLocation();//return CONTRASTOPERSO;
			}
			else if(this.getDotiRuolo() >= CalcolaDotiIntermedie(b.getDotiRuolo())){
				if((int)(Math.random()*10)+1>NUMrIUSCITAmEDIO){
					//	return CONTRASTO;
					return this.getLocation();

				}
				else return pavv.getLocation(); //return CONTRASTOPERSO;
			}
			else if(abilita > MINABILITAPERBONUS){
				if((int)(Math.random()*10)+1>NUMrIUSCITAsCARSOcONaBILITÀ){
					//return CONTRASTO;
					return this.getLocation();
				}
				else return pavv.getLocation();//return CONTRASTOPERSO;
			}
			else{
				if((int)(Math.random()*10)+1>NUMrIUSCITAsCARSO){
					//return CONTRASTO;
					return this.getLocation();
				}
				else return pavv.getLocation();//return CONTRASTOPERSO;
			}			
		}
		else {
			Point newp = new Point();
			return newp;
		}
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
	public int Tiro(int abilitaattacco, Portiere portiere, int abilitadifesa){	 
		if (abilitaattacco > ABILITADIATTACCOMASSIME){
			if(abilitadifesa > ABILITADIDIFESAMASSIME){
				//probabilità di tirare pari è 1/4 per att, 1/5 per centracmp, 1/6 difensore

				return ControllaChiTira( portiere,4,5,6); //X simo :D M'BARE non posso mettere 5 costanti diverse x questi numeri :D kmq sia la 
				//spiegazione dei numeri è riportata sopra ogni chiamata  del metodo ControllaChiTira
				// grazie per la comprensione :D :D :D

			}
			else {
				if (abilitadifesa > ABILITADIDIFESAMINIME && abilitadifesa < ABILITADIDIFESAMASSIME){ //ATTACCO MASSIMO DIFESA MEDIA
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
			if((int)(Math.random()*10) >= j) return GOAL;
			else return FUORI;
		}
		else{
			if(this.getTiro() >= ABILITADITIRODISCRETE){
				if((int)(Math.random()*10) >= k) return GOAL;
				else return FUORI;
			}
			else{
				if(this.getTiro() >= ABILITADITIROSCARSE){
					if((int)(Math.random()*10) >= i) return GOAL;
					else return FUORI;
				}
			}
		}
		return -1;
	}

	private int EsecuzioneParata(int j, int k, int i, Portiere portiere){


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
						return EsecuzioneParata(COSTANTEPERRIUSCITATIROBUONE,COSTANTEPERRIUSCITATIROMEDIE,COSTANTEPERRIUSCITATIROSCARSE	,portiere);
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