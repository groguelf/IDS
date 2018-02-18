import java.rmi.*;
import java.rmi.registry.*;

public class WriteClientImpl implements WriteClient {

	private String message;

	private Registry_itf registre;

	public WriteClientImpl(String host) throws RemoteException, NotBoundException {
		Registry reg = LocateRegistry.getRegistry(host);
		registre = (Registry_itf) reg.lookup("Registre");
	}
 
	public void connectMessage(Info_itf info) throws RemoteException {
		String message = info.getName() + " is now connected to the chat.";
		registre.displayMessage(message, false);
	}

	public void disconnectMessage(Info_itf info) throws RemoteException {
		String message = info.getName() + " is now disconnected.";
		registre.displayMessage(message, false);
	}

	public String writeInChat(Info_itf info, boolean displayName) throws RemoteException {
		if (displayName) {
			return info.getName() + ": " + message;
		} else {
			return message;
		}
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void displayMessage(){

	}
}

