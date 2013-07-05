package graphic;

import java.awt.*;

import javax.swing.*;

import Project.Campionato;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private JFrame frame = this;

	public MainWindow() {
		getContentPane().setBackground(Color.LIGHT_GRAY);

		setTitle("FootBallManager \t\t\tScegli la tua squadra");
		setResizable(false);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setForeground(Color.WHITE);
		this.setSize(800, 400);
		Dimension screenSize = Toolkit.getDefaultToolkit ( ).getScreenSize ( );
		this.setLocation ( ( screenSize.width / 2 ) - ( this.getWidth ( ) / 2 ), (
		screenSize.height / 2 ) - ( this.getHeight ( ) / 2 ) );	
		
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton();
		btnNewButton.setName("atalanta");
		btnNewButton.addActionListener(action);
		btnNewButton.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/atalanta.png")));
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton();
		btnNewButton_1.setName("bologna");
		btnNewButton_1.addActionListener(action);

		btnNewButton_1.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/bologna.png")));
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton();
		btnNewButton_2.setName("cagliari");
		btnNewButton_2.addActionListener(action);

		btnNewButton_2.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/cagliari.png")));
		getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton();
		btnNewButton_3.setName("catania");
		btnNewButton_3.addActionListener(action);

		btnNewButton_3.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/catania.png")));
		getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton();
		btnNewButton_4.setName("chievo");
		btnNewButton_4.addActionListener(action);

		btnNewButton_4.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/chievo.png")));
		getContentPane().add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton();
		getContentPane().add(btnNewButton_5);
		btnNewButton_5.setName("fiorentina");
		btnNewButton_5.addActionListener(action);

		btnNewButton_5.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/fiorentina.gif")));

		JButton btnNewButton_6 = new JButton();
		getContentPane().add(btnNewButton_6);
		btnNewButton_6.setName("genoa");
		btnNewButton_6.addActionListener(action);

		btnNewButton_6.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/genoa.png")));

		JButton btnNewButton_7 = new JButton();
		getContentPane().add(btnNewButton_7);
		btnNewButton_7.setName("inter");
		btnNewButton_7.addActionListener(action);

		btnNewButton_7.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/inter.png")));

		JButton btnNewButton_8 = new JButton();
		getContentPane().add(btnNewButton_8);
		btnNewButton_8.setName("juventus");
		btnNewButton_8.addActionListener(action);

		btnNewButton_8.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/juventus.png")));

		JButton btnNewButton_9 = new JButton();
		getContentPane().add(btnNewButton_9);
		btnNewButton_9.setName("lazio");
		btnNewButton_9.addActionListener(action);

		btnNewButton_9.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/lazio.png")));

		JButton btnNewButton_10 = new JButton();
		getContentPane().add(btnNewButton_10);
		btnNewButton_10.setName("milan");
		btnNewButton_10.addActionListener(action);

		btnNewButton_10.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/milan.gif")));

		JButton btnNewButton_11 = new JButton();
		getContentPane().add(btnNewButton_11);
		btnNewButton_11.setName("napoli");
		btnNewButton_11.addActionListener(action);

		btnNewButton_11.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/napoli.png")));

		JButton btnNewButton_12 = new JButton();
		getContentPane().add(btnNewButton_12);
		btnNewButton_12.setName("palermo");
		btnNewButton_12.addActionListener(action);

		btnNewButton_12.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/palermo.png")));

		JButton btnNewButton_13 = new JButton();
		getContentPane().add(btnNewButton_13);
		btnNewButton_13.setName("parma");
		btnNewButton_13.addActionListener(action);

		btnNewButton_13.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/parma.gif")));

		JButton btnNewButton_14 = new JButton();
		getContentPane().add(btnNewButton_14);
		btnNewButton_14.setName("pescara");
		btnNewButton_14.addActionListener(action);

		btnNewButton_14.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/pescara.png")));


		JButton btnNewButton_15 = new JButton();
		getContentPane().add(btnNewButton_15);
		btnNewButton_15.setName("roma");
		btnNewButton_15.addActionListener(action);

		btnNewButton_15.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/roma.png")));

		JButton btnNewButton_16 = new JButton();
		getContentPane().add(btnNewButton_16);
		btnNewButton_16.setName("sampdoria");
		btnNewButton_16.addActionListener(action);

		btnNewButton_16.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/sampdoria.png")));

		JButton btnNewButton_17 = new JButton();
		getContentPane().add(btnNewButton_17);
		btnNewButton_17.setName("siena");
		btnNewButton_17.addActionListener(action);

		btnNewButton_17.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/siena.gif")));

		JButton btnNewButton_18 = new JButton();
		getContentPane().add(btnNewButton_18);
		btnNewButton_18.setName("torino");
		btnNewButton_18.addActionListener(action);

		btnNewButton_18.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/torino.png")));

		JButton btnNewButton_19 = new JButton();
		getContentPane().add(btnNewButton_19);
		btnNewButton_19.setName("udinese");
		btnNewButton_19.addActionListener(action);

		btnNewButton_19.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/udinese.png")));

	}



	ActionListener action = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			JButton j = (JButton) e.getSource();
			frame.dispose();
			@SuppressWarnings("unused")
			Campionato c = new Campionato(j.getName(),frame);
			
		}
	};
}
