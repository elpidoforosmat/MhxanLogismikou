import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class YpallilosPage {

	public JFrame frame;
	private JTextField text_id;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public YpallilosPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MySQLconn conn = new MySQLconn() ;
		frame = new JFrame();
		frame.setBounds(100, 100, 533, 358);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox1 = new JComboBox();
		comboBox1.setBounds(178, 177, 84, 22);
		frame.getContentPane().add(comboBox1);
		comboBox1.setModel(new DefaultComboBoxModel(KratisiPage.hotels));
		
		JButton btn_back = new JButton("Back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EimaiIdioktitisPage page = new EimaiIdioktitisPage();
				page.frame.setVisible(true);	
				frame.setVisible(false);
			}
		});
		btn_back.setBounds(403, 272, 104, 36);
		frame.getContentPane().add(btn_back);
		
		
		
		JList list_1 = new JList();
		list_1.setBounds(30, 26, 459, 128);
		
		ArrayList<String> books = new ArrayList<String>();
		books = conn.getbooks() ;
		DefaultListModel<String> model = new DefaultListModel<String>();
		for (int i = 0; i < books.size(); i++)
			model.addElement(books.get(i));
		list_1.setModel(model);
		frame.getContentPane().add(list_1);
		
		JButton btn_remove = new JButton("\u0391\u03BA\u03CD\u03C1\u03C9\u03C3\u03B5 \u03C4\u03B7\u03BD \u03BA\u03C1\u03AC\u03C4\u03B7\u03C3\u03B7");
		btn_remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int hotel = comboBox1.getSelectedIndex() ;
				int id = Integer.parseInt(text_id.getText() );
				conn.deletebook(hotel, id);
				ArrayList<String> books = new ArrayList<String>();
				books = conn.getbooks() ;
				DefaultListModel<String> model = new DefaultListModel<String>();
				for (int i = 0; i < books.size(); i++)
					model.addElement(books.get(i));
				list_1.setModel(model);
				
			}
		});
		btn_remove.setBounds(126, 250, 199, 41);
		frame.getContentPane().add(btn_remove);
		
		JLabel lblNewLabel = new JLabel("\u0395\u03C0\u03B9\u03BB\u03AD\u03BE\u03C4\u03B5 \u039E\u03B5\u03BD\u03BF\u03B4\u03BF\u03C7\u03B5\u03AF\u03BF");
		lblNewLabel.setBounds(41, 181, 127, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(41, 213, 95, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		text_id = new JTextField();
		text_id.setBounds(178, 210, 86, 20);
		frame.getContentPane().add(text_id);
		text_id.setColumns(10);
		
	
	}

}
