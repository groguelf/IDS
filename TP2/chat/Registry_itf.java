import java.rmi.*;
import java.io.IOException;

public interface Registry_itf extends Remote {
    public String register(Info_itf client, WriteClient wClient) throws RemoteException, IOException;

    public void displayMessage(String message, boolean displayName) throws RemoteException, IOException;
}
