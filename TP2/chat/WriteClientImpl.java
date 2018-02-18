import java.rmi.*;
import java.rmi.registry.*;

public class WriteClientImpl implements WriteClient {

	private String message;
 
	/*public WriteClientImpl(String s) {
		message = s ;
	}*/

	public String connectMessage(Info_itf info) throws RemoteException {
		return info.getName() + " is now connected to the chat";
	}

	public String disconnectMessage(Info_itf info) throws RemoteException {
		return info.getName() + " is now disconnected";
	}

	public String writeInChat(Info_itf info) throws RemoteException {
		return info.getName() + ": " + message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

