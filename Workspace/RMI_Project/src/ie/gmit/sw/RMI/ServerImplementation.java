//Author: Garry Cummins
// ID: G00335806
package ie.gmit.sw.RMI;

// Imports
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ie.gmit.sw.Model.OrderTransport;


public class ServerImplementation extends UnicastRemoteObject implements server {

	private static final long serialVersionUID = 1L;
	// Variables for connection and state
	private Connection connection;
	private Statement state;

	protected ServerImplementation() throws RemoteException, SQLException {
		super();
		// Establising SQL database connection through wamp with the bookings database
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookings?useSSL=false", "root", "");
	} // SQL server
    
	// Read method to display all records in the booking table
	@Override
	public List<OrderTransport> read() throws RemoteException, SQLException {
		System.out.println("In read");

		state = connection.createStatement();

		List<OrderTransport> List = new ArrayList<OrderTransport>();
		String strSelect = "select * from booking;";

		ResultSet set = state.executeQuery(strSelect);

		while (set.next()) { 
			// Setting variable to correspond with the databases
			int BId = set.getInt("bId");
			int CId = set.getInt("cId");
			String RNo = set.getString("rNo");
			Date bookingDate = set.getDate("bookingdate");
			Date bookingEndDate = set.getDate("bookingEndDate");
			
			OrderTransport s = new OrderTransport(BId, CId, RNo, bookingDate, bookingEndDate);
			
			// Listing table contents
			List.add(s);
			System.out.println(s);
		}
		System.out.println(List);
		return List;
	}

	// Write method to create a new booking record into the table
	@Override
	public List<OrderTransport> write(String bookingDetails) throws RemoteException, SQLException {
		state = connection.createStatement();
		
		List<OrderTransport> List = new ArrayList<OrderTransport>();
				
		// Used for user input
		bookingDetails = bookingDetails.replace("bId=", "");
		bookingDetails = bookingDetails.replace("cId=", "");
		bookingDetails = bookingDetails.replace("rNo=", "");
		bookingDetails = bookingDetails.replace("bookingDate=", "");
		bookingDetails = bookingDetails.replace("bookingEndDate=", "");

		bookingDetails = bookingDetails.replace("&", "', '");
		bookingDetails = bookingDetails + "'";
		
		// Will add entered details into the the table
		String insertQuery = "INSERT INTO booking (bId, cId, rNo, bookingDate, bookingEndDate) VALUES " + 
		"(NULL, '" + bookingDetails + ");";
		
		state.executeUpdate(insertQuery);
		
		String query = "select * from booking";
		
		ResultSet rs = state.executeQuery(query);
		
		while(rs.next()){
			int bID = rs.getInt("bId");
			int cID = rs.getInt("cId");
			String rNO = rs.getString("rNo");
			Date bDate = rs.getDate("bookingDate");
			Date bEndDate = rs.getDate("bookingEndDate");
			
			OrderTransport ot = new OrderTransport();
			
			ot.setBId(bID);
			ot.setCId(cID);
			ot.setRNo(rNO);
			ot.setBookingdate(bDate);
			ot.setBookingEndDate(bEndDate);
			List.add(ot);	
		}
		return List;
	}
	
	// Delete method 
	@Override
	public List<OrderTransport> delete(String bId) throws SQLException, RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	// Update method
	@Override
	public List<OrderTransport> update(String bId) throws SQLException, RemoteException {
		// TODO Auto-generated method stub
		return null;
	}



	

}
