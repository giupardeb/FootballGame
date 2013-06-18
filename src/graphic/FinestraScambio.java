package graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.border.TitledBorder;

import java.awt.TextArea;

public class FinestraScambio extends JPanel {

	//private JFrame frame;
	private TextArea AreaGiocMia;
	private TextArea AreaGiocAvv;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinestraScambio window = new FinestraScambio();
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
	public FinestraScambio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		add(splitPane, BorderLayout.CENTER);

		AreaGiocMia = new TextArea();
		AreaGiocMia.setText("I tuoi giocatori: ");
		AreaGiocMia.setEditable(false);
		splitPane.setLeftComponent(AreaGiocMia);
	    
		AreaGiocAvv = new TextArea();
		AreaGiocAvv.setEditable(false);
		splitPane.setRightComponent(AreaGiocAvv);
	}

	public TextArea getAreaGiocMia(){
		return AreaGiocMia;
	}
	public TextArea getAreaGiocAvv(){
		return AreaGiocAvv;
	}

}
