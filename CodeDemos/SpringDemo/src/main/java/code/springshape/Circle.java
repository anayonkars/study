package code.springshape;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
//@Service
//@Repository
//@Controller
public class Circle implements Shape {

	private Point center;
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	public void draw() {
		//System.out.println("Drawing Circle");
		System.out.println(this.messageSource.getMessage("drawing.circle", null, "Default Drawing Message", null));
		//System.out.println("Circle center is : (" + center.getX() + "," + center.getY() + ")");
		System.out.println(this.messageSource.getMessage("drawing.point", new Object[]{center.getX(), center.getY()}, "Default Point Message", null));
		System.out.println(this.messageSource.getMessage("greeting", null, "Default Greeting", null));
	}

	public Point getCenter() {
		return center;
	}

	//@Required
	/*@Autowired
	@Qualifier("circleCenter")*/
	@Resource(name="pointC")
	public void setCenter(Point center) {
		this.center = center;
	}
	
	@PostConstruct
	public void initializeCircle() {
		System.out.println("Init of Circle");
	}

	@PreDestroy
	public void destroyCircle() {
		System.out.println("Destroy of Circle");
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
}