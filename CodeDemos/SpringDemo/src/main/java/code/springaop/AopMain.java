package code.springaop;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import code.springaop.service.ShapeService;

public class AopMain {

	private static AbstractApplicationContext context;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("spring_aop.xml");
		context.registerShutdownHook();
		ShapeService shapeService = context.getBean("shapeService", ShapeService.class);
		System.out.println(shapeService.getCircle().getName());
		System.out.println(shapeService.getTriangle().getName());
	}

}
