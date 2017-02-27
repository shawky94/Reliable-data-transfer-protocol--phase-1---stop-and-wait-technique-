import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerSide {
	private int port;
	private long timeOutInMillis;
	private double plp;
	private ExecutorService executor = Executors.newCachedThreadPool();

	public ServerSide(int port, long timeOutInMillis, long seed, double plp) {
		this.port = port;
		this.timeOutInMillis = timeOutInMillis;
		this.plp = plp;
		TCPUtils.setRandSeed(seed);
	}

	public void run() {
		DatagramSocket socket = null;
		try {
			InetAddress addr = InetAddress.getByName(TCPUtils.INADDR_ANY);
			socket = new DatagramSocket(port, addr);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		while (true) {
			try {
				byte[] receiveData = new byte[500];
				DatagramPacket requestPacket = new DatagramPacket(receiveData, receiveData.length);
				socket.receive(requestPacket);
				
				//Debuging 
				String sentence = new String(requestPacket.getData(), 0, requestPacket.getLength());
				System.out.println("RECEIVED: " + sentence);
				/*******************************************/
				
				ClientHandler handler = new ClientHandler(requestPacket, plp);
				executor.submit(handler);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public long getTimeOutInMillis() {
		return timeOutInMillis;
	}

	public void setTimeOutInMillis(long timeOutInMillis) {
		this.timeOutInMillis = timeOutInMillis;
	}

	public double getPlp() {
		return plp;
	}

	public void setPlp(double plp) {
		this.plp = plp;
	}

}
