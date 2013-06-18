package graphic;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JButton;

import Project.Campionato;
import net.miginfocom.swing.MigLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FinestraCampionato extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8727626880473140625L;
	private  JFrame frame = this;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinestraCampionato window = new FinestraCampionato();
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
	public FinestraCampionato(final Campionato c) {
		setSize(new Dimension(600, 300));
		setResizable(false);
		getContentPane().setLayout(new MigLayout("", "[][][][][][][][][][][][][][][][][][]", "[][][][][][][][]"));

		JButton btnNewButton = new JButton("Classifica Attuale");
		getContentPane().add(btnNewButton, "cell 17 1");

		JButton btnNewButton_1 = new JButton("Gioca una partita");
		getContentPane().add(btnNewButton_1, "cell 17 3");

		JButton btnNewButton_2 = new JButton("Calciomercato");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c.Calciomercato(frame);
			}
		});
		getContentPane().add(btnNewButton_2, "cell 17 5");

		JButton btnNewButton_3 = new JButton("Esci");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				frame.dispose(); 			
			}
		});
		getContentPane().add(btnNewButton_3, "cell 17 7");

		initialize();
		this.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
