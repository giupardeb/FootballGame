package graphic;

import java.awt.BorderLayout;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import Project.Campionato;
import Project.Giocatore;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;

public class FinestraVendita extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 591864577939618102L;
	private JFrame frame = this;
	private JButton btn = new JButton();
	private TextArea textArea = new TextArea() ;





	/**
	 * Create the application.
	 */
	public FinestraVendita(Campionato c) {
		setSize(new Dimension(800, 600));
		setResizable(false);
		initialize(c);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final Campionato c) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(1.0);
		getContentPane().add(splitPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new BorderLayout(0, 0));


		final JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel.add(panel_1, BorderLayout.CENTER);
		JButton btnNewButton = new JButton("Fatto!");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				FinestraCampionato f = new FinestraCampionato(c);
				f.setVisible(true);
			}
		});
		panel.add(btnNewButton, BorderLayout.SOUTH);


		textArea.setEditable(false);
		splitPane.setRightComponent(textArea);
		
		MouseListener action = new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {

				JButton j = (JButton) e.getSource();
				int i = c.db.GetIndice(j.getText());
				c.db.setGiocatoriInVendita(c.db.GetDb()[i]);
				panel_1.remove(j);
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
		
				JButton j = (JButton) e.getSource();
				
				if(textArea.getText()!="") textArea.setText("");

				int i = c.db.GetIndice(j.getText());

				textArea.setText(c.db.GetDb()[i].toString());

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

	
		};

		for(Giocatore giocatore : c.squadra.GetSquadra()){
			btn = new JButton(giocatore.GetAnagrafe().GetCognome());
			btn.addMouseListener(action);
			panel_1.add(btn);
		}
	}

}
