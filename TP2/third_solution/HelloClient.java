import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class HelloClient implements Info_itf, Accounting_itf {
    private String name;

     public HelloClient(String s){
        this.name = s;
    }

    public String getName() throws RemoteException {
        return name;
    }

    public void numberOfCalls(int number) throws RemoteException {
        System.out.println("number of calls: " + number);
    }

    public static void main(String [] args) {

        try {
            if (args.length != 2) {
            System.out.println("Usage: java HelloClient <rmiregistry host> <client name>");
            return;}

            String host = args[0];
            HelloClient client = new HelloClient(args[1]);
            Info_itf c_stub = (Info_itf) UnicastRemoteObject.exportObject(client, 0);

            Accounting_itf a_stub = (Accounting_itf) UnicastRemoteObject.exportObject(client, 0);

            // Get remote object reference
            Registry reg = LocateRegistry.getRegistry(host);
            Hello h = (Hello) reg.lookup("HelloService");

            Hello2 h2 = (Hello2) reg.lookup("Hello2");

            // Remote method invocation
            for (int i = 0; i < 10; i++) {
                String res = h.sayHello(c_stub);
                System.out.println(res);
                h2.sayHello(a_stub);
            }

        } catch (Exception e)  {
            System.err.println("Error on client: " + e);
        }
    }
}