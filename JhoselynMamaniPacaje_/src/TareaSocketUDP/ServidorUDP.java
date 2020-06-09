package TareaSocketUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.StringTokenizer;

public class ServidorUDP {	

	public static int contar(String cad){
		StringTokenizer a = new StringTokenizer(cad);
		int n =a.countTokens();
		return n;
	}

	public static void main(String[] args) {
		System.out.println("---Servidor----");
		try {
			DatagramSocket socketUDP = new DatagramSocket(6543);
			byte[] bufer = new byte[10000];
			while(true){
				DatagramPacket peticion = new DatagramPacket(bufer,bufer.length);
				socketUDP.receive(peticion);
				String res= new String(peticion.getData());			
				int n = contar(res);
				System.out.println("La cantidad de palabras es :"+n);
				String env =n+"";
				byte []enviar = env.getBytes();
				DatagramPacket mensaje = new DatagramPacket(enviar,env.length(),peticion.getAddress(), peticion.getPort());
				socketUDP.send(mensaje);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
