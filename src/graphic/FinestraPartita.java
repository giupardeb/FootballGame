package graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;

import Project.Giocatore;
import javax.swing.JSplitPane;
import java.awt.TextArea;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JInternalFrame;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class FinestraPartita extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6555644770549918991L;
	private JFrame frame;
	private Palla ball;
	private JLabel palla;

	/**
	 * Create the application.
	 */
	public FinestraPartita(Giocatore campo [][]) {
		initialize(campo);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Giocatore campo [][]) {
		this.setSize(700, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelScelte = new JPanel();
		panel.add(panelScelte, BorderLayout.SOUTH);
		panelScelte.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnTira = new JButton("Tira");
		panelScelte.add(btnTira);
		
		JButton btnPassaggio = new JButton("Passaggio");
		panelScelte.add(btnPassaggio);
		
		JButton btnContrasto = new JButton("Contrasto");
		panelScelte.add(btnContrasto);
		
		JButton btnSostituzioni = new JButton("Sostituzioni");
		panelScelte.add(btnSostituzioni);
		
		JSplitPane splitPane = new JSplitPane();
		panel.add(splitPane, BorderLayout.CENTER);
		InizializzaCampo(campo);
		
		JLabel visualizzainfopartita = new JLabel("");
		splitPane.setRightComponent(visualizzainfopartita);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("OptionPane.questionDialog.border.background"));
		splitPane.setLeftComponent(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblDifensore = new JLabel("");
		lblDifensore.setEnabled(false);
		lblDifensore.setIcon(new ImageIcon(FinestraPartita.class.getResource("/images/soccerSmall.png")));
		GridBagConstraints gbc_lblDifensore = new GridBagConstraints();
		gbc_lblDifensore.insets = new Insets(0, 0, 5, 5);
		gbc_lblDifensore.gridx = 1;
		gbc_lblDifensore.gridy = 1;
		panel_1.add(lblDifensore, gbc_lblDifensore);
		
		JLabel lblCentrocampista = new JLabel("");
		lblCentrocampista.setEnabled(false);
		lblCentrocampista.setIcon(new ImageIcon(FinestraPartita.class.getResource("/images/soccerSmall.png")));
		GridBagConstraints gbc_lblCentrocampista = new GridBagConstraints();
		gbc_lblCentrocampista.insets = new Insets(0, 0, 5, 5);
		gbc_lblCentrocampista.gridx = 3;
		gbc_lblCentrocampista.gridy = 1;
		panel_1.add(lblCentrocampista, gbc_lblCentrocampista);
		
		JLabel lblCentrocampistaAvv = new JLabel("");
		lblCentrocampistaAvv.setEnabled(false);
		lblCentrocampistaAvv.setIcon(new ImageIcon(FinestraPartita.class.getResource("/images/pallaAvv.png")));
		GridBagConstraints gbc_lblCentrocampistaAvv = new GridBagConstraints();
		gbc_lblCentrocampistaAvv.insets = new Insets(0, 0, 5, 5);
		gbc_lblCentrocampistaAvv.gridx = 4;
		gbc_lblCentrocampistaAvv.gridy = 1;
		panel_1.add(lblCentrocampistaAvv, gbc_lblCentrocampistaAvv);
		
		JLabel lblDifensoreAvv = new JLabel("");
		lblDifensoreAvv.setEnabled(false);
		lblDifensoreAvv.setIcon(new ImageIcon(FinestraPartita.class.getResource("/images/pallaAvv.png")));
		GridBagConstraints gbc_lblDifensoreAvv = new GridBagConstraints();
		gbc_lblDifensoreAvv.insets = new Insets(0, 0, 5, 5);
		gbc_lblDifensoreAvv.gridx = 6;
		gbc_lblDifensoreAvv.gridy = 1;
		panel_1.add(lblDifensoreAvv, gbc_lblDifensoreAvv);
		
		JLabel lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblDifensore_1 = new JLabel("");
		lblDifensore_1.setEnabled(false);
		lblDifensore_1.setIcon(new ImageIcon(FinestraPartita.class.getResource("/images/soccerSmall.png")));
		GridBagConstraints gbc_lblDifensore_1 = new GridBagConstraints();
		gbc_lblDifensore_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblDifensore_1.gridx = 1;
		gbc_lblDifensore_1.gridy = 2;
		panel_1.add(lblDifensore_1, gbc_lblDifensore_1);
		
		JLabel lblAttacAvv = new JLabel("");
		lblAttacAvv.setEnabled(false);
		lblAttacAvv.setIcon(new ImageIcon(FinestraPartita.class.getResource("/images/pallaAvv.png")));
		GridBagConstraints gbc_lblAttacAvv = new GridBagConstraints();
		gbc_lblAttacAvv.insets = new Insets(0, 0, 5, 5);
		gbc_lblAttacAvv.gridx = 2;
		gbc_lblAttacAvv.gridy = 2;
		panel_1.add(lblAttacAvv, gbc_lblAttacAvv);
		
		JLabel lblCentrocampista1 = new JLabel("");
		lblCentrocampista1.setEnabled(false);
		lblCentrocampista1.setIcon(new ImageIcon(FinestraPartita.class.getResource("/images/soccerSmall.png")));
		GridBagConstraints gbc_lblCentrocampista1 = new GridBagConstraints();
		gbc_lblCentrocampista1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCentrocampista1.gridx = 3;
		gbc_lblCentrocampista1.gridy = 2;
		panel_1.add(lblCentrocampista1, gbc_lblCentrocampista1);
		
		JLabel lblCentrocampistaAvv1 = new JLabel("");
		lblCentrocampistaAvv1.setEnabled(false);
		lblCentrocampistaAvv1.setIcon(new ImageIcon(FinestraPartita.class.getResource("/images/pallaAvv.png")));
		GridBagConstraints gbc_lblCentrocampistaAvv1 = new GridBagConstraints();
		gbc_lblCentrocampistaAvv1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCentrocampistaAvv1.gridx = 4;
		gbc_lblCentrocampistaAvv1.gridy = 2;
		panel_1.add(lblCentrocampistaAvv1, gbc_lblCentrocampistaAvv1);
		
		JLabel lblAttaccante = new JLabel("");
		lblAttaccante.setEnabled(false);
		lblAttaccante.setIcon(new ImageIcon(FinestraPartita.class.getResource("/images/soccerSmall.png")));
		GridBagConstraints gbc_lblAttaccante = new GridBagConstraints();
		gbc_lblAttaccante.insets = new Insets(0, 0, 5, 5);
		gbc_lblAttaccante.gridx = 5;
		gbc_lblAttaccante.gridy = 2;
		panel_1.add(lblAttaccante, gbc_lblAttaccante);
		
		JLabel lblDifensoreAvv1 = new JLabel("");
		lblDifensoreAvv1.setEnabled(false);
		lblDifensoreAvv1.setIcon(new ImageIcon(FinestraPartita.class.getResource("/images/pallaAvv.png")));
		GridBagConstraints gbc_lblDifensoreAvv1 = new GridBagConstraints();
		gbc_lblDifensoreAvv1.insets = new Insets(0, 0, 5, 5);
		gbc_lblDifensoreAvv1.gridx = 6;
		gbc_lblDifensoreAvv1.gridy = 2;
		panel_1.add(lblDifensoreAvv1, gbc_lblDifensoreAvv1);
		
		JLabel lblDifensore_2 = new JLabel("");
		lblDifensore_2.setEnabled(false);
		lblDifensore_2.setIcon(new ImageIcon(FinestraPartita.class.getResource("/images/soccerSmall.png")));
		GridBagConstraints gbc_lblDifensore_2 = new GridBagConstraints();
		gbc_lblDifensore_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblDifensore_2.gridx = 1;
		gbc_lblDifensore_2.gridy = 3;
		panel_1.add(lblDifensore_2, gbc_lblDifensore_2);
		
		JLabel lblAttacAvv1 = new JLabel("");
		lblAttacAvv1.setEnabled(false);
		lblAttacAvv1.setIcon(new ImageIcon(FinestraPartita.class.getResource("/images/pallaAvv.png")));
		GridBagConstraints gbc_lblAttacAvv1 = new GridBagConstraints();
		gbc_lblAttacAvv1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAttacAvv1.gridx = 2;
		gbc_lblAttacAvv1.gridy = 3;
		panel_1.add(lblAttacAvv1, gbc_lblAttacAvv1);
		
		JLabel lblCentrocampista2 = new JLabel("");
		lblCentrocampista2.setEnabled(false);
		lblCentrocampista2.setIcon(new ImageIcon(FinestraPartita.class.getResource("/images/soccerSmall.png")));
		GridBagConstraints gbc_lblCentrocampista2 = new GridBagConstraints();
		gbc_lblCentrocampista2.insets = new Insets(0, 0, 5, 5);
		gbc_lblCentrocampista2.gridx = 3;
		gbc_lblCentrocampista2.gridy = 3;
		panel_1.add(lblCentrocampista2, gbc_lblCentrocampista2);
		
		JLabel lblCentrocampistaAvv2 = new JLabel("");
		lblCentrocampistaAvv2.setEnabled(false);
		lblCentrocampistaAvv2.setIcon(new ImageIcon(FinestraPartita.class.getResource("/images/pallaAvv.png")));
		GridBagConstraints gbc_lblCentrocampistaAvv2 = new GridBagConstraints();
		gbc_lblCentrocampistaAvv2.insets = new Insets(0, 0, 5, 5);
		gbc_lblCentrocampistaAvv2.gridx = 4;
		gbc_lblCentrocampistaAvv2.gridy = 3;
		panel_1.add(lblCentrocampistaAvv2, gbc_lblCentrocampistaAvv2);
		
		JLabel lblAttaccante1 = new JLabel("");
		lblAttaccante1.setEnabled(false);
		lblAttaccante1.setIcon(new ImageIcon(FinestraPartita.class.getResource("/images/soccerSmall.png")));
		GridBagConstraints gbc_lblAttaccante1 = new GridBagConstraints();
		gbc_lblAttaccante1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAttaccante1.gridx = 5;
		gbc_lblAttaccante1.gridy = 3;
		panel_1.add(lblAttaccante1, gbc_lblAttaccante1);
		
		JLabel lblDifensoreAvv2 = new JLabel("");
		lblDifensoreAvv2.setEnabled(false);
		lblDifensoreAvv2.setIcon(new ImageIcon(FinestraPartita.class.getResource("/images/pallaAvv.png")));
		GridBagConstraints gbc_lblDifensoreAvv2 = new GridBagConstraints();
		gbc_lblDifensoreAvv2.insets = new Insets(0, 0, 5, 5);
		gbc_lblDifensoreAvv2.gridx = 6;
		gbc_lblDifensoreAvv2.gridy = 3;
		panel_1.add(lblDifensoreAvv2, gbc_lblDifensoreAvv2);
		
		JLabel lblDifensore_3 = new JLabel("");
		lblDifensore_3.setEnabled(false);
		lblDifensore_3.setIcon(new ImageIcon(FinestraPartita.class.getResource("/images/soccerSmall.png")));
		GridBagConstraints gbc_lblDifensore_3 = new GridBagConstraints();
		gbc_lblDifensore_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblDifensore_3.gridx = 1;
		gbc_lblDifensore_3.gridy = 4;
		panel_1.add(lblDifensore_3, gbc_lblDifensore_3);
		
		JLabel lblCentrocampista3 = new JLabel("");
		lblCentrocampista3.setEnabled(false);
		lblCentrocampista3.setIcon(new ImageIcon(FinestraPartita.class.getResource("/images/soccerSmall.png")));
		GridBagConstraints gbc_lblCentrocampista3 = new GridBagConstraints();
		gbc_lblCentrocampista3.insets = new Insets(0, 0, 0, 5);
		gbc_lblCentrocampista3.gridx = 3;
		gbc_lblCentrocampista3.gridy = 4;
		panel_1.add(lblCentrocampista3, gbc_lblCentrocampista3);
		
		JLabel lblCentrocampistaAvv3 = new JLabel("");
		lblCentrocampistaAvv3.setEnabled(false);
		lblCentrocampistaAvv3.setIcon(new ImageIcon(FinestraPartita.class.getResource("/images/pallaAvv.png")));
		GridBagConstraints gbc_lblCentrocampistaAvv3 = new GridBagConstraints();
		gbc_lblCentrocampistaAvv3.insets = new Insets(0, 0, 0, 5);
		gbc_lblCentrocampistaAvv3.gridx = 4;
		gbc_lblCentrocampistaAvv3.gridy = 4;
		panel_1.add(lblCentrocampistaAvv3, gbc_lblCentrocampistaAvv3);
		
		JLabel lblDifensoreAvv3 = new JLabel("");
		lblDifensoreAvv3.setEnabled(false);
		lblDifensoreAvv3.setIcon(new ImageIcon(FinestraPartita.class.getResource("/images/pallaAvv.png")));
		GridBagConstraints gbc_lblDifensoreAvv3 = new GridBagConstraints();
		gbc_lblDifensoreAvv3.insets = new Insets(0, 0, 0, 5);
		gbc_lblDifensoreAvv3.gridx = 6;
		gbc_lblDifensoreAvv3.gridy = 4;
		panel_1.add(lblDifensoreAvv3, gbc_lblDifensoreAvv3);
	}
	
	public void InizializzaCampo(Giocatore campo [][]){
				//panel_1.add(campo);
	}

}
