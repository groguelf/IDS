import java.rmi.*;
import java.rmi.registry.*;

public class Hello2Impl implements Hello2 {

	private Registry reg;

	/*public Hello2Impl(String host){
		try {
			reg = LocateRegistry.getRegistry(host);
		}
		catch (Exception e){
			System.out.println("Error in Hello2Impl:" + e);
		}
	}*/

	public void sayHello(Accounting_itf client) throws RemoteException {
		try {
			RegistryImpl registre = (RegistryImpl) reg.lookup("Registre");
			registre.addACall(client);
			client.numberOfCalls(registre.numberCalls(client));
		}
		catch (Exception e){
			System.out.println("Error in Hello2Impl:" + e);
		}
	}
}

