package layers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
        public static boolean CREATE(Connection con , Entry obj) {
String query = "insert into student(id,name,address) values (?,?,?)";
			int id = obj.getId();
			String name = obj.getName();
			String address = obj.getAddress();
			boolean b= true;
			PreparedStatement psmt;
			try {
				psmt = con.prepareStatement(query);
				psmt.setInt(1,id);
				psmt.setString(2, name);
				psmt.setString(3, address);
			 b = psmt.execute();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
        	return b;
        	
        }
        
        
        public static void READ(Connection con) {
        	String query = "select * from Student ";
        	ResultSet rs = null;
        	try {
				Statement smt =  con.createStatement();
		rs  = smt.executeQuery(query);
		   while (rs.next()) {
			   System.out.println(rs.getInt("id"));
               System.out.println(rs.getString("name"));
               System.out.println(rs.getString("address"));
               System.out.println("===========================");
		   }
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		
        }
        
        public static int UPDATE(Connection con,Entry obj) {
        	int i=0;
        	String query = "UPDATE  student set name = ?, address = ? WHERE id = ?";
			PreparedStatement psmt;
			try {
				psmt = con.prepareStatement(query);
				psmt.setInt(3,obj.getId());
				psmt.setString(1,obj.getName());
				psmt.setString(2,obj.getAddress());
				i = psmt.executeUpdate();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
        	
        	return i;
        }
        
     public static int DELETE(Connection con, int id)   {
    	 int i = 0;
    	 String query = "delete from student  where id = ?";
			PreparedStatement psmt;
			try {
				psmt = con.prepareStatement(query);
				psmt.setInt(1,id);
				
				i = psmt.executeUpdate();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
    	 return i;
    	 
     }
        
        
        
        
        
        
        
        
        
 
}
