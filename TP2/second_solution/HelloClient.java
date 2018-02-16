import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class HelloClient implements Info_itf{
    private String name;

    public HelloClient(String s){
        this.name = s;
    }

    public String getName() throws RemoteException{
        return name;
    }

    public static void main(String [] args) {

        try {
            if (args.length != 2) {
            System.out.println("Usage: java HelloClient <rmiregistry host> <client name>");
            return;}

            String host = args[0];
            HelloClient client = new HelloClient(args[1]);
            Info_itf c_stub = (Info_itf) UnicastRemoteObject.exportObject(client, 0);

            // Get remote object reference
            Registry reg = LocateRegistry.getRegistry(host);
            Hello h = (Hello) reg.lookup("HelloService");

            // Remote method invocation
            String res = h.sayHello(c_stub);
            System.out.println(res);

        } catch (Exception e)  {
            System.err.println("Error on client: " + e);
        }
    }
}