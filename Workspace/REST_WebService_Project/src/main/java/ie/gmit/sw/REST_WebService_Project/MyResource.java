// Author: Garry Cummins
// ID: G00335806
package ie.gmit.sw.REST_WebService_Project;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ie.gmit.sw.Model.OrderTransport;
import ie.gmit.sw.RMI.server;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

	 /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	
	// getIt test
	
	/*@GET
	@Path("getIt")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }*/
	
	// Get request used to read in the sql database
	@GET
	@Path("read")
	@Produces(MediaType.APPLICATION_XML)
	// Gets the details for booking in the OrderTransport class
    public List<OrderTransport> bookingDetails() throws MalformedURLException, RemoteException, Exception {
    	System.out.println("Read");
    	server ds;
    	ds = (server) Naming.lookup("rmi://127.0.0.1:1099/database");

        return ds.read();
    }
	
	// POST request used to create a new booking record in the database
	@POST
    @Produces(MediaType.APPLICATION_XML)
    @Path("/create")
    public List<OrderTransport> createOrder(String bookingDetails) throws MalformedURLException, RemoteException, Exception{
    	
    	server ds;
    	ds = (server) Naming.lookup("rmi://127.0.0.1:1099/database");
    	    	
        return ds.write(bookingDetails);
    }
 
}
