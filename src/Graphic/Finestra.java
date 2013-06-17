package Graphic;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class Finestra extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5444684960085881763L;
	private JFrame frmFootballmanager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Finestra window = new Finestra();
					window.frmFootballmanager.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Finestra(Component comp) {
		initialize();
		frmFootballmanager.getContentPane().add(comp);
		frmFootballmanager.pack();
		frmFootballmanager.setVisible(true);

	}
	
	public Finestra() {
		initialize();
		frmFootballmanager.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFootballmanager = new JFrame();
		frmFootballmanager.setTitle("FootBallManager");
		frmFootballmanager.setBounds(100, 100, 450, 300);
		frmFootballmanager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFootballmanager.setResizable(false);
	}
	
}
