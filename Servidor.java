import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class Servidor extends Implementacao {
	public Servidor() {}
	public static void main(String args []) {
		try {
			Implementacao objeto = new Implementacao ();
			Interface stub = (Interface) UnicastRemoteObject.exportObject(objeto, 0);
			Registry registry = LocateRegistry.getRegistry();
			registry.bind("Interface", stub);
			System.out.println("Servidor preparado");
		} catch (Exception e) {
			System.err.println("Server Exception : " + e.toString());
			e.printStackTrace();
		}
	}
}
