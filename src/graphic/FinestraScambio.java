package graphic;



import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;

import Project.Campionato;

import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;

public class FinestraScambio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2120793008315688634L;
	private JFrame frame = this;
	private TextArea AreaGiocMia;
	private TextArea AreaGiocAvv;
	private TextField textField;


	/**
	 * Create the application.
	 */
	public FinestraScambio(final Campionato c) {
		super();
		setSize(new Dimension(870, 600));
		Dimension screenSize = Toolkit.getDefaultToolkit ( ).getScreenSize ( );
		this.setLocation ( ( screenSize.width / 2 ) - ( this.getWidth ( ) / 2 ), (
		screenSize.height / 2 ) - ( this.getHeight ( ) / 2 ) );	
		initialize(c);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final Campionato c) {
		this.setResizable(false);
		textField = new TextField();
		textField.setText("Inserisci il COGNOMETuoGiocatore, COGNOME SuoGiocatore e il NOME della " +
				"squadra separati da una virgola (ES. Totti,Bergessio, Catania)");
		getContentPane().add(textField, BorderLayout.SOUTH);

		textField.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_ENTER){
					String sceltagiocatore = textField.getText();
					String	Scelta [] = sceltagiocatore.split(",");
					frame.dispose();
					c.TrasferimentoPerScambio(Scelta);
				}
			}
		});



		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(textField.getText() != "") textField.setText("");
			}
		});


		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.47);
		getContentPane().add(splitPane, BorderLayout.CENTER);

		AreaGiocMia = new TextArea();
		AreaGiocMia.setText("i tuoi giocatori: ");
		AreaGiocMia.setEditable(false);
		splitPane.setLeftComponent(AreaGiocMia);

		AreaGiocAvv = new TextArea();
		AreaGiocAvv.setEditable(false);
		splitPane.setRightComponent(AreaGiocAvv);

		c.giocatoridavisualizzare = c.VisualizzaGiocatori(c.squadra.GetNomeSquadra());


		for(int i = 0; i<c.giocatoridavisualizzare.length;i++)
			AreaGiocAvv.append(i+". "+c.giocatoridavisualizzare[i] + "\n");

		c.giocatoridavisualizzare = c.VisualizzaGiocatoriMiei();
		AreaGiocMia.append("\n\n");
		for(int i = 0; i<c.giocatoridavisualizzare.length;i++)
			AreaGiocMia.append(i+". "+c.giocatoridavisualizzare[i] + "\n");

	}
}
