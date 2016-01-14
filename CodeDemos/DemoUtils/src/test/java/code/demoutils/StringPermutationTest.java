package code.demoutils;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class StringPermutationTest {

	@Test
	public void testPermutation() {
		StringPermutation.permutate("", "abcd");
		List<String> result = StringPermutation.getResult();
		Assert.assertTrue("message", result.contains("abcd")
										&& result.contains("bcda")
										&& result.contains("cdab")
										&& result.contains("dabc"));
	}
}
