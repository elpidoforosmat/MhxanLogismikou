import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;

public class EimaiIdioktitisPage {

	public JFrame frame;
	private JTextField txt_username;
	private JPasswordField txt_password;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EimaiIdioktitisPage window = new EimaiIdioktitisPage();
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
	public EimaiIdioktitisPage() {
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
		
		JButton btn_Back = new JButton("Back");
		btn_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainPage page = new MainPage();
				page.frmMainPage.setVisible(true);	
				frame.setVisible(false);
			
			}
		});
		btn_Back.setBounds(308, 209, 100, 41);
		frame.getContentPane().add(btn_Back);
		
		JLabel lblNewLabel = new JLabel("\u03A3\u03CD\u03BD\u03C3\u03B5\u03C3\u03B7 \u03C7\u03C1\u03AE\u03C3\u03C4\u03B7");
		lblNewLabel.setBounds(141, 30, 105, 19);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(34, 66, 101, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(34, 92, 77, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel lbl_wrong = new JLabel(" \u039B\u0391\u0398\u039F\u03A3 USERNAME \u0397 K\u03A9\u0394\u0399\u039A\u039F\u03A3");
		lbl_wrong.setForeground(Color.RED);
		lbl_wrong.setBounds(129, 163, 211, 32);
		lbl_wrong.setVisible(false);
		frame.getContentPane().add(lbl_wrong);
		
		txt_username = new JTextField();
		txt_username.setBounds(135, 63, 186, 20);
		frame.getContentPane().add(txt_username);
		txt_username.setColumns(10);
		
		txt_password = new JPasswordField();
		txt_password.setBounds(134, 89, 187, 20);
		frame.getContentPane().add(txt_password);
		
		JButton btn_Login = new JButton("\u03A3\u03A5\u039D\u03A3\u0395\u03A3\u0397");
		btn_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String username = txt_username.getText();
				String password = txt_password.getText();
				MySQLconn connection = new MySQLconn();
				int success = connection.login(username,password) ;
				if ( success == 1) {
					//idioktitis
					lbl_wrong.setVisible(false);
					IdioktitisPage page = new IdioktitisPage();
					page.frame.setVisible(true);
					frame.setVisible(false);	
					
				}
				else if ( success == 2) {
					// ypallilos
					lbl_wrong.setVisible(false);
					YpallilosPage page = new YpallilosPage();
					page.frame.setVisible(true);
					frame.setVisible(false);
				}
				else
					lbl_wrong.setVisible(true);
			}
			
		});
		btn_Login.setBounds(157, 120, 117, 32);
		frame.getContentPane().add(btn_Login);
		
		
	}
}
