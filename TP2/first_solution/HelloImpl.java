import java.rmi.*;
import java.util.*;

public  class HelloImpl implements Hello {

	private String message;

	public HelloImpl(String s) {
		message = s ;
	}

	public String sayHello(String name) throws RemoteException {
        return name + ": " + message;
	}
}

