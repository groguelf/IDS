import java.rmi.*;

public interface Hello2 extends Remote {
    public void sayHello(Accounting_itf client) throws RemoteException;
}
