package graphic;
import Project.Campionato;

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
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.Color;

public class FinestraPartita extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6555644770549918991L;
		private JFrame frame = this;
	private Palla ball;
	private JLabel palla;
	/**
	 * Create the application.
	 */
	public FinestraPartita(final JPanel panel_2, final Campionato c) {
		initialize(panel_2,c);
		Thread t  = new Thread (new Runnable () {
			   public void run () {
			      //qui ci metti tutte le istruzioni che il thread deve eseguire
					c.partita(c.squadra, c.Incontri.pop(),panel_2);
			   }
			});

			//per avviare il Thread fai così:
			t.start ();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final JPanel panel_2,final Campionato c) {
		this.setSize(700, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panelScelte = new JPanel();
		panel.add(panelScelte, BorderLayout.SOUTH);
		panelScelte.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnStop = new JButton("Stop");
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
		splitPane.setResizeWeight(0.1);
		panel.add(splitPane, BorderLayout.CENTER);

		JLabel visualizzainfopartita = new JLabel("");
		splitPane.setRightComponent(visualizzainfopartita);
		

		splitPane.setLeftComponent(panel_2);


		this.setVisible(true);
	}




}
