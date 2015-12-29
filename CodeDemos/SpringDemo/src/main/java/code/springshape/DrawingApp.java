package code.springshape;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

	//private static ApplicationContext context;
	private static AbstractApplicationContext context;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		//Triangle triangle = (Triangle)context.getBean("triangle");
		//Triangle triangle = (Triangle)context.getBean("triangle-alias");
		/*Triangle triangle = (Triangle)context.getBean("triangle");
		triangle.draw();*/
		Triangle triangle = (Triangle)context.getBean("childChildTriangle");
		triangle.draw();
		//System.out.println(triangle.getPointB().getX());
	}

}
