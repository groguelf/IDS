import java.rmi.*;

public interface Info_itf extends Remote{
    public String getName() throws RemoteException;

    public void display(String message) throws RemoteException;
}
