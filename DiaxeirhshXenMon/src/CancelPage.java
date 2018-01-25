import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CancelPage {

	public JFrame frame;
	private JTextField text_id;



	/**
	 * Create the application.
	 */
	public CancelPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btn_Back = new JButton("Back");
		btn_Back.setBounds(304, 207, 120, 43);
		btn_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EimaiPelatisPage page = new EimaiPelatisPage();
				page.frame.setVisible(true);	
				frame.setVisible(false);
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btn_Back);
		
		JLabel lbl_id = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u03BA\u03C1\u03AC\u03C4\u03B7\u03C3\u03B7\u03C2");
		lbl_id.setBounds(29, 86, 156, 14);
		frame.getContentPane().add(lbl_id);
		
		text_id = new JTextField();
		text_id.setBounds(195, 83, 86, 20);
		frame.getContentPane().add(text_id);
		text_id.setColumns(10);
		
		JComboBox comboBox1 = new JComboBox();
		comboBox1.setBounds(197, 36, 84, 22);
		frame.getContentPane().add(comboBox1);
		comboBox1.setModel(new DefaultComboBoxModel(KratisiPage.hotels));
		
		JButton btn_cancel = new JButton("\u0391\u03BA\u03CD\u03C1\u03C9\u03C3\u03B7");
		btn_cancel.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				MySQLconn conn = new MySQLconn() ;
				int id = Integer.parseInt(text_id.getText());
				int hotel = comboBox1.getSelectedIndex() ;
				conn.cancel(id,hotel);
				
			}
		});
		btn_cancel.setBounds(126, 141, 120, 43);
		frame.getContentPane().add(btn_cancel);
		
		JLabel lblNewLabel = new JLabel("\u0394\u03B9\u03AC\u03BB\u03B5\u03BE\u03B5 \u03BE\u03B5\u03BD\u03BF\u03B4\u03BF\u03C7\u03B5\u03AF\u03BF");
		lblNewLabel.setBounds(29, 40, 158, 14);
		frame.getContentPane().add(lblNewLabel);
		
	}
}
