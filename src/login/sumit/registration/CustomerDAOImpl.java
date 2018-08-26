package login.sumit.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDAOImpl implements CustomerDAO {

	
	static Connection con;
	static PreparedStatement ps;
	// Inserting Customer into the database (loginDB)
	@Override
	public int insertCustomer(Customer c) {
		int status = 0;
		
		try {
			con = MyConnectionProvider.getCon();
			ps = con.prepareStatement("INSERT INTO customer VALUES(?,?,?)");
			// Setting the columns of the table
			ps.setString(1, c.getUsername());
			ps.setString(2, c.getPassword());
			ps.setString(3, c.getName());

			// Execute the preparedStatement - returns 1 if there was a statement, 0 if not
			// executeUpdate is for updating database with INSERT UPDATE or DELETE
			status = ps.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return status;
	}
	
	
	// Purpose of this is to store the customer in an object, and find the name associated with the customer
	@Override
	public Customer getCustomer(String userid, String pass) {
		Customer c = new Customer();
		
		try {
			
			con = MyConnectionProvider.getCon();
			ps = con.prepareStatement("SELECT * FROM customer WHERE customer=? AND password=?");
			ps.setString(1, userid);
			ps.setString(2, pass);
			
			// ResultSet contains the data produced by the query
			// executeQuery is for passing selected values into a ResultSet
			ResultSet rs = ps.executeQuery();
			
			// Cursor moves forward one row at a time until last row, then returns false
			while(rs.next()) {
				c.setUsername(rs.getString(1));
				c.setPassword(rs.getString(2));
				c.setName(rs.getString(3));
			}
			
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return c;
	}

}
