package webapp;
/**
 * JDBC Overview
 */
import java.sql.*;

public class DBAuthService implements AuthService{
   public boolean validateUser(String user, String password) {
		  boolean st =false;
	      try{
     		 //loading drivers for mysql
	         Class.forName("com.mysql.jdbc.Driver");

	    	 //creating connection with the database 
	         String connectionString = "jdbc:mysql://localhost:3306/ecommerce?user=root&password=wanmen123";
	         Connection con=DriverManager.getConnection(connectionString);
	         try{
		         PreparedStatement ps =con.prepareStatement
		                             ("select * from users where name=? and password=?");
		         try{
		        	 ps.setString(1, user);
			         ps.setString(2, password);
			         ResultSet rs =ps.executeQuery();
			         try{
			        	 st = rs.next();
			         }finally{
			        	 rs.close(); // release resultSet
			         }
		         }finally{
		          ps.close(); // release the statement
		         }
	         }finally{
	        	 con.close(); // release the connection
	         }
		   }catch(Exception e){
		          e.printStackTrace();
	       }
	       return st;
	}

}