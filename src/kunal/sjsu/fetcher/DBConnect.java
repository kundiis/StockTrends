package kunal.sjsu.fetcher;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	public Connection getConnection(){
		Connection con = null;
		 try {
		      //Register the JDBC driver for MySQL.
		      Class.forName("com.mysql.jdbc.Driver");

		      //Define URL of database server for
		      // database named mysql on the localhost
		      // with the default port number 3306.
		      String url = "jdbc:mysql://localhost:3306/finant";

		      // Get a connection to the database for a
		      // user named root with a blank password.
		      // This user is the default administrator
		      // having full privileges to do anything.
		      con = DriverManager.getConnection(url,"root", "");
		    
		    }catch( Exception e ) {
		      e.printStackTrace();
		    }//end catch
		    return con;
	}
}
