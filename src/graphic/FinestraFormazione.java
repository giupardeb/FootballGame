package graphic;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;

import Project.Campionato;
import Project.Giocatore;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class FinestraFormazione extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1627745280222260463L;
	private JFrame frame = this;


	/**
	 * Create the application.
	 */
	public FinestraFormazione(Giocatore[] array,Campionato c) {
		initialize(array,c);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final Giocatore[] array,final Campionato c) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(400,200);
		this.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton button = new JButton("4-4-2");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				JPanel	panel_2 = new JPanel();
				panel_2.setBackground(new Color(0, 128, 0));
				panel_2.setLayout(null);

				//Difensore
				
				array[0].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/portiereMio.gif")));
				array[0].setBounds(12, 168, 48, 48);
				array[0].setPosizione(12, 168);
				panel_2.add(array[0]);
				
				array[1].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/soccerSmallD.png")));
				array[1].setBounds(110, 26, 48, 48);
				array[1].setPosizione(110, 26);
				panel_2.add(array[1]);

				array[2].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/soccerSmallD.png")));
				array[2].setBounds(110, 126, 48, 48);
				array[2].setPosizione(110, 126);
				panel_2.add(array[2]);


				array[3].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/soccerSmallD.png")));
				array[3].setBounds(110, 226, 48, 48);
				array[3].setPosizione(110, 226);
				panel_2.add(array[3]);
				
				array[4].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/soccerSmallD.png")));
				array[4].setBounds(110, 326, 48, 48);
				array[4].setPosizione(110, 326);
				panel_2.add(array[4]);

				array[5].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/soccerSmallC.png")));
				array[5].setBounds(277, 26, 48, 48);
				array[5].setPosizione(277, 26);
				panel_2.add(array[5]);

				array[6].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/soccerSmallC.png")));
				array[6].setBounds(277, 126, 48, 48);
				array[6].setPosizione(277, 126);
				panel_2.add(array[6]);

				array[7].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/soccerSmallC.png")));
				array[7].setBounds(277, 226, 48, 48);
				array[7].setPosizione(277, 226);
				panel_2.add(array[7]);

				array[8].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/soccerSmallC.png")));
				array[8].setBounds(277, 326, 48, 48);
				array[8].setPosizione(277, 326);
				panel_2.add(array[8]);

				array[9].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/soccerSmallA.png")));
				array[9].setBounds(457, 126, 48, 48);
				array[9].setPosizione(457, 126);
				panel_2.add(array[9]);

				array[10].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/soccerSmallA.png")));
				array[10].setBounds(457, 226, 48, 48);
				array[10].setPosizione(457,226);
				panel_2.add(array[10]);
								
				array[10].setVisible(false);
				array[9].setVisible(false);
				array[8].setVisible(false);
				array[7].setVisible(false);
				array[6].setVisible(false);
				array[5].setVisible(false);
				array[4].setVisible(false);
				array[3].setVisible(false);
				array[2].setVisible(false);
				array[1].setVisible(false);
				array[0].setVisible(false);
				
				frame.dispose();
				FinestraPartita fp = new FinestraPartita(panel_2,c,array); 

			}
		});
		button.setBounds(139, 61, 117, 25);
		panel.add(button);
		this.setVisible(true);

	}

/*	private int SearchGiocatore (String ruolo, ArrayList<Giocatore> array){

		for(Giocatore giocatore : array)
			if(giocatore.getRuolo().equalsIgnoreCase(ruolo)) {
				int i = array.indexOf(giocatore);
				array.remove(giocatore);
				return i;
			}
		return -1;
	}*/

}
