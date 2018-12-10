package ie.gmit.sw.RMI;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;
import java.rmi.Remote;

import ie.gmit.sw.Model.OrderTransport;

// Interface for the database service
public interface server extends Remote {
	// Implementing CRUD functions for database manipulation 
	public List<OrderTransport> read() throws RemoteException, SQLException;
	
	public List<OrderTransport> write(String bookingDetails) throws SQLException, RemoteException;

	public List<OrderTransport> delete(String bId) throws SQLException, RemoteException;

	public List<OrderTransport> update(String bId) throws SQLException, RemoteException;
}
