import java.rmi.*;
import java.rmi.server.*; 
import java.rmi.registry.*;

public class HelloServer {

  public static void  main(String [] args) {
	  try {
		  // Create a Hello remote object
		  HelloImpl h = new HelloImpl ("Hello world !");
		  Hello h_stub = (Hello) UnicastRemoteObject.exportObject(h, 0);

		  // Register the remote object in RMI registry with a given identifier
		  Registry registry= LocateRegistry.getRegistry();
		  registry.bind("HelloService", h_stub);

		  RegistryImpl registre = new RegistryImpl();
		  Registry_itf r_stub = (Registry_itf) UnicastRemoteObject.exportObject(registre, 0);
		  registry.bind("Registre", r_stub);

		  Hello2Impl h2 = new Hello2Impl();
		  //Hello2Impl h2 = new Hello2Impl(args[0]);
		  Hello2 h2_stub = (Hello2) UnicastRemoteObject.exportObject(h2, 0);
		  registry.bind("Hello2", h2_stub);

		  System.out.println ("Server ready");

	  } catch (Exception e) {
		  System.err.println("Error on server :" + e) ;
		  e.printStackTrace();
	  }
  }
}
