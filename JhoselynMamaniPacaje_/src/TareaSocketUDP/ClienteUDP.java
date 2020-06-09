package TareaSocketUDP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;

public class ClienteUDP {
	public static void main(String[] args) {
		System.out.println("---Cliente----");
		try {
			DatagramSocket socketUDP = new DatagramSocket();
			int puerto=6543;
			InetAddress host= InetAddress.getByName("localhost");
			
			BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
			
			String cad;
			while(true){
				cad = sc.readLine();
				//Nos permite enviar datos
				byte [] men = cad.getBytes();
				if(cad.equals("0"))break;
				DatagramPacket peticion = new DatagramPacket(men, cad.length(), host, puerto);
				socketUDP.send(peticion);
				byte [] buffer = new byte [10000];
				DatagramPacket mensaje = new DatagramPacket(buffer, buffer.length );
				socketUDP.receive(mensaje);
				System.out.println("La respuesta del Servidor: Contiene  "+ new String(mensaje.getData())+" Palabras ");
				
			}		
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}