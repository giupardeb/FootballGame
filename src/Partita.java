public class Partita
{
	/*
	 *  TODO - sostituire tutti i numeri usando delle costanti.
	 * non usare costanti se il numero può essere calcolato. 
	 * Esempio:
	 * se hai i numeri 100 e 50 e questi sono correlati. Per esempio
	 * 100 è la lunghezza del campo e 50 il centro del campo.
	 * Allora bisogna creare una costante A = 100 e invece di creare una costante per 50
	 * basta usare A/2. 
	 */ 
	
	
	public void EseguiPartita(Squadra a, SquadraAvversaria b )
	{
		Giocatore miasquadra[] = new Giocatore[a.OrganizzaSquadra().length];
		Giocatore squadra[] = new Giocatore[b.OrganizzaSquadra().length];
	}

	private byte[][] CreaCampo(){
		byte campo [][] = new byte [90][100];
		
		//PERIMETRO CAMPO 
		for(int i=0;i<campo.length;i++) campo[i][0] = 99;
		for(int i=0;i<campo[0].length;i++) campo[0][i] = 99;
		for(int i=0;i<campo.length;i++) campo[i][campo[0].length-1] = 99;
		for(int i=0;i<campo[0].length;i++) campo[campo.length-1][i] = 99;
		
		//SUDDIVISIONE DEL CAMPO A ZONE
		for(int i=1; i<=88;i++){
			for(int j=1; j<=33;j++){
				campo[i][j] = 26; //area difesa mia
			}
		}
		
		for(int i=1; i<=88;i++){
			for(int j=34; j<=67;j++){
				campo[i][j] = 27; //area centrocampo mia
			}
		}
		
		for(int i=1; i<=88;i++){
			for(int j=68; j<99;j++){
				campo[i][j] = 28; //area attacco mia
			}
		}

		for(int i=20; i<=50;i++){
			for(int j=1; j<=4;j++){
				campo[i][j] = 25;//area rigore mia
			}
		}
		
		campo[35][1] = 1; //portiere mio
		
		for(int i=20; i<=50;i++){
			for(int j=95; j<=98;j++){
				campo[i][j] = 24; //area rigore avversaria
			}
		}
		
		campo[35][98] = 12; //portiere avversario
		
		return campo;
	}
}