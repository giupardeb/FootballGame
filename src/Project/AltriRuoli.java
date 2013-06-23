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
	
	private final int NUMrIUSCITAsCARSO = 7;
	private final int NUMrIUSCITAmEDIO = 5;
	private final int NUMrIUSCITAbRAVO = 3;
	
	private final int NUMEQUO = 4;
	private final int CONTRASTO = 1;
	private final int NIENTECONTRASTO = 2;
	private final int CONTRASTOPERSO = 3; 

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
		
		if(this.getPassaggio()<50)
			if((int)(Math.random()*10)+1>NUMrIUSCITAsCARSO) return newp;
		else
			if(this.getPassaggio()<70)
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
	
	
	public int Contrasto(Giocatore campo[][]){
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
			else if(((int)Math.random()*10)+1>NUMrIUSCITAsCARSO){
				return CONTRASTO;
			}
			else return CONTRASTOPERSO;
			
		}
	else return NIENTECONTRASTO;
		
	}
	
	public int CalcolaDotiIntermedie(int DotiPiuForte){
		int tmp = DotiPiuForte*30/100;
		return DotiPiuForte - tmp;
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