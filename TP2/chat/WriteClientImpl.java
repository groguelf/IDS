import java.rmi.*;
import java.rmi.registry.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.lang.String;

public class WriteClientImpl implements WriteClient {

	private String message;

	private String filename;

	private FileWriter fw;

	private Registry_itf registre;

	public WriteClientImpl(String host) throws RemoteException, NotBoundException, IOException {
		filename = "ChatHistory.txt";
		Registry reg = LocateRegistry.getRegistry(host);
		registre = (Registry_itf) reg.lookup("Registre");
	}

	public void connectMessage(Info_itf info) throws RemoteException, IOException {
		fw = new FileWriter(filename, true); //true = append mode
	    fw.write(info.getName() + " is now connected to the chat.\n");
		//appends the string to the file
	    fw.close();
		String message = info.getName() + " is now connected to the chat.";
		registre.displayMessage(message, false);
	}

	public void disconnectMessage(Info_itf info) throws RemoteException, IOException {
		fw = new FileWriter(filename, true);
		fw.write(info.getName() + " is now disconnected.\n");
		fw.close();
		String message = info.getName() + " is now disconnected.";
		registre.displayMessage(message, false);
	}

	public String writeInChat(Info_itf info, boolean displayName) throws RemoteException, IOException {
		if (displayName) {
			fw = new FileWriter(filename, true);
			fw.write(info.getName() + ": " + message + "\n");
			fw.close();
			return info.getName() + ": " + message;
		} else {
			return message;
		}
	}

	public String printHistory(Info_itf info) throws RemoteException, IOException, FileNotFoundException {
		String history = "";
		String line;

		BufferedReader bufferReader = new BufferedReader(new FileReader("ChatHistory.txt"));
		line = bufferReader.readLine();

		while (line != null) {
			history += line + "\n";
			line = bufferReader.readLine();
		}

		bufferReader.close();

		// history.concat(line);
		// history.concat("bonjour");

		// return line;
		return history;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
