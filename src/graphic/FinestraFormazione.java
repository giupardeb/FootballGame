package graphic;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;

import javax.swing.JButton;

import Project.Campionato;
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
			//	Giocatore campo[][] = new Giocatore[6][8];

				JPanel	panel_2 = new JPanel();
				panel_2.setBackground(new Color(0, 128, 0));
				GridBagLayout gbl_panel_2 = new GridBagLayout();
				gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
				gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
				gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				panel_2.setLayout(gbl_panel_2);

				
				array[0].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/soccerSmall.png")));
				GridBagConstraints gbc_Portiere = new GridBagConstraints();
				gbc_Portiere.insets = new Insets(0, 0, 0, 5);
				gbc_Portiere.gridx = 0;
				gbc_Portiere.gridy = 2;
				array[0].setPosizione(0, 2);
				panel_2.add(array[0], gbc_Portiere);
				
				array[1].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/soccerSmall.png")));
				GridBagConstraints gbc_Difensore = new GridBagConstraints();
				gbc_Difensore.insets = new Insets(0, 0, 0, 5);
				gbc_Difensore.gridx = 1;
				gbc_Difensore.gridy = 1;
				array[1].setPosizione(1, 1);
				panel_2.add(array[1], gbc_Difensore);
				
				array[2].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/soccerSmall.png")));
				GridBagConstraints gbc_Difensore1 = new GridBagConstraints();
				gbc_Difensore1.insets = new Insets(0, 0, 0, 5);
				gbc_Difensore1.gridx = 1;
				gbc_Difensore1.gridy = 2;
				array[2].setPosizione(1, 2);
				panel_2.add(array[2], gbc_Difensore1);
				
				array[3].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/soccerSmall.png")));
				GridBagConstraints gbc_Difensore2 = new GridBagConstraints();
				gbc_Difensore2.insets = new Insets(0, 0, 0, 5);
				gbc_Difensore2.gridx = 1;
				gbc_Difensore2.gridy = 3;
				array[3].setPosizione(1,3);
				panel_2.add(array[3], gbc_Difensore2);
				
				array[4].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/soccerSmall.png")));
				GridBagConstraints gbc_Difensore3 = new GridBagConstraints();
				gbc_Difensore3.insets = new Insets(0, 0, 0, 5);
				gbc_Difensore3.gridx = 1;
				gbc_Difensore3.gridy = 4;
				array[4].setPosizione(1, 4);
				panel_2.add(array[4], gbc_Difensore3);
				
				array[5].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/soccerSmall.png")));
				GridBagConstraints gbc_Centrocampista = new GridBagConstraints();
				gbc_Centrocampista.insets = new Insets(0, 0, 0, 5);
				gbc_Centrocampista.gridx = 3;
				gbc_Centrocampista.gridy = 1;
				array[5].setPosizione(3, 1);
				panel_2.add(array[5], gbc_Centrocampista);
				
				array[6].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/soccerSmall.png")));
				GridBagConstraints gbc_Centrocampista1 = new GridBagConstraints();
				gbc_Centrocampista1.insets = new Insets(0, 0, 0, 5);
				gbc_Centrocampista1.gridx = 3;
				gbc_Centrocampista1.gridy = 2;
				array[6].setPosizione(3, 2);
				panel_2.add(array[6], gbc_Centrocampista1);
				
				array[7].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/soccerSmall.png")));
				GridBagConstraints gbc_Centrocampista2 = new GridBagConstraints();
				gbc_Centrocampista2.insets = new Insets(0, 0, 0, 5);
				gbc_Centrocampista2.gridx = 3;
				gbc_Centrocampista2.gridy = 3;
				array[7].setPosizione(3, 3);
				panel_2.add(array[7], gbc_Centrocampista2);
				
				array[8].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/soccerSmall.png")));
				GridBagConstraints gbc_Centrocampista3 = new GridBagConstraints();
				gbc_Centrocampista3.insets = new Insets(0, 0, 0, 5);
				gbc_Centrocampista3.gridx = 3;
				gbc_Centrocampista3.gridy = 4;
				array[8].setPosizione(3, 4);
				panel_2.add(array[8], gbc_Centrocampista3);
				
				array[9].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/soccerSmall.png")));
				GridBagConstraints gbc_Attaccante = new GridBagConstraints();
				gbc_Attaccante.insets = new Insets(0, 0, 0, 5);
				gbc_Attaccante.gridx = 5;
				gbc_Attaccante.gridy = 2;
				array[9].setPosizione(5, 2);
				panel_2.add(array[9], gbc_Attaccante);
				
				array[10].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/soccerSmall.png")));
				GridBagConstraints gbc_Attaccante1 = new GridBagConstraints();
				gbc_Attaccante1.insets = new Insets(0, 0, 0, 5);
				gbc_Attaccante1.gridx = 5;
				gbc_Attaccante1.gridy = 3;
				array[10].setPosizione(5, 3);
				panel_2.add(array[10], gbc_Attaccante1);
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
				FinestraPartita fp = new FinestraPartita(panel_2,c); 

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
