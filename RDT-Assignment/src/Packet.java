
public abstract class Packet {
	private short chkSum, length;

	public short getChkSum() {
		return chkSum;
	}

	public void setChkSum(short chkSum) {
		this.chkSum = chkSum;
	}

	public short getLength() {
		return length;
	}

	public void setLength(short len) {
		this.length = len;
	}
}
