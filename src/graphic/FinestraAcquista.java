package graphic;


import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;

import Project.Campionato;

import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FinestraAcquista extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3443854256216044101L;
	private JFrame frame = this;

	/**
	 * Create the application.
	 */
	public FinestraAcquista(Campionato c,String s) {
		super();
		this.setSize(new Dimension(800, 600));
		Dimension screenSize = Toolkit.getDefaultToolkit ( ).getScreenSize ( );
		this.setLocation ( ( screenSize.width / 2 ) - ( this.getWidth ( ) / 2 ), (
		screenSize.height / 2 ) - ( this.getHeight ( ) / 2 ) );		
		AcquistiAvversari(c);
		this.setResizable(false);
		initialize(c,s);
		this.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final Campionato c, String s) {
		this.getContentPane().setLayout(new BorderLayout(0, 0));

		TextArea giocatoriList = new TextArea();
		giocatoriList.setEditable(false);
		this.getContentPane().add(giocatoriList, BorderLayout.CENTER);

		final TextField textField = new TextField();
		
		textField.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_ENTER){
					String sceltagiocatore = "";
					sceltagiocatore = textField.getText();
					String	giocatoresquadra [] = sceltagiocatore.split(",");
					frame.dispose();
					c.Trasferimento(giocatoresquadra);
				}
			}
		});
		
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(textField.getText() != "") textField.setText("");
			}
		});
		
		textField.setText("Inserisci il COGNOME del giocatore che vorresti acquistare " +
				"e la SQUADRA appartenente separati da una virgola (es.Totti,roma): ");
		getContentPane().add(textField, BorderLayout.SOUTH);

		c.giocatoridavisualizzare = c.VisualizzaGiocatori(s, c.squadra.GetNomeSquadra());
		for(int i = 0; i<c.giocatoridavisualizzare.length;i++){
			giocatoriList.append(i+". "+c.giocatoridavisualizzare[i] + "\n");
		}
	}
	
	
	
	private void AcquistiAvversari(Campionato c){
		JOptionPane.showMessageDialog(this, "Le altre squadre stanno provvedendo all'acquisto..");
		for(int i = 0; i<c.squadre.length;i++)
			c.squadre[i].acquisto(c.squadre, c.squadra);
	}

}
