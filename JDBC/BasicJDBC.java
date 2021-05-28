import java.sql.*;
class BasicJDBC{
	public static void main(String[] args) {
		try{

			// load the driver
			Class.ForName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/practice";
			String username= "root";
			String password= "rawatravi";
			Connection con = DriverManager.getConnection(url,username,password);

			// if(con,isClosed()){
			// 	System.out.println("Connection is closed");
			// }else{
			// 	System.out.println("Connection is created ..")
			// }

			//********** creating the table ****************// 


			// create a query 
			// String q ="create table table1(tid int(20) primary key auto_increament,tname varchar(200) not null,tcity varchar(400))";

			// // create statement :
			// Statement stmt = con.createStatement();

			// stmt.executeUpdate(q); 

			// System.out.println("table created in database ..");

			// con.close();

		//**************************************************************//

			// **** inserting in the table ********//

			// create a query 
			// String q ="insert into table1(tname,tcity) values (?,?)";

			// // get the PreparedStatement object

			// PreparedStatement pstmt = com.prepareStatement(q);

			// // set the values to query 

			// pstmt.setString(1,"Ravinder");
			// pstmt.setString(2,"delhi");

			// pstmt.executeUpdate();

			// System.out.println("inserted..");

		///****************************************************************//

			// **** inserting in the table dynamically ********//

			// // create a query 
			// String q ="insert into table1(tname,tcity) values (?,?)";

			// // get the PreparedStatement object

			// PreparedStatement pstmt = com.prepareStatement(q);

			// Scanner scn = new Scanner(System.in);
			// System.out.println("Enter name :");
			// String name= scn.nextLine();
			// System.out.println("Enter city :");
			// String city= scn.nextLine();



			// // set the values to query 

			// pstmt.setString(1,name);
			// pstmt.setString(2,city);

			// pstmt.executeUpdate();

			// System.out.println("inserted Dynamically..");

		///****************************************************************//
			
		// updating values in the database.

		// String q = "update table1 set tname=? , tcity=? where tid=?";

		// Scanner scn= new Scanner(System.in);

		// System.out.println("Enter new name");
		// String name = scn.nextLine();

		// System.out.println("Enter new city");
		// String city = scn.nextLine();

		// System.out.println("Enter your  id ");
		// int id = scn.nextInt();

		// PreparedConnection pstmt = con.prepareStatement(q);

		// pstmt.setString(1,name);
		// pstmt.setString(2,city);

		// pstmt.setInt(3,id);

		// pstmt.executeUpdate();

		// con.close();

	///****************************************************************//

		// selecting from database .

		String q= "select * from table1";

		Statement stmt= con.createStatement(q);
		// here we used the executeQuery because we are getting the some data.
		ResultSet set = stmt.executeQuery(q);

		while(set.next()){

			int id = set.getInt(1); // 1st column. 
			String name = set.getString(2); // 2nd column.
			String city = set.getString(3); // 3rd column.

			System.out.println("id : " + id + "name : " + name + "city : " + city);
		}


	}
  		catch(Exception e){
			e.printStackTrace();
		}
	}
}