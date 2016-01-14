package code.demoutils;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class StringCombinationTest {

	@Test
	public void testCombination() {
		StringCombination.combine("abcd", new StringBuilder(), 0);
		List<String> result = StringCombination.getResult();
		Assert.assertTrue("message", result.contains("a") 
										&& result.contains("cd") 
										&& result.contains("bcd") 
										&& result.contains("abcd"));
	}
}
