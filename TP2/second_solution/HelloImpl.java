import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;

public class HelloImpl implements Hello {

	private String message;
 
	public HelloImpl(String s) {
		message = s ;
	}

	public String sayHello(Info_itf info) throws RemoteException {
		return info.getName() + ": " + message;
	}
}

