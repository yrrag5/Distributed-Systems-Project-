package ie.gmit.sw.RMI;


import java.rmi.Naming;

import ie.gmit.sw.Model.OrderTransport;

public class rmi {
	
	private server check;
	// Checks for the url name for the database
	public rmi() throws Exception {
		check = (server) Naming.lookup("rmi://127.0.0.1:1099/database");

	}

}
