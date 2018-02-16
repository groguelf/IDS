import java.rmi.*;

public interface Hello extends Remote {
	// A method provided by the remote object
	public String sayHello(Accounting_itf client) throws RemoteException;
}

