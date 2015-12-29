package code.demoutils.BitCoin;

public class Nonce {

	private String input;
	private long nonceNumber;
	private String hash;
	
	public Nonce(String input, long nonceNumber, String hash) {
		this.input = input;
		this.nonceNumber = nonceNumber;
		this.hash = hash;
	}

	public String getInput() {
		return input;
	}

	public long getNonceNumber() {
		return nonceNumber;
	}

	public String getHash() {
		return hash;
	}
	
	
}
