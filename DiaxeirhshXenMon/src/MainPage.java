import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPage {

	public JFrame frmMainPage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
					window.frmMainPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainPage = new JFrame();
		frmMainPage.setTitle("MAIN PAGE");
		frmMainPage.setBounds(100, 100, 514, 345);
		frmMainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainPage.getContentPane().setLayout(null);
		
		JButton btn_eimaipelatis = new JButton("\u0395\u03AF\u03BC\u03B1\u03B9 \u03C0\u03B5\u03BB\u03AC\u03C4\u03B7\u03C2");
		btn_eimaipelatis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MySQLconn conn = new MySQLconn();
				conn.connect();
				EimaiPelatisPage page = new EimaiPelatisPage();
				page.frame.setVisible(true);
				frmMainPage.setVisible(false);
			}
		});
		btn_eimaipelatis.setBounds(10, 140, 205, 87);
		frmMainPage.getContentPane().add(btn_eimaipelatis);
		
		JButton btn_eimaiypal = new JButton("\u0395\u03AF\u03BC\u03B1\u03B9 \u03C5\u03C0\u03AC\u03BB\u03BB\u03B7\u03BB\u03BF\u03C2/\u03B9\u03B4\u03B9\u03BF\u03BA\u03C4\u03AE\u03C4\u03B7\u03C2");
		btn_eimaiypal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EimaiIdioktitisPage page = new EimaiIdioktitisPage();
				page.frame.setVisible(true);
				frmMainPage.setVisible(false);
			}
		});
		btn_eimaiypal.setBounds(285, 140, 203, 87);
		frmMainPage.getContentPane().add(btn_eimaiypal);
		
		JLabel lbl_welcomemsg = new JLabel("\u039A\u0391\u039B\u03A9\u03A3 \u0397\u03A1\u0398\u0391\u03A4\u0395 \u03A3\u03A4\u0397\u039D \u03A3\u0395\u039B\u0399\u0394\u0391 \u03A4\u03A9\u039D \u039E\u0395\u039D\u039F\u0394\u039F\u03A7\u0395\u0399\u03A9\u039D \u039C\u0391\u03A3");
		lbl_welcomemsg.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_welcomemsg.setBounds(77, 23, 360, 62);
		frmMainPage.getContentPane().add(lbl_welcomemsg);
	}
}
