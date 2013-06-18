package graphic;

import java.awt.*;
import javax.swing.*;

import Project.Campionato;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame{

	private JFrame frame = this;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * 
	 */
	private static final long serialVersionUID = -1783382031278484846L;

	/**
	 * Create the application.
	 */
	public MainWindow() {

		setTitle("FootBallManager \t\t\tScegli la tua squadra");
		setResizable(false);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnNewButton = new JButton();
		btnNewButton.setName("atalanta");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton j = (JButton) e.getSource();
				Campionato c = new Campionato(j.getName());
				frame.dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/atalanta.png")));
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton();
		btnNewButton_1.setName("bologna");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton j = (JButton) e.getSource();
				Campionato c = new Campionato(j.getName());
				frame.dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/bologna.png")));
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton();
		btnNewButton_2.setName("cagliari");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton j = (JButton) e.getSource();
				Campionato c = new Campionato(j.getName());
				frame.dispose();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/cagliari.png")));
		getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton();
		btnNewButton_3.setName("catania");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton j = (JButton) e.getSource();
				Campionato c = new Campionato(j.getName());
				frame.dispose();
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/catania.png")));
		getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton();
		btnNewButton_4.setName("chievo");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton j = (JButton) e.getSource();
				Campionato c = new Campionato(j.getName());
				frame.dispose();
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/chievo.png")));
		getContentPane().add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton();
		btnNewButton_5.setName("fiorentina");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton j = (JButton) e.getSource();
				Campionato c = new Campionato(j.getName());
				frame.dispose();
			}
		});
		btnNewButton_5.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/fiorentina.gif")));
		getContentPane().add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton();
		btnNewButton_6.setName("genoa");
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton j = (JButton) e.getSource();
				Campionato c = new Campionato(j.getName());
				frame.dispose();
			}
		});
		btnNewButton_6.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/genoa.png")));
		getContentPane().add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton();
		btnNewButton_7.setName("inter");
		btnNewButton_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton j = (JButton) e.getSource();
				Campionato c = new Campionato(j.getName());
				frame.dispose();
			}
		});
		btnNewButton_7.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/inter.png")));
		getContentPane().add(btnNewButton_7);

		JButton btnNewButton_8 = new JButton();
		btnNewButton_8.setName("juventus");
		btnNewButton_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton j = (JButton) e.getSource();
				Campionato c = new Campionato(j.getName());
				frame.dispose();
			}
		});
		btnNewButton_8.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/juventus.png")));
		getContentPane().add(btnNewButton_8);

		JButton btnNewButton_9 = new JButton();
		btnNewButton_9.setName("lazio");
		btnNewButton_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton j = (JButton) e.getSource();
				Campionato c = new Campionato(j.getName());
				frame.dispose();
			}
		});
		btnNewButton_9.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/lazio.png")));
		getContentPane().add(btnNewButton_9);

		JButton btnNewButton_10 = new JButton();
		btnNewButton_10.setName("milan");
		btnNewButton_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton j = (JButton) e.getSource();
				Campionato c = new Campionato(j.getName());
				frame.dispose();
			}
		});
		btnNewButton_10.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/milan.gif")));
		getContentPane().add(btnNewButton_10);

		JButton btnNewButton_11 = new JButton();
		btnNewButton_11.setName("napoli");
		btnNewButton_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton j = (JButton) e.getSource();
				Campionato c = new Campionato(j.getName());
				frame.dispose();
			}
		});
		btnNewButton_11.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/napoli.png")));
		getContentPane().add(btnNewButton_11);

		JButton btnNewButton_12 = new JButton();
		btnNewButton_12.setName("palermo");
		btnNewButton_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton j = (JButton) e.getSource();
				Campionato c = new Campionato(j.getName());
				frame.dispose();
			}
		});
		btnNewButton_12.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/palermo.png")));
		getContentPane().add(btnNewButton_12);

		JButton btnNewButton_13 = new JButton();
		btnNewButton_13.setName("parma");
		btnNewButton_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton j = (JButton) e.getSource();
				Campionato c = new Campionato(j.getName());
				frame.dispose();
			}
		});
		btnNewButton_13.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/parma.gif")));
		getContentPane().add(btnNewButton_13);

		JButton btnNewButton_14 = new JButton();
		btnNewButton_14.setName("pescara");
		btnNewButton_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton j = (JButton) e.getSource();
				Campionato c = new Campionato(j.getName());
				frame.dispose();
			}
		});
		btnNewButton_14.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/pescara.png")));
		getContentPane().add(btnNewButton_14);

		JButton btnNewButton_15 = new JButton();
		btnNewButton_15.setName("roma");
		btnNewButton_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton j = (JButton) e.getSource();
				Campionato c = new Campionato(j.getName());
				frame.dispose();
			}
		});
		btnNewButton_15.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/roma.png")));
		getContentPane().add(btnNewButton_15);

		JButton btnNewButton_16 = new JButton();
		btnNewButton_16.setName("sampdoria");
		btnNewButton_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton j = (JButton) e.getSource();
				Campionato c = new Campionato(j.getName());
				frame.dispose();
			}
		});
		btnNewButton_16.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/sampdoria.png")));
		getContentPane().add(btnNewButton_16);

		JButton btnNewButton_17 = new JButton();
		btnNewButton_17.setName("siena");
		btnNewButton_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton j = (JButton) e.getSource();
				Campionato c = new Campionato(j.getName());
				frame.dispose();
			}
		});
		btnNewButton_17.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/siena.gif")));
		getContentPane().add(btnNewButton_17);

		JButton btnNewButton_18 = new JButton();
		btnNewButton_18.setName("torino");
		btnNewButton_18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton j = (JButton) e.getSource();
				Campionato c = new Campionato(j.getName());
				frame.dispose();
			}
		});
		btnNewButton_18.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/torino.png")));
		getContentPane().add(btnNewButton_18);

		JButton btnNewButton_19 = new JButton();
		btnNewButton_19.setName("udinese");
		btnNewButton_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton j = (JButton) e.getSource();
				Campionato c = new Campionato(j.getName());
				frame.dispose();
			}
		});
		btnNewButton_19.setIcon(new ImageIcon(MainWindow.class.getResource("/scudetti/udinese.png")));
		getContentPane().add(btnNewButton_19);
		initialize();
		this.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//	this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setForeground(Color.WHITE);
		this.setSize(850,470);

		//	frame.getContentPane().add(lblNewLabel_21, gbc_lblNewLabel_21);
	}

}
