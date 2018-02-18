import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;

public class RegistryImpl implements Registry_itf {

    private HashMap<Info_itf, WriteClientImpl> registre = new HashMap<Accounting_itf, Integer> ();

    public void register(Info_itf client, WriteClientImpl wClient) throws RemoteException {
        if (!registre.containsKey(client)){
            registre.put(client, wClient);
            wClient.connectMessage(client);
        }
    }

    public void addACall(Accounting_itf client) throws RemoteException {
        registre.put(client, registre.get(client) + 1);
    }

    public int numberCalls(Accounting_itf client) throws RemoteException {
        return registre.get(client);
    }
}