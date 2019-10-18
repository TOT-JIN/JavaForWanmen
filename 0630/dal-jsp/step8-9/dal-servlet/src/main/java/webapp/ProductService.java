package webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class ProductService {
	public  List<Product> getAllProduct() {
	  List<Product> allProduct = new ArrayList<Product>();
	  
      try{
 		 //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");

    	 //creating connection with the database 
         String connectionString = "jdbc:mysql://localhost:3306/ecommerce?user=root&password=wanmen123";
         Connection con=DriverManager.getConnection(connectionString);
         try{
	         PreparedStatement ps =con.prepareStatement("select * from product");
	         try{
		         ResultSet rs =ps.executeQuery();
		         try{
		             while (rs.next()) {
		            	 int id = Integer.parseInt(rs.getString("id"));
		            	 String title = rs.getString("title");
		            	 String thumbnail = rs.getString("thumbnail");
		            	 String detail = rs.getString("detail");
		            	 double price = Double.parseDouble(rs.getString("price"));
		            	 allProduct.add(new Product(id, title, detail, thumbnail,price));
		               }		        	 
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
       return allProduct;
	}
}
	
