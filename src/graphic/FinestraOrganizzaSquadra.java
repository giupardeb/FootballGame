package graphic;
import Project.Campionato;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Project.DatabaseGiocatori;
import Project.Giocatore;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JSplitPane;

import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.JLabel;

public class FinestraOrganizzaSquadra extends JFrame{

	
	private  ArrayList <Giocatore> array = new ArrayList <Giocatore>(15); //array che conterrà i giocatori x iniziare la partita
	private static int cont = 0; //utile per aumentare l'array
	private static final long serialVersionUID = -4943380536225481189L;
	private JFrame frame = this;
	JButton btn = new JButton();
	final TextArea textArea = new TextArea();

	
	
	//	ActionListener action = null;

	public FinestraOrganizzaSquadra(Campionato c) {
		setResizable(false);
		this.setSize(900, 400);
		Dimension screenSize = Toolkit.getDefaultToolkit ( ).getScreenSize ( );
		this.setLocation ( ( screenSize.width / 2 ) - ( this.getWidth ( ) / 2 ), (
		screenSize.height / 2 ) - ( this.getHeight ( ) / 2 ) );			
		initialize(c);
		JOptionPane.showMessageDialog(null, "ATTEZIONE, DEVI SCEGLIERE IN ORDINE 1P,4DIFENSORI,4CENTROCAMPISTI,2ATTACCANTI");
		this.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final Campionato c) {
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
				if(cont == 11 ){
					Giocatore giocatori[] = array.toArray(new Giocatore[array.size()]);
					frame.dispose();
					FinestraFormazione f = new FinestraFormazione(giocatori,c);
				}
				else textArea.setText("NON PUOI GIOCARE CON "+cont+"GIOCATORI!");
				
			}
		});
		panel.add(btnNewButton, BorderLayout.SOUTH);
		
		final JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel.add(panel_1, BorderLayout.CENTER);
		
		final JLabel output = new JLabel("");
		panel.add(output, BorderLayout.NORTH);

		textArea.setEditable(false);
		splitPane.setRightComponent(textArea);


		MouseListener action = new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {

					JButton j = (JButton) e.getSource();
					int i = c.db.GetIndice(j.getText());
					if(cont<11){
						cont++;
						array.add(c.db.GetDb()[i]);
						output.setText("Hai inserito "+ cont+"Giocatori, l'ultimo è stato: "+c.db.GetDb()[i].GetAnagrafe().GetCognome());
						panel_1.remove(j);
					}
					else textArea.setText("HAI SCELTO GIÀ 11 GIOCATORI, NON PUOI SCEGLIERNE ALTRI!");

				

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

