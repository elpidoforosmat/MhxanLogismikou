import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextPane;


import com.toedter.calendar.JDateChooser;

public class KratisiPage {

	public JFrame frame;
	private ArrayList< Integer > availablerooms = new ArrayList<Integer>() ;
	public static final String[] hotels = {"athina" , "thessaloniki" , "patra" , "santorini" , "lamia"};
	public static final String[] xwrit = {"2" ,"3"};
	public static int hotel = -1 ;
 	/**
	 * Create the application.
	 */
	public KratisiPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 593, 404);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btn_Back = new JButton("Back");
		btn_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EimaiPelatisPage page = new EimaiPelatisPage();
				page.frame.setVisible(true);	
				frame.setVisible(false);
				
			}
		});
		btn_Back.setBounds(457, 314, 110, 40);
		frame.getContentPane().add(btn_Back);
		
		JList list = new JList();
		list.setBounds(344, 11, 198, 209);
		frame.getContentPane().add(list);
		
		
		JLabel lblChooseHotel = new JLabel("\u0394\u03B9\u03AC\u03BB\u03B5\u03BE\u03B5 \u03BE\u03B5\u03BD\u03BF\u03B4\u03BF\u03C7\u03B5\u03AF\u03BF");
		lblChooseHotel.setBounds(24, 26, 110, 14);
		frame.getContentPane().add(lblChooseHotel);
		
		JComboBox comboBox1 = new JComboBox();
		comboBox1.setBounds(144, 22, 84, 22);
		frame.getContentPane().add(comboBox1);
		comboBox1.setModel(new DefaultComboBoxModel(hotels));
		
		JLabel label = new JLabel("\u03A7\u03C9\u03C1\u03B7\u03C4\u03B9\u03BA\u03CC\u03C4\u03B7\u03C4\u03B1");
		label.setBounds(24, 74, 110, 14);
		frame.getContentPane().add(label);
		
		JComboBox comboBox2 = new JComboBox();
		comboBox2.setBounds(144, 70, 84, 22);
		frame.getContentPane().add(comboBox2);
		comboBox2.setModel(new DefaultComboBoxModel(xwrit));
		
		JLabel lblCheckIn = new JLabel("Check in");
		lblCheckIn.setBounds(24, 129, 110, 14);
		frame.getContentPane().add(lblCheckIn);
		
		JLabel lblCheckOut = new JLabel("Check out");
		lblCheckOut.setBounds(24, 172, 110, 14);
		frame.getContentPane().add(lblCheckOut);
		
		JDateChooser date_in = new JDateChooser();
		date_in.setBounds(144, 129, 84, 20);
		frame.getContentPane().add(date_in);
		
		JDateChooser date_out = new JDateChooser();
		date_out.setBounds(144, 172, 84, 20);
		frame.getContentPane().add(date_out);
		
		JButton btn_anazhthsh = new JButton("\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7");
		btn_anazhthsh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MySQLconn conn = new MySQLconn();
				Date datein,dateout;
				datein = date_in.getDate();
				dateout = date_out.getDate();
				int hotel = comboBox1.getSelectedIndex();
				int xwr = comboBox2.getSelectedIndex()+2;
				ArrayList <Integer> rooms = conn.search(hotel, xwr, datein, dateout);
				availablerooms = rooms ;
				DefaultListModel<String> model = new DefaultListModel<String>();
				for (int i = 0; i < rooms.size(); i++)
					model.addElement("Room " + Integer.toString(rooms.get(i)));
				list.setModel(model);
			}
		});
		btn_anazhthsh.setBounds(93, 228, 124, 43);
		frame.getContentPane().add(btn_anazhthsh);
		
		JButton btn_Kratisi = new JButton("\u039A\u03AC\u03BD\u03B5 \u039A\u03C1\u03AC\u03C4\u03B7\u03C3\u03B7");
		btn_Kratisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StoixeiaPelatiPage page = new StoixeiaPelatiPage();
				page.frame.setVisible(true);
				frame.setVisible(false);
				Date datein , dateout ;
				datein = date_in.getDate() ;
				dateout = date_out.getDate() ;
				int hotel = comboBox1.getSelectedIndex();
				int roomid = availablerooms.get(list.getSelectedIndex());
				MySQLconn conn = new MySQLconn();
				conn.kratisi(roomid, hotel , datein, dateout);
				KratisiPage.hotel = hotel;
				
			}
		});
		btn_Kratisi.setBounds(377, 231, 154, 40);
		frame.getContentPane().add(btn_Kratisi);
		
		JLabel lblNewLabel = new JLabel("* \u039A\u03CC\u03C3\u03C4\u03BF\u03C2 \u03B4\u03AF\u03BA\u03BB\u03B7\u03BD\u03BF\u03C5 30 \u03B5\u03C5\u03C1\u03C9 * \u039A\u03CC\u03C3\u03C4\u03BF\u03C2 \u03C4\u03C1\u03AF\u03BA\u03BB\u03B7\u03BD\u03BF\u03C5 50 \u03B5\u03C5\u03C1\u03C9");
		lblNewLabel.setBounds(10, 296, 376, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label_1 = new JLabel("* \u03A3\u03B5 \u03C0\u03B5\u03C1\u03AF\u03C0\u03C4\u03C9\u03C3\u03B7 \u03B1\u03BA\u03CD\u03C1\u03C9\u03C3\u03B7\u03C2 \u03C4\u03B7\u03C2 \u03BA\u03C1\u03AC\u03C4\u03B7\u03C3\u03B7\u03C2 \u03C3\u03B1\u03C2 \u03B5\u03C0\u03B9\u03C3\u03C4\u03C1\u03AD\u03C6\u03BF\u03C5\u03BC\u03B5 \u03C4\u03BF \u03BC\u03B9\u03C3\u03AC \u03C7\u03C1\u03AE\u03BC\u03B1\u03C4\u03B1 ");
		label_1.setBounds(10, 327, 449, 27);
		frame.getContentPane().add(label_1);
		
		
	}
}
