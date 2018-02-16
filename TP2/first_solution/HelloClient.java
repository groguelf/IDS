import java.rmi.*;
import java.rmi.registry.*;

public class HelloClient {
  public static void main(String [] args) {
	
	try {
	  if (args.length < 2) {
	   System.out.println("Usage: java HelloClient <rmiregistry host> <client name>");
	   return;}

	String host = args[0];
	String name = args[1];

	// Get remote object reference
	Registry registry = LocateRegistry.getRegistry(host); 
	Hello h = (Hello) registry.lookup("HelloService");

	// Remote method invocation
	String res = h.sayHello(name);
	System.out.println(res);

	} catch (Exception e)  {
		System.err.println("Error on client: " + e);
	}
  }
}