package graphic;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Sfondo extends JLabel {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 7533349940834185551L;

    /**
     * @wbp.parser.constructor
     */
    public Sfondo() {
    	setIcon(new ImageIcon(Sfondo.class.getResource("/scudetti/Football.jpg")));
    	setSize(new Dimension(800, 400));
    }
 
}