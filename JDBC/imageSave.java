import java.sql.*;
import java.io.*;

class imageSave{

	public static void main(String[] args) {
		try {


			Class.ForName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/practice";
			String username = "root";
			String password= "rawatravi";
			Connection con = DriverManager.getConnection(url,username,password);

	// inserting image into the databases using datatype blob ->> binary large object.
			

	// create table images(id int primary key auto_increament , pic blob);

	// mysql blob type store only data less 65 kb otherwise "data to long" error will come.

 
		String q = "insert into images(pic) values(?)";

		PreparedStatemen pstmt= com.PrepareStatement(q);

		// pstmt.setString(1,"value");
		// here program and image are in same folder otherwise we will provide the exact directry/loaction.
		// FileInputStream for taking input (image) from pc.
		FileInputStream fis= new FileInputStream("mypics.jpg");
 
 		// fis.available() provide the  available data to it. 
		psmtm.setBinaryStream(1,fis,fis.available());

		psmtm.executeUpdate();

		System.out.println("done ..");

		}
		catch(Exception e){
			System.out.println("Error !!");
		}
	}
}