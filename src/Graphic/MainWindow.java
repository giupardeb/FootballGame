package Graphic;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import javax.swing.JTextField;

public class MainWindow extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	private JFrame frame;
	private JPanel panel;
	private String squadra;
	private JTextField txtInserisciIlTuo;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.panel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
		panel.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setSize(new Dimension(747, 285));
		//	frame = new JFrame();
		//	frame.setBounds(100, 100, 586, 393);
		//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gridBagLayout);
		//	frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		//	frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 0;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		//	frame.getContentPane().setLayout(gridBagLayout);

		final JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				squadra = lblNewLabel.getName();

			}
		});
		
		lblNewLabel.setName("atalanta");
		lblNewLabel.setIcon(new ImageIcon("/home/giuseppe/Dropbox/workspace/progettoProgI/src/Graphic/Scudetti/atalanta.png"));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		//	frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setName("bologna");
		lblNewLabel_2.setIcon(new ImageIcon("/home/giuseppe/Dropbox/workspace/progettoProgI/src/Graphic/Scudetti/bologna.png"));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 1;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);


		//		frame.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setName("cagliari");
		lblNewLabel_4.setIcon(new ImageIcon("/home/giuseppe/Dropbox/workspace/progettoProgI/src/Graphic/Scudetti/cagliari.png"));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 4;
		gbc_lblNewLabel_4.gridy = 1;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);


		//		frame.getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setName("catania");
		lblNewLabel_5.setIcon(new ImageIcon("/home/giuseppe/Dropbox/workspace/progettoProgI/src/Graphic/Scudetti/catania.png"));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 5;
		gbc_lblNewLabel_5.gridy = 1;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);


		//	frame.getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setName("chievo");
		lblNewLabel_6.setIcon(new ImageIcon("/home/giuseppe/Dropbox/workspace/progettoProgI/src/Graphic/Scudetti/chievo.png"));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 6;
		gbc_lblNewLabel_6.gridy = 1;
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);


		//	frame.getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setName("fiorentina");
		lblNewLabel_7.setIcon(new ImageIcon("/home/giuseppe/Dropbox/workspace/progettoProgI/src/Graphic/Scudetti/fiorentina.gif"));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 7;
		gbc_lblNewLabel_7.gridy = 1;
		panel.add(lblNewLabel_7, gbc_lblNewLabel_7);


		//	frame.getContentPane().add(lblNewLabel_7, gbc_lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setName("genoa");
		lblNewLabel_8.setIcon(new ImageIcon("/home/giuseppe/Dropbox/workspace/progettoProgI/src/Graphic/Scudetti/genoa.png"));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 8;
		gbc_lblNewLabel_8.gridy = 1;
		panel.add(lblNewLabel_8, gbc_lblNewLabel_8);

		txtInserisciIlTuo = new JTextField();
		txtInserisciIlTuo.setText("Inserisci il tuo nome");
		txtInserisciIlTuo.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtInserisciIlTuo.getText() != "") txtInserisciIlTuo.setText("");

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(	MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		GridBagConstraints gbc_txtInserisciIlTuo = new GridBagConstraints();
		gbc_txtInserisciIlTuo.gridwidth = 7;
		gbc_txtInserisciIlTuo.insets = new Insets(0, 0, 5, 5);
		gbc_txtInserisciIlTuo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInserisciIlTuo.gridx = 9;
		gbc_txtInserisciIlTuo.gridy = 2;
		panel.add(txtInserisciIlTuo, gbc_txtInserisciIlTuo);
		txtInserisciIlTuo.setColumns(10);


		//	frame.getContentPane().add(lblNewLabel_8, gbc_lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setName("inter");
		lblNewLabel_9.setIcon(new ImageIcon("/home/giuseppe/Dropbox/workspace/progettoProgI/src/Graphic/Scudetti/inter.png"));
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 3;
		panel.add(lblNewLabel_9, gbc_lblNewLabel_9);


		//	frame.getContentPane().add(lblNewLabel_9, gbc_lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setName("juventus");
		lblNewLabel_10.setIcon(new ImageIcon("/home/giuseppe/Dropbox/workspace/progettoProgI/src/Graphic/Scudetti/juventus.png"));
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 2;
		gbc_lblNewLabel_10.gridy = 3;
		panel.add(lblNewLabel_10, gbc_lblNewLabel_10);


		//	frame.getContentPane().add(lblNewLabel_10, gbc_lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setName("lazio");
		lblNewLabel_11.setIcon(new ImageIcon("/home/giuseppe/Dropbox/workspace/progettoProgI/src/Graphic/Scudetti/lazio.png"));
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 4;
		gbc_lblNewLabel_11.gridy = 3;
		panel.add(lblNewLabel_11, gbc_lblNewLabel_11);


		//	frame.getContentPane().add(lblNewLabel_11, gbc_lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setForeground(Color.WHITE);
		lblNewLabel_12.setName("milan");
		lblNewLabel_12.setIcon(new ImageIcon("/home/giuseppe/Dropbox/workspace/progettoProgI/src/Graphic/Scudetti/milan.gif"));
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_12.gridx = 5;
		gbc_lblNewLabel_12.gridy = 3;
		panel.add(lblNewLabel_12, gbc_lblNewLabel_12);


		//	frame.getContentPane().add(lblNewLabel_12, gbc_lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setName("napoli");
		lblNewLabel_13.setIcon(new ImageIcon("/home/giuseppe/Dropbox/workspace/progettoProgI/src/Graphic/Scudetti/napoli.png"));
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_13.gridx = 6;
		gbc_lblNewLabel_13.gridy = 3;
		panel.add(lblNewLabel_13, gbc_lblNewLabel_13);


		//	frame.getContentPane().add(lblNewLabel_13, gbc_lblNewLabel_13);

		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setName("palermo");
		lblNewLabel_14.setIcon(new ImageIcon("/home/giuseppe/Dropbox/workspace/progettoProgI/src/Graphic/Scudetti/palermo.png"));
		GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
		gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_14.gridx = 7;
		gbc_lblNewLabel_14.gridy = 3;
		panel.add(lblNewLabel_14, gbc_lblNewLabel_14);


		//	frame.getContentPane().add(lblNewLabel_14, gbc_lblNewLabel_14);

		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setForeground(Color.WHITE);
		lblNewLabel_15.setName("parma");
		lblNewLabel_15.setIcon(new ImageIcon("/home/giuseppe/Dropbox/workspace/progettoProgI/src/Graphic/Scudetti/parma.gif"));
		GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
		gbc_lblNewLabel_15.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_15.gridx = 8;
		gbc_lblNewLabel_15.gridy = 3;
		panel.add(lblNewLabel_15, gbc_lblNewLabel_15);


		//	frame.getContentPane().add(lblNewLabel_15, gbc_lblNewLabel_15);

		JLabel lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.setForeground(Color.WHITE);
		lblNewLabel_16.setName("pescara");
		lblNewLabel_16.setIcon(new ImageIcon("/home/giuseppe/Dropbox/workspace/progettoProgI/src/Graphic/Scudetti/pescara.png"));
		GridBagConstraints gbc_lblNewLabel_16 = new GridBagConstraints();
		gbc_lblNewLabel_16.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_16.gridx = 0;
		gbc_lblNewLabel_16.gridy = 5;
		panel.add(lblNewLabel_16, gbc_lblNewLabel_16);


		//	frame.getContentPane().add(lblNewLabel_16, gbc_lblNewLabel_16);

		JLabel lblNewLabel_17 = new JLabel("");
		lblNewLabel_17.setName("roma");
		lblNewLabel_17.setIcon(new ImageIcon("/home/giuseppe/Dropbox/workspace/progettoProgI/src/Graphic/Scudetti/roma.png"));
		GridBagConstraints gbc_lblNewLabel_17 = new GridBagConstraints();
		gbc_lblNewLabel_17.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_17.gridx = 2;
		gbc_lblNewLabel_17.gridy = 5;
		panel.add(lblNewLabel_17, gbc_lblNewLabel_17);


		//	frame.getContentPane().add(lblNewLabel_17, gbc_lblNewLabel_17);

		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setForeground(Color.WHITE);
		lblNewLabel_18.setName("sampdoria");
		lblNewLabel_18.setIcon(new ImageIcon("/home/giuseppe/Dropbox/workspace/progettoProgI/src/Graphic/Scudetti/sampdoria.png"));
		GridBagConstraints gbc_lblNewLabel_18 = new GridBagConstraints();
		gbc_lblNewLabel_18.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_18.gridx = 4;
		gbc_lblNewLabel_18.gridy = 5;
		panel.add(lblNewLabel_18, gbc_lblNewLabel_18);


		//	frame.getContentPane().add(lblNewLabel_18, gbc_lblNewLabel_18);

		JLabel lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.setName("siena");
		lblNewLabel_19.setIcon(new ImageIcon("/home/giuseppe/Dropbox/workspace/progettoProgI/src/Graphic/Scudetti/siena.gif"));
		GridBagConstraints gbc_lblNewLabel_19 = new GridBagConstraints();
		gbc_lblNewLabel_19.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_19.gridx = 5;
		gbc_lblNewLabel_19.gridy = 5;
		panel.add(lblNewLabel_19, gbc_lblNewLabel_19);


		//	frame.getContentPane().add(lblNewLabel_19, gbc_lblNewLabel_19);

		JLabel lblNewLabel_20 = new JLabel("");
		lblNewLabel_20.setName("torino");
		lblNewLabel_20.setIcon(new ImageIcon("/home/giuseppe/Dropbox/workspace/progettoProgI/src/Graphic/Scudetti/torino.png"));
		GridBagConstraints gbc_lblNewLabel_20 = new GridBagConstraints();
		gbc_lblNewLabel_20.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_20.gridx = 6;
		gbc_lblNewLabel_20.gridy = 5;
		panel.add(lblNewLabel_20, gbc_lblNewLabel_20);


		//	frame.getContentPane().add(lblNewLabel_20, gbc_lblNewLabel_20);

		JLabel lblNewLabel_21 = new JLabel("");
		lblNewLabel_21.setName("udinese");
		lblNewLabel_21.setIcon(new ImageIcon("/home/giuseppe/Dropbox/workspace/progettoProgI/src/Graphic/Scudetti/udinese.png"));
		GridBagConstraints gbc_lblNewLabel_21 = new GridBagConstraints();
		gbc_lblNewLabel_21.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_21.gridx = 7;
		gbc_lblNewLabel_21.gridy = 5;
		panel.add(lblNewLabel_21, gbc_lblNewLabel_21);
		//	frame.getContentPane().add(lblNewLabel_21, gbc_lblNewLabel_21);
	}

	public String getSq(){
		return squadra;
	}
}
