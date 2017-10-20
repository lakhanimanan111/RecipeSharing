import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test {

	public static void main(String[] args) {
		try {	    	 
			String url = "jdbc:mysql://localhost:3306/";
	        String dbName = "chefs_secret";
	        String driver = "com.mysql.jdbc.Driver";
	        String userName = "root";
	        String password = "";
	        
        	Class.forName(driver).newInstance();
			Connection connection = DriverManager.getConnection(url + dbName, userName,password);
			System.out.println("Connectedddddddd");    	 
	    	 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
