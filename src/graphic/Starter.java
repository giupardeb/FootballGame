package graphic;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JSplitPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Starter extends JFrame {

/**
	 * 
	 */
	private static final long serialVersionUID = 4403410327739686741L;

	private JFrame frame = this;

	
	public Starter() {
		initialize();
		Dimension screenSize = Toolkit.getDefaultToolkit ( ).getScreenSize ( );
		this.setLocation ( ( screenSize.width / 2 ) - ( this.getWidth ( ) / 2 ), (
		screenSize.height / 2 ) - ( this.getHeight ( ) / 2 ) );	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setSize(800, 400);	
		
		lblNewLabel.setIcon(new ImageIcon(Starter.class.getResource("/scudetti/Football.jpg")));
		getContentPane().add(lblNewLabel);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.47);
		getContentPane().add(splitPane, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("INIZIA");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				MainWindow F = new MainWindow();
				
			}
		});
		splitPane.setLeftComponent(btnNewButton);
		
		JButton btnInformazioni = new JButton("INFORMAZIONI");
		splitPane.setRightComponent(btnInformazioni);
		this.pack();
		this.setVisible(true);

	}

}
