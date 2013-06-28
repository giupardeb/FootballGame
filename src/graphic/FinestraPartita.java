package graphic;
import Project.Campionato;
import Project.SquadraAvversaria;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;

import Project.Giocatore;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.TextArea;
import java.awt.Label;

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
		
		final SquadraAvversaria squadraAvv = c.Incontri.pop();
		final Giocatore arrayAvv[] = squadraAvv.OrganizzaSquadra();
		
		initialize(panel_2,c,arrayAvv);
		
		
		
		Thread t  = new Thread (new Runnable () {
			public void run () {
				//qui ci metti tutte le istruzioni che il thread deve eseguire
				c.partita(c.squadra, squadraAvv,panel_2,arrayMio,arrayAvv);
			}
		});

		//per avviare il Thread fai così:
		t.start ();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final JPanel panel_2,final Campionato c,Giocatore arrayAvv[]) {
		this.setSize(700, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panelScelte = new JPanel();
		panel.add(panelScelte, BorderLayout.SOUTH);
		panelScelte.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnStop = new JButton("stop");
		btnStop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//ferma la partita
				c.setFerma(true);
			}
		});
		panelScelte.add(btnStop);

		JButton btnRilancia = new JButton("Rilancia");
		btnRilancia.setEnabled(false);
		panelScelte.add(btnRilancia);

		JButton btnTira = new JButton("Tira");
		panelScelte.add(btnTira);

		JButton btnPassaggio = new JButton("Passaggio");
		panelScelte.add(btnPassaggio);

		JButton btnContrasto = new JButton("Contrasto");
		panelScelte.add(btnContrasto);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setRequestFocusEnabled(false);
		splitPane.setResizeWeight(0.7);
		panel.add(splitPane, BorderLayout.CENTER);
		
		Label VisualizzaInfo = new Label("");
		splitPane.setRightComponent(VisualizzaInfo);
		
		arrayAvv[0].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/pallaAvv.png")));
		GridBagConstraints gbc_PortiereAvv = new GridBagConstraints();
		gbc_PortiereAvv.insets = new Insets(0, 0, 0, 5);
		gbc_PortiereAvv.gridx = 7;
		gbc_PortiereAvv.gridy = 2;
		arrayAvv[0].setPosizione(7, 2);
		panel_2.add(arrayAvv[0], gbc_PortiereAvv);
		
		arrayAvv[1].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/pallaAvv.png")));
		GridBagConstraints gbc_DifensoreAvv = new GridBagConstraints();
		gbc_DifensoreAvv.insets = new Insets(0, 0, 0, 5);
		gbc_DifensoreAvv.gridx = 6;
		gbc_DifensoreAvv.gridy = 1;
		arrayAvv[1].setPosizione(6, 1);
		panel_2.add(arrayAvv[1], gbc_DifensoreAvv);
		
		arrayAvv[2].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/pallaAvv.png")));
		GridBagConstraints gbc_DifensoreAvv1 = new GridBagConstraints();
		gbc_DifensoreAvv1.insets = new Insets(0, 0, 0, 5);
		gbc_DifensoreAvv1.gridx = 6;
		gbc_DifensoreAvv1.gridy = 2;
		arrayAvv[2].setPosizione(6, 2);
		panel_2.add(arrayAvv[2], gbc_DifensoreAvv1);
		
		arrayAvv[3].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/pallaAvv.png")));
		GridBagConstraints gbc_DifensoreAvv2 = new GridBagConstraints();
		gbc_DifensoreAvv2.insets = new Insets(0, 0, 0, 5);
		gbc_DifensoreAvv2.gridx = 6;
		gbc_DifensoreAvv2.gridy = 3;
		arrayAvv[3].setPosizione(6,3);
		panel_2.add(arrayAvv[3], gbc_DifensoreAvv2);
		
		arrayAvv[4].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/pallaAvv.png")));
		GridBagConstraints gbc_DifensoreAvv3 = new GridBagConstraints();
		gbc_DifensoreAvv3.insets = new Insets(0, 0, 0, 5);
		gbc_DifensoreAvv3.gridx = 6;
		gbc_DifensoreAvv3.gridy = 4;
		arrayAvv[4].setPosizione(6, 4);
		panel_2.add(arrayAvv[4], gbc_DifensoreAvv3);
		
		arrayAvv[5].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/pallaAvv.png")));
		GridBagConstraints gbc_CentrocampistaAvv = new GridBagConstraints();
		gbc_CentrocampistaAvv.insets = new Insets(0, 0, 0, 5);
		gbc_CentrocampistaAvv.gridx = 4;
		gbc_CentrocampistaAvv.gridy = 1;
		arrayAvv[5].setPosizione(4, 1);
		panel_2.add(arrayAvv[5], gbc_CentrocampistaAvv);
		
		arrayAvv[6].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/pallaAvv.png")));
		GridBagConstraints gbc_CentrocampistaAvv1 = new GridBagConstraints();
		gbc_CentrocampistaAvv1.insets = new Insets(0, 0, 0, 5);
		gbc_CentrocampistaAvv1.gridx = 4;
		gbc_CentrocampistaAvv1.gridy = 2;
		arrayAvv[6].setPosizione(4, 2);
		panel_2.add(arrayAvv[6], gbc_CentrocampistaAvv1);
		
		arrayAvv[7].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/pallaAvv.png")));
		GridBagConstraints gbc_CentrocampistaAvv2 = new GridBagConstraints();
		gbc_CentrocampistaAvv2.insets = new Insets(0, 0, 0, 5);
		gbc_CentrocampistaAvv2.gridx = 4;
		gbc_CentrocampistaAvv2.gridy = 3;
		arrayAvv[7].setPosizione(4, 3);
		panel_2.add(arrayAvv[7], gbc_CentrocampistaAvv2);
		
		arrayAvv[8].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/pallaAvv.png")));
		GridBagConstraints gbc_CentrocampistaAvv3 = new GridBagConstraints();
		gbc_CentrocampistaAvv3.insets = new Insets(0, 0, 0, 5);
		gbc_CentrocampistaAvv3.gridx = 4;
		gbc_CentrocampistaAvv3.gridy = 4;
		arrayAvv[8].setPosizione(4, 4);
		panel_2.add(arrayAvv[8], gbc_CentrocampistaAvv3);
		
		arrayAvv[9].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/pallaAvv.png")));
		GridBagConstraints gbc_AttaccanteAvv = new GridBagConstraints();
		gbc_AttaccanteAvv.insets = new Insets(0, 0, 0, 5);
		gbc_AttaccanteAvv.gridx = 2;
		gbc_AttaccanteAvv.gridy = 2;
		arrayAvv[9].setPosizione(2, 2);
		panel_2.add(arrayAvv[9], gbc_AttaccanteAvv);
		
		arrayAvv[10].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/pallaAvv.png")));
		GridBagConstraints gbc_AttaccanteAvv1 = new GridBagConstraints();
		gbc_AttaccanteAvv1.insets = new Insets(0, 0, 0, 5);
		gbc_AttaccanteAvv1.gridx = 2;
		gbc_AttaccanteAvv1.gridy = 3;
		arrayAvv[10].setPosizione(2, 3);
		panel_2.add(arrayAvv[10], gbc_AttaccanteAvv1);
		
		arrayAvv[10].setVisible(true);
		arrayAvv[9].setVisible(true);
		arrayAvv[8].setVisible(true);
		arrayAvv[7].setVisible(true);
		arrayAvv[6].setVisible(true);
		arrayAvv[5].setVisible(true);
		arrayAvv[4].setVisible(true);
		arrayAvv[3].setVisible(true);
		arrayAvv[2].setVisible(true);
		arrayAvv[1].setVisible(true);
		arrayAvv[0].setVisible(true);
		
		
		splitPane.setLeftComponent(panel_2);


		this.setVisible(true);
	}




}
