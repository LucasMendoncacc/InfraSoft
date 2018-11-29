import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.util.*;
import java.io.FileInputStream;
import java.rmi.*;

public class Cliente {
	private Cliente () {}
	public static void main (String args[]) {
		try {
			Scanner leia = new Scanner(System.in);
			//padrao
			Registry registry = LocateRegistry.getRegistry(null);
			Interface stub = (Interface) registry.lookup("Interface");
			

			// Escrever o texto num arquivo
			String entrada = leia.nextLine();
			Writer escritor = null;
			try {
				escritor = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("filename.txt"), "utf-8"));
				escritor.write(entrada);
				escritor.close();
			} catch (IOException IOEerro) {
				System.out.print("Erro: " + IOEerro.toString());
			} 

			
			//pegando arquivo
			File arquivo ;
			arquivo = new File( "C:\\Users\\lucas\\Desktop\\SOFT\\RMI\\src" );
			byte [] dados =new byte[1024*1024];
			int tamanho = System.in.read(dados); //ñ sei se ta certo
			while(tamanho>0){
				 stub.sendData(arquivo.getName(), dados, tamanho);	 
				 tamanho = System.in.read(dados); //ñ sei se ta certo
			 }
	        
			
					
					
		}catch (Exception e) {
			System.err.println("Cliente Exception: " + e.toString() );
			e.printStackTrace();
		}
	}
}
