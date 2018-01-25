import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelosKratisiPage {

	public JFrame frame;

	

	/**
	 * Create the application.
	 */
	public TelosKratisiPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u03A3\u03A5\u039D\u03A7\u0391\u03A1\u0397\u03A4\u0397\u03A1\u0399\u0391");
		lblNewLabel.setBounds(157, 43, 182, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btn_ok = new JButton("\u0391\u03A1\u03A7\u0399\u039A\u0397");
		btn_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainPage page = new MainPage();
				page.frmMainPage.setVisible(true);
				frame.setVisible(false);
			}
		});
		btn_ok.setBounds(144, 129, 117, 48);
		frame.getContentPane().add(btn_ok);
		
		JLabel lblNewLabel_1 = new JLabel("\u0397 \u039A\u03A1\u0391\u03A4\u0397\u03A3\u0397 \u039F\u039B\u039F\u039A\u039B\u0397\u03A1\u03A9\u0398\u0397\u039A\u0395 \u039C\u0395 \u0395\u03A0\u0399\u03A4\u03A5\u03A7\u0399\u0391");
		lblNewLabel_1.setBounds(93, 68, 318, 14);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
