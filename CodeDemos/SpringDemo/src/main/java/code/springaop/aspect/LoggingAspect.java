package code.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	//@Before("execution(public String code.springaop.model.Circle.getName())")
	//@Before("execution(public * get*())")
	@Before("allGetters()")
	public void loggingAdvice() {
		System.out.println("Advice run, get method called.");
	}
	
	//when loggingAdvice and anotherAdvice have exactly same aspect criteria
	//then anotherAdvice will run first because it comes first alphabetically
	//@Before("execution(* get*())")
	@Before("allGetters()")
	public void anotherAdvice() {
		System.out.println("Anoter advice run");
	}
	
	@Pointcut("execution(* get*())")
	public void allGetters() {}
}
