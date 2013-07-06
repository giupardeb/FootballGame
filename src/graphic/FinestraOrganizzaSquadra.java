package graphic;
import Project.Campionato;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Project.Giocatore;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JSplitPane;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.JLabel;

public class FinestraOrganizzaSquadra extends JFrame{


	private  ArrayList <Giocatore> array = new ArrayList <Giocatore>(11); //array che conterrà i giocatori x iniziare la partita
	private static int cont; //utile per aumentare l'array
	private static final long serialVersionUID = -4943380536225481189L;
	private JFrame frame = this;
	JButton btn = new JButton();
	final TextArea textArea = new TextArea();

	public FinestraOrganizzaSquadra(Campionato c) {
		setResizable(false);
		this.setSize(900, 400);
		Dimension screenSize = Toolkit.getDefaultToolkit ( ).getScreenSize ( );
		this.setLocation ( ( screenSize.width / 2 ) - ( this.getWidth ( ) / 2 ), (
				screenSize.height / 2 ) - ( this.getHeight ( ) / 2 ) );			
		initialize(c);
		JOptionPane.showMessageDialog(null, "ATTEZIONE, DEVI SCEGLIERE IN ORDINE 1P,4DIFENSORI,4CENTROCAMPISTI,2ATTACCANTI");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final Campionato c) {
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(1.0);
		getContentPane().add(splitPane, BorderLayout.CENTER);

		array.removeAll(array);
		cont = 0;
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		FlowLayout experimentLayout = new FlowLayout();
		JPanel panelBtn = new JPanel();
		panelBtn.setLayout(experimentLayout);
		panel.setLayout(new BorderLayout(0, 0));
		JButton btnSquadraDefault = new JButton("Formazione Default");
		btnSquadraDefault.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Giocatore giocatori[] = c.db.GetIndiceRuolo(c.squadra.GetNomeSquadra());
				if( giocatori!= null){
					frame.dispose();
					FinestraFormazione f = new FinestraFormazione(giocatori,c);
					f.setVisible(true);
				}

			}
		});
		
		JButton btnNewButton = new JButton("Fatto");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(cont == 11 ){
					Giocatore giocatori[] = array.toArray(new Giocatore[array.size()]);
					if(ControlloArray(giocatori)){
						frame.dispose();
						FinestraFormazione f = new FinestraFormazione(giocatori,c);
						f.setVisible(true);
					}
					else{
						array.removeAll(array);
						cont = 0;
						frame.dispose();
						FinestraOrganizzaSquadra o = new FinestraOrganizzaSquadra(c);
						o.setVisible(true);
					}
				}
				else textArea.setText("NON PUOI GIOCARE CON "+cont+"GIOCATORI!");

			}
		});
		panelBtn.add(btnNewButton);
		panelBtn.add(btnSquadraDefault);
		panel.add(panelBtn, BorderLayout.SOUTH);

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

	private boolean ControlloArray(Giocatore[] giocatori) {

		String tmp[] ={"Portiere","Difensore","Difensore","Difensore","Difensore",
				"Centrocampista","Centrocampista","Centrocampista","Centrocampista","Attaccante","Attaccante"};
		int ok = 0;
		for(int i=0; i<giocatori.length;i++)
			if(giocatori[i].getRuolo().equalsIgnoreCase(tmp[i]))
				ok++;
		if(ok == giocatori.length) return true;
		else return false;
	}
}

