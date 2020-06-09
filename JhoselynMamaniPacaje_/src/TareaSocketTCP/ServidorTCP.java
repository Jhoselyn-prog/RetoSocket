package TareaSocketTCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServidorTCP {
	public static void main(String[] args) throws IOException {
		System.out.println("---Servidor---");
		ServerSocket socketServidor=null;
		Socket socketCliente =null;
		
		BufferedReader entrada=null;
		PrintWriter salida =null;

		try {
			socketServidor = new ServerSocket(8888);
			socketCliente.setSoTimeout(10*3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		try {
			while (true) {
				socketCliente = socketServidor.accept();
				entrada = new BufferedReader( new InputStreamReader(socketCliente.getInputStream()));
				salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())),true);
		
				while(true){
					String cad=entrada.readLine();
					
					salida.println(cad);
					System.out.println(cad);
					if(cad.equals("4"))break;
				}
			
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		salida.close();
		entrada.close();
		socketServidor.close();
		
		socketCliente.close();	
	}

}
