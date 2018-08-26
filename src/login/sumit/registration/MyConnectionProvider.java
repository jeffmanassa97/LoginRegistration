package login.sumit.registration;

import java.sql.Connection;
import java.sql.DriverManager;

// this is the class to implement the MyProvuder interface
// make connections to our driver
public class MyConnectionProvider implements MyProvider {

	static Connection con = null;

	public static Connection getCon() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(connUrl, username, pwd);
			

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("SQLException: " + e.getMessage());
		}
		return con;
	}
}
