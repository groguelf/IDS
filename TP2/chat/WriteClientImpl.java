import java.rmi.*;
import java.rmi.registry.*;

public class WriteClientImpl implements writeClient {

	private String message;
 
	public writeClientImpl(String s) {
		message = s ;
	}

	public String connectMessage(Info_itf info) throws RemoteException {
		return info.getName() + " is now connected";
	}

	public String writeInChat(Info_itf info) throws RemoteException {
		return info.getName() + ": " + message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

