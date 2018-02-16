import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.*;

public class Hello2 implements Hello, Registry_itf {
    private String message;

    private HashMap<Accounting_itf, Integer> clientCalls = new HashMap<Accounting_itf, Integer> ();

    public Hello2(String message){
        this.message = message;
    }

    public String sayHello(Accounting_itf client) throws RemoteException {
        if (clientCalls.containsKey(client)){
            return message;
        }
        return("You are not registered");
    }

    public void register(Accounting_itf client) throws RemoteException {
        if (!clientCalls.containsKey(client)){
            clientCalls.put(client, 0);
        }
    }
}