package graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;

import Project.Campionato;

import java.awt.Component;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FinestraAcquista extends JFrame{

	private JFrame frame = this;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinestraAcquista window = new FinestraAcquista();
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
	public FinestraAcquista(Campionato c,String s) {
		super();
		this.setSize(new Dimension(800, 600));
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
		boolean visibile = true;
	}

}
