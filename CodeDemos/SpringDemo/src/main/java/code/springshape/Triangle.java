package code.springshape;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements ApplicationContextAware, BeanNameAware, InitializingBean, DisposableBean, Shape {

	static {
		System.out.println("Triangle Created");
	}
	
	private List<Point> points;
	
	/*private String type;
	private int height;
	
	public Triangle(String type) {
		this.type = type;
	}
	
	public Triangle(String type, int height) {
		this.type = type;
		this.height = height;
	}
	
	public Triangle(int heigh) {
		this.height = heigh;
	}
	
	public void draw() {
		System.out.println(this.type + " Triangle drawn of height " + this.height);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getHeight() {
		return height;
	}*/
	
	@Override
	public void draw() {
		/*System.out.println("Point A: (" + this.pointA.getX() + "," + this.pointA.getY() + ")");
		System.out.println("Point B: (" + this.pointB.getX() + "," + this.pointB.getY() + ")");
		System.out.println("Point C: (" + this.pointC.getX() + "," + this.pointC.getY() + ")");*/
		System.out.println("Drawing Triangle");
		for(Point point : this.points) {
			System.out.println("Point : (" + point.getX() + "," + point.getY() + ")");
		}
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	/*public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}*/

	public void setBeanName(String beanName) {
		System.out.println("Setting beanName to " + beanName);
	}

	public void setApplicationContext(ApplicationContext context) throws BeansException {
		System.out.println("Setting application context to " + context);
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("Triangle initialized");
	}

	public void destroy() throws Exception {
		System.out.println("Triangle disposed");
	}
	
	public void myInit() {
		System.out.println("Triangle myInit");
	}
	
	public void myDestroy() {
		System.out.println("Triangle myDestroy");
	}
	
	/*public void init() {
		System.out.println("Triangle init");
	}
	
	public void destroy() {
		System.out.println("Triangle destroy");
	}*/
}
