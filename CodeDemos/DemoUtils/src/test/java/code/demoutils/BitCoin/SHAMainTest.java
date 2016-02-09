package code.demoutils.BitCoin;

import java.security.NoSuchAlgorithmException;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class SHAMainTest {

	@Test
	public void testNonce() {
		int prefixZero = 5;
		StringBuilder strToCompare = new StringBuilder();
		for(int i = 0 ; i < prefixZero ; i++) {
			strToCompare.append("0");
		}
		StringBuilder input = new StringBuilder("Hello, World!");
		try {
			Nonce nonce = SHAMain.findNonce(input, prefixZero);
			Assert.assertTrue("message", nonce.getHash().startsWith(strToCompare.toString()));
		} catch (NoSuchAlgorithmException | InterruptedException e) {
			e.printStackTrace();
			System.out.println("Exception is : " + e.getMessage());
		}
	}
}
