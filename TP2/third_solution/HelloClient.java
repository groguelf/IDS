import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.*;

public class HelloClient implements Accounting_itf {

    public void numberOfCalls(int number) throws RemoteException {
        System.out.println(number);
    }

    public static void main(String [] args) {

        try {
            if (args.length != 1) {
            System.out.println("Usage: java HelloClient <rmiregistry host>");
            return;}

            String host = args[0];

            // Get remote object reference
            Registry reg = LocateRegistry.getRegistry(host);
            Hello h = (Hello) reg.lookup("HelloService");

             var = new  ();
            Accounting_itf c_stub = (Accounting_itf) UnicastRemoteObject.exportObject(var, 0);

            // Remote method invocation
            String res = h.sayHello(c_stub);
            System.out.println(res);

        } catch (Exception e)  {
            System.err.println("Error on client: " + e);
        }
    }
}