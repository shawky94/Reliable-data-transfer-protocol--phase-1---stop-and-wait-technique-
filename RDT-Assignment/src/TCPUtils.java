import java.util.Random;

/**
 * 
 */

/**
 * @author youssef
 *
 */
public class TCPUtils {
	public static final String INADDR_ANY = "0.0.0.0";
	public static final int ANY_AVAIL_PORT = 0;
	private static Random rand;

	public static void setRandSeed(long seed) {
		rand = new Random(seed);
	}

	public static boolean isToDrop(double plp) {
		return rand.nextDouble() <= plp;
	}

}
