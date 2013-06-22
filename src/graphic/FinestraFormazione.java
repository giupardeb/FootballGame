package graphic;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;

import Project.Giocatore;



public class FinestraFormazione extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1627745280222260463L;
	private JFrame frame = this;


	/**
	 * Create the application.
	 */
	public FinestraFormazione(Giocatore [] array) {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(400,200);
		this.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton button = new JButton("4-4-2");
		button.setBounds(12, 61, 117, 25);
		panel.add(button);

		JButton btnNewButton = new JButton("4-3-3");

		btnNewButton.setBounds(269, 61, 117, 25);
		panel.add(btnNewButton);
		this.setVisible(true);


	}
}
