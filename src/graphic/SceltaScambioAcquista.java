package graphic;

import javax.swing.JFrame;
import javax.swing.JRadioButton;

import Project.Campionato;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SceltaScambioAcquista extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3046936363507453245L;
	private JFrame frame = this;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SceltaScambioAcquista window = new SceltaScambioAcquista();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public SceltaScambioAcquista(Campionato c) {
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
		
		JRadioButton rdbtnAcquista = new JRadioButton("Acquista");
		rdbtnAcquista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				SceltaRuolo FinestraSceltaRuolo = new SceltaRuolo(c);
			}
		});
		this.getContentPane().add(rdbtnAcquista);
		
		JRadioButton rdbtnScambio = new JRadioButton("Scambio");
		
		rdbtnScambio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				FinestraScambio FinestraScambio = new FinestraScambio(c);
			}
		});
		
		this.getContentPane().add(rdbtnScambio);
	}

}
