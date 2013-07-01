package graphic;
import Project.Campionato;
import Project.SquadraAvversaria;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Point;

import javax.swing.JButton;

import Project.Giocatore;
import javax.swing.JSplitPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;


public class FinestraPartita extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6555644770549918991L;
	private JFrame frame = this;
	private JPanel panelScelte;
	private MyTextAreaInfo txtInfo;
	private SquadraAvversaria squadraAvv = null;
	private Giocatore arrayAvv[] = null;
	private int azione = 0; //Serve per il tiro
	private Point punto = new Point(); // serve per il passaggio  per il contrasto e rilancio
	private int esito = 0;
	private Giocatore giocatore = null;
	private int puntiUmano = 0;
	private int puntiComputer = 0;


	public FinestraPartita(final JPanel panel_2, final Campionato c,final Giocatore arrayMio[]) {
		setResizable(false);

		panelScelte = new JPanel();
		panelScelte.setName("panelScelte");
		getContentPane().add(panelScelte, BorderLayout.SOUTH);

		JButton btnRilancia = new JButton("Rilancia");
		btnRilancia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c.Rilancia(frame, c.squadra, arrayMio);
			}
		});
		
		JButton btnEsci = new JButton("Esci");
		btnEsci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				FinestraCampionato f = new FinestraCampionato(c);
			}
		});
		panelScelte.add(btnEsci);
		btnRilancia.setName("Rilancia");
		
		panelScelte.add(btnRilancia);

		JButton btnTira = new JButton("Tira");
		btnTira.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c.Tira(frame, arrayAvv, squadraAvv, c.squadra);
			}
		});
		btnTira.setName("Tira");
		panelScelte.add(btnTira);

		JButton btnPassaggio = new JButton("Passaggio");
		btnPassaggio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c.Passa(frame, squadraAvv, arrayMio, arrayAvv);
			}
		});
		btnPassaggio.setName("Passaggio");

		panelScelte.add(btnPassaggio);

		JButton btnContrasto = new JButton("Contrasto");
		btnContrasto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c.Contrasta(frame, arrayMio, arrayAvv, c.squadra, squadraAvv);
			}
		});
		btnContrasto.setName("Contrasto");
		
		panelScelte.add(btnContrasto);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setContinuousLayout(true);
		splitPane.setResizeWeight(0.5);
		getContentPane().add(splitPane, BorderLayout.CENTER);
		
		txtInfo = new MyTextAreaInfo();
		txtInfo.setMinimumSize(new Dimension(1000, 75));
		txtInfo.setEditable(false);


		splitPane.setRightComponent(txtInfo);
		
		squadraAvv = c.Incontri.pop();
		arrayAvv = squadraAvv.OrganizzaSquadra();
		this.setTitle(c.squadra.GetNomeSquadra()+" "+getPuntiUmano()+ " "+squadraAvv.GetNomeSquadra()+" "+ getPuntiComputer());
		initialize(panel_2,c,arrayAvv);
		splitPane.setLeftComponent(panel_2);

		Thread t  = new Thread (new Runnable () {
			public void run () {
				//qui ci metti tutte le istruzioni che il thread deve eseguire
				setAzione(0);
				setEsito(0);
				setGiocatoreCorrente(null);
				Point reset = new Point();
				setPoint(reset);
				c.partita(c.squadra, squadraAvv,frame,arrayMio,arrayAvv);
			}
		});

		//per avviare il Thread fai così:
		t.start ();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final JPanel panel_2,final Campionato c,Giocatore arrayAvv[]) {
		this.setSize(1000, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		arrayAvv[0].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/portiereavv.gif")));
		arrayAvv[0].setBounds(638, 168, 48, 48);
		arrayAvv[0].setPosizione(638, 168);
		panel_2.add(arrayAvv[0]);

		arrayAvv[1].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/pallaAvv.png")));
		arrayAvv[1].setBounds(548, 26, 48, 48);
		arrayAvv[1].setPosizione(548, 26);
		panel_2.add(arrayAvv[1]);

		arrayAvv[2].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/pallaAvv.png")));
		arrayAvv[2].setBounds(548, 126, 48, 48);
		arrayAvv[2].setPosizione(548, 126);
		panel_2.add(arrayAvv[2]);


		arrayAvv[3].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/pallaAvv.png")));
		arrayAvv[3].setBounds(548, 226, 48, 48);
		arrayAvv[3].setPosizione(548, 226);
		panel_2.add(arrayAvv[3]);

		arrayAvv[4].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/pallaAvv.png")));
		arrayAvv[4].setBounds(548, 326, 48, 48);
		arrayAvv[4].setPosizione(548, 326);
		panel_2.add(arrayAvv[4]);

		arrayAvv[5].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/pallaAvv.png")));
		arrayAvv[5].setBounds(380, 26, 48, 48);
		arrayAvv[5].setPosizione(380, 26);
		panel_2.add(arrayAvv[5]);

		arrayAvv[6].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/pallaAvv.png")));
		arrayAvv[6].setBounds(380, 126, 48, 48);
		arrayAvv[6].setPosizione(380, 126);
		panel_2.add(arrayAvv[6]);

		arrayAvv[7].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/pallaAvv.png")));
		arrayAvv[7].setBounds(380, 226, 48, 48);
		arrayAvv[7].setPosizione(380, 226);
		panel_2.add(arrayAvv[7]);

		arrayAvv[8].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/pallaAvv.png")));
		arrayAvv[8].setBounds(380, 326, 48, 48);
		arrayAvv[8].setPosizione(380, 326);
		panel_2.add(arrayAvv[8]);

		arrayAvv[9].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/pallaAvv.png")));
		arrayAvv[9].setBounds(193, 126, 48, 48);
		arrayAvv[9].setPosizione(193, 126);
		panel_2.add(arrayAvv[9]);

		arrayAvv[10].setIcon(new ImageIcon(FinestraFormazione.class.getResource("/images/pallaAvv.png")));
		arrayAvv[10].setBounds(193, 226, 48, 48);
		arrayAvv[10].setPosizione(193,226);
		panel_2.add(arrayAvv[10]);

		arrayAvv[10].setVisible(false);
		arrayAvv[9].setVisible(false);
		arrayAvv[8].setVisible(false);
		arrayAvv[7].setVisible(false);
		arrayAvv[6].setVisible(false);
		arrayAvv[5].setVisible(false);
		arrayAvv[4].setVisible(false);
		arrayAvv[3].setVisible(false);
		arrayAvv[2].setVisible(false);
		arrayAvv[1].setVisible(false);
		arrayAvv[0].setVisible(false);

		this.setVisible(true);
	}

	public JPanel getPanelScelta(){
		return panelScelte;
	}
	
	public MyTextAreaInfo getPanelInfo(){
		return txtInfo;
	}

	public int getAzione(){
		return azione;
	}
	public void setAzione(int val){
		azione = val;
	}

	public Point getPoint(){
		return punto;
	}

	public void setPoint(Point p){
		punto.setLocation(p);
	}

	public int getEsito(){
		return esito;
	}
	public void setEsito(int val){
		esito = val;
	}

	public int getPuntiUmano(){
		return puntiUmano;
	}
	public void setPuntiUmano(){
		puntiUmano++;

	}

	public int getPuntiComputer(){
		return puntiComputer;
	}
	public void setPuntiComputer(){
		puntiComputer++;
	}

	public Giocatore getGiocatoreCorrente(){
		return giocatore;
	}
	public void setGiocatoreCorrente(Giocatore g){
		giocatore = g;
	}
}
