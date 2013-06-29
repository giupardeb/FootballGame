package graphic;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import Project.Campionato;
import Project.DatabaseGiocatori;
import net.miginfocom.swing.MigLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FinestraCampionato extends JFrame{

	private static final long serialVersionUID = 8727626880473140625L;
	private  JFrame frame = this;


	public FinestraCampionato(final Campionato c) {
			
		setResizable(false);
		getContentPane().setLayout(new MigLayout("", "[][][][][][][][][][][][][][][][][][]", "[][][][][][][][]"));

		JButton btnNewButton = new JButton("Classifica Attuale");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.hide();
				FinestraClassifica f = new FinestraClassifica(c,frame);
			}
		});
		
		getContentPane().add(btnNewButton, "cell 17 1");

		
		
		JButton btnNewButton_1 = new JButton("Gioca una partita");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				FinestraOrganizzaSquadra o = new FinestraOrganizzaSquadra(c);
			}
		});
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
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit ( ).getScreenSize ( );
		this.setSize(new Dimension(600, 300));
		this.setLocation ( ( screenSize.width / 2 ) - ( this.getWidth ( ) / 2 ), (
		screenSize.height / 2 ) - ( this.getHeight ( ) / 2 ) );
	}

}
