package TareaSocketTCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {
	static  Scanner was= new Scanner(System.in);
	public static void menu(){
		System.out.println("-----------MENU-------------");
		System.out.println("1. Opcion 1");
		System.out.println("2. Opcion 2");
		System.out.println("3. Opcion 3");
		System.out.println("4. Salir");

	}
	public static void main(String[] args) throws IOException {
		System.out.println("--Cliente--");
		Socket socketCliente =null;
		BufferedReader entrada =null;
		PrintWriter salida=null;	
		try {
			socketCliente = new Socket("localhost", 8888);
			entrada = new BufferedReader( new InputStreamReader(socketCliente.getInputStream()));
			salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())),true);

		} catch (Exception e) {
			System.out.println(e);
		}

		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		try {

			while(true){
				menu();
				String cad = sc.readLine();
				if(cad.equals("1"))
				{
					salida.println("papel");
				}
				else{
					if(cad.equals("2"))
						salida.println("piedra");
					else
					{
						if(cad.equals("3"))
						salida.println("tijera");
					}
				}
				cad =entrada.readLine();
				System.out.println("la respuesta del servidor es:" + cad);
				if(cad.equals("4"))break;
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		salida.close();
		entrada.close();
		sc.close();
		socketCliente.close();
	}
}
