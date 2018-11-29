import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;

public class Implementacao implements Interface {
	
	public void sendData(String nomeArquivo, byte[] dados, int tamanho) throws RemoteException {
		try {
			FileOutputStream out = new FileOutputStream(nomeArquivo,true);
        	out.write(dados,0,tamanho);
        	out.flush();
        	out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
