package Graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import java.awt.TextArea;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FinestraScambio {

	private JFrame frmCalciomercatoScambio;
	private TextArea AreaGiocMia = new TextArea();
	private TextArea AreaGiocAvv = new TextArea();



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinestraScambio window = new FinestraScambio();
					window.frmCalciomercatoScambio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FinestraScambio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalciomercatoScambio = new JFrame();
		frmCalciomercatoScambio.setTitle("CalcioMercato - Scambio");
		frmCalciomercatoScambio.setSize(800,600);
		frmCalciomercatoScambio.setResizable(false);
		//	frmCalciomercatoScambio.setBounds(100, 100, 575, 395);
		frmCalciomercatoScambio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JTextField textField = new JTextField("Inserisci il Cognome del giocatore della tua squadra che vuoi scambiare, il Cognome del giocatore" +
						"che vorresti avere e la squadra di provenienza, separati da un virgola (ES. Totti,Bergessio,Catania)");

		textField.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				if(textField.getText() != "") textField.setText("");
			}
			public void mousePressed(MouseEvent e) {}

			public void mouseReleased(MouseEvent e) {}

			public void mouseEntered(MouseEvent e) {}

			public void mouseExited(MouseEvent e) {}
		});
		
		textField.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});

		textField.setAutoscrolls(false);
		frmCalciomercatoScambio.getContentPane().add(textField, BorderLayout.SOUTH);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.48);
		frmCalciomercatoScambio.getContentPane().add(splitPane, BorderLayout.CENTER);
		AreaGiocMia.setText("I tuoi giocatori: ");
		AreaGiocMia.setEditable(false);

		splitPane.setLeftComponent(AreaGiocMia);

		AreaGiocAvv.setEditable(false);
		splitPane.setRightComponent(AreaGiocAvv);
	}

	public TextArea getAreaGiocMia(){
		return AreaGiocMia;
	}

	public TextArea getAreaGiocAvv(){
		return AreaGiocAvv;
	}
	
	public JFrame getFinestrScambio(){
		return frmCalciomercatoScambio;
	}
	
	public void Go(){
		frmCalciomercatoScambio.setVisible(true);
	}
	public void stop(){
		frmCalciomercatoScambio.setVisible(false);
	}

}
