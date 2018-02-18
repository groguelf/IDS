import java.rmi.*;
import java.io.IOException;

public interface  WriteClient extends Remote {
	// A method provided by the remote object
	public void connectMessage(Info_itf info) throws RemoteException, IOException;

	public void disconnectMessage(Info_itf info) throws RemoteException, IOException;

	public String writeInChat(Info_itf info, boolean displayName) throws RemoteException, IOException;

	public String printHistory(Info_itf info) throws RemoteException, IOException;
	
	public void setMessage(String message) throws RemoteException;
}
