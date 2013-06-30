package graphic;
import Project.Campionato;
import Project.SquadraAvversaria;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;

import Project.Giocatore;
import javax.swing.JSplitPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class FinestraPartita extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6555644770549918991L;
	private JFrame frame = this;
	/**
	 * Create the application.
	 */
	public FinestraPartita(final JPanel panel_2, final Campionato c,final Giocatore arrayMio[]) {
		setResizable(false);
		
		JPanel panelScelte = new JPanel();
		getContentPane().add(panelScelte, BorderLayout.SOUTH);
		
		JButton btnRilancia = new JButton("Rilancia");
		btnRilancia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c.rilancia = 1;
			}
		});
		panelScelte.add(btnRilancia);
		
		JButton btnTira = new JButton("Tira");
		btnTira.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c.tira = 1;
			}
		});
		panelScelte.add(btnTira);
		
		JButton btnNewButton_1 = new JButton("Passaggio");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c.passa = 1;
			}
		});
		
		panelScelte.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Contrasto");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c.contrasto = 1;
			}
		});
		panelScelte.add(btnNewButton);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setContinuousLayout(true);
		splitPane.setResizeWeight(0.8);
		getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("");
		splitPane.setRightComponent(lblNewLabel);
		
		final SquadraAvversaria squadraAvv = c.Incontri.pop();
		final Giocatore arrayAvv[] = squadraAvv.OrganizzaSquadra();
		initialize(panel_2,c,arrayAvv);
		splitPane.setLeftComponent(panel_2);
		
		Thread t  = new Thread (new Runnable () {
			public void run () {
				//qui ci metti tutte le istruzioni che il thread deve eseguire
				c.partita(c.squadra, squadraAvv,frame,arrayMio,arrayAvv);
			}
		});

		//per avviare il Thread fai così:
		t.start ();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final JPanel panel_2,final Campionato c,Giocatore arrayAvv[]) {
		this.setSize(900, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		arrayAvv[0].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/portiereavv.gif")));
		arrayAvv[0].setBounds(638, 168, 48, 48);
		arrayAvv[0].setPosizione(638, 168);
		panel_2.add(arrayAvv[0]);
		
		arrayAvv[1].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/pallaAvv.png")));
		arrayAvv[1].setBounds(548, 26, 48, 48);
		arrayAvv[1].setPosizione(548, 26);
		panel_2.add(arrayAvv[1]);

		arrayAvv[2].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/pallaAvv.png")));
		arrayAvv[2].setBounds(548, 126, 48, 48);
		arrayAvv[2].setPosizione(548, 126);
		panel_2.add(arrayAvv[2]);


		arrayAvv[3].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/pallaAvv.png")));
		arrayAvv[3].setBounds(548, 226, 48, 48);
		arrayAvv[3].setPosizione(548, 226);
		panel_2.add(arrayAvv[3]);
		
		arrayAvv[4].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/pallaAvv.png")));
		arrayAvv[4].setBounds(548, 326, 48, 48);
		arrayAvv[4].setPosizione(548, 326);
		panel_2.add(arrayAvv[4]);

		arrayAvv[5].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/pallaAvv.png")));
		arrayAvv[5].setBounds(380, 26, 48, 48);
		arrayAvv[5].setPosizione(380, 26);
		panel_2.add(arrayAvv[5]);

		arrayAvv[6].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/pallaAvv.png")));
		arrayAvv[6].setBounds(380, 126, 48, 48);
		arrayAvv[6].setPosizione(380, 126);
		panel_2.add(arrayAvv[6]);

		arrayAvv[7].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/pallaAvv.png")));
		arrayAvv[7].setBounds(380, 226, 48, 48);
		arrayAvv[7].setPosizione(380, 226);
		panel_2.add(arrayAvv[7]);

		arrayAvv[8].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/pallaAvv.png")));
		arrayAvv[8].setBounds(380, 326, 48, 48);
		arrayAvv[8].setPosizione(380, 326);
		panel_2.add(arrayAvv[8]);

		arrayAvv[9].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/pallaAvv.png")));
		arrayAvv[9].setBounds(193, 126, 48, 48);
		arrayAvv[9].setPosizione(193, 126);
		panel_2.add(arrayAvv[9]);

		arrayAvv[10].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/pallaAvv.png")));
		arrayAvv[10].setBounds(193, 226, 48, 48);
		arrayAvv[10].setPosizione(193,226);
		panel_2.add(arrayAvv[10]);
		
		arrayAvv[10].setVisible(false);
		arrayAvv[9].setVisible(false);
		arrayAvv[8].setVisible(false);
		arrayAvv[7].setVisible(false);
		arrayAvv[6].setVisible(false);
		arrayAvv[5].setVisible(false);
		arrayAvv[4].setVisible(false);
		arrayAvv[3].setVisible(false);
		arrayAvv[2].setVisible(false);
		arrayAvv[1].setVisible(false);
		arrayAvv[0].setVisible(false);


		this.setVisible(true);
	}




}
