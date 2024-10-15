package layers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectiondb {
  public static Connection connect() {
	  
	  String url  = "jdbc:mysql://localhost:3306/SchoolDb";
		String user = "root";
		String password = "root";
		 Connection con=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	 con = DriverManager.getConnection(url,user,password);
		 
		if (con!=null) {
			System.out.println("connection successful");
			
		}else {
			System.out.println("something went wrong");
		}
		
	} catch (ClassNotFoundException e ) {
		System.out.println("class not found");
	}catch (SQLException e) {
		System.out.println("sql exception");
	  
	}
	
	
	
	return con;
	  
	
}
}
