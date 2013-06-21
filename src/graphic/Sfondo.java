package graphic;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Sfondo extends JLabel {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 7533349940834185551L;
	private Image img;

    /**
     * @wbp.parser.constructor
     */
    public Sfondo() {
    	setIcon(new ImageIcon(Sfondo.class.getResource("/scudetti/Football.jpg")));
    	setSize(new Dimension(800, 400));
    }
 
}