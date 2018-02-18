import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;

public class RegistryImpl implements Registry_itf {
    //La HashMap est surement inutile et un HashSet serait mieux
    private HashMap<Info_itf, WriteClient> registre = new HashMap<Info_itf, WriteClient> ();

    public void register(Info_itf client, WriteClient wClient) throws RemoteException {
        if (!registre.containsKey(client)){
            registre.put(client, wClient);
            wClient.connectMessage(client);
        }
    }
}