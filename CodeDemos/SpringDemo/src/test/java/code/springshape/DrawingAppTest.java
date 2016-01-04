package code.springshape;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingAppTest {

	private AbstractApplicationContext context;

	@Test
	public void messageTest() {
		context = new ClassPathXmlApplicationContext("spring_new.xml");
		context.registerShutdownHook();
		String message = context.getMessage("greeting", null, "Default Greeting", null);
		final String expected = "Hello!";
		Assert.assertTrue("message", expected.equals(message));
	}
}