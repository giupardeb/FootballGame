package graphic;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Project.Campionato;
import Project.DatabaseGiocatori;
import Project.Giocatore;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JSplitPane;

import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import javax.swing.JLabel;

public class FinestraOrganizzaSquadra extends JFrame{

	
	private  Giocatore array[] = new Giocatore[15]; //array che conterrà i giocatori x iniziare la partita
	private static int cont = 0; //utile per aumentare l'array
	private static final long serialVersionUID = -4943380536225481189L;
	private JFrame frame = this;
	JButton btn = null;
	//	ActionListener action = null;

	public FinestraOrganizzaSquadra(Campionato c, DatabaseGiocatori db) {
		setResizable(false);
		this.setSize(900, 400);
		Dimension screenSize = Toolkit.getDefaultToolkit ( ).getScreenSize ( );
		this.setLocation ( ( screenSize.width / 2 ) - ( this.getWidth ( ) / 2 ), (
		screenSize.height / 2 ) - ( this.getHeight ( ) / 2 ) );			initialize(c,db);
		this.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Campionato c, final DatabaseGiocatori dbGiocatori) {
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(1.0);
		getContentPane().add(splitPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("Fatto? continua con la selezione della formazione");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FinestraFormazione f = new FinestraFormazione(array);
				frame.dispose();
			}
		});
		panel.add(btnNewButton, BorderLayout.SOUTH);
		
		final JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel.add(panel_1, BorderLayout.CENTER);
		
		final JLabel output = new JLabel("");
		panel.add(output, BorderLayout.NORTH);

		final TextArea textArea = new TextArea();
		textArea.setEditable(false);
		splitPane.setRightComponent(textArea);



		MouseListener action = new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {

					JButton j = (JButton) e.getSource();
					int i = dbGiocatori.GetIndice(j.getText());
					if(cont<15){
						array[cont++] = dbGiocatori.GetDb()[i];
						output.setText("Hai inserito "+ cont+"Giocatori, l'ultimo è stato: "+dbGiocatori.GetDb()[i].GetAnagrafe().GetCognome());
						panel_1.remove(j);
					}
					else textArea.setText("HAI SCELTO GIÀ 15 GIOCATORI, NON PUOI SCEGLIERNE ALTRI!");

				

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

				int i = dbGiocatori.GetIndice(j.getText());

				textArea.setText(dbGiocatori.GetDb()[i].toString());

			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		};


		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for(Giocatore giocatore : c.squadra.GetSquadra()){
			btn = new JButton(giocatore.GetAnagrafe().GetCognome());
			btn.addMouseListener(action);
			panel_1.add(btn);
		}


	}
}

