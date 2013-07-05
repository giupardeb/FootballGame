package graphic;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JRadioButton;

import Project.Campionato;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SceltaRuolo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6948036084218256765L;
	private JFrame frame = this;


	/**
	 * Create the application.
	 */
	public SceltaRuolo(Campionato c) {
		initialize(c);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final Campionato c) {
		//	frame = new JFrame();
		this.setBounds(100, 100, 581, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		this.setLocationRelativeTo(null);

		JRadioButton rdbtnCentrocampista = new JRadioButton("Centrocampista");
		rdbtnCentrocampista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				JRadioButton j = (JRadioButton) e.getSource();
				FinestraAcquista Finestracquista = new FinestraAcquista(c,j.getText());
				Finestracquista.setVisible(true);
			}
		});
		this.getContentPane().add(rdbtnCentrocampista);

		JRadioButton rdbtnAttaccante = new JRadioButton("Attaccante");

		rdbtnAttaccante.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				JRadioButton j = (JRadioButton) e.getSource();
				FinestraAcquista Finestracquista = new FinestraAcquista(c,j.getText());
				Finestracquista.setVisible(true);

			}
		});

		this.getContentPane().add(rdbtnAttaccante);

		JRadioButton rdbtnDifensore = new JRadioButton("Difensore");

		rdbtnDifensore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				JRadioButton j = (JRadioButton) e.getSource();
				FinestraAcquista Finestracquista = new FinestraAcquista(c,j.getText());
				Finestracquista.setVisible(true);

			}
		});

		this.getContentPane().add(rdbtnDifensore);

		JRadioButton rdbtnPortiere = new JRadioButton("Portiere");

		rdbtnPortiere.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				JRadioButton j = (JRadioButton) e.getSource();
				FinestraAcquista Finestracquista = new FinestraAcquista(c,j.getText());
				Finestracquista.setVisible(true);

			}
		});

		this.getContentPane().add(rdbtnPortiere);
	}
}
