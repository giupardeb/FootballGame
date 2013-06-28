package graphic;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;

import Project.Campionato;
import Project.Squadra;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FinestraClassifica extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -802253560046956209L;
	private JTable table;
	private Squadra array[] = new Squadra [20];


		private JFrame frame = this;


	/**
	 * Create the application.
	 */
	public FinestraClassifica(Campionato c, final JFrame FinestraCampionato) {
		setSize(new Dimension(550, 450));
		setResizable(false);

		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				FinestraCampionato.show();
				
			}
		});
		getContentPane().add(btnIndietro, BorderLayout.SOUTH);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		OrdinaSquadre(array,c);

		String[] Namescolonne = {"Nome", "Punti", "Vittorie", "Pareggi", "Sconfitte", "GolSubiti", "GolFatti"};

		String[][] data = new String[20][Namescolonne.length];

		for(int riga=0; riga<data.length; riga++){
			for(int colonna=0; colonna<data[riga].length;colonna++){
				if(Namescolonne[colonna].equalsIgnoreCase("Nome"))
					data[riga][colonna] = array[riga].GetNomeSquadra();
				else if(Namescolonne[colonna].equalsIgnoreCase("Punti"))
					data[riga][colonna] = Integer.toString(array[riga].getPunti());
				else if(Namescolonne[colonna].equalsIgnoreCase("Vittorie"))
					data[riga][colonna] = Integer.toString(array[riga].getVittorie());
				else if(Namescolonne[colonna].equalsIgnoreCase("Pareggi"))
					data[riga][colonna] = Integer.toString(array[riga].getPareggi());
				else if(Namescolonne[colonna].equalsIgnoreCase("Sconfitte"))
					data[riga][colonna] = Integer.toString(array[riga].getSconfitte());
				else if(Namescolonne[colonna].equalsIgnoreCase("GolSubiti"))
					data[riga][colonna] = Integer.toString(array[riga].getGolSubiti());
				else if(Namescolonne[colonna].equalsIgnoreCase("GolFatti"))
					data[riga][colonna] = Integer.toString(array[riga].getGolFatti());
			}
		}

		table = new JTable(data,Namescolonne);
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		JScrollPane jsp = new JScrollPane( table );
		this.add(jsp);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}




	private void swap ( Squadra[] array, int primo, int secondo )
	{
		Squadra tmp;
		tmp = array[primo];         
		array[primo] = array[secondo];  
		array[secondo] = tmp;
	}

	private void OrdinaSquadre(Squadra[] array,Campionato c){

		array[0] = c.squadra;

		for(int i=1,j=0; i<array.length;i++,j++){
			array[i] = c.squadre[j];
		}

		for ( int pass = 1;pass < array.length; pass++ ) 
			for ( int i = 0;i < array.length-1; i++ )   
				if ( array[i].getPunti() > array[i+1].getPunti() )    
					swap( array, i, i + 1 ); 

	}

}
