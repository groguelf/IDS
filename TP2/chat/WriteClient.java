import java.rmi.*;

public interface  WriteClient extends Remote {
	// A method provided by the remote object
	public void connectMessage(Info_itf info) throws RemoteException;

	public void disconnectMessage(Info_itf info) throws RemoteException;

	public String writeInChat(Info_itf info, boolean displayName) throws RemoteException;

	public void setMessage(String message) throws RemoteException;
}
