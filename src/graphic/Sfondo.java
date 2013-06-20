package graphic;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class Sfondo extends JPanel {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 7533349940834185551L;
	private Image sfondoImage;

    public Sfondo(Image sfondoImage) {
        this.sfondoImage = sfondoImage;
        this.setVisible(true);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setOpaque(false);
        g.drawImage(sfondoImage, 0, 0, this);
    }
}