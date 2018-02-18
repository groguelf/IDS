import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import java.util.Map.*;

public class RegistryImpl implements Registry_itf {
    //La HashMap est surement inutile et un HashSet serait mieux
    private HashMap<Info_itf, WriteClient> registre = new HashMap<Info_itf, WriteClient> ();

    public String register(Info_itf client, WriteClient wClient) throws RemoteException {
        if (!registre.containsKey(client)){
            registre.put(client, wClient);
            wClient.connectMessage(client);
            return "";
        } else {
            return "You are already connected";
        }
    }

    public void displayMessage(String message, boolean displayName) throws RemoteException {
        for (Entry<Info_itf, WriteClient> entry: registre.entrySet()) {
            Info_itf info = entry.getKey();
            WriteClient wClient = entry.getValue();
            wClient.setMessage(message);
            String toDisplay = wClient.writeInChat(info, displayName);
            info.display(toDisplay);
        }
    }
}