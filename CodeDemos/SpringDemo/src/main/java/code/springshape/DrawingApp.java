package code.springshape;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class DrawingApp {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring_new.xml");
		context.registerShutdownHook();
		//Triangle triangle = (Triangle)context.getBean("triangle");
		//Triangle triangle = (Triangle)context.getBean("triangle-alias");
		/*Triangle triangle = (Triangle)context.getBean("triangle");
		triangle.draw();*/
		Shape shape;
		/*shape = (Shape) context.getBean("childChildTriangle");
		shape.draw();*/
		//shape = (Shape)context.getBean("shape");
		shape = (Shape) context.getBean("circle");
		shape.draw();
		//System.out.println(triangle.getPointB().getX());
		/*
		System.out.println(context.getMessage("greeting", null, "Default Greeting", null));
		*/
	}

}