import java.net.*;
public class ClientHandler implements Runnable {
	private DatagramPacket fileRequestPacket;
	private double plp;
	public ClientHandler(DatagramPacket fileRequestPacket, double plp) {
		this.fileRequestPacket = fileRequestPacket;
		this.plp = plp;
	}

	public void run() {
		try {
			InetAddress addr = InetAddress.getByName(TCPUtils.INADDR_ANY);
			DatagramSocket socket = new DatagramSocket(TCPUtils.ANY_AVAIL_PORT, addr);
			//TODO Sending Code
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
