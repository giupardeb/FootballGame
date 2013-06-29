package graphic;

import javax.swing.JFrame;
import javax.swing.JRadioButton;

import Project.Campionato;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SceltaScambioAcquistaVendita extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3046936363507453245L;
	private JFrame frame = this;


	/**
	 * Create the application.
	 */
	public SceltaScambioAcquistaVendita(Campionato c) {
		initialize(c);
		this.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final Campionato c) {
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		this.setLocationRelativeTo(null);

		JRadioButton rdbtnAcquista = new JRadioButton("Acquista");
		rdbtnAcquista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				SceltaRuolo FinestraSceltaRuolo = new SceltaRuolo(c);
			}
		});
		this.getContentPane().add(rdbtnAcquista);
		
		JRadioButton rdbtnScambio = new JRadioButton("Scambio");
		
		rdbtnScambio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				FinestraScambio FinestraScambio = new FinestraScambio(c);
			}
		});
		
		JRadioButton rdbtnVendita = new JRadioButton("Vendita");
		rdbtnVendita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				FinestraVendita f = new FinestraVendita(c);
			}
		});
		getContentPane().add(rdbtnVendita);
		
		this.getContentPane().add(rdbtnScambio);
	}

}
