import java.rmi.Remote;
import java.rmi.RemoteException;

// Criando uma interface remota para nossa aplicação

public interface Interface extends Remote {
	void sendData(String nomeArquivo, byte[] dados, int tamanho) throws RemoteException;
}
