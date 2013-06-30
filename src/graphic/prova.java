package graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Point;

import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class prova {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prova window = new prova();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public prova() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(new Dimension(700, 400));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(12, 168,  48, 48);
		Point p = btnNewButton.getLocation();
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(110, 26,  48, 48);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(110, 126,  48, 48);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(110, 226,  48, 48);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(110, 321,  48, 48);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setBounds(277, 26,  48, 48);
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.setBounds(277, 126,  48, 48);
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("New button");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_7.setBounds(457, 126, 48, 48);
		panel.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("New button");
		btnNewButton_8.setBounds(277, 226,  48, 48);
		panel.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("New button");
		btnNewButton_9.setBounds(277, 321,  48, 48);
		panel.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("New button");
		btnNewButton_10.setBounds(457, 226,  48, 48);
		panel.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("New button");
		btnNewButton_11.setBounds(638, 168,  48, 48);
		panel.add(btnNewButton_11);
		
		JButton button = new JButton("New button");
		button.setBounds(380, 26, 48, 48);
		panel.add(button);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(380, 126, 48, 48);
		panel.add(button_1);
		
		JButton button_2 = new JButton("New button");
		button_2.setBounds(380, 226, 48, 48);
		panel.add(button_2);
		
		JButton button_3 = new JButton("New button");
		button_3.setBounds(380, 321, 48, 48);
		panel.add(button_3);
		
		JButton button_4 = new JButton("New button");
		button_4.setBounds(548, 321, 48, 48);
		panel.add(button_4);
		
		JButton button_5 = new JButton("New button");
		button_5.setBounds(548, 226, 48, 48);
		panel.add(button_5);
		
		JButton button_6 = new JButton("New button");
		button_6.setBounds(548, 126, 48, 48);
		panel.add(button_6);
		
		JButton button_7 = new JButton("New button");
		button_7.setBounds(548, 26, 48, 48);
		panel.add(button_7);
		
		JButton button_8 = new JButton("New button");
		button_8.setBounds(193, 126, 48, 48);
		panel.add(button_8);
		
		JButton button_9 = new JButton("New button");
		button_9.setBounds(193, 226, 48, 48);
		panel.add(button_9);
	}

}
