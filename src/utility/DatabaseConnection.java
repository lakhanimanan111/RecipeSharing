package utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
		
	private static Connection connection;

	public static Connection getConnection() throws Exception {
		if(connection == null) {
			String url = "jdbc:mysql://localhost:3306/";
	        String dbName = "chefs_secret";
	        String driver = "com.mysql.jdbc.Driver";
	        String userName = "root";
	        String password = "";
	        try {
	        	Class.forName(driver).newInstance();
				connection = DriverManager.getConnection(url + dbName, userName,password);
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		}		
		return connection;
    }
}
