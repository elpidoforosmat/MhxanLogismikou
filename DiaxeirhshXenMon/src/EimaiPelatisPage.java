import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EimaiPelatisPage {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EimaiPelatisPage window = new EimaiPelatisPage();
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
	public EimaiPelatisPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 539, 341);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btn_Back = new JButton("Back");
		btn_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainPage page = new MainPage();
				page.frmMainPage.setVisible(true);	
				frame.setVisible(false);
			}
		});
		btn_Back.setBounds(387, 250, 126, 41);
		frame.getContentPane().add(btn_Back);
		
		JButton btn_make = new JButton("\u039A\u0391\u039D\u0395 \u039C\u0399\u0391 \u039A\u03A1\u0391\u03A4\u0397\u03A3\u0397");
		btn_make.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				KratisiPage page = new KratisiPage();
				page.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btn_make.setBounds(134, 71, 228, 51);
		frame.getContentPane().add(btn_make);
		
		JButton btn_cancel = new JButton("\u0391\u039A\u03A5\u03A1\u03A9\u03A3\u0395 \u039C\u0399\u0391 \u039A\u03A1\u0391\u03A4\u0397\u03A3\u0397");
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CancelPage page = new CancelPage();
				page.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btn_cancel.setBounds(134, 151, 228, 51);
		frame.getContentPane().add(btn_cancel);
	}

}
