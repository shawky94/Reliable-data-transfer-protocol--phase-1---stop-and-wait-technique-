import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClientSide {
	String serverIp;
	int serverPort, port;
	public ClientSide(String serverIp, int serverPort, int port) {
		super();
		this.serverIp = serverIp;
		this.serverPort = serverPort;
		this.port = port;
	}
	
	public void start(String fileName){
		try {
			DatagramSocket socket = new DatagramSocket(port, InetAddress.getByName(TCPUtils.INADDR_ANY));
			DatagramPacket packet = new DatagramPacket(fileName.getBytes(), fileName.length(), InetAddress.getByName(serverIp), serverPort);
			socket.send(packet);
			//Recieving Code is here 
			
			
			
			socket.close();
		} catch (SocketException | UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
