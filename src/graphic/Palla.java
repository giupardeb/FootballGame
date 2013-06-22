package graphic;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Palla extends ImageIcon {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7342766703705607917L;
	private JFrame frame;
	int x, y;
	final static String url = "images/soccerSmall.png";
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public Palla(int x, int y){
		super(url);
		this.x = x;
		this.y = y;
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
