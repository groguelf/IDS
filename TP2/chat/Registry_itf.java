import java.rmi.*;

public interface Registry_itf extends Remote {
    public String register(Info_itf client, WriteClient wClient) throws RemoteException;

    public void displayMessage(String message, boolean displayName) throws RemoteException;
}