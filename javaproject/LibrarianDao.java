import java.sql.*;

public class LibrarianDao {

	public static int save(String name,String password,String email,String address,String city,String contact) {
		int status = 0;
		try {
			
			// to connect the database with the help of jdbc
			Connection con = CP.createC();
			
			PreparedStatement ps = con.prepareStatement("insert into librarian(name,password,email,address,city,contact) values(?,?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, address);
			ps.setString(5, city);
			ps.setString(6, contact);
			status = ps.executeUpdate();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
	public static boolean validate(String name, String password) {
		boolean status=false;
		
		try {
			
			Connection con = CP.createC();
			
			PreparedStatement ps = con.prepareStatement("select * from librarian where name=? and password=?");
			ps.setString(1,name);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static int delete(String sid) {
		int status = 0;
		try {
			
			Connection con = CP.createC();
			
			PreparedStatement ps = con.prepareStatement("delete from librarian where name=?");
			ps.setString(1, sid);
			status = ps.executeUpdate();
			con.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
}
