import java.rmi.*;

public interface  writeClient extends Remote {
	// A method provided by the remote object
	public String connectMessage(Info_itf client) throws RemoteException;

	public String writeInChat(Info_itf client) throws RemoteException;
}
