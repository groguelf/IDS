import java.rmi.*;

public interface Registry_itf extends Remote {
    public void register(Info_itf client) throws RemoteException;
}