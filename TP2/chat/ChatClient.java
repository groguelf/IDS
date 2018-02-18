import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.Scanner;

public class ChatClient implements Info_itf {
    private String name;

     public ChatClient(String s){
        this.name = s;
    }

    public String getName() throws RemoteException {
        return name;
    }

    public void display(String message) {
        System.out.println(message);
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
            WriteClientImpl wClient = new WriteClientImpl(host);
            WriteClient w_stub = (WriteClient) UnicastRemoteObject.exportObject(wClient, 0);

            // Remote method invocation
            String connected = registre.register(c_stub, w_stub);
            System.out.println("Welcome to this channel!\nType a message anytime then press enter to send it.\nWrite /quit to leave.");

            Scanner keyboard = new Scanner(System.in);

            while (true) {
                String mymessage = keyboard.nextLine();
                if (mymessage.equals("/quit")) {
                    w_stub.disconnectMessage(c_stub);
                    System.out.println("You have been correctly disconnected.");
                    System.exit(0);
                } else {
                    w_stub.setMessage(mymessage);
                    String res = w_stub.writeInChat(c_stub, true);
                    registre.displayMessage(res, false);
                }
            }

        } catch (Exception e)  {
            System.err.println("Error on client: " + e);
            e.printStackTrace();
        }
    }
}
