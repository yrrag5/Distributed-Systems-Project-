package ie.gmit.sw.RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServerStartup {
	
	public static void main(String[] args) throws Exception {

		// Set an instance of DatabaseService
		server s = new ServerImplementation();
		LocateRegistry.createRegistry(1099);
		Naming.rebind("database", s);
		System.out.println("Server ready.");
	}

}
