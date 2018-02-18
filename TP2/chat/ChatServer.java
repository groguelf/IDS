import java.rmi.*;
import java.rmi.server.*; 
import java.rmi.registry.*;

public class ChatServer {

  public static void  main(String [] args) {
	  try {
		  // Register the remote object in RMI registry with a given identifier
		  Registry registry = LocateRegistry.getRegistry();

		  RegistryImpl registre = new RegistryImpl();
		  Registry_itf r_stub = (Registry_itf) UnicastRemoteObject.exportObject(registre, 0);
		  registry.bind("Registre", r_stub);

		  System.out.println ("Server ready");

	  } catch (Exception e) {
		  System.err.println("Error on server :" + e) ;
		  e.printStackTrace();
	  }
  }
}
