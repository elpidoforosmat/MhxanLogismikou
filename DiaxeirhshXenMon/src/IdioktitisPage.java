import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class IdioktitisPage {

	public JFrame frame;
	private JTextField text_username;
	private JTextField text_password;
	private JTextField text_iduser;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public IdioktitisPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MySQLconn conn = new MySQLconn();
		frame = new JFrame();
		frame.setBounds(100, 100, 570, 473);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btn_back = new JButton("Back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EimaiIdioktitisPage page = new EimaiIdioktitisPage();
				page.frame.setVisible(true);	
				frame.setVisible(false);
			}
		});
		btn_back.setBounds(442, 374, 102, 49);
		frame.getContentPane().add(btn_back);
		
		JList list = new JList();
		list.setBounds(10, 11, 505, 129);
		ArrayList<String> users = new ArrayList<String>();
		users = conn.getusers() ;
		DefaultListModel<String> model = new DefaultListModel<String>();
		for (int i = 0; i < users.size(); i++)
			model.addElement(users.get(i));
		list.setModel(model);
		frame.getContentPane().add(list);
		
		JButton btn_add = new JButton("Add user");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = text_username.getText();
				String password = text_password.getText();
				conn.add(username, password);
				ArrayList<String> users = new ArrayList<String>();
				users = conn.getusers() ;
				DefaultListModel<String> model = new DefaultListModel<String>();
				for (int i = 0; i < users.size(); i++)
					model.addElement(users.get(i));
				list.setModel(model);
						}
		});
		btn_add.setBounds(53, 251, 161, 40);
		frame.getContentPane().add(btn_add);
		
		JButton btn_remove = new JButton("Remove user");
		btn_remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt(text_iduser.getText()) ;
				conn.remove(id);
				ArrayList<String> users = new ArrayList<String>();
				users = conn.getusers() ;
				DefaultListModel<String> model = new DefaultListModel<String>();
				for (int i = 0; i < users.size(); i++)
					model.addElement(users.get(i));
				list.setModel(model);
			}
		});
		btn_remove.setBounds(358, 250, 157, 42);
		frame.getContentPane().add(btn_remove);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(10, 165, 75, 14);
		frame.getContentPane().add(lblNewLabel);
		
		text_username = new JTextField();
		text_username.setBounds(95, 162, 141, 20);
		frame.getContentPane().add(text_username);
		text_username.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(10, 202, 75, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		text_password = new JTextField();
		text_password.setBounds(95, 199, 141, 20);
		frame.getContentPane().add(text_password);
		text_password.setColumns(10);
		
		JLabel lbl_id = new JLabel("ID \u03C4\u03BF\u03C5 user");
		lbl_id.setBounds(307, 165, 67, 14);
		frame.getContentPane().add(lbl_id);
		
		text_iduser = new JTextField();
		text_iduser.setBounds(405, 162, 110, 20);
		frame.getContentPane().add(text_iduser);
		text_iduser.setColumns(10);
	}
}
