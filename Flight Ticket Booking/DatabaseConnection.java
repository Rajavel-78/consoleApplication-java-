package FlightBookingApplication;

import java.sql.*;

public class DatabaseConnection {
	
  public Statement dbConnection(){
	  Statement statement=null;
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Flight","rajavel","Password123#@!");
	 statement=connection.createStatement();
	
	}
	catch(Exception e) {
	  e.printStackTrace();
	}
	return statement;
  }
}
