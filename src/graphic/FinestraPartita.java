package graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;

import Project.Giocatore;

public class FinestraPartita extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6555644770549918991L;
	private JFrame frame;


	/**
	 * Create the application.
	 */
	public FinestraPartita(Giocatore campo [][]) {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
	}

}
