import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StoixeiaPelatiPage {

	public JFrame frame;
	
	private JTextField text_onoma;
	private JTextField text_epwnymo;
	private JTextField text_thlefwno;
	private JTextField text_email;
	private JTextField text_card;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public StoixeiaPelatiPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 525, 407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0395\u03AF\u03C3\u03C4\u03B5 \u03AD\u03BD\u03B1 \u03B2\u03AE\u03BC\u03B1 \u03C0\u03C1\u03B9\u03BD \u03C4\u03B7\u03BD \u03BA\u03C1\u03AC\u03C4\u03B7\u03C3\u03B7");
		lblNewLabel.setBounds(136, 23, 286, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\u03A0\u03B1\u03C1\u03B1\u03BA\u03B1\u03BB\u03CE \u03C3\u03C5\u03BC\u03C0\u03BB\u03B7\u03C1\u03CE\u03C3\u03C4\u03B5 \u03C4\u03B1 \u03C3\u03C4\u03BF\u03B9\u03C7\u03B5\u03AF\u03B1 \u03C3\u03B1\u03C2");
		label.setBounds(136, 48, 286, 14);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel_1 = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1");
		lblNewLabel_1.setBounds(80, 74, 80, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("\u0395\u03C0\u03CE\u03BD\u03C5\u03BC\u03BF");
		label_1.setBounds(80, 109, 80, 14);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u03A4\u03B7\u03BB\u03AD\u03C6\u03C9\u03BD\u03BF");
		label_2.setBounds(80, 147, 80, 14);
		frame.getContentPane().add(label_2);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(80, 181, 80, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblC = new JLabel("Credit card");
		lblC.setBounds(80, 218, 80, 14);
		frame.getContentPane().add(lblC);
		
		text_onoma = new JTextField();
		text_onoma.setBounds(170, 73, 179, 20);
		frame.getContentPane().add(text_onoma);
		text_onoma.setColumns(10);
		
		text_epwnymo = new JTextField();
		text_epwnymo.setColumns(10);
		text_epwnymo.setBounds(170, 106, 179, 20);
		frame.getContentPane().add(text_epwnymo);
		
		text_thlefwno = new JTextField();
		text_thlefwno.setColumns(10);
		text_thlefwno.setBounds(170, 144, 179, 20);
		frame.getContentPane().add(text_thlefwno);
		
		text_email = new JTextField();
		text_email.setColumns(10);
		text_email.setBounds(170, 178, 179, 20);
		frame.getContentPane().add(text_email);
		
		text_card = new JTextField();
		text_card.setColumns(10);
		text_card.setBounds(170, 215, 179, 20);
		frame.getContentPane().add(text_card);
		
		JButton btn_Kratisi = new JButton("\u039A\u03AC\u03BD\u03B5 \u039A\u03C1\u03AC\u03C4\u03B7\u03C3\u03B7");
		btn_Kratisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MySQLconn conn = new MySQLconn();
				String onoma = text_onoma.getText();
				String epwnymo = text_epwnymo.getText();
				String thlefwno = text_thlefwno.getText();
				String email = text_email.getText();
				String card= text_card.getText();
				conn.kratisi2(KratisiPage.hotel, onoma, epwnymo, thlefwno, email, card);
				TelosKratisiPage page = new TelosKratisiPage();
				page.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		
		
		btn_Kratisi.setBounds(140, 311, 179, 33);
		frame.getContentPane().add(btn_Kratisi);
		
		
		JButton btn_Back = new JButton("Back");
		btn_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				KratisiPage page = new KratisiPage();
				page.frame.setVisible(true);	
				frame.setVisible(false);
			}
		});
		btn_Back.setBounds(410, 334, 89, 23);
		frame.getContentPane().add(btn_Back);
	}
}
