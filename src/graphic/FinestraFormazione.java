package graphic;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Point;

import javax.swing.JButton;

import Project.Giocatore;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;



public class FinestraFormazione extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1627745280222260463L;
	private JFrame frame = this;


	/**
	 * Create the application.
	 */
	public FinestraFormazione(ArrayList<Giocatore> array) {
		initialize(array);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final ArrayList<Giocatore> array) {
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
				Giocatore campo[][] = new Giocatore[6][8];

				campo[2][0] = array.get(SearchGiocatore ("portiere",array));
				campo[2][0].setPosizione(2, 0);
				campo[1][1] = array.get(SearchGiocatore ("difensore",array));
				campo[1][1].setPosizione(1, 1);
				campo[2][1] = array.get(SearchGiocatore ("difensore",array));
				campo[2][1].setPosizione(2, 1);
				campo[3][1] = array.get(SearchGiocatore ("difensore",array));
				campo[3][1].setPosizione(3, 1);
				campo[4][1] = array.get(SearchGiocatore ("difensore",array));
				campo[4][1].setPosizione(4, 1);
				campo[1][3] = array.get(SearchGiocatore ("centrocampista",array));
				campo[1][3].setPosizione(1, 3);
				campo[2][3] = array.get(SearchGiocatore ("centrocampista",array));
				campo[2][3].setPosizione(2, 3);
				campo[3][3] = array.get(SearchGiocatore ("centrocampista",array));
				campo[3][3].setPosizione(3, 3);
				campo[4][3] = array.get(SearchGiocatore ("centrocampista",array));
				campo[4][3].setPosizione(4, 3);
				campo[2][5] = array.get(SearchGiocatore ("attaccante",array));
				campo[2][5].setPosizione(2, 5);
				campo[3][5] = array.get(SearchGiocatore ("attaccante",array));
				campo[3][5].setPosizione(3, 5);
				
				FinestraPartita fp = new FinestraPartita(campo); 
			}
		});
		button.setBounds(12, 61, 117, 25);
		panel.add(button);

		JButton btnNewButton = new JButton("4-3-3");

		btnNewButton.setBounds(269, 61, 117, 25);
		panel.add(btnNewButton);
		this.setVisible(true);

	}

	private int SearchGiocatore (String ruolo, ArrayList<Giocatore> array){

		for(Giocatore giocatore : array)
			if(giocatore.getRuolo().equalsIgnoreCase(ruolo)) {
				int i = array.indexOf(giocatore);
				array.remove(giocatore);
				return i;
			}
		return -1;
	}

}
