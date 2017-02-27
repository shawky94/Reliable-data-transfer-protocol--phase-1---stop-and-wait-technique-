public class ServerMain {
	
	public static void main(String[] args){
		new ServerSide(8088, 1000, System.nanoTime(), .05).run();
	}

}
