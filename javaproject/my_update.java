import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class my_update{
	
void  my_db_update(String str1, String password,String str3,String str4, String str5, String str6) {
		try{  
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection(  
	"jdbc:mysql://localhost:3306/my_tutorial","root","");  
	Statement st=con.createStatement();  
	int mark = Integer.parseInt(str3); // Mark is an integer
	// Adding record 
	String query1="INSERT INTO `my_tutorial`.`student`"
	 + " (`name`, `class`, `mark`, `sex`)"
	 + "VALUES('" +str1+"','"+password+"','"+str3+"','"+str4+"','"+str5+"')";
	st.executeUpdate(query1); // record added. 
	
	con.close();  
	
	}catch(Exception e){ System.out.println(e);} 
	
}
}