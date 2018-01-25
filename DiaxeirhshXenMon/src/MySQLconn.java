import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;



public class MySQLconn {
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String connURL = "jdbc:mysql://localhost:3306/hotel";
			String user = "root";
			String pw = "1234qwer";
			 conn = DriverManager.getConnection(connURL, user, pw); 
			 stmt = conn.createStatement();
		
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	public int login(String username , String password) {
		
		connect();
		try {
			rs = stmt.executeQuery("select *from accounts where username='"+ username +"' and password= '"+ password +"'" );
			if (rs.next()) {
				if (rs.getString("thesh").equals("Idioktitis") ) {
					return 1;
					
				}
				else 
					return 2;
				
			}
			else 
				return 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	 public ArrayList <Integer> search(int hotel , int xwritikotita , Date in , Date out) {
		connect();
		
		String datein , dateout ;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(in);
		datein = "'" + Integer.toString(calendar.get(Calendar.YEAR)) + "-" + Integer.toString(calendar.get(Calendar.MONTH)+1) + "-" + Integer.toString(calendar.get(Calendar.DAY_OF_MONTH)) + "'";
		calendar.setTime(out);
		dateout = "'" + Integer.toString(calendar.get(Calendar.YEAR)) + "-" + Integer.toString(calendar.get(Calendar.MONTH)+1) + "-" + Integer.toString(calendar.get(Calendar.DAY_OF_MONTH)) + "'";
		String psaxe = "select *from " + KratisiPage.hotels[hotel] + " left outer join books" + KratisiPage.hotels[hotel] + " on " 
		+ KratisiPage.hotels[hotel] + ".id = books" + KratisiPage.hotels[hotel] + ".roomid where xwritikotita = " + xwritikotita + " and(datein is null or datein > " +  datein 
		+ " or dateout < " + dateout + ")";
		
		try {
			rs = stmt.executeQuery(psaxe);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList <Integer> rooms = new ArrayList <Integer>();
		
		try {
			while (rs.next()) {
				rooms.add(rs.getInt(KratisiPage.hotels[hotel] + ".id"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		
		return rooms;
		
		
		
				
	}
	
	public void kratisi (int roomid ,int hotel ,  Date datein , Date dateout) {
		connect() ;
		
		String dateinn , dateoutt ;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(datein);
		dateinn = "'" + Integer.toString(calendar.get(Calendar.YEAR)) + "-" + Integer.toString(calendar.get(Calendar.MONTH)+1) + "-" + Integer.toString(calendar.get(Calendar.DAY_OF_MONTH)) + "'";
		calendar.setTime(dateout);
		dateoutt = "'" + Integer.toString(calendar.get(Calendar.YEAR)) + "-" + Integer.toString(calendar.get(Calendar.MONTH)+1) + "-" + Integer.toString(calendar.get(Calendar.DAY_OF_MONTH)) + "'";
		String 	psaxe = "insert into books" + KratisiPage.hotels[hotel] + " values(id," + roomid + "," + dateinn + "," + dateoutt + ")";
		try {
			 stmt.executeUpdate(psaxe);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void kratisi2 (int hotel , String onoma , String epwnymo , String thlefwno , String email , String card ) {
		connect();
		
		String query = "insert into pelates values(id," + hotel + ",'" + onoma + "','" + epwnymo + "','" + thlefwno + "','" + email + "','" + card + "')" ;
		try {
			 stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cancel ( int id , int hotel) {
		connect();
		
		String query = "delete from books" + KratisiPage.hotels[hotel] + " where id = " + id ;
		try {
			 stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<String> getusers ( ) {
		connect();
		String query = "select *from accounts" ;
		
		try {
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList <String> users = new ArrayList <String>();
		
		try {
			while (rs.next()) {
				if (rs.getString("thesh").equals("Ypallilos")) {

					String user = rs.getString("id") + ", " + rs.getString("username") + ", " + rs.getString("thesh");
					users.add(user);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return users;
	}
	
	public void add (String username , String password) {
		connect();
		String query = "insert into accounts values(id," + "'Ypallilos','" + username + "','" + password + "')";
		try {
			 stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void remove (int id) {
		connect ();
		
		String query = "delete from accounts where id = " + id ; 
		try {
			 stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getbooks() {
		connect();
		
		ArrayList<String> books = new ArrayList<String>() ;
		for (int i = 0; i<5 ; i++) {
			String hotel = KratisiPage.hotels[i];
			String query = "select *from books" + hotel ;
			try {
				
				rs = stmt.executeQuery(query);
				while (rs.next() ) {
					
					String book = hotel + ", " + rs.getString("id") + ", room " + rs.getString("roomid") + ", from " + rs.getDate("datein") + " to " + rs.getDate("dateout");
					
					books.add(book);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return books;
	}
	public void deletebook (int hotel ,int id) {
		connect();
		String query = "delete from books" + KratisiPage.hotels[hotel] + " where id=" + id ;
		try {
			 stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
			 
		}
	}
	
}

