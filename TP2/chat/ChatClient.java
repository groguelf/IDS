import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class ChatClient implements Info_itf {
    private String name;

     public ChatClient(String s){
        this.name = s;
    }

    public String getName() throws RemoteException {
        return name;
    }

    public static void main(String [] args) {

        try {
            if (args.length != 2) {
                System.out.println("Usage: java HelloClient <rmiregistry host> <client name>");
                return;
            }

            String host = args[0];
            ChatClient client = new ChatClient(args[1]);

            // Get remote object reference
            Registry reg = LocateRegistry.getRegistry(host);
            Registry_itf registre = (Registry_itf) reg.lookup("Registre");

            Info_itf c_stub = (Info_itf) UnicastRemoteObject.exportObject(client, 0);
            WriteClientImpl wClient = new WriteClientImpl();
            WriteClient w_stub = (WriteClient) UnicastRemoteObject.exportObject(wClient, 0);
            registre.register(c_stub, w_stub);

            // Remote method invocation
            w_stub.setMessage("yo!");
            String res = w_stub.writeInChat(c_stub);
            System.out.println(res);

        } catch (Exception e)  {
            System.err.println("Error on client: " + e);
        }
    }
}