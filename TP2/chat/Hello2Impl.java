import java.rmi.*;
import java.rmi.registry.*;

public class Hello2Impl implements Hello2 {

	private Registry_itf registre;

	public Hello2Impl(String host){
		try {
			Registry reg = LocateRegistry.getRegistry(host);
			registre = (Registry_itf) reg.lookup("Registre");
		}
		catch (Exception e){
			System.out.println("Error in Hello2Impl:" + e);
		}
	}

	public void sayHello(Accounting_itf client) throws RemoteException {
		registre.register(client);
	}
}

