public class Palla{
	
	private final static int POSIZIONE_INIZIALE_X = 45;
	private final static int POSIZIONE_INIZIALE_Y = 60;
	
	int x;
	int y;
	
	public Palla(){
		x = POSIZIONE_INIZIALE_X;
		y = POSIZIONE_INIZIALE_Y;
	}
	
	public void setPalla(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getPallaX(){
		return x;
	}
	
	public int getPallaY(){
		return y;
	}
}